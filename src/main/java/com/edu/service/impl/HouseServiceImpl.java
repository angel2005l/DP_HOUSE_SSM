package com.edu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.dao.IHouseDao;
import com.edu.entity.House;
import com.edu.service.IHouseService;
import com.edu.util.Result;

@Service("houseService")
public class HouseServiceImpl implements IHouseService {

	@Autowired
	private IHouseDao dao;

	@Override
	public List<House> selHouse(String empId, String coId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result<Object> uptChangeHouseSellType(String houId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int selHouseCountByEmpId(String empId) throws Exception {
		return dao.selHouseCountByEmpId(empId);
	}
}
