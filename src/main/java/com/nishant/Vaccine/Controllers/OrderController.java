package com.nishant.Vaccine.Controllers;

import com.nishant.Vaccine.Model.Order;
import com.nishant.Vaccine.Services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class OrderController {

    @Autowired
    OrderService orderService;

    @CrossOrigin("http://localhost:4200/")
    @ResponseBody
    @RequestMapping(value = "/order/{count}/{add}/")
    public String placeOrder(@PathVariable("count") int count, @PathVariable("add") String address){

        if(count<1 || address.isEmpty())
            throw new NullPointerException("Count or Address value not provided");

        Order order = orderService.createOrder(count, address);
        String orderId = orderService.placeOrder(order);

        return orderId;
    }

    @ResponseBody
    @RequestMapping(value = "/cancel/{orderId}")
    public String cancelOrder(@PathVariable("orderId") String orderId){
        String message = "Order with id: " + orderId;

        System.out.println("Order "+orderId);

        String orderStatus = orderService.findOrderStatus(orderId);

        if(orderStatus.equalsIgnoreCase("Cancelled")){
            message += " already cancelled";
        }

        else {
            boolean cancelStatus = orderService.cancelOrder(orderId);

            if (cancelStatus)
                message += " cancelled";
            else
                message += " not found";
        }

        return message;
    }

    @ResponseBody
    @RequestMapping(value = "/posts", method = RequestMethod.POST)
    public String placeOrders(int count, String address){

        if(count<1 || address.isEmpty())
            throw new NullPointerException("Count or Address value not provided");

        Order order = orderService.createOrder(count, address);
        String orderId = orderService.placeOrder(order);

        return orderId;
    }

    @GetMapping("/order")
    public String orderPage(){
        return "order";
    }
}
