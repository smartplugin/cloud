package com.leyou.gateway;

import com.leyou.gateway.filter.AuthFilter;
import org.aspectj.lang.annotation.After;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

/**
 * @author chendong
 * @date 2018-07-03
 * @description
 */
@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
public class LyApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(LyApiApplication.class, args);
    }

}
