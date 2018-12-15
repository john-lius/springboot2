package com.digihealth.login.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.digihealth.common.web.BaseController;
import com.digihealth.sysMng.entity.BasUser;
import com.digihealth.sysMng.service.BasUserService;

@Controller
//@RequestMapping("/login")
public class LoginController extends BaseController {
	@Autowired
	private BasUserService basUserService;

	@RequestMapping("/")
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView();
		logger.info("进入登录界面...........");
        mv.addObject("msg", "这是我的登录界面。");
        mv.setViewName("login");
        return mv;
	}

	@RequestMapping("/home")
	public ModelAndView home() { //首页
		ModelAndView mv = new ModelAndView();
        mv.addObject("msg", "这是我的登录界面。");
        mv.setViewName("home");
        return mv;
	}

	@RequestMapping("/login")
	public ModelAndView login(HttpServletRequest request) {
		logger.info("-------------begin login-----------------");
		ModelAndView mv = new ModelAndView();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		BasUser user = new BasUser();
		user.setUserName(username);
		user.setPassword(password);
		BasUser basUser = basUserService.verifyUser(user);
		if (basUser != null) {
			mv.addObject("user", basUser);
			mv.setViewName("login/index");
		} else {
			mv.setViewName("login/error");
		}
        return mv;
	}
}
