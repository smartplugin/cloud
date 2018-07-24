package com.leyou.gateway.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.annotation.Order;

import java.util.List;

/**
 * @author chendong
 * @date 2018-07-11
 * @description
 */
@ConfigurationProperties(prefix = "ly.filter")
public class FilterProperties {

    private List<String> allowPaths;

    public List<String>  getAllowPaths() {
        return allowPaths;
    }

    public void setAllowPaths(List<String>  allowPaths) {
        this.allowPaths = allowPaths;
    }

}
