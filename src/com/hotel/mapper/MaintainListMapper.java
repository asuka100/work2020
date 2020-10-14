package com.hotel.mapper;

import com.hotel.pojo.MaintainList;
import com.hotel.pojo.MaintainListExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MaintainListMapper {
    int countByExample(MaintainListExample example);

    int deleteByExample(MaintainListExample example);

    int deleteByPrimaryKey(Integer maintainId);

    int insert(MaintainList record);

    int insertSelective(MaintainList record);

    List<MaintainList> selectByExample(MaintainListExample example);

    MaintainList selectByPrimaryKey(Integer maintainId);

    int updateByExampleSelective(@Param("record") MaintainList record, @Param("example") MaintainListExample example);

    int updateByExample(@Param("record") MaintainList record, @Param("example") MaintainListExample example);

    int updateByPrimaryKeySelective(MaintainList record);

    int updateByPrimaryKey(MaintainList record);
}