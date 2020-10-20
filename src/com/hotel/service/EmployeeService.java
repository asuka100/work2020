package com.hotel.service;

import com.hotel.pojo.Employee;

public interface EmployeeService {
	Employee selectById(int id);
	
	int insert(Employee employee);
}
