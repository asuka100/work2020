package com.hotel.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.mapper.MaintainListMapper;
import com.hotel.pojo.MaintainList;
import com.hotel.pojo.MaintainListExample;
import com.hotel.service.MaintainListService;

@Service
public class MaintainListServiceImpl implements MaintainListService{

	@Autowired
	private MaintainListMapper mapper;
	
	@Override
	public int insertMaintain(MaintainList maintainList) {
		return mapper.insertSelective(maintainList);
	}

	@Override
	public List<MaintainList> selectAll() {
		return mapper.selectByExample(null);
	}

	@Override
	public List<MaintainList> seleteByRoomId(int roomId) {
		MaintainListExample example = new MaintainListExample();
		example.createCriteria().andRoomIdEqualTo(roomId);
		return mapper.selectByExample(example);
	}

	@Override
	public MaintainList selectById(int maintainListId) {
		return mapper.selectByPrimaryKey(maintainListId);
	}
	
	@Override
	public int updateMaintainListById(MaintainList maintainList) {
		if(maintainList.getMaintainId()==null) {
			return 0;
		}
		return mapper.updateByPrimaryKey(maintainList);
	}

	@Override
	public int deleteById(int id) {
		return mapper.deleteByPrimaryKey(id);
	}

}
