package com.edu.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.edu.base.BaseSevice;
import com.edu.base.Constant;
import com.edu.dao.IEmployeeDao;
import com.edu.entity.Employee;
import com.edu.service.IEmployeeService;
import com.edu.util.MD5Util;
import com.edu.util.Result;
import com.edu.util.StrUtil;

@Service
public class EmployeeServiceImpl extends BaseSevice implements IEmployeeService {
	private static final Logger log = LoggerFactory.getLogger(EmployeeServiceImpl.class);
	private final int defaultIndex = 0;
	@Autowired
	IEmployeeDao employeeDao;

	@Override
	@Transactional
	public boolean login(String userId, String userPass) {

		try {
			List<Employee> datas = employeeDao.selEmployee(userId, "");
			if (datas != null && datas.isEmpty()) {
				Employee empObj = datas.get(defaultIndex);
				return MD5Util.check(userPass, empObj.getEmpSalt(), empObj.getEmpPass());
			}
			return false;
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			log.error(e.getMessage());
			return false;
		}
	}

	@Override
	@Transactional
	public Result<Object> insEmployee(String coId, List<Employee> datas) {
				if(datas==null || datas.isEmpty()){
			return rtnFailResult("添加员工数据集为空,请检查文件");
		}
		synchronized (this) {
			try {
				String maxEmpId = employeeDao.selMaxEmpId(coId);
				if(StrUtil.isBlank(maxEmpId)){
					return rtnFailResult("未找到相关公司信息");
				}
					 Integer maxNum = StrUtil.integerForIdAdd(maxEmpId, 5, Constant.RIGHT);
					 StrUtil.cutString(maxEmpId, size, type)
				if(maxNum==null)
					return rtnFailResult("获取最大增量Id失败.");
					 
					 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		//empId由单位别名+自增5位	
		//获得最大的数字
		
		
	}

}
