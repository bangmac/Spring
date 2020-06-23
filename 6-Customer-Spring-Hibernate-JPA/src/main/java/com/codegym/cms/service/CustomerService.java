package com.codegym.cms.service;

import com.codegym.cms.model.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findByAllService();

    Customer findByIdService(Long id);

    void saveService(Customer customer);

    void removeService(Long id);
}
