package com.sswapp.aqua.repo;

import com.sswapp.aqua.entity.People;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PeopleRepo extends MongoRepository<People, String> {
}
