package com.hotel.controller;

import java.text.SimpleDateFormat;
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
import com.hotel.pojo.Client;
import com.hotel.pojo.Room;
import com.hotel.service.RoomService;

@Controller
@RequestMapping(value = "/room")
public class RoomController {

	@Autowired
	private RoomService service;
	
	@RequestMapping("/viewAddRoom")
	public String viewAddRoom() {
		return "/WEB-INF/jsp/room/addRoom";
	}
	
	@RequestMapping("/viewRoomList")
	public String viewRoomList() {
		return "/WEB-INF/jsp/room/roomList";
	}
	
	/**
	 * 新建房间
	 * @param room
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/create")
	public int createRoom(Room room) {
		if(room==null||room.getRoomId()==null||room.getRoomStatusId()==null||room.getRoomTypeId()==null) {
			return 0;
		}
		if(service.selectById(room.getRoomId())!=null) {
			return 2;
		}
		System.out.println(room);
		return service.insert(room);
	}
	
	/**
	 * 房间列表
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/select/all")
	public Object selectAll(int page, int limit) {
		PageHelper.startPage(page,limit);
		List<Room> list = service.selectAll();
		
		System.out.println(list);
		PageInfo info = new PageInfo<>(list);
		long total = info.getTotal();
	
		JSONObject jsObj = new JSONObject();
		jsObj.put("code", "0");
		jsObj.put("msg","");
		jsObj.put("count",total);
		jsObj.put("data",list);
		
		return jsObj;
	}
	
	/**
	 * 根据房间编号查询房间
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/select")
	public Object selectById(int id) {
		
		Room room = service.selectById(id);
		JSONObject jsObj = new JSONObject();
		System.out.println(room);
		jsObj.put("room",room);
		
		return jsObj;
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
	
	@RequestMapping("/update")
	@ResponseBody
	public int update(Room room) {
		if (room.getRoomStatusId()==0||room.getRoomTypeId()==0) {
			return 0;
		}
		int result = service.update(room);
		return result;
	}
	
}
