package com.hotel.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.hotel.mapper.RoomStatusMapper;
import com.hotel.pojo.RoomStatus;
import com.hotel.service.RoomStatusService;

@Service
public class RoomStatusServiceImpl implements RoomStatusService {

	@Autowired
	private RoomStatusMapper mapper;
	
	@Override
	public int insertRoomStatus(String statusName) {
		return mapper.insertSelective(new RoomStatus(statusName));
	}
	
}
