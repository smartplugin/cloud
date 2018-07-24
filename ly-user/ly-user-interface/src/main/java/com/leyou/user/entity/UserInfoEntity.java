package com.leyou.user.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * PO类 
 * 用户信息
 * @author auto
 * @since 2018-07-11
 */
public class UserInfoEntity  {

    private static final long serialVersionUID = 1L;
    
    /** 用户编码 */
	private String userCode;
    /** 密码 */
	private String passwd;
    /** 昵称 */
	private String nickName;
    /** 用户头像 */
	private String headPic;
    /** 手机号 */
	private String mobile;
    /** 真实姓名 */
	private String realName;
    /** 身份证号 */
	private String idcardNo;
    /** 手机号绑定状态: [0 未绑定; 1 已绑定] */
	private Integer isBindMobile;
    /** 是否实名: [0 未实名; 1 已实名] */
	private Integer isReal;
    /** 用户状态: [0 正常; 1 冻结; 2 黑名单; 3 注销] */
	private Integer status;
    /** 最后一次登录时间 */
	private Date lastLoginTime;
    /** 删除标记: [1 删除; 0 使用] */
	private Integer isDel;

    /** 用户编码 */
	public String getUserCode() {
		return userCode;
	}
	
    /** 用户编码 */
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	
    /** 密码 */
	public String getPasswd() {
		return passwd;
	}
	
    /** 密码 */
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	
    /** 昵称 */
	public String getNickName() {
		return nickName;
	}
	
    /** 昵称 */
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	
    /** 用户头像 */
	public String getHeadPic() {
		return headPic;
	}
	
    /** 用户头像 */
	public void setHeadPic(String headPic) {
		this.headPic = headPic;
	}
	
    /** 手机号 */
	public String getMobile() {
		return mobile;
	}
	
    /** 手机号 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
    /** 真实姓名 */
	public String getRealName() {
		return realName;
	}
	
    /** 真实姓名 */
	public void setRealName(String realName) {
		this.realName = realName;
	}
	
    /** 身份证号 */
	public String getIdcardNo() {
		return idcardNo;
	}
	
    /** 身份证号 */
	public void setIdcardNo(String idcardNo) {
		this.idcardNo = idcardNo;
	}
	
    /** 手机号绑定状态: [0 未绑定; 1 已绑定] */
	public Integer getIsBindMobile() {
		return isBindMobile;
	}
	
    /** 手机号绑定状态: [0 未绑定; 1 已绑定] */
	public void setIsBindMobile(Integer isBindMobile) {
		this.isBindMobile = isBindMobile;
	}
	
    /** 是否实名: [0 未实名; 1 已实名] */
	public Integer getIsReal() {
		return isReal;
	}
	
    /** 是否实名: [0 未实名; 1 已实名] */
	public void setIsReal(Integer isReal) {
		this.isReal = isReal;
	}
	
    /** 用户状态: [0 正常; 1 冻结; 2 黑名单; 3 注销] */
	public Integer getStatus() {
		return status;
	}
	
    /** 用户状态: [0 正常; 1 冻结; 2 黑名单; 3 注销] */
	public void setStatus(Integer status) {
		this.status = status;
	}
	
    /** 最后一次登录时间 */
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	public Date getLastLoginTime() {
		return lastLoginTime;
	}
	
    /** 最后一次登录时间 */
	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}
	
    /** 删除标记: [1 删除; 0 使用] */
	public Integer getIsDel() {
		return isDel;
	}
	
    /** 删除标记: [1 删除; 0 使用] */
	public void setIsDel(Integer isDel) {
		this.isDel = isDel;
	}
	

}