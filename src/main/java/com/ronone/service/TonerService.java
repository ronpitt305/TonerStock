package com.ronone.service;

import com.ronone.dao.TonerDAO;
import com.ronone.entities.Toner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TonerService {

    @Autowired
    private TonerDAO tonerDAO;

    public <S extends Toner> S saveToner(S Toner){
        tonerDAO.save(Toner);
        return Toner;
    }

    public List<Toner> findAllToners(){

        return (List<Toner>) tonerDAO.findAll();
    }

    public void deleteToner(Long id){
        tonerDAO.delete(id);
    }

    public Toner findOneToner(Long id){
        return tonerDAO.findOne(id);
    }
}
