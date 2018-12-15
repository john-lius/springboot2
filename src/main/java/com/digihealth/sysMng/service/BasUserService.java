package com.digihealth.sysMng.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digihealth.common.formbean.SystemSearchFormBean;
import com.digihealth.sysMng.dao.BasUserDao;
import com.digihealth.sysMng.entity.BasUser;

@Service
public class BasUserService {

	@Autowired
	private BasUserDao basUserDao;

	public BasUser selectByPrimaryKey(String userName) {
		return basUserDao.selectByPrimaryKey(userName);
	}

	public BasUser verifyUser(BasUser user) {
		return basUserDao.verifyUser(user);
	}

	public List<BasUser> getAllUser(SystemSearchFormBean formBean) {
		return basUserDao.getAllUser(formBean);
	}

	public void updateByPrimaryKey(BasUser user) {
		basUserDao.updateByPrimaryKey(user);
	}

	public int getTotalAllUser() {
		return basUserDao.getTotalAllUser();
	}
}
