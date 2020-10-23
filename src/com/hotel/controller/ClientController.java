package com.hotel.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.hotel.pojo.Client;
import com.hotel.service.ClientService;

@Controller
@RequestMapping(value = "/client")
public class ClientController {

	@Autowired
	private ClientService service;
	
	
	@RequestMapping(value = "/viewAddClient")
	public String viewAddClient() {
		return "/WEB-INF/jsp/client/addClient";
	}
	
	/**
	 * 新建客户信息
	 * @param client
	 * @return0:新建失败 1:新建成功
	 */
	@RequestMapping(value = "/create")
	@ResponseBody
	public int createClient(Client client) {
		String clientId = null;
		int count = 0;
		int result = 0;
		do {
			clientId = new SimpleDateFormat("yyyyMM").format(new Date()) + System.currentTimeMillis()%100000;
			//TODO:逻辑不合理，无法进行准确计数，因为获取的是毫秒级的时间，代码重复执行的间隔不知道
			count++;
			if(count>1000) {
				break;
			}
		}while(service.selectById(Integer.parseInt(clientId))!=null);
		
		if(client==null||clientId==null||count>1000||client.getCardId()!=null) {
			return result;
		}
		
		result = service.insert(client);
		return result;
	}
	
	/**
	 * 根据用户编号查询客户
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/select/{id}")
	public String selectById(@PathVariable int id) {
		Client client = service.selectById(id);
		String json = JSON.toJSONString(client);
		return json;
	}
	
	/**
	 * 查询所有客户信息
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/select/all")
	public String selectAll() {
		List<Client> list = service.selectAll();
		String json = JSON.toJSONString(list);
		return json;
	}
	
	/**
	 * 修改客户信息，根据用户编号查找
	 * @param client
	 * @return 0:修改失败 1:修改成功
	 */
	@RequestMapping(value = "/update/id")
	@ResponseBody
	public int updateById(Client client) {
		if(client==null) {
			return 0;
		}
		int result = service.updateById(client);
		
		return result;
	}
	
	/**
	 * 修改客户信息，根据身份证号查找
	 * @param client
	 * @return 0:修改失败 1:修改成功
	 */
	@RequestMapping(value = "/update/cardId")
	@ResponseBody
	public int updateByCardId(Client client) {
		if(client==null) {
			return 0;
		}
		int result = service.updateByCardId(client);
		return result;
	}
	
	/**
	 * 删除客户信息，根据身份证号查找
	 * @param cardId
	 * @return 0:删除失败 1:删除成功
	 */
	@RequestMapping(value = "/delete/cardId")
	@ResponseBody
	public int deleteByCardId(String cardId) {
		int result = service.deleteByCardId(cardId);
		return result;
	}
	
	/**
	 * 删除客户信息，根据用户编号查找
	 * @param clientId
	 * @return 0:删除失败 1:删除成功
	 */
	@RequestMapping(value = "/delete/{clientId}")
	@ResponseBody
	public int deleteById(@PathVariable int clientId) {
		int result = service.deleteById(clientId);
		return result;
	}
	
}
