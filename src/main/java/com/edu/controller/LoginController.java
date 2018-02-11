package com.edu.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.edu.service.IEmployeeService;

@Controller
public class LoginController {
	@Autowired
	IEmployeeService serviceEmp;
	
	@RequestMapping("/login.do")
	public String login(HttpServletRequest request,HttpSession session){
		String userId = request.getParameter("userId");
		String userPass = request.getParameter("userPass");
		boolean isLogin = serviceEmp.login(userId, userPass);
		if(isLogin){
			serviceEmp.selEmployee(empId, coId)
			
			return 
		}else{
			return "login.jsp";
		}
		return "";
	}
	
}
