package com.digihealth.sysMng.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.digihealth.basedata.entity.BasDictItem;
import com.digihealth.basedata.service.BasDictItemService;
import com.digihealth.common.entity.ResponseValue;
import com.digihealth.common.formbean.SystemSearchFormBean;
import com.digihealth.sysMng.entity.BasRole;
import com.digihealth.sysMng.entity.BasUser;
import com.digihealth.sysMng.service.BasRoleService;
import com.digihealth.sysMng.service.BasUserService;

@RestController
@RequestMapping("sysMng/user")
@Api(value="BasUserController")
public class BasUserController {
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private BasUserService userService;
	@Autowired
	private BasDictItemService basDictItemService;
	@Autowired
	private BasRoleService basRoleService;

	@ResponseBody
	@RequestMapping("/findAllUser")
	@ApiOperation(value="查询所有用户信息", httpMethod="POST", notes="查询所有用户信息")
	public String findAllUser(Integer page, Integer limit) {
		ResponseValue resp = new ResponseValue();
		SystemSearchFormBean formBean = new SystemSearchFormBean();
		formBean.setPage(page);
		formBean.setLimit(limit);
		logger.info("formBean:" + formBean.getPage());
		List<BasUser> list = userService.getAllUser(formBean);
		int total = userService.getTotalAllUser();
		logger.info("查询所有用户信息.");
		resp.put("data", list);
		resp.put("count", total);
		return resp.getJsonStr();
	}

	@RequestMapping("/tabs")
	public ModelAndView tabs() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("userUrl", "sysMng/user/list :: userFrm");
        mv.setViewName("sysMng/user/tabs");
        return mv;
	}

	@RequestMapping("/list")
	public ModelAndView list() {
		ModelAndView mv = new ModelAndView();
		System.out.println("OOOOOOOOOOOOOOOOOOOLLLLL");
        mv.setViewName("sysMng/user/list");
        return mv;
	}

	/**
	 * 编辑用户信息
	 * @return
	 */
	@RequestMapping("/detail")
	public ModelAndView detail(String userName) {
		ModelAndView mv = new ModelAndView();
		BasUser user = userService.selectByPrimaryKey(userName);
		if (user == null) {
			user = new BasUser();
		}
		List<BasDictItem> userTypes = basDictItemService.queryListByGroupId("user_type");
		List<BasDictItem> executiveLevels = basDictItemService.queryListByGroupId("executive_level");
		List<BasDictItem> professionalTitles = basDictItemService.queryListByGroupId("professional_title");
		List<BasRole> roles = basRoleService.queryList(new SystemSearchFormBean());
        mv.addObject("user", user);
        mv.addObject("roles", roles);
        mv.addObject("userTypes", userTypes);
        mv.addObject("executiveLevels", executiveLevels);
        mv.addObject("professionalTitles", professionalTitles);
        mv.setViewName("sysMng/user/detail");
        return mv;
	}

	@ResponseBody
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ApiOperation(value="修改保存用户信息", httpMethod="POST", notes="修改保存用户信息")
	public String update(@RequestBody BasUser entity) {
		logger.info("begin updateBasUser");
		Map<String, Object> map = new HashMap<String, Object>();
		System.out.println("entity.userName::::::::::" + entity.getUserName());
		userService.updateByPrimaryKey(entity);
		map.put("code", "0");
		map.put("msg", "操作成功");
		logger.info("end updateBasUser");
        return JSON.toJSONString(map);
	}
}
