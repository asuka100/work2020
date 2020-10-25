package com.hotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.hotel.pojo.RoomType;
import com.hotel.service.RoomTypeService;

@Controller
@RequestMapping(value = "/roomType")
public class RoomTypeController {

	@Autowired
	private RoomTypeService service;
	
	@RequestMapping("/viewAddRoomType")
	public String viewAddRoomType() {
		return "/WEB-INF/jsp/roomType/addRoomType";
	}
	
	@RequestMapping("/viewRoomTypeList")
	public String viewRoomTypeList() {
		
		return "/WEB-INF/jsp/roomType/roomTypeList";
	}
	
	@ResponseBody
	@RequestMapping(value = "/create")
	public int createRoomType(String typeName) {
		int result = service.insertRoomType(typeName);
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value = "/delete/{id}")
	public int deleteById(@PathVariable int id) {
		int result = service.deleteById(id);
		return result;
	}
	
	@RequestMapping(value = "/list")
	@ResponseBody
	public String selectAll() {
		List<RoomType> list = service.selectAll();
		String json = JSON.toJSONString(list);
		return json;
	}
	
	@RequestMapping(value = "/select/{id}")
	@ResponseBody
	public String selectById(@PathVariable int id) {
		RoomType roomType = service.selectById(id);
		return JSON.toJSONString(roomType);
	}
	
	@ResponseBody
	@RequestMapping(value = "/update")
	public int update(RoomType roomType) {
		int result = service.update(roomType);
		return result;
	}
	
}
