package com.edu.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.edu.entity.Employee;
import com.edu.service.IEmployeeService;
import com.edu.service.IFunctionService;
import com.edu.util.Result;

@Controller
public class LoginController {
	@Autowired
	IEmployeeService serviceEmp;
	@Autowired
	IFunctionService serviceFun;
	/**
	 * 
	 * @Title: login   
	 * @Description: 登录校验功能
	 * @param request
	 * @param session
	 * @return
	 * @author: MR.H
	 * @return: Result<Employee>
	 *
	 */
	@RequestMapping("/login.do")
	@ResponseBody
	public Result<Employee> login(HttpServletRequest request,HttpSession session){
		System.err.println("dasdasdsa");
		String userId = request.getParameter("userId");
		String userPass = request.getParameter("userPass");
		System.err.println(userId+userPass);
		Result<Employee> result = serviceEmp.login(userId, userPass);
		if(result.getStatus() ==Result.SUCCESS){
			//若返回为success 保存用信息
			Employee loginUserObj = result.getData();
			session.setAttribute("userName",loginUserObj.getEmpName());
			session.setAttribute("userCoId", loginUserObj.getCoId());
			session.setAttribute("permission", loginUserObj.getEmpPermission());
			session.setAttribute("funcs", serviceFun.functionForUser(loginUserObj.getEmpPermission()));
		}
		return result;
	}
	
}
