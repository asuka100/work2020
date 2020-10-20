package com.hotel.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.mapper.EmployeeMapper;
import com.hotel.pojo.Employee;
import com.hotel.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeMapper mapper;
	
	@Override
	public Employee selectById(int id) {
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public int insert(Employee employee) {
		if(employee==null||employee.getEmployeeId()==null) {
			return 0;
		}
		return mapper.insertSelective(employee);
		
	}

}
