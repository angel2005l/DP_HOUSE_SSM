package com.edu.service;

import java.util.List;

import com.edu.entity.Employee;
import com.edu.util.Result;

public interface IEmployeeService {
	/**
	 * 
	 * @Title: login   
	 * @Description: 员工登录验证
	 * @param: @param userId
	 * @param: @param userPass
	 * @param: @return 
	 * @author: MR.H
	 * @return: boolean      
	 * @throws
	 */
	public boolean login(String userId, String userPass);

	/**
	 * 
	 * @Title: insEmployee   
	 * @Description: 员工批量插入   
	 * @param: @param coId
	 * @param: @param datas
	 * @param: @return 
	 * @author: MR.H
	 * @return: Result<Object>      
	 * @throws
	 */
	public Result<Object> insEmployee(String coId, List<Employee> datas);

	/**
	 * 
	 * @Title: selEmployeeByFirst   
	 * @Description: 查询一个员工
	 * @param: @param empId
	 * @param: @param coId
	 * @param: @return 
	 * @author: MR.H
	 * @return: Employee      
	 * @throws
	 */
	public Result<Employee> selEmployeeByFirst(String empId, String coId);

	/**
	 * 
	 * @Title: selEmployee   
	 * @Description: 查询全部员工
	 * @param: @param empId
	 * @param: @param coId
	 * @param: @return 
	 * @author: MR.H
	 * @return: List<Employee>      
	 * @throws
	 */
	public Result<List<Employee>> selEmployee(String empId, String coId);

	/**
	 * 
	 * @Title: delEmployee   
	 * @Description: 删除员工
	 * @param: @param enmId
	 * @param: @param coId
	 * @param: @return 
	 * @author: MR.H
	 * @return: Result<Object>      
	 * @throws
	 */
	public Result<Object> delEmployee(String empId, String coId);

	/**
	 * 
	 * @Title: uptEmployee   
	 * @Description: 更改密码  
	 * @param: @param oldPass
	 * @param: @param newPass
	 * @param: @param empId
	 * @param: @param coId
	 * @param: @return 
	 * @author: MR.H
	 * @return: Result<Object>      
	 * @throws
	 */
	public Result<Object> uptEmployeePass(String oldPass, String newPass, String empId, String coId);
}
