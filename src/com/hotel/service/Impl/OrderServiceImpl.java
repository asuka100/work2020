package com.hotel.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.mapper.OrderMapper;
import com.hotel.pojo.Order;
import com.hotel.pojo.OrderExample;
import com.hotel.pojo.OrderExample.Criteria;
import com.hotel.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderMapper mapper;
	
	@Override
	public int createOrder(Order order) {
		return mapper.insertSelective(order);
	}

	@Override
	public int updateByOrderId(Order order) {
		return mapper.updateByPrimaryKeySelective(order);
	}

	@Override
	public int deleteByOrderId(int orderId) {
		return mapper.deleteByPrimaryKey(orderId);
	}

	@Override
	public List<Order> selectAll() {
		return mapper.selectByExample(null);
	}

	@Override
	public Order selectById(int orderId) {
		return mapper.selectByPrimaryKey(orderId);
	}

	@Override
	public List<Order> selectByClientId(int clientId) {
		OrderExample example = new OrderExample();
		example.createCriteria().andClientIdEqualTo(clientId);
		return mapper.selectByExample(example);
	}

	@Override
	public List<Order> selectByEmployeeId(int employeeId) {
		OrderExample example = new OrderExample();
		Criteria criteria = example.createCriteria();
		//负责创建的员工
		criteria.andCreateEmployeeIdEqualTo(employeeId);
		List<Order> list = mapper.selectByExample(example);
		
		//负责入住的员工
		example.clear();
		criteria.andCheckEmployeeIdEqualTo(employeeId);
		for(Order temp : mapper.selectByExample(example)) {
			//修改了Order的equals(), orderId属性相同为true
			if(!list.contains(temp)) {
				list.add(temp);
			}
		}
		
		example.clear();
		criteria.andPayEmployeeIdEqualTo(employeeId);
		for(Order temp : mapper.selectByExample(example)) {
			//修改了Order的equals(), orderId属性相同为true
			if(!list.contains(temp)) {
				list.add(temp);
			}
		}
		return list;
	}
	
	@Override
	public List<Order> selectByStatus(String Status) {
		OrderExample example = new OrderExample();
		example.createCriteria().andStatusEqualTo(Status);
		return mapper.selectByExample(example);
	}


}
