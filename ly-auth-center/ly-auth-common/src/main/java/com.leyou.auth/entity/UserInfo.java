package com.leyou.auth.entity;

/**
 * @author chendong
 * @date 2018-07-11
 * @description
 */

public class UserInfo {
    private String userCode;
    private String mobile;

    public UserInfo() {
    }

    public UserInfo(String userCode, String mobile) {
        this.userCode = userCode;
        this.mobile = mobile;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}