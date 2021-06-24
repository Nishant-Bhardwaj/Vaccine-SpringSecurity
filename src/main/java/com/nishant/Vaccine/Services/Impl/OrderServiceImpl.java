package com.nishant.Vaccine.Services.Impl;

import com.nishant.Vaccine.Model.Order;
import com.nishant.Vaccine.Repositories.OrderRepo;
import com.nishant.Vaccine.Services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepo orderRepo;

    @Override
    public boolean cancelOrder(String orderId) {

        Order order = orderRepo.findById(orderId).orElse(null);
        if(order != null){
            order.setStatus("Cancelled");
            orderRepo.saveAndFlush(order);
            return true;
        }
        return false;
    }

    @Override
    public String placeOrder(Order order) {
        return orderRepo.saveAndFlush(order).getOrderId();
    }

    @Override
    public Order createOrder(int count, String address) {
        Order order = null;

        if(count!=0 && address!=null) {
            order = new Order();
            order.setOrderId("V" + String.valueOf(Math.random()).substring(2, 7));
            order.setCount(count);
            order.setAddress(address);
            order.setStatus("new");
        }

        return order;
    }

    @Override
    public String findOrderStatus(String orderId) {
        System.out.println("Order Id in service "+orderId);
        Order order = orderRepo.findById(orderId).get();
        System.out.println("Order retrieved "+ order.getOrderId());
        if(order != null)
            return order.getStatus();
        return null;
    }
}
