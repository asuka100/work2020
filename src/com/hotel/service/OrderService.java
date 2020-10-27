package com.hotel.service;

import java.util.List;

import com.hotel.pojo.Orders;

public interface OrderService {
	int createOrders(Orders order);
	
	int updateByOrdersId(Orders order);
	
	int deleteByOrdersId(int orderId);
	
	List<Orders> selectAll();
	
	Orders selectById(int orderId);
	
	List<Orders> selectByClientId(int clientId);
	
	List<Orders> selectByEmployeeId(int employeeId);
	
	List<Orders> selectByStatus(String Status);
	
}
