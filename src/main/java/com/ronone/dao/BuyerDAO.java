package com.ronone.dao;

import com.ronone.entities.Buyer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface BuyerDAO extends CrudRepository<Buyer, Integer> {

    @Override
    Iterable<Buyer> findAll(Iterable<Integer> iterable);

    @Override
    void delete(Buyer buyer);


}
