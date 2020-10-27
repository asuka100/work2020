package com.hotel.service;

import java.util.List;

import com.hotel.pojo.Room;

public interface RoomService {
	int insert(Room room);
	
	List<Room> selectAll();
	
	Room selectById(int id);
	
	int deleteById(int id);

	List<Room> selectByRoomTypeId(int id);
	
	List<Room> selectByStatusId(int statusId);

	int update(Room room);

	List<Room> findByMaintainId(Integer roomId);



	

	
}
