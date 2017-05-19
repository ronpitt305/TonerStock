package com.ronone.service;

import com.ronone.dao.BuyerDAO;
import com.ronone.entities.Buyer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuyerService {

    @Autowired
    private BuyerDAO buyerDAO;

    public <S extends Buyer> S saveBuyer(S Buyer){
        buyerDAO.save(Buyer);
        return Buyer;
    }

    public List<Buyer> findAllBuyers(){
        return (List<Buyer>) buyerDAO.findAll();
    }

    public void deleteBuyer(Buyer buyer){
        buyerDAO.delete(buyer);
    }
 }
