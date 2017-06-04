package com.ronone.dao;

import com.ronone.entities.Buyer;
import com.sun.xml.internal.bind.v2.model.core.ID;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import static javafx.scene.input.KeyCode.T;

@Repository
@Transactional
public interface BuyerDAO extends CrudRepository<Buyer, Long> {

    @Override
    Iterable<Buyer> findAll(Iterable<Long> iterable);

    @Override
    void delete(Long aLong);

    @Override
    Buyer findOne(Long aLong);

    @Override
    <S extends Buyer> S save(S buyer);




}
