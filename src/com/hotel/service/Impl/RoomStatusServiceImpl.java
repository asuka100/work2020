package com.hotel.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.hotel.mapper.RoomMapper;
import com.hotel.mapper.RoomStatusMapper;
import com.hotel.pojo.Room;
import com.hotel.pojo.RoomExample;
import com.hotel.pojo.RoomStatus;
import com.hotel.pojo.RoomStatusExample;
import com.hotel.pojo.RoomStatusExample.Criteria;
import com.hotel.service.RoomStatusService;

@Service
public class RoomStatusServiceImpl implements RoomStatusService {

	@Autowired
	private RoomStatusMapper mapper;
	
	@Autowired
	private RoomMapper roomMapper;
	
	/**
	 * 新增房态
	 */
	@Override
	public int insertRoomStatus(String statusName) {
		//检查是否存在有同名房态
		if(this.selectSatusByName(statusName)!=null) {
			return 0;
		}
		return mapper.insertSelective(new RoomStatus(statusName));
	}
	
	/**
	 * 删除房态
	 * @return 0:删除失败，1:删除成功
	 */
	@Override
	public int deleteById(int roomStatusId) {
		//检验房间表中时候还有该房态的房间
		RoomExample roomExample = new RoomExample();
		com.hotel.pojo.RoomExample.Criteria criteria = roomExample.createCriteria();
		criteria.andRoomStatusIdEqualTo(roomStatusId);
		List<Room> results = roomMapper.selectByExample(roomExample);
		if(results.size()>0) {
			return 0;
		}
		
		return mapper.deleteByPrimaryKey(roomStatusId);
	}
	
	/**
	 * 查询所有房态
	 */
	@Override
	public List<RoomStatus> selectAll() {
		return mapper.selectByExample(null);
	}
	
	/**
	 * 查询指定名称的房态
	 */
	@Override
	public RoomStatus selectSatusByName(String statusName) {
		RoomStatusExample example = new RoomStatusExample();
		Criteria criteria = example.createCriteria();
		criteria.andStatusNameEqualTo(statusName);
		List<RoomStatus> list = mapper.selectByExample(example);
		if(list.isEmpty()) {
			return null;
		}
		return list.get(0);
	}
	
	/**
	 * 查询指定id的房态
	 */
	@Override
	public RoomStatus selectById(int roomStatusId) {
		return mapper.selectByPrimaryKey(roomStatusId);
	}
	
	/**
	 * 通过id指定修改房态名称
	 * @return 0:修改失败，1：修改成功
	 */
	@Override
	public int updateNameById(RoomStatus roomStatus) {
		//传进的参数不为空，且数据库中已有对应id的记录，并且没有同名房态
		if(roomStatus==null||roomStatus.getStatusName()==null||roomStatus.getRoomStatusId()==null
				||mapper.selectByPrimaryKey(roomStatus.getRoomStatusId())!=null
				||this.selectSatusByName(roomStatus.getStatusName())!=null) {
			return 0;
		}
		return mapper.updateByPrimaryKey(roomStatus);
	}
}
