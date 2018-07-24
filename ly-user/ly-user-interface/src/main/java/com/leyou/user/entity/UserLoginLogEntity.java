package com.leyou.user.entity;

import java.util.Date;

/**
 * PO类 
 * 用户登录日志
 * @author auto
 * @since 2018-07-16
 */
public class UserLoginLogEntity  {

    private static final long serialVersionUID = 1L;
    
    /** 用户ID */
	private Integer userId;
    /** 登录IP */
	private String loginIp;
    /** 登录设备IMEI */
	private String loginImei;
    /** 登录时间 */
	private Date loginTime;

    /** 用户ID */
	public Integer getUserId() {
		return userId;
	}
	
    /** 用户ID */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
    /** 登录IP */
	public String getLoginIp() {
		return loginIp;
	}
	
    /** 登录IP */
	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}
	
    /** 登录设备IMEI */
	public String getLoginImei() {
		return loginImei;
	}
	
    /** 登录设备IMEI */
	public void setLoginImei(String loginImei) {
		this.loginImei = loginImei;
	}
	
    /** 登录时间 */
	public Date getLoginTime() {
		return loginTime;
	}
	
    /** 登录时间 */
	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}
	

}