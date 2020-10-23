package com.hotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
	public int createEmployee(Employee employee) {
		return service.insert(employee);
	}
	

	@RequestMapping(value = "/select/all")
	@ResponseBody
	public Object selectAll(int page, int limit){
		
		PageHelper.startPage(page, limit);
		
		List<Employee> list = service.selectAll();
		PageInfo info = new PageInfo<>(list);
		long total = info.getTotal();
		JSONArray jsonArray=new JSONArray();
		if(list!=null){
            jsonArray = new JSONArray();
            for(Employee t: list){
                jsonArray.add(t);

            }
        }
		JSONObject jsObj = new JSONObject();
		jsObj.put("code","0");	//响应码：0
		jsObj.put("msg","");	//消息：空
		jsObj.put("count",total);	//总记录数
		jsObj.put("data",jsonArray);	//列表数据
		
		
		return jsObj;
		
		
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
