package com.digihealth.sysMng.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digihealth.common.formbean.SystemSearchFormBean;
import com.digihealth.sysMng.dao.BasRoleDao;
import com.digihealth.sysMng.entity.BasRole;

@Service
public class BasRoleService {
	@Autowired BasRoleDao basRoleDao;

	public List<BasRole> queryList(@Param("formBean")SystemSearchFormBean formBean) {
		return basRoleDao.queryList(formBean);
	}

	public int getTotalAllRole() {
		return basRoleDao.getTotalAllRole();
	}
}
