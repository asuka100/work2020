package com.hotel.service;

import java.util.List;

import com.hotel.pojo.Client;

public interface ClientService {
	
	int insert(Client client);
	
	int deleteById(int client_id);
	
	int deleteByCardId(String card_id);
	
	int updateById(Client client);
	
	int updateByCardId(Client client);
	
	List<Client> selectAll();
	
	Client selectById(int id);
	
	List<Client> selectByCardId(String card_id);
	
	List<Client> selectByPhone(String phone);
	
	
}
