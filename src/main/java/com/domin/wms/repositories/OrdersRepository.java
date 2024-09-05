package com.domin.wms.repositories;

import com.domin.wms.molels.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface OrdersRepository extends JpaRepository<Order, Integer> {
    List<Order> findAllByCustomer_Id(int id);
    Order findByLotStartsWith(String lot);
}
