package com.ronone.controller;

import com.ronone.entities.Manager;
import com.ronone.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ManagerController {

    private ManagerService managerService;

    @Autowired
    public void setManagerService(ManagerService managerService){
        this.managerService = managerService;
    }

    @RequestMapping("/add-manager")
    public String showManagerPage(Model model){
        List<Manager> managers = managerService.findAllManagers();
        model.addAttribute("manager", new Manager());
        model.addAttribute("managers", managers);
        return "add-manager";
    }

    @GetMapping("/showManagerForm")
    public String addManagerForm(Model model){
        model.addAttribute("manager", new Manager());
        model.addAttribute("managerId", new Manager().getMid());
        return "add-manager";
    }

    @PostMapping("/saveManager")
    public String postManagerForm(@ModelAttribute("manager") Manager manager, Model model){
        managerService.saveManager(manager);
        model.addAttribute("manager", new Manager());
        return "redirect:/";
    }

    @PostMapping("/deleteManager/{id}")
    public String deleteManager(@PathVariable Long id){
        managerService.deleteManager(id);
        return "redirect:/";
    }
}
