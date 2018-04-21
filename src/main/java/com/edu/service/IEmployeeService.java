package com.edu.service;

import java.util.List;

import com.edu.entity.Employee;
import com.edu.util.Result;

public interface IEmployeeService {
	/**
	 * 
	 * @Title: login   
	 * @Description: 员工登录验证
	 * @param userId
	 * @param userPass
	 * @return 
	 * @author: MR.H
	 * @return: boolean      
	 *
	 */
	public Result<Employee> login(String empAccount, String userPass);

	/**
	 * 
	 * @Title: insEmployee   
	 * @Description: 员工批量插入   
	 * @param coId
	 * @param datas
	 * @return 
	 * @author: MR.H
	 * @return: Result<Object>      
	 *
	 */
	public Result<Object> insEmployee(String coId, List<Employee> datas) throws Exception;

	/**
	 * 
	 * @Title: selEmployeeByFirst   
	 * @Description: 查询一个员工
	 * @param empId
	 * @param coId
	 * @return 
	 * @author: MR.H
	 * @return: Employee      
	 *
	 */
	public Result<Employee> selEmployeeByFirst(String empId, String coId);

	/**
	 * 
	 * @Title: selEmployee   
	 * @Description: 查询全部员工
	 * @param empId
	 * @param coId
	 * @return 
	 * @author: MR.H
	 * @param pageNum 
	 * @return: List<Employee>      
	 *
	 */
	public Result<List<Employee>> selEmployee(String empId, String coId, String pageNum);

	/**
	 * 
	 * @Title: delEmployee   
	 * @Description: 删除员工
	 * @param enmId
	 * @param coId
	 * @return 
	 * @author: MR.H
	 * @return: Result<Object>      
	 *
	 */
	public Result<Object> delEmployee(String empId, String coId);

	/**
	 * 
	 * @Title: uptEmployee   
	 * @Description: 更改密码  
	 * @param oldPass
	 * @param newPass
	 * @param empId
	 * @param coId
	 * @return 
	 * @author: MR.H
	 * @return: Result<Object>      
	 *
	 */
	public Result<Object> uptEmployeePass(String oldPass, String newPass, String empId, String coId);
}
