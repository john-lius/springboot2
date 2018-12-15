package com.digihealth.sysMng.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.digihealth.common.entity.ResponseValue;
import com.digihealth.common.formbean.SystemSearchFormBean;
import com.digihealth.sysMng.entity.BasRole;
import com.digihealth.sysMng.service.BasRoleService;

@RestController
@RequestMapping("sysMng/role")
@Api(value="BasRoleController")
public class BasRoleController {
	private Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private BasRoleService basRoleService;

	@RequestMapping("/list")
	public ModelAndView list() {
		ModelAndView mv = new ModelAndView();
        mv.setViewName("sysMng/role/list");
        return mv;
	}

	@ResponseBody
	@RequestMapping("/findAllRole")
	@ApiOperation(value="查询所有权限信息", httpMethod="POST", notes="查询所有权限信息")
	public String findAllRole(Integer page, Integer limit) {
		logger.info("==========begin findAllRole==========");
		ResponseValue resp = new ResponseValue();
		if (page > 0) {
			page = (page - 1) * limit;
		}
		SystemSearchFormBean formBean = new SystemSearchFormBean();
		formBean.setPage(page);
		formBean.setLimit(limit);
		List<BasRole> list = basRoleService.queryList(formBean);
		int total = basRoleService.getTotalAllRole();
		resp.put("data", list);
		resp.put("count", total);
		logger.info("==========end findAllRole==========");
		return resp.getJsonStr();
	}

	/**
	 * 编辑角色信息
	 * @return
	 */
//	@RequestMapping("/detail")
//	public ModelAndView detail(String userName) {
//		ModelAndView mv = new ModelAndView();
//		BasUser user = userService.selectByPrimaryKey(userName);
//		List<BasDictItem> userTypes = basDictItemService.queryListByGroupId("user_type");
//		List<BasDictItem> executiveLevels = basDictItemService.queryListByGroupId("executive_level");
//		List<BasDictItem> professionalTitles = basDictItemService.queryListByGroupId("professional_title");
//		List<BasRole> roles = basRoleService.queryList();
//        mv.addObject("user", user);
//        mv.addObject("roles", roles);
//        mv.addObject("userTypes", userTypes);
//        mv.addObject("executiveLevels", executiveLevels);
//        mv.addObject("professionalTitles", professionalTitles);
//        mv.setViewName("sysMng/user/detail");
//        return mv;
//	}
//
//	@RequestMapping(value = "/update", method = RequestMethod.POST)
//	@ResponseBody
//	public String update(@ModelAttribute BasUser entity) {
//		logger.info("begin updateBasUser");
//		Map<String, Object> map = new HashMap<String, Object>();
//		System.out.println("entity::::::::::" + entity);
//		userService.updateByPrimaryKey(entity);
//		map.put("code", "0");
//		map.put("msg", "操作成功");
//		logger.info("end updateBasUser");
//        return JSON.toJSONString(map);
//	}
}
