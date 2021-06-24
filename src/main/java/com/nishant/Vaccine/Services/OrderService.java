package com.nishant.Vaccine.Services;

import com.nishant.Vaccine.Model.Order;
import org.springframework.stereotype.Service;

@Service
public interface OrderService {

    boolean cancelOrder(String orderId);

    String placeOrder(Order order);

    Order createOrder(int count, String address);

    String findOrderStatus(String orderId);
}
