package com.hotel.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

public class CheckUserInterceptor implements HandlerInterceptor {
@Override
public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
		throws Exception {
	// TODO Auto-generated method stub
	HttpSession session = request.getSession();
	if(session.getAttribute("user")!=null) {
		//已登录
		return true;
	}
	else {
		//未登录，跳转到登录页面
//		System.out.println(request.getContextPath());
		response.sendRedirect(request.getContextPath()+"/login.jsp");
	}
	
	return false;
}
}
