package com.edu.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.edu.entity.Employee;
import com.edu.service.IEmployeeService;
import com.edu.service.IFinanceService;
import com.edu.service.IFunctionService;
import com.edu.service.IHouseService;
import com.edu.service.IIndentService;
import com.edu.util.Result;

@Controller
public class LoginController {
	private static final Logger log = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	private IEmployeeService serviceEmp;
	@Autowired
	private IFunctionService serviceFun;
	@Autowired
	private IHouseService serviceHouse;
	@Autowired
	private IIndentService serviceIndent;
	@Autowired
	private IFinanceService serviceFinance;

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
	public Result<Employee> login(HttpServletRequest request, HttpSession session) {
		String userId = request.getParameter("userId");
		String userPass = request.getParameter("userPass");
		Result<Employee> result = serviceEmp.login(userId, userPass);
		if (result.getStatus() == Result.SUCCESS) {
			// 若返回为success 保存用信息
			Employee loginUserObj = result.getData();
			session.setAttribute("userName", loginUserObj.getEmpName());
			session.setAttribute("userCoId", loginUserObj.getCoId());
			session.setAttribute("userId", loginUserObj.getEmpId());
			session.setAttribute("permission", loginUserObj.getEmpPermission());
			session.setAttribute("funcs", serviceFun.functionForUser(loginUserObj.getEmpPermission()));
		}
		return result;
	}

	/**
	 * 
	 * @Title: logout   
	 * @Description: 登出
	 * @param session
	 * @return
	 * @author: MR.H
	 * @return: String
	 *
	 */
	@RequestMapping("/logout.do")
	public String logout(HttpSession session) {
		session.invalidate();
		return "login";
	}

	@RequestMapping("/index.do")
	public String index(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws IOException {
		try {
			String empId = session.getAttribute("userId") + "";
			String coId = session.getAttribute("userCoId") + "";
			String empPer = session.getAttribute("permission") + "";
			request.setAttribute("financeCount", serviceFinance.selFinanceCountByEmpInfo("1".equals(empPer) ? empId
					: coId,
					empPer));
			request.setAttribute("indentCount", serviceIndent.selIndentCountByEmpInfo("1".equals(empPer) ? empId : coId,
					empPer));
			request.setAttribute("houseCount", serviceHouse.selHouseCountByEmpId(empId));
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return "view/index";
	}
}
