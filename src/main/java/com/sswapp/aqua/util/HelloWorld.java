package com.sswapp.aqua.util;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class HelloWorld
{
    @GetMapping("/api/welcome")
    public String Welcome()
    {
        return "Welcome to partha planet!";
    }
}