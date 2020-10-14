package com.hotel.pojo;

public class RoomStatus {
    private Integer roomStatusId;

    private String statusName;
    
    public RoomStatus() { }
    
    public RoomStatus(String statusName) {
		super();
		this.statusName = statusName;
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