package com.edu.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.edu.base.BaseController;
import com.edu.entity.Company;
import com.edu.service.ICompanyService;
import com.edu.util.Result;
import com.edu.util.StrUtil;

@Controller
@RequestMapping("/company")
public class CompanyController extends BaseController {
	private static Logger log = LoggerFactory.getLogger(CompanyController.class);

	@Autowired
	private ICompanyService service;

	// 注册公司
	@RequestMapping("/insCompany.do")
	@ResponseBody
	public Result<Object> insCompany(HttpServletRequest request) {
		String coName = request.getParameter("coName");
		String coAddCode = request.getParameter("coAddCode");
		String coType = request.getParameter("coType");
		String coUniqueId = request.getParameter("coUniqueId");
		String coAdd = request.getParameter("coAdd");

		Company insObj = new Company();

		insObj.setCoSimpleName("");
		insObj.setCoName(coName);
		insObj.setCoAddCode(coAddCode);
		insObj.setCoType(coType);
		insObj.setCoUniqueId(coUniqueId);
		insObj.setCoAdd(coAdd);
		return service.insCompany(insObj);
	}

	// 确认公司
	@RequestMapping("/uptCompany.do")
	@ResponseBody
	public Result<Object> uptCompany(HttpServletRequest request) {
		String coId = request.getParameter("coId");
		String simpleName = request.getParameter("simpleName");
		return service.uptCompany(coId, simpleName);
	}

	@RequestMapping("/delCompany.do")
	@ResponseBody
	public Result<Object> delCompany(HttpServletRequest request) {
		String coId = request.getParameter("coId");
		return service.delCompany(coId);
	}

	@RequestMapping("/index.do")
	public String index() {
		return "redirect:/company/selCompany.do";
	}

	// 查询公司
	@RequestMapping("/selCompany.do")
	public String selCompany(HttpServletRequest request) {
		String coId = request.getParameter("coId");
		String simpleName = request.getParameter("simpleName");
		String pageSign = request.getParameter("pageSign");
		String pageNum = request.getParameter("pageNum");

		List<Company> data = service.selCompany(coId, simpleName, pageNum = StrUtil.isBlank(pageNum) ? "1" : pageNum);
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
			data = service.selCompany(coId, simpleName, page + "");

		}
		request.setAttribute("companyList", data);
		request.setAttribute("pageNum", page);
		return "view/allCompany";
	}

}
