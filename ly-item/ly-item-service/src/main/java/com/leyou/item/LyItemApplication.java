package com.leyou.item;

import com.leyou.common.utils.SpringContextUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.instrument.classloading.InstrumentationLoadTimeWeaver;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author chendong
 * @date 2018-07-03
 * @description
 */
@SpringBootApplication(scanBasePackages = "com.leyou")
@EnableDiscoveryClient
@MapperScan(value = "com.leyou.item.mapper")
public class LyItemApplication {
    public static void main(String[] args) {
        SpringApplication.run(LyItemApplication.class, args);
    }
//
//    @Bean
//    public InstrumentationLoadTimeWeaver loadTimeWeaver() throws Throwable {
//        InstrumentationLoadTimeWeaver loadTimeWeaver = new InstrumentationLoadTimeWeaver();
//        return loadTimeWeaver;
//    }

    @Bean
    public SpringContextUtil springContextUtil() {
        return new SpringContextUtil();
    }
}
