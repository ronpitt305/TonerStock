package com.ronone.controller;

import com.ronone.dao.OrderDAO;
import com.ronone.entities.Buyer;
import com.ronone.entities.OrderForm;
import com.ronone.entities.Toner;
import com.ronone.service.BuyerService;
import com.ronone.service.OrderService;
import com.ronone.service.TonerService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class OrderController {

   private OrderService orderService;

   @Autowired
   private BuyerService buyerService;

   @Autowired
   private TonerService tonerService;

   @Autowired
   public void setOrderService(OrderService orderService){
       this.orderService = orderService;
   }

    @RequestMapping("/orders")
    public String orderFormPage(Model model){
        List<OrderForm> orders = orderService.findAllOrder();
        List<Buyer> buyers = buyerService.findAllBuyers();
        List<Toner> toners = tonerService.findAllToners();
        model.addAttribute("order", new OrderForm());
        model.addAttribute("orders", orders);
        model.addAttribute("buyers", buyers);
        model.addAttribute("toners", toners);
        return "order-form";
    }

    @GetMapping("/showOrderForm")
    public String makeOrderForm(Model model){
        model.addAttribute("order", new OrderForm());
        return "order-form";
    }

    @PostMapping("/saveOrderForm")
    public String saveOrderForm(@ModelAttribute("order") OrderForm orderForm, Model model){
        orderService.saveOrder(orderForm);
        model.addAttribute("order", new OrderForm());
        return "redirect:/";
    }
}
