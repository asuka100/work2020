package com.hotel.service;

import java.util.List;

import com.hotel.pojo.RoomStatus;

public interface RoomStatusService {

	int insertRoomStatus(RoomStatus status);
	
	int deleteById(int roomStatusId);
	
	List<RoomStatus> selectAll();
	
	RoomStatus selectSatusByName(String statusName);
	
	RoomStatus selectById(int roomStatusId);
	
	int updateNameById(RoomStatus roomStatus);
}
