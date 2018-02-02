package com.edu.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.edu.entity.Employee;

public interface IEmployeeDao {

	public List<Employee> selEmployee(@Param("empId") String empId, @Param("coId") String coId) throws SQLException;

	public int uptEmployee(@Param("empName") String empName, @Param("empId") String empId) throws SQLException;

	public int delEmployee(@Param("empId") String empId, @Param("coId") String coId) throws SQLException;

	public int insEmployee(Employee empObj) throws SQLException;

	public int insEmployees(List<Employee> insObjs) throws SQLException;

	public String selMaxEmpId(String coId) throws SQLException;

	public int employeeExist(@Param("empId") String empId, @Param("coId") String coId) throws SQLException;

	public int uptEmployeeByPass(@Param("pass") String pass, @Param("empId") String empId, @Param("coId") String coId)
			throws SQLException;
}
