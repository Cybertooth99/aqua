package com.sswapp.aqua.controller;

import com.sswapp.aqua.service.PeopleService;
import com.sswapp.aqua.entity.People;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/people")
public class PeopleController {

    private final PeopleService peopleService;

    @Autowired
    public PeopleController(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    @GetMapping
    public List<People> getAllPeople(@RequestParam Map<String, String> params){
        return peopleService.getAllPeople(params);
    }
}
