package com.hotel.pojo;

import java.util.Date;
import java.util.List;

public class Order {
    private Integer orderId;

    private Integer clientId;

    private Integer createEmployeeId;

    private Integer checkEmployeeId;

    private Integer payEmployeeId;

    private String status;

    private Double totalPrice;

    private Date date;
    
    private OrderDetail orderDetail;
    
    private Client client;
    
    private Employee create_employee;
    
    private Employee check_employee;
    
    private Employee pay_employee;
    
    public Order() {
    	this.date = new Date();
    }

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (orderId == null) {
			if (other.orderId != null)
				return false;
		} else if (!orderId.equals(other.orderId))
			return false;
		return true;
	}

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

	
	

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Employee getCreate_employee() {
		return create_employee;
	}

	public void setCreate_employee(Employee create_employee) {
		this.create_employee = create_employee;
	}

	public Employee getCheck_employee() {
		return check_employee;
	}

	public void setCheck_employee(Employee check_employee) {
		this.check_employee = check_employee;
	}

	public Employee getPay_employee() {
		return pay_employee;
	}

	public void setPay_employee(Employee pay_employee) {
		this.pay_employee = pay_employee;
	}

	public OrderDetail getOrderDetail() {
		return orderDetail;
	}

	public void setOrderDetail(OrderDetail orderDetail) {
		this.orderDetail = orderDetail;
	}
}