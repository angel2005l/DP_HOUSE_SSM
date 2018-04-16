package com.edu.controller;

import java.math.BigDecimal;

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
import com.edu.entity.House;
import com.edu.service.IHouseService;
import com.edu.util.IOUtil;
import com.edu.util.Result;
import com.edu.util.StrUtil;

@Controller
@RequestMapping("/house")
public class HouseController extends BaseController {
	private final Logger log = LoggerFactory.getLogger(HouseController.class);

	private String path = "upLoadFiles";

	@Autowired
	private IHouseService service;

	@RequestMapping("/add.do")
	@ResponseBody
	public Result<Object> addHouse(@RequestParam("housephoto") MultipartFile mf, HttpServletRequest request,
			HttpSession session) {
		String info = request.getParameter("Hinfo");// info
		String address = request.getParameter("Hadd");// address
		String type = request.getParameter("Htype");// type
		String floor = request.getParameter("Hfloor");// floor
		String build = request.getParameter("Hbuild");// build
		String money = request.getParameter("Hmoney");// money
		String bed = request.getParameter("Hbed");// bed
		String bath = request.getParameter("Hbath");// bath
		String living = request.getParameter("Hliving");// living

		House insHouse = new House();

		insHouse.setHouName(info);
		insHouse.setHouStatus(Constant.TYPE[0]);
		insHouse.setHouType(type);
		insHouse.setHouFloor(new BigDecimal(floor));
		insHouse.setHouBuild(new BigDecimal(build));
		insHouse.setHouMoney(new BigDecimal(money));
		insHouse.setHouAdd(address);
		insHouse.setHouBed(Integer.parseInt(bed));
		insHouse.setHouBath(Integer.parseInt(bath));
		insHouse.setHouLiving(Integer.parseInt(living));
		insHouse.setEmpId(session.getAttribute("userId").toString());
		synchronized (this) {
			try {
				String newHouseId = service.selHouseMax();
					System.err.println(newHouseId);
				if (StrUtil.isBlank(newHouseId)) {
					return rtnFailResult("房屋编码格式错误");
				}
				String imgName = IOUtil.uploadFile(mf, path, newHouseId);
				imgName = imgName.substring(imgName.indexOf("\\"));
				insHouse.setHouId(newHouseId);
				insHouse.setHouImg(imgName);
				System.err.println(insHouse.toString());
				return service.insHouse(insHouse);
			} catch (Exception e) {
				log.error("添加房屋异常,异常原因:" + e.getMessage());
				return rtnErrorResult("添加房屋异常,请联系管理员");
			}
		}

	}

}