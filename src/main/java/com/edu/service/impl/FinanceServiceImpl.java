package com.edu.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.base.Constant;
import com.edu.dao.IFinanceDao;
import com.edu.entity.Finance;
import com.edu.service.IFinanceService;
import com.edu.util.DateUtil;
import com.edu.util.StrUtil;

@Service("financeService")
public class FinanceServiceImpl implements IFinanceService {

	@Autowired
	private IFinanceDao financeDao;

	@Override
	public int selFinanceCountByEmpInfo(String empInfo, String empPer) throws Exception {
		return financeDao.selFinanceCountByEmpInfo(empInfo, empPer);
	}

	@Override
	public List<Finance> selFinance(String empId, String coId, String pageNum, String userPer,String finId) throws Exception {
		return financeDao.selFinance(empId, coId, Integer.parseInt(pageNum), userPer,finId);
	}

	@Override
	public int insFinance(String coId, String indId, String finType,BigDecimal finMoney) throws Exception {
		String maxFinId = financeDao.maxFinId();
		int maxId = 0;
		if (StrUtil.isBlank(maxFinId)) {
			maxId = 0;
		} else {
			maxId = StrUtil.cutStringRightRtnInteger(maxFinId, 5, true);
		}
		Finance insObj = new Finance();
		insObj.setFinId(Constant.FINANCETAG + DateUtil.curDateYMDHMForService() + StrUtil.strAddLeftZero((++maxId) + "",
				5));
		insObj.setFinType(finType);
		insObj.setFinDate(new Date());
		insObj.setFinMoney(finMoney);
		insObj.setCoId(coId);
		insObj.setIndId(indId);
		return financeDao.insFinace(insObj);
	}

}
