package com.edu.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.edu.entity.Employee;
import com.edu.service.IEmployeeService;
import com.edu.util.Result;

@Controller
public class LoginController {
	@Autowired
	IEmployeeService serviceEmp;
	@Autowired
	
	
	@RequestMapping("/login.do")
	public Result<Employee> login(HttpServletRequest request,HttpSession session){
		String userId = request.getParameter("userId");
		String userPass = request.getParameter("userPass");
		Result<Employee> result = serviceEmp.login(userId, userPass);
		if(result.getStatus() ==Result.SUCCESS){
			Employee loginUserObj = result.getData();
			session.setAttribute("userName",loginUserObj.getEmpName());
			session.setAttribute("userCoId", loginUserObj.getCoId());
			session.setAttribute("permission", loginUserObj.getEmpPermission());
			
		}
		return result;
	}
	
	@RequestMapping("/indexFun.do")
	public String indexForFunDisplay(HttpRequest request,HttpSession session){
		
		//根据权限查询所拥有的权限
		
		
		return "";
	}
	
}
