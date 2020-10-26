package com.hotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hotel.pojo.MaintainList;
import com.hotel.pojo.Room;
import com.hotel.pojo.RoomStatus;
import com.hotel.service.MaintainListService;
import com.hotel.service.RoomService;
import com.hotel.service.RoomStatusService;

@Controller
@RequestMapping(value = "/maintainlist")
public class MaintainListController {

	@Autowired
	private MaintainListService service;
	@Autowired
	private RoomService roomService;
	@Autowired
	private RoomStatusService statusService;
	
	@RequestMapping("/viewAddMaintain")
	public String viewAddMaintain() {
		return "/WEB-INF/jsp/maintain/addMaintain";
	}
	
	@RequestMapping("/viewMaintainList")
	public String viewMaintainList() {
		return "/WEB-INF/jsp/maintain/MaintainList";
	}
	
	
	//int[] employeeId 可以改为int ...employeeId一样可以接收多个参数
	@ResponseBody
	@RequestMapping(value = "/create")
	public Object createMaintain(MaintainList maintainList) {
		JSONObject jsObj = new JSONObject();
		if(maintainList.getRoomId()==0||"".equals(maintainList.getEmployeeIdList())) {
			
			jsObj.put("result", 0);
			return jsObj;
		}
		Room room  = roomService.selectById(maintainList.getRoomId());
		if(room.getRoomStatusId()!=1) {
			jsObj.put("result", 0);
			return jsObj;
		}
		room.setRoomStatusId(Integer.valueOf(maintainList.getStatus()));
		int result = service.insertMaintain(maintainList);
		int result1 = roomService.update(room);
		
		jsObj.put("result", result);
		List<MaintainList> list = service.selectAll();
		jsObj.put("maintain", list.size()==0 ? "null" : list.get(list.size()-1) );
		
		return jsObj;
	}
	
	@ResponseBody
	@RequestMapping(value = "/select/all")
	public Object selectAll(int page, int limit) {
		List<MaintainList> list = service.selectAll();
		for (MaintainList maintainList : list) {
			maintainList.setStatusName(statusService.selectById(Integer.valueOf(maintainList.getStatus())).getStatusName());
		}
		PageHelper.startPage(page,limit);
		PageInfo info = new PageInfo<>(list);
		long total = info.getTotal();
		
		JSONObject jsObj = new JSONObject();
		jsObj.put("code", 0);
		jsObj.put("msg","");
		jsObj.put("count",total);
		jsObj.put("data",list);
		
		return jsObj;
	}
	
	@ResponseBody
	@RequestMapping(value = "/select/id")
	public Object selectById(int id) {
		 MaintainList maintain = service.selectById(id);

		JSONObject jsObj = new JSONObject();
		if(maintain==null) {
			jsObj.put("result","fail");
		}else {
			jsObj.put("result","success");
			jsObj.put("maintain",maintain);
		}
		
		
		return jsObj;
	}
	
	@ResponseBody
	@RequestMapping(value = "/update/id")
	public int updateById(MaintainList maintain) {
		
		MaintainList m = service.selectById(maintain.getMaintainId());
		if(m.getStatus().equals(maintain.getStatus())) {
			return 0;
		}else {
			Room room = roomService.selectById(maintain.getRoomId());
			room.setRoomStatusId(1);
			roomService.update(room);
			service.deleteById(maintain.getMaintainId());
		}
		
		return 1;
	}
	
	@ResponseBody
	@RequestMapping(value = "/delete/id")
	public int deleteById(int id) {
		return service.deleteById(id);
	}
}
