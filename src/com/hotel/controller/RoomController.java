package com.hotel.controller;

import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.hotel.pojo.Room;
import com.hotel.service.RoomService;

@Controller
public class RoomController {

	@Autowired
	private RoomService service;
	
	/**
	 * 新建房间
	 * @param room
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/create")
	public int create(Room room) {
		if(room==null||room.getRoomId()==null||room.getRoomStatusId()==null||room.getRoomTypeId()==null) {
			return 0;
		}
		return service.insert(room);
	}
	
	/**
	 * 房间列表
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/select/all")
	public String selectAll() {
		String json = JSON.toJSONString(service.selectAll());
		return json;
	}
	
	/**
	 * 根据房间编号查询房间
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/select/id")
	public Room selectById(int id) {
		return service.selectById(id);
	}
	
	/**
	 * 根据房间编号删除房间
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/delete/id")
	public int deleteById(int id) {
		return service.deleteById(id);
	}
	
}
