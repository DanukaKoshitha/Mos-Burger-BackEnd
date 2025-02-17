package org.example.service.Impl;

import lombok.RequiredArgsConstructor;
import org.example.dto.Customer;
import org.example.entity.CustomerEntity;
import org.example.reporsitory.CustomerReporsitory;
import org.example.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    final CustomerReporsitory reporsitory;
    final ModelMapper mapper;

    @Override
    public void addCustomer(Customer customer) {
        reporsitory.save(mapper.map(customer, CustomerEntity.class));
    }

    @Override
    public List<Customer> getCustomers() {
        List<CustomerEntity> all = reporsitory.findAll();
        List<Customer> customerList = new ArrayList<>();

        all.forEach(customerEntity -> {
            customerList.add(mapper.map(customerEntity, Customer.class));
        });

        return customerList;
    }

    @Override
    public void deleteCustomers(Integer id) {
        reporsitory.deleteById(id);
    }

    @Override
    public void update(Customer customer) {
        reporsitory.save(mapper.map(customer, CustomerEntity.class));
    }

    @Override
    public Customer serchCustomer(Integer id) {
        return mapper.map(reporsitory.findById(id), Customer.class);
    }

    @Override
    public List<Customer> searchByName(String name) {
        List<CustomerEntity> byName = reporsitory.findByName(name);
        List<Customer> customerList = new ArrayList<>();

        byName.forEach(customerEntity -> {
            customerList.add(mapper.map(customerEntity, Customer.class));
        });
        return customerList;
    }
//
//    @Override
//    public List<Customer> searchByAddress(String address) {
//        List<CustomerEntity> customerEntities = reporsitory.findByAddress();
//        List<Customer> customerList = new ArrayList<>();
//
//        customerEntities.forEach(customerEntity -> {
//            customerList.add(mapper.map(customerEntity, Customer.class));
//        });
//        return customerList;
//    }
//}
}