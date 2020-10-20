package com.hotel.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hotel.pojo.Employee;
import com.hotel.pojo.User;
import com.hotel.service.EmployeeService;

@Controller
public class UserContorller {

	@Autowired
	private EmployeeService service;
	
	@RequestMapping(value = "/login")
	public String login(User user, HttpServletRequest request) {
		System.out.println("UserController");
		String name = user.getName();
		String password = user.getPassword();
		System.out.println(name+"  "+password);
		Employee employee = service.selectById(Integer.parseInt(name));
		
		if(employee.getPassword().toString().equals(password)) {
			//登录成功; TODO:进行跳转或者重定向，或者返回登录成功的信息。
			HttpSession session = request.getSession();
			session.setAttribute("employeeId", name);
			session.setAttribute("positionId", employee.getEmployeePositionId());
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
