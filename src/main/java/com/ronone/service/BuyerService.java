package com.ronone.service;

import com.ronone.dao.BuyerDAO;
import com.ronone.entities.Buyer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
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

    public void deleteBuyer(Long along){
        buyerDAO.delete(along);
    }

    public Buyer findOne(Long id){
        return buyerDAO.findOne(id);
    }


 }
