package com.hotel.service;

import java.util.List;

import com.hotel.pojo.OrderDetail;

public interface OrderDetailService {
	int increaseOrderDetail(OrderDetail detail);
	
	OrderDetail selectById(int id);
	
	int deleteById(int id);
	
	List<OrderDetail> selectByOrderId(int orderId);
}
