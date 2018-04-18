package com.edu.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.edu.service.IIndentService;
import com.edu.util.Result;

public class IndentController {

	private static Logger log = LoggerFactory.getLogger(IndentController.class);

	@Autowired
	private IIndentService service;

	// 生成订单
	public Result<Object> addIndent(HttpServletRequest request) {

		return null;
	}

	// 查询订单
	public String selIndent(HttpServletRequest request) {

		return "";
	}

	// 删除订单
	public Result<Object> delIndent(HttpServletRequest request) {

		return null;
	}

	// 确认订单
	public Result<Object> upIndent(HttpServletRequest request) {
		
		return null;
	}
}
