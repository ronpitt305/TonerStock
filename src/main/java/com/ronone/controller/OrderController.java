package com.ronone.controller;

import com.ronone.dao.OrderDAO;
import com.ronone.entities.Buyer;
import com.ronone.entities.Manager;
import com.ronone.entities.OrderForm;
import com.ronone.entities.Toner;
import com.ronone.service.BuyerService;
import com.ronone.service.ManagerService;
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
   private ManagerService managerService;

   @Autowired
   public void setOrderService(OrderService orderService){
       this.orderService = orderService;
   }

    @RequestMapping("/orders")
    public String orderFormPage(Model model){
        List<OrderForm> orders = orderService.findAllOrder();
        List<Buyer> buyers = buyerService.findAllBuyers();
        List<Toner> toners = tonerService.findAllToners();
        List<Manager> managers = managerService.findAllManagers();
        model.addAttribute("order", new OrderForm());
        model.addAttribute("orders", orders);
        model.addAttribute("buyers", buyers);
        model.addAttribute("toners", toners);
        model.addAttribute("managers", managers);
        return "order-form";
    }


    @GetMapping("/orders")
    public String selectOrder(Model model){
        model.addAttribute("buyers", new Buyer());
        model.addAttribute("toners", new Toner());
        model.addAttribute("managers", new Manager());
        return "order-form";
    }

    @PostMapping("/saveOrder")
    public String sendOrderToORM(@ModelAttribute("toner") Toner toner, @ModelAttribute("buyer") Buyer buyer, Model model){
        model.addAttribute("buyers", new Buyer());
        model.addAttribute("toners", new Toner());
        model.addAttribute("managers", new Manager());
        buyerService.saveBuyer(buyer);
        tonerService.saveToner(toner);
        return "redirect:/";
    }


}
