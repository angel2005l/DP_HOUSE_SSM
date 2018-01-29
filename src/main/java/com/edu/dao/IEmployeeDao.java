package com.edu.dao;

import java.sql.SQLException;

public interface IEmployeeDao {

	public void selEmployee(String empId) throws SQLException;

	public int uptEmployee() throws SQLException;

	public int delEmployee() throws SQLException;

	public int insEmployee() throws SQLException;

}
