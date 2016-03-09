/**
 * 作者：魏胜泽
 * 学校：长江师范学院
 * 学院：计算机工程学院
 * 专业：计算机科学与技术（软件服务外包）
 * 年级：2012级
 * 日期：2014年11月26日
 * 时间：下午1:18:40
 * 文件名：UserInfoBean.java
 * 所属包名：com.stock.bean
 * 所属项目名：Ambow
 * Designed by Shengze Wei in Chongqing Coded in Fuling
 * Copyright 2014 Shengze Wei. All rights reserved.
 */
package com.stock.bean;

public class UserInfoBean {
	private String userid;
	private String password;
	private String name;
	private String sex;
	private String birthday;
	private String email;
	private String telephone;
	// 账户信息（目前一人一个账户）
	private String accountBalance;
	private String lastModify;

	public UserInfoBean() {
		super();
	}

	/**
	 * @param userid
	 * @param password
	 * @param name
	 * @param sex
	 * @param birthday
	 * @param email
	 * @param telephone
	 * @param accountBalance
	 * @param lastModify
	 */
	public UserInfoBean(String userid, String password, String name,
			String sex, String birthday, String email, String telephone,
			String accountBalance, String lastModify) {
		super();
		this.userid = userid;
		this.password = password;
		this.name = name;
		this.sex = sex;
		this.birthday = birthday;
		this.email = email;
		this.telephone = telephone;
		this.accountBalance = accountBalance;
		this.lastModify = lastModify;
	}

	/**
	 * @return userid
	 */
	public String getUserid() {
		return userid;
	}

	/**
	 * @param userid
	 *            要设置的 userid
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}

	/**
	 * @return password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            要设置的 password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            要设置的 name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return sex
	 */
	public String getSex() {
		return sex;
	}

	/**
	 * @param sex
	 *            要设置的 sex
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}

	/**
	 * @return birthday
	 */
	public String getBirthday() {
		return birthday;
	}

	/**
	 * @param birthday
	 *            要设置的 birthday
	 */
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	/**
	 * @return email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            要设置的 email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return telephone
	 */
	public String getTelephone() {
		return telephone;
	}

	/**
	 * @param telephone
	 *            要设置的 telephone
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	/**
	 * @return accountBalance
	 */
	public String getAccountBalance() {
		return accountBalance;
	}

	/**
	 * @param accountBalance
	 *            要设置的 accountBalance
	 */
	public void setAccountBalance(String accountBalance) {
		this.accountBalance = accountBalance;
	}

	/**
	 * @return lastModify
	 */
	public String getLastModify() {
		return lastModify;
	}

	/**
	 * @param lastModify
	 *            要设置的 lastModify
	 */
	public void setLastModify(String lastModify) {
		this.lastModify = lastModify;
	}
}