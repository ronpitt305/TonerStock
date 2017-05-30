package com.ronone.service;

import com.ronone.dao.BalanceDAO;
import com.ronone.entities.Balances;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BalanceService {

    @Autowired
    private BalanceDAO balanceDAO;

    public List<Balances> findAllBalances(){
        return (List<Balances>) balanceDAO.findAll();
    }

    public <S extends Balances> S saveBalance (S Balance){
        return balanceDAO.save(Balance);
    }

    public void deleteBalance(Long id){
        balanceDAO.delete(id);
    }


}
