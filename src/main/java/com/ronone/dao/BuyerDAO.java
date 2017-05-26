package com.ronone.dao;

import com.ronone.entities.Buyer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface BuyerDAO extends CrudRepository<Buyer, Long> {

    @Override
    Iterable<Buyer> findAll(Iterable<Long> iterable);

    @Override
    void delete(Long aLong);

    Iterable<Buyer> findByFirstName (String firstName);
}
