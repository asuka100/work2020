package com.hotel.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.mapper.EmployeePositionMapper;
import com.hotel.pojo.EmployeePosition;
import com.hotel.pojo.EmployeePositionExample;
import com.hotel.service.PositionService;

@Service
public class PositionServiceImpl implements PositionService {

	@Autowired
	private EmployeePositionMapper mapper;
	
	@Override
	public int insert(EmployeePosition position) {
		return mapper.insertSelective(position);
	}

	@Override
	public List<EmployeePosition> selectAll() {
		return mapper.selectByExample(null);
	}

	@Override
	public EmployeePosition selectById(int id) {
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public List<EmployeePosition> selectByName(String name) {
		EmployeePositionExample example = new EmployeePositionExample();
		example.createCriteria().andPositionNameEqualTo(name);
		return mapper.selectByExample(example);
	}
	
	@Override
	public int deleteById(int id) {
		return mapper.deleteByPrimaryKey(id);
	}

	@Override
	public int updateById(EmployeePosition position) {
		return mapper.updateByPrimaryKeySelective(position);
	}
	
}
