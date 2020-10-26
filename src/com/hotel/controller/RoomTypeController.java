package com.hotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hotel.pojo.Employee;
import com.hotel.pojo.Room;
import com.hotel.pojo.RoomType;
import com.hotel.service.RoomService;
import com.hotel.service.RoomTypeService;

@Controller
@RequestMapping(value = "/roomType")
public class RoomTypeController {

	@Autowired
	private RoomTypeService service;
	
	@Autowired
	private RoomService roomService;
	
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
	public int createRoomType(RoomType roomType) {
		if(roomType.getTypeName()==null||roomType.getPrice()==0.0) {
			return 0;
		}
		int result = service.insertRoomType(roomType);
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value = "/delete/{id}")
	public int deleteById(@PathVariable int id) {
		int result = 0;
		List<Room> list = roomService.selectByRoomTypeId(id);
		if(list.size() == 0) {
			result = service.deleteById(id);
		}
		
		return result;
	}
	
	@RequestMapping(value = "/list")
	@ResponseBody
	public Object selectAll(int page, int limit) {
		PageHelper.startPage(page, limit);
		
		List<RoomType> list = service.selectAll();
		PageInfo info = new PageInfo<>(list);
		long total = info.getTotal();
		
		JSONObject jsObj = new JSONObject();
		jsObj.put("code","0");	//响应码：0
		jsObj.put("msg","");	//消息：空
		jsObj.put("count",total);	//总记录数
		jsObj.put("data",list);	//列表数据
		
		return jsObj;
	}
	
	@RequestMapping(value = "/findAll")
	@ResponseBody
	public List<RoomType> findAll() {
		
		
		List<RoomType> list = service.selectAll();

		
		return list;
	}
	
	@RequestMapping(value = "/select/{id}")
	@ResponseBody
	public Object selectById(@PathVariable int id) {
		RoomType roomType = service.selectById(id);
		JSONObject jsObj = new JSONObject();
		jsObj.put("roomType",roomType);	

		return jsObj;
	}
	
	@ResponseBody
	@RequestMapping(value = "/update")
	public int update(RoomType roomType) {
		int result = service.update(roomType);
		return result;
	}
	
}
