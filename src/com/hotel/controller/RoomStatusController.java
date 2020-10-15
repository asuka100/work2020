package com.hotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.hotel.pojo.RoomStatus;
import com.hotel.service.RoomStatusService;

@Controller
@RequestMapping(value = "/roomStatus")
public class RoomStatusController {
	
	@Autowired
	private RoomStatusService service;
	
	/**
	 * 增加新的房间状态
	 * @param status_name
	 * @return 0:表中已有数据，新增失败， 1：新增成功
	 */
	@RequestMapping(value = "/create")
	@ResponseBody
	public String createRoomStatus(String status_name) {
		int result = service.insertRoomStatus(status_name);
		return result+"";
	}
	
	/**
	 * 根据房态id，删除房态
	 * @param status_id
	 * @return
	 */
	public String deleteById(int status_id) {
		
		return "";
	}
	
	/**
	 * 返回房态列表
	 * @return json:JSON格式的列表数据
	 */
	@RequestMapping(value = "/list", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String selectAll() {
		List<RoomStatus> list = service.selectAll();
		String json = JSON.toJSONString(list);
		return json;
	}
	
	/**
	 * url传入id，查询房间状态
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/{id}")
	@ResponseBody
	public String selectById(@PathVariable int id) {
		RoomStatus roomStatus =  service.selectById(id);
		String json = JSON.toJSONString(roomStatus);
		return json;
	}
	
	/**
	 * 修改房态名称
	 * @param status_name
	 * @return 0:修改失败，1:修改成功
	 */
	@RequestMapping(value = "/update")
	public String update(RoomStatus roomStatus) {
		int result = service.updateNameById(roomStatus);
		return result+"";
	}
	

}
