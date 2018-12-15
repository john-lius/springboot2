package com.digihealth.basedata.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.digihealth.basedata.entity.BasDictItem;

@Mapper
public interface BasDictItemDao {
	public List<BasDictItem> queryListByGroupId(String groupId);
	
	public BasDictItem selectByPrimaryKey(String primaryKey);
	
	public void updateByPrimaryKey(BasDictItem entity);
}
