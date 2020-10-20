package com.hotel.service;

import java.util.List;

import com.hotel.pojo.EmployeePosition;

public interface PositionService {
	int insert(EmployeePosition position);
	
	List<EmployeePosition> selectAll();
	
	EmployeePosition selectById(int id);
	
	List<EmployeePosition> selectByName(String name);
	
	int deleteById(int id);
	
	int updateById(EmployeePosition position);
}
