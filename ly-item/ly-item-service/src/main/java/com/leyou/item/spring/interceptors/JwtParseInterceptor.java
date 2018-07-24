package com.leyou.item.spring.interceptors;

import com.leyou.auth.entity.UserInfo;
import com.leyou.auth.utils.JwtUtils;
import com.leyou.common.config.JwtProperties;
import com.leyou.common.redis.DB00RedisUtils;
import com.leyou.common.springboot.annotation.Interceptor;
import com.leyou.common.springboot.interceptor.BaseInterceptor;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author chendong
 * @date 2018-07-12
 * @description jwt的验证
 */
@Interceptor
public class JwtParseInterceptor implements BaseInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(JwtParseInterceptor.class);

    //封装一个抽象类，能够自动注入拦截规则和添加到注册拦截接口中
    @Override
    public String ruleName() {
        return "test";
    }

    @Override
    public int interceptorOrder() {
        return 20;
    }

    private JwtProperties jwtProperties;

    public void setJwtProperties(JwtProperties jwtProperties) {
        this.jwtProperties = jwtProperties;
    }

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.info("执行的拦截器，我的拦截order顺序是:{}", interceptorOrder());
        DB00RedisUtils.setString("test", "123");
        String test = (String) DB00RedisUtils.getString("test");
        logger.info("test={}", test);

        if (jwtProperties == null) {
            logger.info("空");
        }
        String cookieName = jwtProperties.getCookieName();
        String token = request.getHeader(cookieName);

        if (StringUtils.isBlank(token)) {
            //跳转登录
            return false;
        }
        //验证token是否合法
        try {
            UserInfo userInfo = JwtUtils.getInfoFromToken(token, jwtProperties.getPublicKey());
            if (userInfo != null) {
                //去redis中根据用户手机号获取用户信息，放入到session中

            }
        } catch (Exception e) {
            logger.info("jwt 验证失败：{}", e.getMessage());
            e.printStackTrace();
            return false;
        }

        return true;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
    }


}
