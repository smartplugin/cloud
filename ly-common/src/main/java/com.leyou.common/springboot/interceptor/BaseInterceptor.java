package com.leyou.common.springboot.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

/**
 * @author chendong
 * @date 2018-07-13
 * @description
 */

public interface BaseInterceptor extends HandlerInterceptor {


    /**
     * 由子类进行实现覆盖，如果子类没有实现和覆盖，则不添加到拦截路径中
     *
     * @return
     */

    String ruleName();

    /**
     * 由子类进行实现覆盖，用数字表示拦截器执行的先后顺序，数字越小优先级越高。
     * @return
     */
    int interceptorOrder();

}