package com.leyou.common.config;

import com.leyou.common.springboot.annotation.Interceptor;
import com.leyou.common.springboot.annotation.ScanPackageService;
import com.leyou.common.springboot.interceptor.BaseInterceptor;
import com.leyou.common.utils.SpringContextUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;

/**
 * @author chendong
 * @date 2018-07-12
 * @description
 */

@SpringBootConfiguration
public class WebMvcConfig implements WebMvcConfigurer {

    @Autowired
    private Environment environment;

    private static final String INTERCEPTOR_PATH_INCLUDE = "ly.interceptor.RULENAME.include";

    private static final String INTERCEPTOR_PATH_EXCLUDE = "ly.interceptor.RULENAME.exclude";

    private final static Logger logger = LoggerFactory.getLogger(WebMvcConfig.class);


    /**
     * 配置拦截器
     * 扫描拦截器，注册自定义拦截器，获取规则后，添加拦截路径和排除拦截路径
     *
     * @param registry
     */
    public void addInterceptors(InterceptorRegistry registry) {

        //TODO 这里应该改成获取项目的classpath
        String packages = "com.leyou";
        Set<String> interceptorAnnotationClass = ScanPackageService.findPackageAnnotationClass(packages, Interceptor.class);
        if (interceptorAnnotationClass.isEmpty()) {
            logger.debug("扫描完毕，没有找到 Interceptor.class 注解的拦截器");
            return;
        }

        Map<Integer, BaseInterceptor> interceptorMap = new HashMap<>();

        for (String annotationClass : interceptorAnnotationClass) {
            try {
                Class<?> interceptorClass = Class.forName(annotationClass);
                BaseInterceptor interceptor = (BaseInterceptor) interceptorClass.newInstance();
                logger.debug("检验完该拦截器，{},进入加载队列", annotationClass);

                //根据加载顺序来添加拦截器，获取之后加入map然后排序
                Integer orderNO = interceptor.interceptorOrder();
                if (orderNO == null) {
                    orderNO = Integer.MAX_VALUE;
                }

                //获取配置文件规则
                if (StringUtils.isBlank(interceptor.ruleName())) {
                    logger.error("{}未配置拦截器规则,不会添加该拦截器进入拦截链", annotationClass);
                    continue;
                }
                interceptorMap.put(orderNO, interceptor);

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (ClassCastException e) {
                logger.error("类型转换异常,{}未实现:{},不能使用interceptor注解", annotationClass, BaseInterceptor.class.getName());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        List<Map.Entry<Integer, BaseInterceptor>> list = new ArrayList<>(interceptorMap.entrySet());
//        Collections.sort(list, Comparator.comparing(Map.Entry::getKey));//spring做好了排序

        for (Map.Entry<Integer, BaseInterceptor> interceptorEntry : list) {
            BaseInterceptor interceptorActive = interceptorEntry.getValue();
            Class<? extends BaseInterceptor> aClass = interceptorActive.getClass();

            Field[] fields = aClass.getDeclaredFields();
            for (Field field : fields) {
                try {
                    Class<?> type = field.getType();
                    String name = type.getName();
                    field.setAccessible(true);
                    Object fieldValue = field.get(interceptorActive);
                    if (Logger.class.getName().equals(name) || fieldValue != null) {
                        logger.debug("排除拦截器中的日志字段属性或非空字段属性：{}", name);
                        continue;
                    }
                    String classNameUp = name.split("\\.")[name.split("\\.").length - 1];
                    String classNameLow = classNameUp.substring(0, 1).toLowerCase() + classNameUp.substring(1);
                    //通过类型转换
                    Object bean = SpringContextUtil.getBean(classNameLow);
                    Method method = aClass.getMethod("set" + classNameUp, type);
                    method.invoke(interceptorActive, bean);
                    logger.debug("注入字段属性:{}的对象:{}", classNameLow, bean);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            //获取配置文件规则
            String ruleName = interceptorActive.ruleName();
            if (StringUtils.isBlank(ruleName)) {
                logger.error("{}未配置拦截器规则", aClass.getName());
                continue;
            }
            //获取配置文件规则里的添加路径和排除路径
            String includePath = environment.getProperty(INTERCEPTOR_PATH_INCLUDE.replace("RULENAME", ruleName));
            if (StringUtils.isBlank(includePath)) {
                logger.error("{}拦截器规则不存在", aClass.getName());
                continue;
            }
            String excludePath = environment.getProperty(INTERCEPTOR_PATH_EXCLUDE.replace("RULENAME", ruleName));

            //添加到拦截器适配器中
            if (!StringUtils.isBlank(excludePath)) {
                registry.addInterceptor(interceptorActive).addPathPatterns(includePath).excludePathPatterns(excludePath).order(interceptorActive.interceptorOrder());
            } else {
                registry.addInterceptor(interceptorActive).addPathPatterns(includePath).order(interceptorActive.interceptorOrder());
            }
            logger.debug("加载拦截器配置：{}加载完毕,添加路径:{},排除路径:{}", aClass.getName(), includePath, excludePath);
        }
    }


}
