package com.digihealth.basedata.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

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
@Api(value = "BasDictItemController", description = "数据字典API")
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

	@ResponseBody
	@RequestMapping(value = "/queryListByGroupId")
	@ApiOperation(value = "根据GroupId查询数据字典值", httpMethod="POST", notes = "根据GroupId查询数据字典值")
	public String queryListByGroupId(String groupId) {
		logger.info("==========begin queryListByGroupId==========");
		ResponseValue resp = new ResponseValue();
		List<BasDictItem> list = basDictItemService.queryListByGroupId(groupId);
		resp.put("data", list);
		logger.info("==========end queryListByGroupId==========");
		return resp.getJsonStr();
	}

}
