package com.codegym.cms.service;

import com.codegym.cms.model.Customer;
import com.codegym.cms.model.Province;

import java.util.List;

public interface CustomerService {

    Iterable<Customer> findAllCustomerByProvince(Province province);

    Iterable<Customer> findByAll();

    Customer findById(Long id);

    void save(Customer customer);

    void remove(Long id);
}
