package com.leyou.user.bean;

import com.leyou.user.entity.UserInfoEntity;

import javax.persistence.Table;

/**
 * VO类
 * 用户信息
 * @author auto
 * @since 2018-07-11
 */
@Table(name = "user_info")
public class UserInfoBean extends UserInfoEntity {

	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {

	}
}
