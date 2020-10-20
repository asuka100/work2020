package com.hotel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hotel.pojo.Room;

@Controller
public class RoomController {

	@RequestMapping(value = "/create")
	public String create(Room room) {
		return "";
	}
}
