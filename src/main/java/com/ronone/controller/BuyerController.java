package com.ronone.controller;

import com.ronone.dao.BuyerDAO;
import com.ronone.entities.Buyer;
import com.ronone.entities.Toner;
import com.ronone.service.BuyerService;
import com.ronone.service.TonerService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Controller
public class BuyerController {

    private BuyerService buyerService;

    @Autowired
    private TonerService tonerService;

    @Autowired
    public void setBuyerService(BuyerService buyerService){
        this.buyerService = buyerService;
    }

    @RequestMapping("/add-buyer")
    public String showBuyerPager(Model model){

        //List
        List<Buyer> buyers = buyerService.findAllBuyers();
        List<Toner> toners = tonerService.findAllToners();

        //sending list to view
        model.addAttribute("buyers", buyers);
        model.addAttribute("toners", toners);

        //creating objects in view
        model.addAttribute("buyer", new Buyer());
        model.addAttribute("toner", new Toner());
        return "add-buyer";
    }

    @GetMapping("/showBuyerForm")
    public String addBuyerForm(Model model){
        model.addAttribute("buyer", new Buyer());
        model.addAttribute("toner", new Toner());
        model.addAttribute("buyerId", new Buyer().getBuyerId());
        return "add-buyer";
    }

    @PostMapping("/addBuyer")
    public String postBuyerForm(@ModelAttribute("buyer") Buyer buyer, Model model){
        buyerService.saveBuyer(buyer);
        model.addAttribute("buyer", new Buyer());
        return "redirect:/";
    }

    @PostMapping("/deleteBuyer/{id}")
    public String deleteBuyer(@PathVariable Long id){
        buyerService.deleteBuyer(id);
        return "redirect:/";
    }

    @PostMapping("/addToBuyerBal/{id}")
    public String addToBuyerBalance(Model model, @PathVariable Long id, @RequestParam("add") int add){
        int num = add;
        Buyer mBuyer = buyerService.findOne(id);
        mBuyer.setBalance(mBuyer.getBalance() + num);
        buyerService.saveBuyer(mBuyer);
        model.addAttribute("add", add);
        return "redirect:/";


    }

    @PostMapping("/purcahseToner/{id}")
    public String buyToner(Model model, @PathVariable Long id, @ModelAttribute("toner") Toner toner){
        Buyer mBuyer = buyerService.findOne(id);
        Toner mToner = tonerService.saveToner(toner);
        return "redirect:/";
    }

    @PostMapping("/saleToner/{toner}")
    public String saleToner(){

        return "redirect:/";
    }
}
