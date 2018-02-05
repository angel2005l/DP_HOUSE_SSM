package com.edu.service;

import java.util.List;

import com.edu.entity.Indent;
import com.edu.util.Result;

public interface IIndentService {
	// 查询订单信息
	public List<Indent> selIndent(String permiType, String indId, String empId, String coId);

	// 更新订单 enter/cancel
	public Result<Object> uptIndent(String indType, String indId,String coId);

	// 删除订单 只能删除(审核中)的单子
	public Result<Object> delIndent(String indId, String coId);

	// 添加订单
	public Result<Object> addIndent(Indent insObj);

}
