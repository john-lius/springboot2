package com.digihealth.basedata.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.digihealth.basedata.entity.BasDictGroup;

@Mapper
public interface basDictGroupDao {
	public List<BasDictGroup> queryListByGroupId(String groupId);

	public BasDictGroup selectByPrimaryKey(String primaryKey);

	public void updateByPrimaryKey(BasDictGroup entity);
}
