package com.edu.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.edu.entity.House;

@Repository
public interface IHouseDao {
	// 房屋查询
	public List<House> selHouse(@Param("empId") String empId, @Param("coId") String coId) throws SQLException;

	// 房屋添加
	public int insHouse(House house) throws SQLException;

	// 房屋删除
	public int delHouse(String houId) throws SQLException;

	// 房屋更新
	public int uptHouseStatus(String houId) throws SQLException;

	// 房屋是否存在
	public int selHouseExist(@Param("houId") String houId, @Param("coId") String coId) throws SQLException;

	// 获得最大房屋Id
	public String selHouseMaxId() throws SQLException;
}