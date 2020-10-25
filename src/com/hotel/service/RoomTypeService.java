package com.hotel.service;

import java.util.List;

import com.hotel.pojo.RoomType;

public interface RoomTypeService {

	int insertRoomType(RoomType type);
	
	int deleteById(int typeId);
	
	List<RoomType> selectAll();
	
	RoomType selectById(int typeId);
	
	RoomType selectByTypeName(String typeName);
	
	int update(RoomType roomType);
}
