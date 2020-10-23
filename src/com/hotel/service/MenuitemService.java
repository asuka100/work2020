package com.hotel.service;

import java.util.List;

import com.hotel.pojo.Menuitem;

public interface MenuitemService {
	List<Menuitem> selectByPositionIdAndParent(int positionId,String parent);
	
	List<Menuitem> selectByPositionId(int positionId);
}
