package com.edu.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.edu.entity.Employee;
import com.edu.entity.FunctionDIY;
import com.edu.service.IEmployeeService;
import com.edu.service.IFunctionService;
import com.edu.util.Result;
import com.edu.util.StrUtil;

@Controller
public class LoginController {
	@Autowired
	IEmployeeService serviceEmp;
	@Autowired
	IFunctionService serviceFun;
	
	@RequestMapping("/login.do")
	@ResponseBody
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
	public String indexForFunDisplay(HttpServletRequest request,HttpSession session){
		Object permissionForUser = session.getAttribute("permission");
		if(StrUtil.isBlank(permissionForUser+"")){
			return "login.jsp";
		}
		//根据权限查询所拥有的权限
		Result<List<FunctionDIY>> result = serviceFun.functionForUser(session.getAttribute("permission")+"");
		if(result.getStatus() == Result.SUCCESS){
			request.setAttribute("functionDatas", result.getData());
			return "index.jsp";
		}
		return "login.jsp";
	}
	
}
