package com.edu.controller;

import java.sql.SQLException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.edu.entity.User;
import com.edu.service.IUserService;
import com.edu.util.Result;
@Controller
public class UserController {
	private Logger log = LoggerFactory.getLogger(UserController.class);
	@Resource
	private IUserService userService;
	
	@RequestMapping("/login.do")
	@ResponseBody
	public  Result<Object> test(HttpSession session,HttpServletRequest request){
		User user = new User();
		user.setUserCode("000001");
		user.setUserPassword("123456");
		String msg = "";
		try {
			if(userService.login(user)){
				session.setAttribute("userName", user.getId());
				msg = "登录成功";
			}else{
				msg = "登录失败";
			}
		} catch (SQLException e) {
			System.err.println("操作异常："+e.getMessage());
			log.error(e.getMessage());
		}
		Result<Object> result = new Result<Object>();
		result.setStatus(1);
		result.setMsg(msg);
		return result;
	}

	@RequestMapping("/home.do")
	public String toHome(){
		return "success";
	}
	
}
