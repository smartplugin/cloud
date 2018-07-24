package com.leyou.item.spring.interceptors;

import com.leyou.common.springboot.annotation.Interceptor;
import com.leyou.common.springboot.interceptor.BaseInterceptor;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author chendong
 * @date 2018-07-20
 * @description
 */

@Interceptor
public class TestInterceptor implements BaseInterceptor {

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestInterceptor.class);
    @Override
    public String ruleName() {
        return "test";
    }

    @Override
    public int interceptorOrder() {
        return 10;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.info("执行的拦截器，我的拦截order顺序是:{}",interceptorOrder());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
