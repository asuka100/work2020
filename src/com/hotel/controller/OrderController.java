package com.hotel.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hotel.pojo.Client;
import com.hotel.pojo.Order;
import com.hotel.pojo.OrderDetail;
import com.hotel.pojo.Room;
import com.hotel.pojo.RoomStatus;
import com.hotel.service.ClientService;
import com.hotel.service.OrderDetailService;
import com.hotel.service.OrderService;
import com.hotel.service.RoomService;
import com.hotel.service.RoomStatusService;

@Controller
@RequestMapping(value = "/order")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private OrderDetailService orderDetailService;
	
	@Autowired
	private ClientService clientService;
	
	@Autowired
	private RoomService roomService;

	/**
	 * 创建订单
	 * @param clientId
	 * @param employeeId ：负责创建订单的员工的id
	 * @param rooms ：要预定的所有房间
	 * @return Order ：返回的order中多出订单编号、创建时间、订单状态（orderId、date、status）
	 */
	@RequestMapping(value = "/create")
	@ResponseBody
	public Order createOrder(int clientId,int employeeId,List<Room> rooms) {
		Order order = new Order();
		order.setClientId(clientId);
		order.setCreateEmployeeId(employeeId);
		order.setStatus("创建");
		double totalPrice = 0;
		for(Room room:rooms) {
			totalPrice += room.getRoomType().getPrice();
		}
		order.setTotalPrice(totalPrice);
		order.setDate(new Date());
		
		int result = orderService.createOrder(order);
		if(result==0) {
			return null;
		}
		//获取完整的order
		List<Order> list_order = orderService.selectAll();
		order = list_order.get(list_order.size()-1);
		
		OrderDetail tempDetail = new OrderDetail();
		//一个房间对应一条订单明细
		for(Room room:rooms) {
			tempDetail.setOrderId(order.getOrderId());
			tempDetail.setRoomId(room.getRoomId());
			tempDetail.setPrice(room.getRoomType().getPrice());
			orderDetailService.increaseOrderDetail(tempDetail);
		}
		
		return order;
	}
	
	/**
	 * 创建客户信息，并且创建订单
	 * @param client
	 */
	@RequestMapping(value = "/create2")
	@ResponseBody
	public Order createOrder(Client client, int employeeId) {
		if("".equals(client.getCardId()) ) {
			return null;
		}
		int result = clientService.insert(client);
		if(result==0) {
			return null;
		}
		client = clientService.selectByCardId(client.getCardId()).get(0);
		
		Order order = new Order();
		order.setClientId(client.getClientId());
		order.setCreateEmployeeId(employeeId);
		order.setStatus("创建");
		order.setDate(new Date());
		order.setTotalPrice(0.0);
		
		result = orderService.createOrder(order);
		if(result!=0) {
			List<Order> list = orderService.selectAll();
			return list.get(list.size()-1);//返回最新插入的记录
		}
		return null;
	}
	//更新订单
	@RequestMapping(value = "/update/orderId")
	@ResponseBody
	public int updateOrderById(Order order) {
		if(order.getOrderId()==null) {
			return 0;
		}
		int result = orderService.updateByOrderId(order);
		//如果是结账，需要把所有房间状态修改为“未清扫”
		if(result!=0) {
			Order temp = orderService.selectById(order.getOrderId());
			List<OrderDetail> detail_list = temp.getOrderDetail();
			if("结账".equals(order.getStatus())) {
				Room room_temp = new Room();
				for(OrderDetail detail : detail_list) {
					room_temp.setRoomId(detail.getRoomId());
					room_temp.setRoomStatusId(3);
					roomService.update(room_temp);
				}
			}//如果是结账，需要把所有房间状态修改为“入住中”
			else if("入住".equals(order.getStatus())) {
				Room room_temp = new Room();
				for(OrderDetail detail : detail_list) {
					room_temp.setRoomId(detail.getRoomId());
					room_temp.setRoomStatusId(4);
					roomService.update(room_temp);
				}
			}
		}

		return result;
	}
	
	//删除订单
	@RequestMapping(value = "/delete/orderId")
	public int deleteByOrderId(int orderId) {
		if(orderId==0) {
			return 0;
		}
		Order order = orderService.selectById(orderId);
		int result = orderId==0 ? 0 : orderService.deleteByOrderId(orderId);
		//如果订单删除成功，所有相关订单的房间状态均要修改
		if(result!=0) {
			int room_status_id = 0;
			//订单为创建状态，房态修改为空闲
			if("创建".equals(order.getStatus())) {
				room_status_id = 1;
			}//订单为入住状态，房态修改为未清扫
			else if("入住".equals(order.getStatus())) {
				room_status_id = 3;
			}
			List<OrderDetail> detail_list = order.getOrderDetail();
			Room room_temp = new Room();
			for(OrderDetail detail : detail_list) {
				room_temp.setRoomId(detail.getRoomId());
				room_temp.setRoomStatusId(room_status_id);
				roomService.update(room_temp);
			}
		}
		
		
		return result;
	}
	//订单列表
	@RequestMapping(value = "/select/all")
	@ResponseBody
	public Object selectAllOrder(int page, int limit) {
		List<Order> list = orderService.selectAll();
		
		PageHelper.startPage(page,limit);
		PageInfo info = new PageInfo<>(list);
		long total = info.getTotal();
		
		JSONObject jsObj = new JSONObject();
		jsObj.put("code","0");	//响应码：0
		jsObj.put("msg","");	//消息：空
		jsObj.put("count",total);	//总记录数
		jsObj.put("data",list);	//列表数据
		
		return jsObj;
	}
	
	//查询订单
	@RequestMapping(value = "/select/orderId")
	@ResponseBody
	public Order selectById(int orderId) {
		return orderService.selectById(orderId);
	}
	
	@RequestMapping(value = "/select/clientId")
	@ResponseBody
	public Object selectByClientId(int clientId, int page, int limit) {
		List<Order> list = orderService.selectByClientId(clientId);
		return this.toJsonObject(page, limit, list);
	}
	
	@RequestMapping(value = "/select/employteeId")
	@ResponseBody
	public Object selectByEmployeeId(int employeeId, int page, int limit) {
		List<Order> list = orderService.selectByEmployeeId(employeeId);
		return this.toJsonObject(page, limit, list);
	}
	
	@RequestMapping(value = "/select/status")
	@ResponseBody
	public Object selectByStatus(String status, int page, int limit) {
		List<Order> list = orderService.selectByStatus(status);
		return this.toJsonObject(page, limit, list);
	}
	
	//order_detail 增加订单明细,增加的同时需要修改该订单的总价
	@RequestMapping(value = "/detail/increase")
	@ResponseBody
	public int increaseOrderDetail(OrderDetail detail) {
		if(detail.getOrderId()==null||detail.getRoomId()==null) {
			return 0;
		}
		int orderId = detail.getOrderId();
		
		double price = detail.getRoom().getRoomType().getPrice();
		detail.setPrice(price);
		
		//order正常修改之后再插入order_detail表
		Order order = orderService.selectById(orderId);
		order.setTotalPrice( order.getTotalPrice()+price );
		int result = orderService.updateByOrderId(order);
		if(result==0) {
			return 0;
		}
		
		Room room = new Room();
		room.setRoomId(detail.getRoomId());
		//如果订单为“创建”状态，房间状态修改为“已预订”
		if(	"创建".equals(order.getStatus())) {
			room.setRoomStatusId(5);
			roomService.update(room);
		}
		//如果订单为"入住"状态，房间状态修改为“入住中”
		if("入住".equals(order.getStatus())) {
			room.setRoomStatusId(4);
			roomService.update(room);
		}
		
		return orderDetailService.increaseOrderDetail(detail);
	}
	
	//删除（减少）订单明细
	@RequestMapping(value = "/deleteDetail/id")
	@ResponseBody
	public int decreaseOrderDetailById(int id) {
		OrderDetail detail = orderDetailService.selectById(id);
		
		Order order = orderService.selectById(detail.getOrderId());
		order.setTotalPrice(order.getTotalPrice()-detail.getPrice());
		int result = orderService.updateByOrderId(order);
		if(result==0) {
			return 0;
		}
		
		Room room = new Room();
		room.setRoomId(detail.getRoomId());
		//房间状态修改为“未清扫”
		room.setRoomStatusId(3);
		roomService.update(room);
		
		
		return orderDetailService.deleteById(id);
		
	}
	//查询订单明细,在订单明细普遍不多的情况下不用分页
	@RequestMapping(value = "/selectDetail/byOrderId")
	@ResponseBody
	public List<OrderDetail> selectByOrderId(int orderId) {
		return orderDetailService.selectByOrderId(orderId);
	}
	//查询订单明细,  使用分页操作
	@RequestMapping(value = "/selectDetail/byOrderId/pages")
	@ResponseBody
	public Object selectByOrderId(int orderId, int page, int limit) {
		List<OrderDetail> list = orderDetailService.selectByOrderId(orderId);
		PageHelper.startPage(page,limit);
		PageInfo info = new PageInfo<>(list);
		long total = info.getTotal();
		
		JSONObject jsObj = new JSONObject();
		jsObj.put("code","0");	//响应码：0
		jsObj.put("msg","");	//消息：空
		jsObj.put("count",total);	//总记录数
		jsObj.put("data",list);	//列表数据
		
		return jsObj;
	}
	
	
	private JSONObject toJsonObject(int page, int limit, List<Order> list) {
		PageHelper.startPage(page,limit);
		PageInfo info = new PageInfo<>(list);
		long total = info.getTotal();
		
		JSONObject jsObj = new JSONObject();
		jsObj.put("code","0");	//响应码：0
		jsObj.put("msg","");	//消息：空
		jsObj.put("count",total);	//总记录数
		jsObj.put("data",list);	//列表数据
		
		return jsObj;
	}

}
