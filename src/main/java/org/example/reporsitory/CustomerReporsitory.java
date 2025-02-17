package org.example.reporsitory;

import org.example.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerReporsitory extends JpaRepository<CustomerEntity,Integer> {

    List<CustomerEntity> findByName(String name);

   // List<CustomerEntity> findByAddress();
}
