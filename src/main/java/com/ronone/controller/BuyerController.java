package com.ronone.controller;

import com.ronone.dao.BuyerDAO;
import com.ronone.entities.Buyer;
import com.ronone.service.BuyerService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BuyerController {

    private BuyerService buyerService;

    @Autowired
    public void setBuyerService(BuyerService buyerService){
        this.buyerService = buyerService;
    }

    @RequestMapping("/add-buyer")
    public String showBuyerPager(Model model){
        List<Buyer> buyers = buyerService.findAllBuyers();
        model.addAttribute("buyers", buyers);
        model.addAttribute("buyer", new Buyer());
        return "add-buyer";
    }

    @GetMapping("/showBuyerForm")
    public String addBuyerForm(Model model){
        model.addAttribute("buyer", new Buyer());
        return "add-buyer";
    }

    @PostMapping("/addBuyer")
    public String postBuyerForm(@ModelAttribute("buyer") Buyer buyer, Model model){
        buyerService.saveBuyer(buyer);
        model.addAttribute("buyer", new Buyer());
        return "redirect:/";
    }

    @PostMapping("/deleteBuyer")
    public String deleteBuyer(@ModelAttribute("buyer") Buyer buyer, Model model){
        model.addAttribute("buyer", new Buyer());
        buyerService.deleteBuyer(buyer);
        return "redirect:/";
    }


}
