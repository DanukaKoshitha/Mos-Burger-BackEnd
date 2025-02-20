package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.dto.Customer;
import org.example.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
@CrossOrigin

public class CustomerController {
   //  http://localhost:8080/customer/add

    final CustomerService service;

    @PostMapping("/add")
    public void addCustomer(@RequestBody Customer customer){
        service.addCustomer(customer);
    }

    @GetMapping("/get-customers")
    public List<Customer> getAll(){
        return service.getCustomers();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCustomer(@PathVariable Integer id){
        service.deleteCustomers(id);
    }

    @PutMapping("/update-customer/")
    public void updateCustomer(@RequestBody Customer customer){
        service.update(customer);
    }

    @GetMapping("/searchCustomer/{id}")
    public Customer searchById(@PathVariable Integer id){
        return service.serchCustomer(id);
    }

    @GetMapping("/searchByName/{name}")
    public List<Customer> searchByName(@PathVariable String name){
        return service.searchByName(name);
    }

    @GetMapping("/getElementByPhone/{contact}")
    public Customer searchByContact(@PathVariable String contact){
        return service.searchByContact(contact);
    }
}
