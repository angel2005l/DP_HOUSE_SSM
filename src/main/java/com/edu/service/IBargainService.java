package com.edu.service;

import java.util.List;

import com.edu.entity.Bargain;
import com.edu.util.Result;

public interface IBargainService {
	/**
	 * 
	 * @Title: selBargain   
	 * @Description: 合同查询
	 * @param: @param barId
	 * @param: @param coId
	 * @param: @return 
	 * @author: MR.H
	 * @return: List<Bargain>      
	 * @throws
	 */
	public List<Bargain> selBargain(String barId, String coId);

	/**
	 * 
	 * @Title: insBargain   
	 * @Description: 合同添加
	 * @param: @param coId
	 * @param: @return 
	 * @author: MR.H
	 * @return: Result<Object>      
	 * @throws
	 */
	public Result<Object> insBargain(String indId, String coId);
}
