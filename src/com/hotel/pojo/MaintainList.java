package com.hotel.pojo;

public class MaintainList {
    private Integer maintainId;

    private Integer roomId;

    private String employeeIdList;

    private String content;

    private String status;

    public Integer getMaintainId() {
        return maintainId;
    }

    public void setMaintainId(Integer maintainId) {
        this.maintainId = maintainId;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public String getEmployeeIdList() {
        return employeeIdList;
    }

    public void setEmployeeIdList(String employeeIdList) {
        this.employeeIdList = employeeIdList == null ? null : employeeIdList.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }
}