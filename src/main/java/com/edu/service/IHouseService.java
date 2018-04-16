package com.edu.service;

import java.util.List;

import com.edu.entity.House;
import com.edu.util.Result;

/**
 * @author MR.H
 *
 */
public interface IHouseService {

	// 查询房屋信息
	public List<House> selHouse(String empId, String coId) throws Exception;

	// 收回房屋重置房屋状态
	public Result<Object> uptChangeHouseSellType(String houId) throws Exception;

	// 新增房屋
	public Result<Object> insHouse(House insHouse) throws Exception;
	//获得最大房屋数
	public String selHouseMax() throws Exception;

	// 根据empId查询房屋数量
	public int selHouseCountByEmpId(String empI, String empPer) throws Exception;

}
