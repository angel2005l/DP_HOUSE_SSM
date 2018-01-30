package com.edu.service;

import java.util.List;

import com.edu.entity.Employee;
import com.edu.util.Result;

public interface IEmployeeService {
	public boolean login(String userId, String userPass);

	public Result<Object> insEmployee(String coId, List<Employee> datas);
}
