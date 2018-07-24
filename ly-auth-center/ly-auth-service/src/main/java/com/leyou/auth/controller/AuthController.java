package com.leyou.auth.controller;

import com.leyou.auth.config.JwtProperties;
import com.leyou.auth.service.AuthService;
import com.leyou.common.utils.CookieUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.leyou.common.base.Result;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author chendong
 * @date 2018-07-11
 * @description
 */
@RestController
@EnableConfigurationProperties(JwtProperties.class)
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private JwtProperties prop;

    /**
     * 登录授权
     *
     * @param mobile
     * @param password
     * @return
     */
    @PostMapping("accredit")
    @ResponseBody
    public Result authentication(
            @RequestParam("mobile") String mobile,
            @RequestParam("password") String password,
            HttpServletRequest request,
            HttpServletResponse response) {
        if (StringUtils.isBlank(mobile)||StringUtils.isBlank(password)){
            return new Result(Result.SUCCESS_CODE,"请输入参数");
        }
        // 登录校验
        String token = this.authService.authentication(mobile, password);
        if (StringUtils.isBlank(token)) {
            return new Result(Result.SUCCESS_CODE,"认证失败");
        }
        // 将token写入cookie,并指定httpOnly为true，防止通过JS获取和修改
        CookieUtils.setCookie(request, response, prop.getCookieName(),
                token, prop.getCookieMaxAge(), null, true);
        return new Result(Result.SUCCESS_CODE,"认证成功",token);
    }




}
