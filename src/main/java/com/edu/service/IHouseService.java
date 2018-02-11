package com.edu.service;

import java.util.List;

import com.edu.entity.House;
import com.edu.util.Result;

/**
 * @author MR.H
 *
 */
public interface IHouseService {
	
	//查询房屋信息
	public List<House> selHouse(String empId,String coId);
	
	//收回房屋重置房屋状态
	public Result<Object> uptChangeHouseSellType(String houId);
	
	//新增房屋
	
	
	
	
	
	
}
