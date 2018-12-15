package com.digihealth.sysMng.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.digihealth.common.formbean.SystemSearchFormBean;
import com.digihealth.sysMng.entity.BasRole;

@Mapper
public interface BasRoleDao {

	public BasRole selectByPrimaryKey(String id);

	public List<BasRole> queryList(@Param("formBean")SystemSearchFormBean formBean);
	
	public int getTotalAllRole();

	public void updateByPrimaryKey(BasRole role);
}
