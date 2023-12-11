package com.sambit.toyandgames;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShopResources {
    @GetMapping(value = "/allresources")
    public String hello(){
        return "Hello Spring";
    }
}
