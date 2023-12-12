package com.sambit.toyandgames.Repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.sambit.toyandgames.Models.Item;

public interface ItemRepository extends MongoRepository<Item,String>{
    List<Item> findByCategory(String category);
}
