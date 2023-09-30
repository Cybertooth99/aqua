package com.sswapp.aqua;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface PeopleRepo extends MongoRepository<People, String> {
}
