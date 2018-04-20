package com.edu.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.edu.entity.Bargain;
import com.edu.service.IBargainService;

@Controller
@RequestMapping("/bargain")
public class BargainController {

	@Autowired
	private IBargainService service;

	
	@RequestMapping("/index.do")
	public String index() {
		return "view/bargainSearch";
	}


	@RequestMapping("/bargain.do")
	public String selBargain(HttpServletRequest request, HttpSession session) {
		String barId = request.getParameter("bargainNo");
		String coId = session.getAttribute("userCoId") + "";
		Bargain bargain = service.selBargain("B" + barId, coId);
		request.setAttribute("bargain", bargain);
		return "view/bargainSearch";
	}

}
