package com.ronone.service;

import com.ronone.dao.OrderDAO;
import com.ronone.entities.OrderForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderDAO orderDAO;

    public List<OrderForm> findAllOrder(){
        return (List<OrderForm>) orderDAO.findAll();
    }


    public <S extends OrderForm> S saveOrder(S OrderForm){
        orderDAO.save(OrderForm);
        return OrderForm;
    }
}
