package com.leyou.gateway.filter;

import com.leyou.auth.utils.JwtUtils;
import com.leyou.common.config.JwtProperties;
import com.leyou.gateway.config.FilterProperties;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author chendong
 * @date 2018-07-11
 * @description 权限验证拦截器
 */
@Component
@EnableConfigurationProperties({JwtProperties.class, FilterProperties.class})
public class AuthFilter extends ZuulFilter {

    private final Logger logger = LoggerFactory.getLogger(AuthFilter.class);

    @Autowired
    private JwtProperties jwtProperties;

    @Autowired
    private FilterProperties filterProperties;

    /**
     * filterType：返回字符串，代表过滤器的类型。包含以下4种：
     * - pre：       请求在被路由之前执行
     * - routing：在路由请求时调用
     * - post：     在 routing和 error过滤器之后调用
     * - error：   处理请求时发生错误调用
     *
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        //通过返回的int值来定义过滤器的执行顺序，数字越小优先级越高。
        return 1;
    }

    /**
     * 是否需要进行过滤，返回true则执行 run()方法，false则跳过
     *
     * @return
     */
    @Override
    public boolean shouldFilter() {
        logger.info("进入网管拦截器");
        // 1）获取Zuul提供的请求上下文对象
        RequestContext ctx = RequestContext.getCurrentContext();
        // 2) 从上下文中获取request对象
        HttpServletRequest req = ctx.getRequest();
        // 3)获取请求路径
        String url = req.getServletPath();
        // 4) 获取允许访问的白名单路径
        boolean flag = true;
        for (String allowPath : this.filterProperties.getAllowPaths()) {
            if (url.startsWith(allowPath)) {
                flag = false;
            }
        }
        return flag;
    }

    @Override
    public Object run() throws ZuulException {

        // 1）获取Zuul提供的请求上下文对象
        RequestContext ctx = RequestContext.getCurrentContext();
        // 2) 从上下文中获取request对象
        HttpServletRequest req = ctx.getRequest();
        // 3) 从请求中获取token
        String token = req.getHeader(jwtProperties.getCookieName());
        if (StringUtils.isBlank(token)) {
            // 没有token，登录校验失败，拦截
            ctx.setSendZuulResponse(false);
            // 返回401状态码。也可以考虑重定向到登录页。
            ctx.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
        }
        try {
            logger.info(jwtProperties.getCookieName() + " : " + token);
            JwtUtils.getInfoFromToken(token, jwtProperties.getPublicKey());
        } catch (Exception e) {
            logger.info("jwt 验证失败：{}", e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
}
