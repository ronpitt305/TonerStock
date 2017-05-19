package com.ronone.service;

import com.ronone.dao.ManagerDAO;
import com.ronone.entities.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagerService {

    @Autowired
    private ManagerDAO managerDAO;

    public <S extends Manager> S saveManager(S Manager){
        managerDAO.save(Manager);
        return Manager;
    }

    public List<Manager> findAllManagers(){
        return (List<Manager>) managerDAO.findAll();
    }

    public void deleteManager(Manager manager){
        managerDAO.delete(manager);
    }
}
