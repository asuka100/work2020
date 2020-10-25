package com.hotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
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
	public Object createEmployee(Employee employee) {
		
		JSONObject jsObj = new JSONObject();
		int in = service.insert(employee);
		jsObj.put("result", in);
		jsObj.put("employee", employee);
		return jsObj;
	}
	
	@RequestMapping(value = "/select/{employeeId}")
	@ResponseBody
	public Object selectById(@PathVariable int employeeId){
		
		
		Employee employee = service.selectById(employeeId);
		
		JSONObject jsObj = new JSONObject();
		
		if(employee == null) {
			jsObj.put("result","fail");	//列表数据
		}else {
			jsObj.put("result", "success");
			jsObj.put("employee",employee);	//列表数据
			
		}
		
		
		return jsObj;
		
	}
	
	@RequestMapping("/findAllMaintainEmployee")
	@ResponseBody
	public Object findAllMaintainEmployee() {
		
		List<Employee> employeeList = service.findAllMaintainEmployee();
		JSONObject jsObj = new JSONObject();
		jsObj.put("employeeList", employeeList);
		
		return jsObj;
	}

	@RequestMapping(value = "/select/all")
	@ResponseBody
	public Object selectAll(int page, int limit){
		
		PageHelper.startPage(page, limit);
		
		List<Employee> list = service.selectAll();
		PageInfo info = new PageInfo<>(list);
		long total = info.getTotal();
		
		JSONObject jsObj = new JSONObject();
		jsObj.put("code","0");	//响应码：0
		jsObj.put("msg","");	//消息：空
		jsObj.put("count",total);	//总记录数
		jsObj.put("data",list);	//列表数据

		return jsObj;
		
	}
	
	@ResponseBody
	@RequestMapping(value = "/update")
	public Object update(Employee employee) {
		JSONObject jsObj = new JSONObject();
		if(employee.getEmployeeId()==null) {
			jsObj.put("result","fail");	//列表数据
			return jsObj;
		}else {
			int in = service.updateEmployee(employee);
			if(in<1) {
				jsObj.put("result","fail");	//列表数据
				return jsObj;
			}else {
				jsObj.put("result","success");	//列表数据
				return jsObj;
			}
		}
		
	}
	
	@RequestMapping(value = "/deleteById")
	@ResponseBody
	public String deleteById(int employeeId) {
		
		
		String result = "";
		int in = service.deleteEmployeeById(employeeId);
		if(in>=1) {
			result = "success";
		}
		return result;
	}
}
