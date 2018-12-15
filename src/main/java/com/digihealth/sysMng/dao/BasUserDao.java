package com.digihealth.sysMng.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.digihealth.common.formbean.SystemSearchFormBean;
import com.digihealth.sysMng.entity.BasUser;

@Mapper
public interface BasUserDao {
	
	public BasUser selectByPrimaryKey(String userName);

	public BasUser verifyUser(BasUser user);

	public List<BasUser> getAllUser(@Param("formBean")SystemSearchFormBean formBean);
	
	public int getTotalAllUser();
	
	public void updateByPrimaryKey(BasUser user);
}
