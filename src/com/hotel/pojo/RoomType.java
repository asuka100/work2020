package com.hotel.pojo;

public class RoomType {
    private Integer roomTypeId;

    private String typeName;

    public RoomType() { }
  //id自增
    public RoomType(String typeRoom) {
    	super();
    	this.setTypeName(typeRoom);
    }
    
    public Integer getRoomTypeId() {
        return roomTypeId;
    }

    public void setRoomTypeId(Integer roomTypeId) {
        this.roomTypeId = roomTypeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName == null ? null : typeName.trim();
    }
}