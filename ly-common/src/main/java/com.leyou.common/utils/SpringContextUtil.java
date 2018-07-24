package com.leyou.common.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.logging.Logger;


/**
 * 上下文工具类
 */
public class SpringContextUtil implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    public static Object getBean(String beanId) {
        if (applicationContext==null){
            System.out.println("beanId ------初始化失败"+beanId);
            return new Object();
        }
        return applicationContext.getBean(beanId);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringContextUtil.applicationContext=applicationContext;
    }
}
