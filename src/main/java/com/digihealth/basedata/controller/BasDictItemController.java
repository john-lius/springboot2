package com.digihealth.basedata.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.digihealth.basedata.entity.BasDictItem;
import com.digihealth.basedata.service.BasDictItemService;
import com.digihealth.common.entity.ResponseValue;

@RestController
@RequestMapping(value = "/basedata")
public class BasDictItemController {
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private BasDictItemService basDictItemService;

//	@RequestMapping(value = "/queryList")
//	@ResponseBody
//	public String queryList(String groupId) {
//		logger.info("==========begin queryList==========");
//		ResponseValue resp = new ResponseValue();
//		List<BasDictItem> list = basDictItemService.queryList(groupId);
//		resp.put("data", list);
//		logger.info("==========end queryList==========");
//		return resp.getJsonStr();
//	}

	@RequestMapping(value = "/queryListByGroupId")
	@ResponseBody
	public String queryListByGroupId(String groupId) {
		logger.info("==========begin queryListByGroupId==========");
		ResponseValue resp = new ResponseValue();
		List<BasDictItem> list = basDictItemService.queryListByGroupId(groupId);
		resp.put("data", list);
		logger.info("==========end queryListByGroupId==========");
		return resp.getJsonStr();
	}

}
