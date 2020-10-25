package com.hotel.pojo;

public class RoomType {
    private Integer roomTypeId;

    private String typeName;

    private Double price;

    private String decript;

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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDecript() {
        return decript;
    }

    public void setDecript(String decript) {
        this.decript = decript == null ? null : decript.trim();
    }

	@Override
	public String toString() {
		return "RoomType [roomTypeId=" + roomTypeId + ", typeName=" + typeName + ", price=" + price + ", decript="
				+ decript + "]";
	}
    
    
}