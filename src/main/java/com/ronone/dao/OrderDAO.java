package com.ronone.dao;

import com.ronone.entities.OrderForm;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface OrderDAO extends CrudRepository<OrderForm, Integer> {

}
