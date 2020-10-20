package com.hotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.hotel.pojo.EmployeePosition;
import com.hotel.service.PositionService;

@Controller
@RequestMapping(value = "/position")
public class PositionController {

	@Autowired
	private PositionService service;
	
	@RequestMapping(value = "/all")
	@ResponseBody
	public String selectAll() {
		List<EmployeePosition> list = service.selectAll();
		String json = JSON.toJSONString(list);
		return json;
	}
	
	@RequestMapping(value = "/select/id")
	@ResponseBody
	public String selectById(int id) {
		EmployeePosition position = service.selectById(id);
		String json = JSON.toJSONString(position);
		return json;
	}
	
	@RequestMapping(value = "/update")
	public String updateById(EmployeePosition position) {
		//参数不为空，并且数据库中未有要修改的职位名称
		if(position==null|| service.selectByName(position.getPositionName()).size()!=0) {
			return "0";
		}
		
		int result = service.updateById(position);
		return result+"";
	}
	
	@RequestMapping(value = "/delete/id")
	public String deleteById(int id) {
		int result = service.deleteById(id);
		return result+"";
	}
}
