package com.ecommerce.microcommerce.model;

import java.util.Date;
import java.util.List;

public class OrderInfo {

    private String id;
    private Date orderDate;
    private double amount;
    private int orderNum;
    private String userName;
    private int status;

    private List<OrderDetailInfo> details;

    public OrderInfo() {

    }

    // Using for Hibernate Query.
    public OrderInfo(String id, Date orderDate, int orderNum, String userName, //
                     double amount, int status) {
        this.id = id;
        this.orderDate = orderDate;
        this.amount = amount;
        this.orderNum = orderNum;
        this.userName = userName;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(int orderNum) {
        this.orderNum = orderNum;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserId(String userName) {
        this.userName = userName;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<OrderDetailInfo> getDetails() {
        return details;
    }

    public void setDetails(List<OrderDetailInfo> details) {
        this.details = details;
    }

}
