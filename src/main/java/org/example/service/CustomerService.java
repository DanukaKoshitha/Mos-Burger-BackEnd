package org.example.service;

import org.example.dto.Customer;

import java.util.List;

public interface CustomerService {
    void addCustomer(Customer customer);

    List<Customer> getCustomers();

    void deleteCustomers(Integer id);

    void update(Customer customer);

    Customer serchCustomer(Integer id);

    List<Customer> searchByName(String name);

   // List<Customer> searchByAddress(String address);
}
