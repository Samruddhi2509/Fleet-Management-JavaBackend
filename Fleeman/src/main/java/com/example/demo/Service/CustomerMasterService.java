package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Customer;
import com.example.demo.repository.CustomerMasterRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerMasterService {

    @Autowired
    private CustomerMasterRepository repository;

    public List<Customer> getAllCustomers() {
        return repository.findAll();
    }

    public Optional<Customer> getCustomerById(int id) {
        return repository.findById(id);
    }

    public Customer saveCustomer(Customer customer) {
        return repository.save(customer);
    }

    public void deleteCustomer(int id) {
        repository.deleteById(id);
    }
}

