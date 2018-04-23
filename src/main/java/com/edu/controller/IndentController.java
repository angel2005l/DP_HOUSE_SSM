package com.edu.controller;

import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.edu.base.BaseController;
import com.edu.base.Constant;
import com.edu.entity.House;
import com.edu.entity.Indent;
import com.edu.service.IHouseService;
import com.edu.service.IIndentService;
import com.edu.util.Result;
import com.edu.util.StrUtil;

@RequestMapping("/indent")
@Controller
public class IndentController extends BaseController {

	private static Logger log = LoggerFactory.getLogger(IndentController.class);

	@Autowired
	private IIndentService service;
	@Autowired
	private IHouseService houseService;

	/**
	 * 
	 * @Title: index   
	 * @Description: 跳转查询定点页面
	 * @return
	 * @author: MR.H
	 * @return: String
	 *
	 */
	@RequestMapping("/index.do")
	public String index() {
		return "redirect:/indent/selIndent.do";
	}

	/**
	 * 
	 * @Title: addIndent   
	 * @Description: 生成订单 
	 * @param request
	 * @param session
	 * @return
	 * @author: MR.H
	 * @return: Result<Object>
	 *
	 */
	@RequestMapping("/insIndent.do")
	@ResponseBody
	public Result<Object> addIndent(HttpServletRequest request, HttpSession session) {
		try {
			String houId = request.getParameter("houId");
			String discount = request.getParameter("indDiscount");
			String coId = session.getAttribute("userCoId") + "";
			String day = request.getParameter("day");

			House house = houseService.selHouseInfoById(houId);

			Indent insObj = new Indent();
			insObj.setIndInfo("顾客：" + Constant.CUSNAME[(int) (Math.random() * 3)] + "-房屋：【" + house.getHouName()
					+ "】租赁订单");
			insObj.setHouId(house.getHouId());
			BigDecimal houseMoney = house.getHouMoney();// 房屋价钱
			BigDecimal indDiscount = new BigDecimal(StrUtil.isBlank(discount) ? "1" : discount);
			BigDecimal indMoney = new BigDecimal("0.00");
			indMoney = houseMoney.multiply(indDiscount);
			insObj.setHouMoney(houseMoney);
			insObj.setIndMoney(indMoney);
			insObj.setIndDiscount(indDiscount);
			insObj.setCusId((int) (Math.random() * 1000) + "");
			insObj.setCoId(coId);
			insObj.setIndDay(Integer.valueOf(day));
			return service.insIndent(insObj);
		} catch (Exception e) {
			log.error(e.toString());
			return rtnErrorResult("生成订单异常");
		}

	}

	/**
	 * 
	 * @Title: selIndent   
	 * @Description:查询订单
	 * @param request
	 * @param session
	 * @return
	 * @author: MR.H
	 * @return: String
	 *
	 */
	@RequestMapping("/selIndent.do")
	public String selIndent(HttpServletRequest request, HttpSession session) {
		String pageSign = request.getParameter("pageSign");
		String pageNum = request.getParameter("pageNum");
		String empId = session.getAttribute("userId") + "";
		String coId = session.getAttribute("userCoId") + "";
		String permiType = session.getAttribute("permission") + "";
		String indId = request.getParameter("indentId");
		try {
			List<Indent> data = service.selIndent(permiType, indId, empId, coId, pageNum = StrUtil.isBlank(pageNum)
					? "1" : pageNum);

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
				data = service.selIndent(permiType, indId, empId, coId, page + "");
			}
			request.setAttribute("pageNum", page);
			request.setAttribute("IndentList", data);
		} catch (Exception e) {
			log.error("查询订单异常" + e.toString());
		}
		return "view/houseOrdMana";
	}

	/**
	 * 
	 * @Title: delIndent   
	 * @Description: 删除订单
	 * @param request
	 * @param session
	 * @return
	 * @author: MR.H
	 * @return: Result<Object>
	 *
	 */
	@RequestMapping("/delIndent.do")
	@ResponseBody
	public Result<Object> delIndent(HttpServletRequest request, HttpSession session) {
		String coId = session.getAttribute("userCoId") + "";
		String indId = request.getParameter("indId");
		return service.delIndent(indId, coId);
	}

	/**
	 * 
	 * @Title: upIndent   
	 * @Description: 确认订单   
	 * @param request
	 * @param session
	 * @return
	 * @author: MR.H
	 * @return: Result<Object>
	 *
	 */
	@RequestMapping("/updateIndent.do")
	@ResponseBody
	public Result<Object> upIndent(HttpServletRequest request, HttpSession session) {
		String coId = session.getAttribute("userCoId") + "";
		String indId = request.getParameter("indId");
		int index = Integer.parseInt(request.getParameter("inx"));
		try {
			return service.uptIndent(Constant.INDENTTYPE[index], indId, coId);
		} catch (Exception e) {
			log.error("订单状态更新异常,异常原因：" + e.getMessage());
			return rtnFailResult("订单状态更新异常");
		}
	}
}
