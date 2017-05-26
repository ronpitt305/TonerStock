package com.ronone.controller;

import com.ronone.entities.Buyer;
import com.ronone.service.BuyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @Autowired
    private BuyerService buyerService;

    @RequestMapping("/")
    public String homepage(){
        return "home-page";
    }

    @GetMapping("/searchBuyer")
    public String searchBuyer(Model model){
        model.addAttribute("buyer", new Buyer());
        return "home-page";
    }

    @PostMapping("/foundBuyer")
    public String foundBuyer(@ModelAttribute("buyer") String buyerName, Model model){
        buyerService.findByBuyerFirstName(buyerName);
        model.addAttribute("buyer", new Buyer());
        return "home-page";
    }
}
