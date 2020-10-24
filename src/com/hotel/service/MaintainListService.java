package com.hotel.service;

import java.util.List;

import com.hotel.pojo.MaintainList;

public interface MaintainListService {

	int insertMaintain(MaintainList maintainList);
	
	List<MaintainList> selectAll();
	
	List<MaintainList> seleteByRoomId(int roomId);

	MaintainList selectById(int maintainListId);
	
	int updateMaintainListById(MaintainList maintainList);
	
	int deleteById(int id);
}
