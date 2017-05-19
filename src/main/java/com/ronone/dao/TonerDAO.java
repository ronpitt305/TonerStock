package com.ronone.dao;

import com.ronone.entities.Toner;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TonerDAO extends CrudRepository<Toner, Integer> {

    @Override
    <S extends Toner> S save(S s);

    @Override
    Iterable<Toner> findAll();
}
