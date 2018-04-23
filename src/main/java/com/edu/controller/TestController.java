package com.edu.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.edu.entity.Test;
import com.edu.service.ITestService;

@Controller
public class TestController {
	@Resource
	ITestService testService;

	@RequestMapping("/test.do")
	public String selTestController(HttpServletRequest request, HttpSession session) {
		String parameter = request.getParameter("username");
		Test selTestSer = testService.selTestSer(parameter);
		session.setAttribute("userObj", selTestSer);
		return "indexForResult";
	}
}
