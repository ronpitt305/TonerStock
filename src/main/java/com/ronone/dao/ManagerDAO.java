package com.ronone.dao;

import com.ronone.entities.Manager;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface ManagerDAO extends CrudRepository<Manager, Integer> {

    @Override
    Iterable<Manager> findAll();

    @Override
    void delete(Manager manager);
}
