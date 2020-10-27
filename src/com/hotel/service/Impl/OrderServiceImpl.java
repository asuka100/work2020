package com.hotel.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.mapper.OrdersMapper;
import com.hotel.pojo.Orders;
import com.hotel.pojo.OrdersExample;
import com.hotel.pojo.OrdersExample.Criteria;
import com.hotel.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrdersMapper mapper;
	
	@Override
	public int createOrders(Orders order) {
		return mapper.insertSelective(order);
	}

	@Override
	public int updateByOrdersId(Orders order) {
		return mapper.updateByPrimaryKeySelective(order);
	}

	@Override
	public int deleteByOrdersId(int orderId) {
		return mapper.deleteByPrimaryKey(orderId);
	}

	@Override
	public List<Orders> selectAll() {
		return mapper.selectByExample(null);
	}

	@Override
	public Orders selectById(int orderId) {
		return mapper.selectByPrimaryKey(orderId);
	}

	@Override
	public List<Orders> selectByClientId(int clientId) {
		OrdersExample example = new OrdersExample();
		example.createCriteria().andClientIdEqualTo(clientId);
		return mapper.selectByExample(example);
	}

	@Override
	public List<Orders> selectByEmployeeId(int employeeId) {
		OrdersExample example = new OrdersExample();
		Criteria criteria = example.createCriteria();
		//负责创建的员工
		criteria.andCreateEmployeeIdEqualTo(employeeId);
		List<Orders> list = mapper.selectByExample(example);
		
		//负责入住的员工
		example.clear();
		criteria.andCheckEmployeeIdEqualTo(employeeId);
		for(Orders temp : mapper.selectByExample(example)) {
			//修改了Order的equals(), orderId属性相同为true
			if(!list.contains(temp)) {
				list.add(temp);
			}
		}
		
		example.clear();
		criteria.andPayEmployeeIdEqualTo(employeeId);
		for(Orders temp : mapper.selectByExample(example)) {
			//修改了Order的equals(), orderId属性相同为true
			if(!list.contains(temp)) {
				list.add(temp);
			}
		}
		return list;
	}
	
	@Override
	public List<Orders> selectByStatus(String Status) {
		OrdersExample example = new OrdersExample();
		example.createCriteria().andStatusEqualTo(Status);
		return mapper.selectByExample(example);
	}


}
