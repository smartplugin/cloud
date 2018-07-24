package com.leyou.item.entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * PO类 
 * 
 * @author auto
 * @since 2018-07-11
 */
public class ItemInfoEntity {

    private static final long serialVersionUID = 1L;
    
	private Integer goodId;
	private String name;
	private BigDecimal price;
	private Date operDate;

	public Integer getGoodId() {
		return goodId;
	}
	
	public void setGoodId(Integer goodId) {
		this.goodId = goodId;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public BigDecimal getPrice() {
		return price;
	}
	
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	public Date getOperDate() {
		return operDate;
	}
	
	public void setOperDate(Date operDate) {
		this.operDate = operDate;
	}

	public static void main(String[] args) {

	}
}