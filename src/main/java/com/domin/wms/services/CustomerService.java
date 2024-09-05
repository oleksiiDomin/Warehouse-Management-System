package com.domin.wms.services;

import com.domin.wms.molels.Customer;
import com.domin.wms.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class CustomerService {
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    public Customer findOne(int id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Transactional
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Transactional
    public void update(Customer updatedCustomer, int id) {
        updatedCustomer.setId(id);
        customerRepository.save(updatedCustomer);
    }

    @Transactional
    public void delete(int id) {
        customerRepository.deleteById(id);
    }
}
