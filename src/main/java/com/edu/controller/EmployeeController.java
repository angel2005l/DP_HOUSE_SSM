package com.edu.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.edu.base.BaseController;
import com.edu.base.Constant;
import com.edu.entity.Employee;
import com.edu.service.IEmployeeService;
import com.edu.util.IOUtil;
import com.edu.util.POIUtil;
import com.edu.util.Result;
import com.edu.util.StrUtil;

@Controller
@RequestMapping("/employee")
public class EmployeeController extends BaseController {
	private static Logger log = LoggerFactory.getLogger(EmployeeController.class);
	private String path = "upLoadFiles/excel";
	@Autowired
	private IEmployeeService service;

	/**
	 * 
	 * @Title: index   
	 * @Description: 跳转员工信息主页
	 * @return
	 * @author: MR.H
	 * @return: String
	 *
	 */
	@RequestMapping("/index.do")
	public String index() {
		return "redirect:/employee/selEmployee.do";
	}

	/**
	 * 
	 * @Title: batchInsEmpInfo   
	 * @Description: 批量注册员工信息
	 * @param mf
	 * @param request
	 * @param session
	 * @return
	 * @author: MR.H
	 * @return: Result<Object>
	 *
	 */
	@RequestMapping("/insEmpInfo.do")
	@ResponseBody
	public Result<Object> batchInsEmpInfo(@RequestParam("employeeInfo") MultipartFile mf, HttpServletRequest request,
			HttpSession session) {
		String filePath = IOUtil.uploadFile(mf, path, "");
		if (StrUtil.isBlank(filePath)) {
			return rtnFailResult("文件上传失败");
		}
		List<Employee> empDatas = new ArrayList<>();
		try {
			List<Map<String, String>> datas = POIUtil.readExcel(filePath, 4, 2, Constant.EMPEXCELCOL);
			for (Map<String, String> map : datas) {
				Employee data = new Employee();
				data.setEmpAccount(map.get("empAccount"));
				data.setEmpName(map.get("empName"));
				data.setEmpPhone(map.get("empPhone"));
				data.setEmpEmail(map.get("empEmail"));
				empDatas.add(data);
			}
		} catch (Exception e) {
			log.error("批量保存用户读取excel文件异常,异常原因：" + e.getMessage());
			return rtnErrorResult("批量保存用户读取excel文件异常" + e.getMessage());
		}
		String coId = session.getAttribute("userCoId") + "";
		try {
			return service.insEmployee(coId, empDatas);
		} catch (Exception e) {
			log.error("员工批量插入异常,异常信息：" + e.getMessage());
			return rtnFailResult("员工批量插入异常");
		}
	}

	/**
	 * 
	 * @Title: selEmployee   
	 * @Description: 查询所有员工信息
	 * @param request
	 * @param session
	 * @return
	 * @author: MR.H
	 * @return: String
	 *
	 */
	@RequestMapping("/selEmployee.do")
	public String selEmployee(HttpServletRequest request, HttpSession session) {
		String pageSign = request.getParameter("pageSign");
		String pageNum = request.getParameter("pageNum");
		String empId = request.getParameter("empId");
		String coId = session.getAttribute("userCoId") + "";
		try {
			Result<List<Employee>> selEmployee = service.selEmployee(empId, coId, pageNum = StrUtil.isBlank(pageNum)
					? "1" : pageNum);
			List<Employee> data = selEmployee.getData();
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
				data = service.selEmployee(empId, coId, page + "").getData();
			}
			int empNum = service.selEmpCount(coId);
			BigDecimal moneyNum = service.selMoneyCount(coId);
			request.setAttribute("empNum", empNum);
			request.setAttribute("moneyNum", moneyNum.toString());
			request.setAttribute("pageNum", page);
			request.setAttribute("empList", data);
		} catch (Exception e) {
			log.error("查询员工异常" + e.toString());
		}
		return "view/allEmpInfo";
	}

	/**
	 * 
	 * @Title: delEmployee   
	 * @Description: 删除员工信息
	 * @param request
	 * @param session
	 * @return
	 * @author: MR.H
	 * @return: Result<Object>
	 *
	 */
	@RequestMapping("/delEmp.do")
	@ResponseBody
	public Result<Object> delEmployee(HttpServletRequest request, HttpSession session) {
		String empId = request.getParameter("empId");
		String coId = session.getAttribute("userCoId") + "";
		return service.delEmployee(empId, coId);

	}
	// 编辑员工信息 未开发
	
	// 数据统计的接口 已在别处实现

}
