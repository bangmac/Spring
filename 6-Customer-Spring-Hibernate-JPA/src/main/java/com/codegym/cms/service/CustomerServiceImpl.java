package com.codegym.cms.service;

import com.codegym.cms.model.Customer;
import com.codegym.cms.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CustomerServiceImpl implements CustomerService{
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> findByAllService() {
        return customerRepository.findAllRespo();
    }

    @Override
    public Customer findByIdService(Long id) {
        return customerRepository.findByIdRespo(id);
    }

    @Override
    public void saveService(Customer customer) {
        customerRepository.saveRespo(customer);
    }

    @Override
    public void removeService(Long id) {
        customerRepository.removeRespo(id);
    }
}
