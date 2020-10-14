package com.hotel.pojo;

import java.util.Date;

public class Order {
    private Integer orderId;

    private Integer clientId;

    private Integer createEmployeeId;

    private Integer checkEmployeeId;

    private Integer payEmployeeId;

    private String status;

    private Double totalPrice;

    private Date date;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public Integer getCreateEmployeeId() {
        return createEmployeeId;
    }

    public void setCreateEmployeeId(Integer createEmployeeId) {
        this.createEmployeeId = createEmployeeId;
    }

    public Integer getCheckEmployeeId() {
        return checkEmployeeId;
    }

    public void setCheckEmployeeId(Integer checkEmployeeId) {
        this.checkEmployeeId = checkEmployeeId;
    }

    public Integer getPayEmployeeId() {
        return payEmployeeId;
    }

    public void setPayEmployeeId(Integer payEmployeeId) {
        this.payEmployeeId = payEmployeeId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}