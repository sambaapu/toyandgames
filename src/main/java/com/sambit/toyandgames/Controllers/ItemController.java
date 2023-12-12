package com.sambit.toyandgames.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sambit.toyandgames.Models.Item;
import com.sambit.toyandgames.Services.ItemService;

@RestController
public class ItemController {
    @Autowired
    ItemService itemService;

    @GetMapping(value="/items")
    public List<Item> getAllItems(){
        return itemService.findAll();
    }

    @GetMapping(value="/category/{category}")
    public List<Item> getItemsByCategory(@PathVariable String category){
        return itemService.findByCategory(category);
    }

    @PostMapping("/addItem")
    public ResponseEntity<Item> addItem(@RequestBody Item item){
        try {
            itemService.insert(item);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Item> updateItem(@PathVariable String id, @RequestBody Item item){
        Optional<Item> currItem = itemService.findById(id);
        if (currItem.isPresent()) {
            Item _currItem = currItem.get();
            _currItem.setCategory(item.getCategory());
            _currItem.setName(item.getName());
            _currItem.setUnitPrice(item.getUnitPrice());
            return new ResponseEntity<>(itemService.save(_currItem),HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Item> deleteItem(@PathVariable String id){
        try {
            itemService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
