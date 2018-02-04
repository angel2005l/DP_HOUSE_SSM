package com.edu.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.edu.base.BaseSevice;
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
		if (datas == null || datas.isEmpty())
			return rtnFailResult("添加员工数据集为空,请检查文件");
		synchronized (this) {
			try {
				String maxEmpId = employeeDao.selMaxEmpId(coId);
				if (StrUtil.isBlank(maxEmpId))
					return rtnFailResult("未找到相关公司信息");
				Integer maxId = StrUtil.cutStringLeftRtnInteger(maxEmpId, 5, true);
				String comSimpleCode = StrUtil.cutStringForRight(coId, 5);
				if (null == maxId || StrUtil.isBlank(comSimpleCode))
					return rtnFailResult("插入失败,无法获得当前最大值");
				// 进行加密和自增列添加
				for (Employee empObj : datas) {
					empObj.setEmpId(comSimpleCode +StrUtil.strAddLeftZero((++maxId)+"", 5) );
					// 随机盐
					String salt = MD5Util.getRandomSalt();
					// 加密密码
					empObj.setEmpSalt(salt);
					empObj.setEmpPass(MD5Util.getMD5EncryptPass(empObj.getEmpPass().trim(), salt.getBytes()));
					empObj.setCoId(coId);
				}
				// 保存数据
				int insNum = employeeDao.insEmployees(datas);
				if (insNum == datas.size()) {
					return rtnSuccessResult("员工批量插入成功");
				} else {
					return rtnFailResult("员工批量操作失败");
				}
			} catch (SQLException e) {
				log.error("员工批量插入异常,异常信息：" + e.getMessage());
				return rtnFailResult("员工批量插入异常");
			}
		}
	}

	@Override
	public Result<Employee> selEmployeeByFirst(String empId, String coId) {
		try {
			List<Employee> employees = employeeDao.selEmployee(empId, coId);
			if (null == employees || employees.isEmpty())
				return rtnFailResultWithData("查找对象不存在,请检查查询条件", null);
			else
				return rtnSuccessResultWithData("", employees.get(0));
		} catch (SQLException e) {
			log.error("员工查询异常：异常信息：" + e.getMessage());
			return rtnFailResultWithData("员工查询异常", null);
		}
	}

	@Override
	public Result<List<Employee>> selEmployee(String empId, String coId) {
		try {
			List<Employee> employees = employeeDao.selEmployee(empId, coId);
			if (null == employees || employees.isEmpty())
				return rtnFailResultWithData("查找对象不存在,请检查查询条件", null);
			else
				return rtnSuccessResultWithData("", employees);
		} catch (SQLException e) {
			log.error("员工查询异常：异常信息：" + e.getMessage());
			return rtnFailResultWithData("员工查询异常", null);
		}
	}

	@Override
	public Result<Object> delEmployee(String empId, String coId) {
		try {
			if (employeeDao.employeeExist(empId, coId) > 0) {
				return employeeDao.delEmployee(empId, coId) > 0 ? rtnSuccessResult("员工【" + empId + "】删除成功")
						: rtnFailResult("员工【" + empId + "】删除失败");
			}
			return rtnFailResult("员工信息不存在,删除失败");
		} catch (SQLException e) {
			log.error("员工删除异常,异常信息：" + e.getMessage());
			return rtnFailResult("员工删除异常");
		}
	}

	@Override
	public Result<Object> uptEmployeePass(String oldPass, String newPass, String empId, String coId) {
		try {
			List<Employee> uptEmpObj = employeeDao.selEmployee(empId, coId);
			if (null != uptEmpObj && !uptEmpObj.isEmpty()) {
				Employee employee = uptEmpObj.get(0);
				String salt = employee.getEmpSalt();
				if (MD5Util.check(oldPass, salt, employee.getEmpPass().trim())) {
					// String newPassCiphertext =
					// MD5Util.getMD5EncryptPass(newPass, salt.getBytes());
					int rtn = employeeDao.uptEmployeeByPass(MD5Util.getMD5EncryptPass(newPass, salt.getBytes()), empId,
							coId);
					return rtn > 0 ? rtnSuccessResult("员工【" + empId + "】密码修改成功")
							: rtnFailResult("员工【" + empId + "】密码修改失败");
				} else {
					return rtnFailResult("该员工原密码不正确");
				}
			} else {
				return rtnFailResult("员工信息不存在,请重试...");
			}
		} catch (SQLException e) {
			log.error("员工密码修改异常,异常信息：" + e.getMessage());
			return rtnFailResult("员工密码修改异常");
		}
	}
}
