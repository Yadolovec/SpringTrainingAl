package com.app.repositories;

import com.app.models.Item;
import com.app.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemsRepository extends JpaRepository<Item, Integer> {
    List<Item> findByOwner(Person owner);
    List<Item> findByItemName(String itemName);

}
