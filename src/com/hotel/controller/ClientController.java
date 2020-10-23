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
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
	 * @return null:新建失败  Client:新建成功
	 */
	@RequestMapping(value = "/create")
	@ResponseBody
	public Client createClient(Client client) {
		if(client==null||client.getCardId()==null) {
			return null;
		}
		List<Client> temp = service.selectByCardId(client.getCardId());
		if(temp.size()!=0) {
			//身份号已存在
			return null;
		}
		
		int result = service.insert(client);
		temp = service.selectByCardId(client.getCardId());
		return temp.get(0);
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
	public Object selectAll(int page, int limit) {
		PageHelper.startPage(page,limit);
		List<Client> list = service.selectAll();
		PageInfo info = new PageInfo<>(list);
		long total = info.getTotal();
		JSONArray jsonArray = new JSONArray();
		if(list!=null) {
			jsonArray = new JSONArray();
			for(Client c : list) {
				jsonArray.add(c);
			}
		}
		JSONObject jsObj = new JSONObject();
		jsObj.put("code", "0");
		jsObj.put("msg","");
		jsObj.put("count",total);
		jsObj.put("data",jsonArray);
		
		return jsObj;
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
