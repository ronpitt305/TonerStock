package com.ronone.dao;

import com.ronone.entities.Toner;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface TonerDAO extends CrudRepository<Toner, Long> {

    @Override
    <S extends Toner> S save(S s);

    @Override
    Iterable<Toner> findAll();

    @Override
    void delete(Long aLong);
}
