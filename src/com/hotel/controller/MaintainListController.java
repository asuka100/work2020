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
import com.hotel.service.MaintainListService;

@Controller
@RequestMapping(value = "/maintainlist")
public class MaintainListController {

	@Autowired
	private MaintainListService service;
	
	//int[] employeeId 可以改为int ...employeeId一样可以接收多个参数
	@ResponseBody
	@RequestMapping(value = "/create")
	public Object createMaintain(int roomId, int[] employeeId, String content) {
		JSONObject jsObj = new JSONObject();
		if(roomId==0||employeeId==null) {
			jsObj.put("error","roomId==0||employeeId==null");
			jsObj.put("result", 0);
			return jsObj;
		}
		MaintainList maintain = new MaintainList();
		maintain.setRoomId(roomId);
		maintain.setContent(content);
		
		//把多个员工id组合并转换为String类型，如 员工id：1、2、3，转换后为 1_2_3_
		String employeeIdList = "";
		for(int id:employeeId) {
			employeeIdList += id+'_';
		}
		System.out.println(employeeIdList);
		maintain.setEmployeeIdList(employeeIdList);
		
		int result = service.insertMaintain(maintain);
		
		jsObj.put("result", result);
		List<MaintainList> list = service.selectAll();
		jsObj.put("maintain", list.size()==0 ? "null" : list.get(list.size()-1) );
		
		return jsObj;
	}
	
	@ResponseBody
	@RequestMapping(value = "/select/all")
	public Object selectAll(int page, int limit) {
		List<MaintainList> list = service.selectAll();
		
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
	public Object selectById(int page, int limit,int roomId) {
		List<MaintainList> list = service.seleteByRoomId(roomId);
		
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
	@RequestMapping(value = "/update/id")
	public int updateById(MaintainList maintain) {
		if(maintain.getMaintainId()==null) {
			return 0;
		}
		return service.updateMaintainListById(maintain);
	}
	
	@ResponseBody
	@RequestMapping(value = "/delete/id")
	public int deleteById(int id) {
		return service.deleteById(id);
	}
}
