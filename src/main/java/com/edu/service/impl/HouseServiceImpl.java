package com.edu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.base.BaseSevice;
import com.edu.base.Constant;
import com.edu.dao.IHouseDao;
import com.edu.entity.House;
import com.edu.service.IHouseService;
import com.edu.util.DateUtil;
import com.edu.util.Result;
import com.edu.util.StrUtil;

@Service("houseService")
public class HouseServiceImpl extends BaseSevice implements IHouseService {

	@Autowired
	private IHouseDao dao;

	@Override
	public List<House> selHouse(String empId, String coId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result<Object> uptChangeHouseSellType(String houId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public Result<Object> insHouse(House insHouse) throws Exception {
		return dao.insHouse(insHouse) > 0 ? rtnSuccessResult("添加房屋成功") : rtnFailResult("添加房屋失败");
	}

	@Override
	public int selHouseCountByEmpId(String empInfo, String empPer) throws Exception {
		return dao.selHouseCountByEmpId(empInfo, empPer);
	}

	@Override
	public String selHouseMax() throws Exception {
		String maxId = dao.selHouseMaxId(Constant.HOUSETAG+DateUtil.curDateYMDForservice());
		if (StrUtil.isBlank(maxId)) {
			return Constant.HOUSETAG + DateUtil.curDateYMDForservice() + StrUtil.strAddLeftZero("1", 9);
		}
		Integer numMaxId = StrUtil.cutStringRightRtnInteger(maxId, 9, true);
		return null != numMaxId ? Constant.HOUSETAG + DateUtil.curDateYMDForservice() + StrUtil.strAddLeftZero(
				(++numMaxId).toString(), 9) : "";
	}
}
