package com.hotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hotel.pojo.Employee;
import com.hotel.service.EmployeeService;

@Controller
@RequestMapping(value = "/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService service;
	
	@RequestMapping(value = "/viewAddEmployee")
	public String viewAddEmployee() {
		return "/WEB-INF/jsp/employee/addEmployee";
	}
	
	@RequestMapping(value = "/viewEmployeeList")
	public String viewEmployeeList() {
		return "/WEB-INF/jsp/employee/employeeList";
	}
	
	@ResponseBody
	@RequestMapping(value = "/create")
	public int createEmployee(Employee employee) {
		return service.insert(employee);
	}
	
	@ResponseBody
	@RequestMapping(value = "/select/all")
	public List<Employee> selectAll(int page, int limit){
		
		PageHelper.startPage(page, limit);
		
		List<Employee> list = service.selectAll();
		
	
	
		
	
		
		return list;
		
		
	}
	
	@ResponseBody
	@RequestMapping(value = "/update/id")
	public int updateById(Employee employee) {
		if(employee.getEmployeeId()==null) {
			return 0;
		}
		return service.updateEmployee(employee);
	}
}
