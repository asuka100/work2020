package com.hotel.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.mapper.OrderDetailMapper;
import com.hotel.pojo.OrderDetail;
import com.hotel.pojo.OrderDetailExample;
import com.hotel.service.OrderDetailService;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {
	
	@Autowired
	private OrderDetailMapper detailMapper;

	@Override
	public int increaseOrderDetail(OrderDetail detail) {
		return detailMapper.insertSelective(detail);
	}

	@Override
	public OrderDetail selectById(int id) {
		return detailMapper.selectByPrimaryKey(id);
	}

	@Override
	public int deleteById(int id) {
		return detailMapper.deleteByPrimaryKey(id);
	}

	@Override
	public List<OrderDetail> selectByOrderId(int orderId) {
		OrderDetailExample example = new OrderDetailExample();
		example.createCriteria().andOrderIdEqualTo(orderId);
		return detailMapper.selectByExample(example);
	}

	
}
