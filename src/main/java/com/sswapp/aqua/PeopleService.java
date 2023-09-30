package com.sswapp.aqua;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class PeopleService
{
    private final PeopleRepo peopleRepo;

    @Autowired
    public PeopleService(PeopleRepo peopleRepo) {
        this.peopleRepo = peopleRepo;
    }

    public List<People> getAllPeople(String fieldName) throws Exception{
        Sort sort = null;
        if(fieldName != null)
        {
            if("asc".equals(fieldName))
            {
                sort = Sort.by(Sort.Order.asc("Place"));
            }
            else if ("desc".equals(fieldName))
            {
                sort = Sort.by(Sort.Order.desc("Place"));
            }
            else
            {
                throw new Exception("Invalid type specified");
            }
        }
        return (sort == null) ? peopleRepo.findAll() : peopleRepo.findAll(sort);
    }
}
