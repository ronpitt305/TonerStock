package com.ronone.controller;

import com.ronone.dao.BalanceDAO;
import com.ronone.entities.Balances;
import com.ronone.entities.Buyer;
import com.ronone.service.BalanceService;
import com.ronone.service.BuyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BalanceController {

    private BalanceService balanceService;

    @Autowired
    private BuyerService buyerService;

    @Autowired
    public void setBalanceService(BalanceService balanceService){
        this.balanceService = balanceService;
    }

    @GetMapping("/balances")
    public String showBalancePage(Model model){

        //Add Lists to view
        List<Balances> balances = balanceService.findAllBalances();
        List<Buyer> buyers = buyerService.findAllBuyers();

        //Adding objects
        model.addAttribute("balance", new Balances());
        model.addAttribute("buyer",new Buyer());

        //
        model.addAttribute("buyers", buyers);
        model.addAttribute("balances", balances);
        System.out.println(buyers);
        System.out.println();
        return "balances";
    }

    @PostMapping("/addBalance")
    public String savingBuyerBalance(@ModelAttribute("balance") Balances balances, Model model, @ModelAttribute("buyer") Buyer buyer){
        balanceService.saveBalance(balances);
        buyerService.saveBuyer(buyer);
        return "redirect:/";
    }

    @PostMapping("/deleteBalance/{id}")
    public String deleteBalance(@PathVariable Long id){
        balanceService.deleteBalance(id);
        return "redirect:/";
    }
}
