package com.leyou.user.entity;

import java.util.Date;

/**
 * PO类 
 * 游客信息
 * @author auto
 * @since 2018-07-16
 */
public class VisitorInfoEntity  {

    private static final long serialVersionUID = 1L;
    
    /** 游客ID */
	private Integer visitorId;
    /** 游客昵称 */
	private String nickName;
    /** 是否首次登录 */
	private Integer isFirstLogin;
    /** 最后一次登录时间 */
	private Date lastLoginTime;
    /** 最后一次登录IP */
	private String lastLoginIp;
    /** 黑名单: 0 正常 1在黑名单 */
	private Integer isBlack;
    /** 是否禁言 0正常  1禁言 */
	private Integer isGag;
    /** 是否在线:  0不在线  1在线 */
	private Integer isOnline;
    /** 0正常用户 1在线  2禁言  3拉黑   游客没有删除 */
	private Integer status;
    /** 用户来源 */
	private String utmSource;

    /** 游客ID */
	public Integer getVisitorId() {
		return visitorId;
	}
	
    /** 游客ID */
	public void setVisitorId(Integer visitorId) {
		this.visitorId = visitorId;
	}
	
    /** 游客昵称 */
	public String getNickName() {
		return nickName;
	}
	
    /** 游客昵称 */
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	
    /** 是否首次登录 */
	public Integer getIsFirstLogin() {
		return isFirstLogin;
	}
	
    /** 是否首次登录 */
	public void setIsFirstLogin(Integer isFirstLogin) {
		this.isFirstLogin = isFirstLogin;
	}
	
    /** 最后一次登录时间 */
	public Date getLastLoginTime() {
		return lastLoginTime;
	}
	
    /** 最后一次登录时间 */
	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}
	
    /** 最后一次登录IP */
	public String getLastLoginIp() {
		return lastLoginIp;
	}
	
    /** 最后一次登录IP */
	public void setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
	}
	
    /** 黑名单: 0 正常 1在黑名单 */
	public Integer getIsBlack() {
		return isBlack;
	}
	
    /** 黑名单: 0 正常 1在黑名单 */
	public void setIsBlack(Integer isBlack) {
		this.isBlack = isBlack;
	}
	
    /** 是否禁言 0正常  1禁言 */
	public Integer getIsGag() {
		return isGag;
	}
	
    /** 是否禁言 0正常  1禁言 */
	public void setIsGag(Integer isGag) {
		this.isGag = isGag;
	}
	
    /** 是否在线:  0不在线  1在线 */
	public Integer getIsOnline() {
		return isOnline;
	}
	
    /** 是否在线:  0不在线  1在线 */
	public void setIsOnline(Integer isOnline) {
		this.isOnline = isOnline;
	}
	
    /** 0正常用户 1在线  2禁言  3拉黑   游客没有删除 */
	public Integer getStatus() {
		return status;
	}
	
    /** 0正常用户 1在线  2禁言  3拉黑   游客没有删除 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	
    /** 用户来源 */
	public String getUtmSource() {
		return utmSource;
	}
	
    /** 用户来源 */
	public void setUtmSource(String utmSource) {
		this.utmSource = utmSource;
	}
	

}