package com.sambit.toyandgames;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

@Document(collection = "items")
public class Item {
    private int id;
    private String name;
    private String category;
    private double unitPrice;
}
