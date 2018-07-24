package com.leyou.auth.service;

import com.leyou.auth.client.UserClient;
import com.leyou.auth.config.JwtProperties;
import com.leyou.auth.entity.UserInfo;
import com.leyou.auth.utils.JwtUtils;
import com.leyou.common.base.Result;
import com.leyou.common.utils.MapUtils;
import com.leyou.user.bean.UserInfoBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author chendong
 * @date 2018-07-11
 * @description
 */

@Service
@EnableConfigurationProperties(JwtProperties.class)
public class AuthService {

    @Autowired
    private JwtProperties jwtProp;

    @Autowired
    private UserClient userClient;

    private static Logger logger = LoggerFactory.getLogger(AuthService.class);

    public String authentication(String mobile, String password) {
        try {
            // 查询用户
          Result resp = this.userClient.queryUser(mobile, password);
            System.out.println("resp = " + resp.getCode()+resp.getMessage()+resp.getData());
            if (resp.getData() == null) {
                logger.info("用户信息不存在，{}", mobile);
                return null;
            }
            // 获取登录用户
            UserInfoBean user = MapUtils.map2Java(new UserInfoBean(), (Map) resp.getData());
            // 生成token
            String token = JwtUtils.generateToken(
                    new UserInfo(user.getUserCode(), user.getMobile()),
                    jwtProp.getPrivateKey(), jwtProp.getExpire());
            return token;
        } catch (Exception e) {
            System.out.println("e = " + e);
            return null;
        }
    }
}
