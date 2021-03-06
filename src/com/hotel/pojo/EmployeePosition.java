package com.hotel.pojo;

public class EmployeePosition {
	//id自增
    private Integer employeePositionId;

    private String positionName;

    public Integer getEmployeePositionId() {
        return employeePositionId;
    }

    public void setEmployeePositionId(Integer employeePositionId) {
        this.employeePositionId = employeePositionId;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName == null ? null : positionName.trim();
    }

	@Override
	public String toString() {
		return positionName ;
	}
    
}