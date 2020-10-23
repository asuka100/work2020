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
	
	/**
	 * 房间列表
	 * @return
	 */
	public String selectAll() {
		return "";
	}
	
	/**
	 * 根据房间编号查询房间
	 * @return
	 */
	public String selectById() {
		return "";
	}
	
	/**
	 * 根据房间编号删除房间
	 * @return
	 */
	public String deleteById() {
		return "";
	}
	
}
