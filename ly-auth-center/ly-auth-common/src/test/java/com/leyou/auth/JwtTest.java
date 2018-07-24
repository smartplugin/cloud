package com.leyou.auth;

import com.leyou.auth.entity.UserInfo;
import com.leyou.auth.utils.JwtUtils;
import com.leyou.auth.utils.RsaUtils;

import java.security.PrivateKey;
import java.security.PublicKey;

/**
 * @author chendong
 * @date 2018-07-11
 * @description
 */

public class JwtTest {

    private static final String pubKeyPath = "W:\\data\\rsa\\rsa.pub";

    private static final String priKeyPath = "W:\\data\\rsa\\rsa.pri";

    private PublicKey publicKey;

    private PrivateKey privateKey;

//    @Test
    public void testRsa() throws Exception {
        //根据密文，生存rsa公钥和私钥,并写入指定文件
        RsaUtils.generateKey(pubKeyPath, priKeyPath, "234");
    }

//    @Before
    public void testGetRsa() throws Exception {
        this.publicKey = RsaUtils.getPublicKey(pubKeyPath);
        this.privateKey = RsaUtils.getPrivateKey(priKeyPath);
    }

//    @Test
    public void testGenerateToken() throws Exception {
        // 生成token
        String token = JwtUtils.generateToken(new UserInfo("20", "jack"), privateKey, 5);
        System.out.println("token = " + token);
    }

//    @Test
    public void testParseToken() throws Exception {
//        String token = "eyJhbGciOiJSUzI1NiJ9.eyJpZCI6MjAsInVzZXJOYW1lIjoiamFjayIsImV4cCI6MTUyNzMzMDY5NX0.VpGNedy1z0aR262uAp2sM6xB4ljuxa4fzqyyBpZcGTBNLodIfuCNZkOjdlqf-km6TQPoz3epYf8cc_Rf9snsGdz4YPIwpm6X14JKU9jwL74q6zy61J8Nl9q7Zu3YnLibAvcnC_y9omiqKN8-iCi7-MvM-LwVS7y_Cx9eu0aaY8E";
        String token = " eyJhbGciOiJSUzI1NiJ9.eyJpZCI6MjAsInVzZXJuYW1lIjoiamFjayIsImV4cCI6MTUzMTI3ODM3Nn0.Y8y49K8Pddtc--nlGg-KTA8XnfEQmLmAIT49AVtMcKCuqXN5xnx9w36HtMvUtZ0BO6wOPSf9lYHUNJNfTMsLhcAsoOwmplOkQ-Q-4Ixiepzg7MrPEED7vrxxbXJxLnKwjh4qVQPbbMHm4P1ZDfnTw_8wVC5VlOnXSdyVJ2E1bv0";
        // 解析token
        UserInfo user = JwtUtils.getInfoFromToken(token, publicKey);
        System.out.println("id: " + user.getUserCode());
        System.out.println("userName: " + user.getMobile());
    }
}
