package com.leyou.user.entity;


/**
 * PO类 
 * 用户身份|角色
 * @author auto
 * @since 2018-07-16
 */
public class UserIdentityEntity {

    private static final long serialVersionUID = 1L;
    
    /** 系统生成ID */
	private Long uid;
    /** 用户ID */
	private Integer userId;
    /** 手机号 */
	private String phone;
    /** 名称 */
	private String name;
    /** 身份类型 0普通用户 1老师 2客服 3 巡管 */
	private Integer userType;
    /** 用户类型名称 */
	private String typeName;
    /** 1正常 2停用 */
	private Integer status;
    /** 修改人 */
	private Integer modifyUserId;
    /** 创建人 */
	private Integer createUserId;

    /** 系统生成ID */
	public Long getUid() {
		return uid;
	}
	
    /** 系统生成ID */
	public void setUid(Long uid) {
		this.uid = uid;
	}
	
    /** 用户ID */
	public Integer getUserId() {
		return userId;
	}
	
    /** 用户ID */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
    /** 手机号 */
	public String getPhone() {
		return phone;
	}
	
    /** 手机号 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
    /** 名称 */
	public String getName() {
		return name;
	}
	
    /** 名称 */
	public void setName(String name) {
		this.name = name;
	}
	
    /** 身份类型 0普通用户 1老师 2客服 3 巡管 */
	public Integer getUserType() {
		return userType;
	}
	
    /** 身份类型 0普通用户 1老师 2客服 3 巡管 */
	public void setUserType(Integer userType) {
		this.userType = userType;
	}
	
    /** 用户类型名称 */
	public String getTypeName() {
		return typeName;
	}
	
    /** 用户类型名称 */
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	
    /** 1正常 2停用 */
	public Integer getStatus() {
		return status;
	}
	
    /** 1正常 2停用 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	
    /** 修改人 */
	public Integer getModifyUserId() {
		return modifyUserId;
	}
	
    /** 修改人 */
	public void setModifyUserId(Integer modifyUserId) {
		this.modifyUserId = modifyUserId;
	}
	
    /** 创建人 */
	public Integer getCreateUserId() {
		return createUserId;
	}
	
    /** 创建人 */
	public void setCreateUserId(Integer createUserId) {
		this.createUserId = createUserId;
	}
	

}