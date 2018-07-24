package com.leyou.common.springboot.annotation;

import java.lang.annotation.*;

/**
 * @author chendong
 * @date 2018-07-13
 * @description  扫描拦截器
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Interceptor {
}
