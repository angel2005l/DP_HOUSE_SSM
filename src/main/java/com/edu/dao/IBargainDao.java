package com.edu.dao;

import java.sql.SQLException;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.edu.entity.Bargain;

@Repository
public interface IBargainDao {

	/**
	 * 
	 * @Title: selBargain   
	 * @Description: 合同查询Dao
	 * @param barId
	 * @param coId
	 * @return
	 * @throws SQLException 
	 * @author: MR.H
	 * @return: List<Bargain>      
	 *
	 */
	public Bargain selBargain(@Param("barId") String barId, @Param("coId") String coId) throws SQLException;

	// 合同删除
	public int delBargain(String barId) throws SQLException;

	// 合同添加
	public int insBargain(Bargain insData) throws SQLException;

	// 当天合同最大ID
	public String maxBarId() throws SQLException;

	// 合同是否存在
	public int isBargainExist(@Param("barId") String barId, @Param("coId") String coId) throws SQLException;
}
