package com.leyou.user.service;

import com.leyou.user.bean.UserInfoBean;

/**
 * @author chendong
 * @date 2018-07-11
 * @description
 */

public interface IUserInfoService {

    UserInfoBean queryUserById(Long userId);

    UserInfoBean queryUser(String username, String password);
}
