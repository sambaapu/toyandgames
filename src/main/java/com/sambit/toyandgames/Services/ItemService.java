package com.sambit.toyandgames.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sambit.toyandgames.Models.Item;
import com.sambit.toyandgames.Repositories.ItemRepository;

@Service
public class ItemService{
    @Autowired
    public ItemRepository itemRepo;

    public List<Item> findAll() {
        return itemRepo.findAll();
    }

    public List<Item> findByCategory(String category) {
        return itemRepo.findByCategory(category);
    }

    public void insert(Item item) {
        itemRepo.insert(item);
    }

    public Optional<Item> findById(String id) {
        return itemRepo.findById(id);
    }

    public Item save(Item item) {
        return itemRepo.save(item);
    }

    public void deleteById(String id) {
    }
}
