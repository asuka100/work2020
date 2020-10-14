package com.hotel.mapper;

import com.hotel.pojo.EmployeePosition;
import com.hotel.pojo.EmployeePositionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EmployeePositionMapper {
    int countByExample(EmployeePositionExample example);

    int deleteByExample(EmployeePositionExample example);

    int deleteByPrimaryKey(Integer employeePositionId);

    int insert(EmployeePosition record);

    int insertSelective(EmployeePosition record);

    List<EmployeePosition> selectByExample(EmployeePositionExample example);

    EmployeePosition selectByPrimaryKey(Integer employeePositionId);

    int updateByExampleSelective(@Param("record") EmployeePosition record, @Param("example") EmployeePositionExample example);

    int updateByExample(@Param("record") EmployeePosition record, @Param("example") EmployeePositionExample example);

    int updateByPrimaryKeySelective(EmployeePosition record);

    int updateByPrimaryKey(EmployeePosition record);
}