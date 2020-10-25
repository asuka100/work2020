package com.hotel.service;

import java.util.List;

import com.hotel.pojo.Employee;

public interface EmployeeService {
	Employee selectById(int id);
	
	int insert(Employee employee);
	
	List<Employee> selectAll();
	
	int updateEmployee(Employee employee);
	
	int deleteEmployeeById(int employeeId);

	List<Employee> findAllMaintainEmployee();
}
