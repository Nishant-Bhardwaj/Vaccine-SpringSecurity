package com.nishant.Vaccine.Controllers;

import com.nishant.Vaccine.Model.Order;
import com.nishant.Vaccine.Services.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200/")
@Controller
public class OrderController {

    @Autowired
    OrderService orderService;

    Logger logger = LoggerFactory.getLogger(OrderController.class);

    @ResponseBody
    @RequestMapping(value = "/order/{count}/{add}/")
    public String placeOrder(@PathVariable("count") int count, @PathVariable("add") String address){

        if(count<1 || address.isEmpty())
            throw new NullPointerException("Count or Address value not provided");

        Order order = orderService.createOrder(count, address);

        return orderService.placeOrder(order);
    }

    @ResponseBody
    @RequestMapping(value = "/cancel/{orderId}")
    public String cancelOrder(@PathVariable("orderId") String orderId){
        String message = "Order with id: " + orderId;

        logger.info(String.format("Order %s" ,orderId));

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
    @PostMapping(value = "/posts")
    public String placeOrdersPost(int count, String address){

        if(count<1 || address.isEmpty())
            throw new NullPointerException("Count or Address value not provided");

        Order order = orderService.createOrder(count, address);

        return orderService.placeOrder(order);
    }

    /**
     * Redirects to order.jsp page, present in templates package(thymleaf implemented)
     * @return order.jsp
     */
    @GetMapping("/order")
    public String orderPage(){
        return "order";
    }
}
