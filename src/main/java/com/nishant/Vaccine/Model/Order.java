package com.nishant.Vaccine.Model;

import javax.persistence.*;

@Entity
@Table(name = "orderTBL")
public class Order {

    @Id
    @Column(name = "ORDER_ID")
    private String orderId;

    @Column(name = "COUNT_VACCINE")
    private int count;

    @Column(name = "address")
    private String address;

    @Column(name = "status")
    private String status;

    public Order() {
    }

    public Order(String orderId, int count, String address, String status) {
        this.orderId = orderId;
        this.count = count;
        this.address = address;
        this.status = status;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
