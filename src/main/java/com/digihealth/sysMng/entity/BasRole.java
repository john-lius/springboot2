package com.digihealth.sysMng.entity;

public class BasRole {
	/**
	 * 主键id
	 */
	private String id;
	/**
	 * 角色名称
	 */
	private String name;

	private String menuName;
	/**
	 * 描述
	 */
	private String description;

	/**
	 * 是否可用:1-可用，0-不可用
	 */
	private Integer enable;
	/**
	 * 角色类型 运营管理员：OPERATOR_ADMIN,系统管理员：ADMIN,麻醉医生：ANAES_DOCTOR,护士：NURSE,护士长：
	 * HEAD_NURSE,麻醉主任：ANAES_DIRECTOR,其他：OTHER
	 */
	private String roleType;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description == null ? null : description.trim();
	}

	public Integer getEnable() {
		return enable;
	}

	public void setEnable(Integer enable) {
		this.enable = enable;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getRoleType() {
		return roleType = roleType == null ? null : roleType.trim();
	}

	public void setRoleType(String roleType) {
		this.roleType = roleType;
	}

}