package com.digihealth.basedata.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digihealth.basedata.dao.BasDictItemDao;
import com.digihealth.basedata.entity.BasDictItem;

@Service
public class BasDictItemService {
	@Autowired BasDictItemDao basDictItemDao;

	public List<BasDictItem> queryListByGroupId(String groupId) {
		return basDictItemDao.queryListByGroupId(groupId);
	}
}
