package com.hotel.service.Impl;

import java.util.List;

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
		
		return mapper.insertSelective(employee);
		
	}

	@Override
	public List<Employee> selectAll() {
		return mapper.selectByExample(null);
	}

	@Override
	public int updateEmployee(Employee employee) {
		return mapper.updateByPrimaryKeySelective(employee);
	}

	@Override
	public int deleteEmployeeById(int employeeId) {
		
		return mapper.deleteByPrimaryKey(employeeId);
	}

}
