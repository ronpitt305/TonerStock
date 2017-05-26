package com.ronone.controller;

import com.ronone.entities.Toner;
import com.ronone.service.TonerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class StockController {

    private TonerService tonerService;

    @Autowired
    public void setTonerService(TonerService tonerService){
        this.tonerService = tonerService;
    }

    @RequestMapping("/current-stock")
    public String showStockPage(Model model){
        List<Toner> toners = tonerService.findAllToners();
        model.addAttribute("toners", toners);
        model.addAttribute("toner", new Toner());
        return "current-stock";
    }

    @GetMapping("/showStockItem")
    public String addStockItem(@ModelAttribute("toner") Toner toner, Model model){
        model.addAttribute("toner", new Toner());
        model.addAttribute("tonerId", new Toner().getId());
        return "current-stock";
    }

    @PostMapping("/saveToner")
    public String saveStockItem(@ModelAttribute("toner") Toner toner, Model model){
        model.addAttribute("toner", new Toner());
        tonerService.saveToner(toner);
        return "redirect:/";
    }

    @PostMapping("/deleteToner/{id}")
    public String deleteStockItem(@PathVariable Long id){
        tonerService.deleteToner(id);
        return "redirect:/";
    }
}
