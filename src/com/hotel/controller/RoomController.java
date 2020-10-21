package com.hotel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hotel.pojo.Room;

@Controller
public class RoomController {

	/**
	 * 新建房间
	 * @param room
	 * @return
	 */
	@RequestMapping(value = "/create")
	public String create(Room room) {
		return "";
	}
	
	public String selectAll() {
		return "";
	}
	
	public String selectById() {
		return "";
	}
	
	public String
	
}
