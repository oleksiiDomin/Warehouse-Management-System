package com.domin.wms.services;

import com.domin.wms.molels.Order;
import com.domin.wms.repositories.OrdersRepository;
import com.domin.wms.util.exceptions.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class OrdersService {

    private final OrdersRepository ordersRepository;



    @Autowired
    public OrdersService(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }



    public List<Order> findAll() {
        return ordersRepository.findAll();
    }


    public List<Order> findAllByCustomerId(int id) {
        return ordersRepository.findAllByCustomer_Id(id);
    }


    public Order findOne(int id) {
        return ordersRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }


    public Order findByLot(String lot) {
        return ordersRepository.findByLotStartsWith(lot);
    }


    @Transactional
    public void save(Order order) {
        ordersRepository.save(order);
    }


    @Transactional
    public void update(Order updatedOrder, int id) {
        updatedOrder.setId(id);
        ordersRepository.save(updatedOrder);
    }
}
