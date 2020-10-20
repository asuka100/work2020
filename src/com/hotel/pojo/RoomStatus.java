package com.hotel.pojo;

public class RoomStatus {
    private Integer roomStatusId;

    private String statusName;

    public RoomStatus() { }
    //id自增
    public RoomStatus(String statusName) {
    	super();
    	this.setStatusName(statusName);
    }
    
    public Integer getRoomStatusId() {
        return roomStatusId;
    }

    public void setRoomStatusId(Integer roomStatusId) {
        this.roomStatusId = roomStatusId;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName == null ? null : statusName.trim();
    }
}