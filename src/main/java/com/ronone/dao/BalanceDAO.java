package com.ronone.dao;

import com.ronone.entities.Balances;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface BalanceDAO extends CrudRepository<Balances, Long> {

    @Override
    Iterable<Balances> findAll();

    @Override
    <S extends Balances> S save(S Balance);

    @Override
    void delete(Long aLong);
}
