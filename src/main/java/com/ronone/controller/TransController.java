package com.ronone.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TransController {

    @RequestMapping("/transactions")
    public String showTransPage(Model model){

        return "transactions";
    }
}
