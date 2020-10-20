package com.hotel.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.mapper.RoomTypeMapper;
import com.hotel.pojo.RoomType;
import com.hotel.pojo.RoomTypeExample;
import com.hotel.service.RoomTypeService;

@Service
public class RoomTypeServiceImpl implements RoomTypeService {

	@Autowired
	private RoomTypeMapper mapper;
	
	/**
	 * 增加房间类型
	 */
	@Override
	public int insertRoomType(String typeName) {
		if(this.selectByTypeName(typeName)!=null) {
			//已存在同名的房间类型
			return 0;
		}
		return mapper.insertSelective(new RoomType(typeName));
	}

	@Override
	public int deleteById(int typeId) {
		return mapper.deleteByPrimaryKey(typeId);
	}

	@Override
	public List<RoomType> selectAll() {
		return mapper.selectByExample(null);
	}

	@Override
	public RoomType selectById(int typeId) {
		return mapper.selectByPrimaryKey(typeId);
	}

	@Override
	public RoomType selectByTypeName(String typeName) {
		if(typeName==null) {
			return null;
		}
		RoomTypeExample example = new RoomTypeExample();
		example.createCriteria().andTypeNameEqualTo(typeName);
		List<RoomType> list = mapper.selectByExample(example);
		if(list.size()==0) {
			//未查找到同名的房间类型
			return null;
		}
		return list.get(0);
	}

	/**
	 * 更新房间类型
	 */
	@Override
	public int update(RoomType roomType) {
		//参数不为空，数据库中已有相同id的记录，没有相同类型名称的记录
		if(roomType==null||roomType.getRoomTypeId()==null||roomType.getTypeName()==null
				||mapper.selectByPrimaryKey(roomType.getRoomTypeId())!=null
				||this.selectByTypeName(roomType.getTypeName())==null) {
			return 0;
		}
		return mapper.updateByPrimaryKey(roomType);
	}

	
	
}
