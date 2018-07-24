package com.leyou.user.entity;


/**
 * PO类 
 * 用户注册来源
 * @author auto
 * @since 2018-07-16
 */
public class UserRegistFromEntity  {

    private static final long serialVersionUID = 1L;
    
    /** 用户ID */
	private Integer userId;
    /** 注册平台:[1交易 2直播间 3资讯] */
	private Integer regPlat;
    /** 注册渠道:[0自主注册 1链接加入; 2邀请码加入; 3管理员加入] */
	private Integer regSource;

    /** 用户ID */
	public Integer getUserId() {
		return userId;
	}
	
    /** 用户ID */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
    /** 注册平台:[1交易 2直播间 3资讯] */
	public Integer getRegPlat() {
		return regPlat;
	}
	
    /** 注册平台:[1交易 2直播间 3资讯] */
	public void setRegPlat(Integer regPlat) {
		this.regPlat = regPlat;
	}
	
    /** 注册渠道:[0自主注册 1链接加入; 2邀请码加入; 3管理员加入] */
	public Integer getRegSource() {
		return regSource;
	}
	
    /** 注册渠道:[0自主注册 1链接加入; 2邀请码加入; 3管理员加入] */
	public void setRegSource(Integer regSource) {
		this.regSource = regSource;
	}
	

}