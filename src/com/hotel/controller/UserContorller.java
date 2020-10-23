package com.hotel.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hotel.pojo.Employee;
import com.hotel.pojo.Menuitem;
import com.hotel.pojo.User;
import com.hotel.service.EmployeeService;
import com.hotel.service.MenuitemService;

@Controller
public class UserContorller {

	@Autowired
	private EmployeeService emploueeService;
	
	@Autowired
	private MenuitemService menuitemService; 
	
	String [] parent = {"房间管理","员工管理","客户管理","房态管理","维修管理","订单管理"};
	
	@RequestMapping(value = "/login")
	public String login(User user, HttpSession session) {
		System.out.println("UserController");
		String name = user.getName();
		String password = user.getPassword();
		System.out.println(name+"  "+password);
		
		Employee employee = emploueeService.selectById(Integer.parseInt(name));
		int positionId = employee.getEmployeePositionId();
		Map<String, List<Menuitem>> result = new HashMap<>();
		
		for(String menu : parent) {
			List<Menuitem> temp_list = menuitemService.selectByPositionIdAndParent(positionId, menu);
			result.put(menu,temp_list);//一级菜单名称为key，二级菜单列表为value
		}
		
		for(String menu : parent) {
			System.out.println(menu);
			for(Menuitem item : result.get(menu)) {
				System.out.println(item);
			}
		}
		
		
		if(employee.getPassword().toString().equals(password)) {
			//登录成功; TODO:进行跳转或者重定向，或者返回登录成功的信息。
			session.setAttribute("employee", employee);
			session.setAttribute("positionId", positionId);
			session.setAttribute("menu", result);
			
			System.out.println("登录成功");
			return "/WEB-INF/jsp/index";
		}
		System.out.println(employee.getPassword());
		System.out.println("登录失败，返回登录页面");
		//登录失败，返回登录页面
		return "login";
	}
	
	@RequestMapping(value = "/newfile")
	public String newfile() {
		return "WEB-INF/jsp/NewFile";
	}
	
}
