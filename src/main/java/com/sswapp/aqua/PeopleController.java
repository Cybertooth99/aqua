package com.sswapp.aqua;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/people")
public class PeopleController {

    private final PeopleService peopleService;

    @Autowired
    public PeopleController(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    @GetMapping
    public List<People> getAllPeople(@RequestParam(name = "Place", required = false) String place) throws Exception {
        return peopleService.getAllPeople(place);
    }

    // Add more endpoints as needed
}
