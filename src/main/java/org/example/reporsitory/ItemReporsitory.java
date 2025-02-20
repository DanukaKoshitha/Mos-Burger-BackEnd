package org.example.reporsitory;

import org.example.entity.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemReporsitory extends JpaRepository<ItemEntity,String> {

}
