package com.edu.service;

import java.util.List;

import com.edu.entity.House;
import com.edu.util.Result;

/**
 * @author MR.H
 *
 */
public interface IHouseService {

	/**
	 * 
	 * @Title: selHouse   
	 * @Description: 查询房屋信息
	 * @param empId
	 * @param coId
	 * @param pageNum
	 * @param hid
	 * @param type
	 * @return
	 * @throws Exception
	 * @author: MR.H
	 * @return: List<House>
	 *
	 */
	public List<House> selHouse(String empId, String coId, String pageNum, String hid, String type,String userPer) throws Exception;

	/**
	 * 
	 * @Title: uptChangeHouseSellType   
	 * @Description: 重置房屋状态   
	 * @param houId
	 * @param status
	 * @return
	 * @throws Exception
	 * @author: MR.H
	 * @return: Result<Object>
	 *
	 */
	public Result<Object> uptChangeHouseSellType(String houId, String status) throws Exception;

	/**
	 * 
	 * @Title: insHouse   
	 * @Description: 新增房屋
	 * @param insHouse
	 * @return
	 * @throws Exception
	 * @author: MR.H
	 * @return: Result<Object>
	 *
	 */
	public Result<Object> insHouse(House insHouse) throws Exception;

	/**
	 * 
	 * @Title: selHouseMax   
	 * @Description: 获得最大房屋数
	 * @return
	 * @throws Exception
	 * @author: MR.H
	 * @return: String
	 *
	 */
	public String selHouseMax() throws Exception;

	/**
	 * 
	 * @Title: selHouseCountByEmpId   
	 * @Description: 根据empId查询房屋数量
	 * @param empI
	 * @param empPer
	 * @return
	 * @throws Exception
	 * @author: MR.H
	 * @return: int
	 *
	 */
	public int selHouseCountByEmpId(String empI, String empPer) throws Exception;

	/**
	 * 
	 * @Title: selHouseInfoById   
	 * @Description: 根据houId查询房屋信息  
	 * @param houId
	 * @return
	 * @throws Exception
	 * @author: MR.H
	 * @return: House
	 *
	 */
	public House selHouseInfoById(String houId) throws Exception;

	/**
	 * 
	 * @Title: delHouse   
	 * @Description: 删除房屋信息
	 * @param houId
	 * @return
	 * @throws Exception
	 * @author: MR.H
	 * @return: Result<Object>
	 *
	 */
	public Result<Object> delHouse(String houId) throws Exception;

	/**
	 * 
	 * @Title: selHouseConfirm   
	 * @Description: 查询所有待审核的订单
	 * @param houId
	 * @param pageNum
	 * @return
	 * @throws Exception
	 * @author: MR.H
	 * @return: List<House>
	 *
	 */
	public List<House> selHouseConfirm(String houId, String pageNum) throws Exception;

}
