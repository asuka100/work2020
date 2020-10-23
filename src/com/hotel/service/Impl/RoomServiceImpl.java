package com.hotel.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.mapper.RoomMapper;
import com.hotel.pojo.Room;
import com.hotel.service.RoomService;

@Service
public class RoomServiceImpl implements RoomService {

	@Autowired
	private RoomMapper mapper;
	
	@Override
	public int insert(Room room) {
		return mapper.insertSelective(room);
	}

	@Override
	public List<Room> selectAll() {
		return mapper.selectByExample(null);
	}

	@Override
	public Room selectById(int id) {
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public int deleteById(int id) {
		return mapper.deleteByPrimaryKey(id);
	}

}
