package com.hotel.mapper;

import com.hotel.pojo.RoomStatus;
import com.hotel.pojo.RoomStatusExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RoomStatusMapper {
    int countByExample(RoomStatusExample example);

    int deleteByExample(RoomStatusExample example);

    int deleteByPrimaryKey(Integer roomStatusId);

    int insert(RoomStatus record);

    int insertSelective(RoomStatus record);

    List<RoomStatus> selectByExample(RoomStatusExample example);

    RoomStatus selectByPrimaryKey(Integer roomStatusId);

    int updateByExampleSelective(@Param("record") RoomStatus record, @Param("example") RoomStatusExample example);

    int updateByExample(@Param("record") RoomStatus record, @Param("example") RoomStatusExample example);

    int updateByPrimaryKeySelective(RoomStatus record);

    int updateByPrimaryKey(RoomStatus record);
}