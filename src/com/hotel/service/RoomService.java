package com.hotel.service;

import java.util.List;

import com.hotel.pojo.Room;

public interface RoomService {
	int insert(Room room);
	
	List<Room> selectAll();
	
	Room selectById(int id);
	
	int deleteById(int id);
}
