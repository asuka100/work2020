package com.hotel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hotel.service.RoomStatusService;

@Controller
@RequestMapping(value = "/room_status")
public class RoomStatusController {
	
	@Autowired
	private RoomStatusService service;
	
	@RequestMapping(value = "/{status_name}")
	public String createRoomStatus(@PathVariable String status_name) {
		service.insertRoomStatus(status_name);
		return "login";
	}
}
