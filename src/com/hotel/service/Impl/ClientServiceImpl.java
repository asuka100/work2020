package com.hotel.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.mapper.ClientMapper;
import com.hotel.pojo.Client;
import com.hotel.pojo.ClientExample;
import com.hotel.pojo.ClientExample.Criteria;
import com.hotel.service.ClientService;

@Service
public class ClientServiceImpl implements ClientService {

	@Autowired
	private ClientMapper mapper;
	
	private ClientExample example;
	
	@Override
	public int insert(Client client) {
		if(client==null) {
			return 0;
		}
		return mapper.insertSelective(client);
	}

	@Override
	public int deleteById(int client_id) {
		return mapper.deleteByPrimaryKey(client_id);
	}

	@Override
	public int deleteByCardId(String card_id) {
		ClientExample example = new ClientExample();
		example.createCriteria().andCardIdEqualTo(card_id);
		return mapper.deleteByExample(example);
	}

	@Override
	public int updateById(Client client) {
		if(client==null) {
			return 0;
		}
		return mapper.updateByPrimaryKeySelective(client);
	}

	@Override
	public int updateByCardId(Client client) {
		if(client==null) {
			return 0;
		}
		client.setClientId(null);
		example = new ClientExample();
		example.createCriteria().andCardIdEqualTo(client.getCardId());
		return mapper.updateByExampleSelective(client, example);
	}

	@Override
	public List<Client> selectAll() {
		return mapper.selectByExample(null);
	}

	@Override
	public Client selectById(int id) {
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Client> selectByCardId(String card_id) {
		example = new ClientExample();
		example.createCriteria().andCardIdEqualTo(card_id);
		return mapper.selectByExample(example);
	}

	@Override
	public List<Client> selectByPhone(String phone) {
		example = new ClientExample();
		example.createCriteria().andPhoneEqualTo(phone);
		return mapper.selectByExample(example);
	}

}
