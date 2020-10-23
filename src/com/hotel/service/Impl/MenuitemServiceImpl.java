package com.hotel.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.mapper.MenuitemMapper;
import com.hotel.pojo.Menuitem;
import com.hotel.pojo.MenuitemExample;
import com.hotel.service.MenuitemService;

@Service
public class MenuitemServiceImpl implements MenuitemService{

	@Autowired
	private MenuitemMapper mapper;
	
	@Override
	public List<Menuitem> selectByPositionIdAndParent(int positionId, String parent) {
		MenuitemExample example = new MenuitemExample();
		example.createCriteria().andPositionIdEqualTo(positionId).andParentEqualTo(parent);
		return mapper.selectByExample(example);
	}

	@Override
	public List<Menuitem> selectByPositionId(int positionId) {
		MenuitemExample example = new MenuitemExample();
		example.createCriteria().andPositionIdEqualTo(positionId);
		return mapper.selectByExample(example);
	}

}
