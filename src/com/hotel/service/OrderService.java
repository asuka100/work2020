package com.hotel.service;

import java.util.List;

import com.hotel.pojo.Order;

public interface OrderService {
	int createOrder(Order order);
	
	int updateByOrderId(Order order);
	
	int deleteByOrderId(int orderId);
	
	List<Order> selectAll();
	
	Order selectById(int orderId);
	
	List<Order> selectByClientId(int clientId);
	
	List<Order> selectByEmployeeId(int employeeId);
	
	List<Order> selectByStatus(String Status);
	
}
