package com.leyou.user.entity;


/**
 * PO类 
 * 游客客服关系表
 * @author auto
 * @since 2018-07-16
 */
public class VisitorServiceEntity  {

    private static final long serialVersionUID = 1L;
    
    /** 游客ID */
	private Integer visitorId;
    /** 客服ID */
	private Integer serviceUserId;
    /** 删除标记: [1 删除; 0 使用] */
	private Integer isDel;

    /** 游客ID */
	public Integer getVisitorId() {
		return visitorId;
	}
	
    /** 游客ID */
	public void setVisitorId(Integer visitorId) {
		this.visitorId = visitorId;
	}
	
    /** 客服ID */
	public Integer getServiceUserId() {
		return serviceUserId;
	}
	
    /** 客服ID */
	public void setServiceUserId(Integer serviceUserId) {
		this.serviceUserId = serviceUserId;
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