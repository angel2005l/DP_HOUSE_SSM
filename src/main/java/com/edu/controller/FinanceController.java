package com.edu.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.edu.base.BaseController;
import com.edu.entity.Finance;
import com.edu.service.IFinanceService;
import com.edu.util.StrUtil;

@Controller
@RequestMapping("/finance")
public class FinanceController extends BaseController {
	private static Logger log = LoggerFactory.getLogger(FinanceController.class);

	@Autowired
	private IFinanceService service;

	@RequestMapping("index.do")
	public String index() {
		return "";
	}

	// 查询订单信息
	@RequestMapping("/selFinance.do")
	public String selFinance(HttpServletRequest request, HttpSession session) {
		String userPer = session.getAttribute("permission") + "";
		String coId = session.getAttribute("userCoId") + "";
		String pageSign = request.getParameter("pageSign");
		String pageNum = request.getParameter("pageNum");
		String empId = "1".equals(userPer) ? session.getAttribute("userId") + "" : request.getParameter("empId");
		String finId = request.getParameter("finId");
		try {
			List<Finance> data = service.selFinance(empId, coId, pageNum = StrUtil.isBlank(pageNum) ? "1" : pageNum,
					userPer,finId);
			int page = StrUtil.isBlank(pageNum) ? 1 : Integer.parseInt(pageNum);
			if (StrUtil.notBlank(pageSign) && null != data && !data.isEmpty()) {
				switch (pageSign) {
				case "add":
					page++;
					break;
				case "minus":
					if (page > 1) {
						page--;
					}
					break;
				}
			} else {
				if (page > 1) {
					page--;
				}
				data = service.selFinance(empId, coId, page + "", userPer,finId);
			}
			request.setAttribute("empId", empId);
			request.setAttribute("pageNum", page);
			request.setAttribute("finList", data);
		} catch (Exception e) {
			log.error("财务查询异常,异常原因" + e.getMessage());
		}

		return "view/income";
	}
}
