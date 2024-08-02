package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.Service.CustomerMasterService;
import com.example.demo.entities.Customer;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/customers")
public class MasterController {

    @Autowired
    private CustomerMasterService service;

    @GetMapping
    public List<Customer> getAllCustomers() {
        return service.getAllCustomers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable int id) {
        Optional<Customer> customer = service.getCustomerById(id);
        if (customer.isPresent()) {
            return ResponseEntity.ok(customer.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Customer createCustomer(@RequestBody Customer customer) {
        return service.saveCustomer(customer);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable int id, @RequestBody Customer customerDetails) {
        Optional<Customer> customer = service.getCustomerById(id);
        if (customer.isPresent()) {
            Customer updatedCustomer = customer.get();
            updatedCustomer.setCustName(customerDetails.getCustName());
            updatedCustomer.setAddress1(customerDetails.getAddress1());
            updatedCustomer.setAddress2(customerDetails.getAddress2());
            updatedCustomer.setCity(customerDetails.getCity());
            updatedCustomer.setState(customerDetails.getState());
            updatedCustomer.setPin(customerDetails.getPin());
            updatedCustomer.setPhone(customerDetails.getPhone());
            service.saveCustomer(updatedCustomer);
            return ResponseEntity.ok(updatedCustomer);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable int id) {
        if (service.getCustomerById(id).isPresent()) {
            service.deleteCustomer(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
