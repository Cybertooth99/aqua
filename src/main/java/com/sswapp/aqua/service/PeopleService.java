package com.sswapp.aqua.service;

import com.sswapp.aqua.entity.People;
import com.sswapp.aqua.repo.PeopleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PeopleService
{
    private final PeopleRepo peopleRepo;
    private final MongoTemplate mongoTemplate;

    @Autowired
    public PeopleService(PeopleRepo peopleRepo, MongoTemplate mongoTemplate) {
        this.peopleRepo = peopleRepo;
        this.mongoTemplate = mongoTemplate;
    }

    public List<People> getAllPeople(Map params) {
        Query query = new Query();
        if(params != null && !params.isEmpty())
        {
            //Filtering based on Name or Place
            String name = (String) params.get("name");
            String place = (String) params.get("Place");
            if (name != null) {
                query.addCriteria(Criteria.where("name").is(name));
            }
            if (place != null) {
                query.addCriteria(Criteria.where("Place").is(place));
            }

            // Sorting based on Place
            if(params.containsKey("sortasc")) {
                String field = (String) params.get("sortasc");
                if ("name".equalsIgnoreCase(field)) {
                    query.with(Sort.by(Sort.Order.asc("name")));
                } else if ("place".equalsIgnoreCase(field)) {
                    query.with(Sort.by(Sort.Order.asc("Place")));
                } else if (!"name".equals(field) && !"Place".equals(field)) {
                    throw new IllegalArgumentException("Invalid sort direction specified");
                }
            }
            if(params.containsKey("sortdesc")) {
                String field = (String) params.get("sortdesc");
                if ("name".equalsIgnoreCase(field)) {
                    query.with(Sort.by(Sort.Order.desc("name")));
                } else if ("place".equalsIgnoreCase(field)) {
                    query.with(Sort.by(Sort.Order.desc("Place")));
                } else if (!"name".equals(field) && !"Place".equals(field)) {
                    throw new IllegalArgumentException("Invalid sort direction specified");
                }
            }
        }
        // Execute the query and return the result
        return (!query.getQueryObject().isEmpty()) ? mongoTemplate.find(query, People.class) : peopleRepo.findAll();
    }
}
