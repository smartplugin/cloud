package com.leyou.user.service.impl;

import com.leyou.user.bean.UserInfoBean;
import com.leyou.user.mapper.UserInfoMapper;
import com.leyou.user.service.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author chendong
 * @date 2018-07-11
 * @description
 */
@Service("userInfoService")
public class UserInfoService implements IUserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public UserInfoBean queryUserById(Long userId) {
        UserInfoBean user = new UserInfoBean();
        user.setUserCode(String.valueOf(userId));
        return userInfoMapper.selectOne(user);
    }

    @Override
    public UserInfoBean queryUser(String mobile, String password) {
        UserInfoBean user = new UserInfoBean();
        user.setMobile(mobile);
        user.setPasswd(password);
        return userInfoMapper.selectOne(user);
    }
}
