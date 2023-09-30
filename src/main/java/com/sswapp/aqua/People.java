package com.sswapp.aqua;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "HelloWorld")
public class People
{
    private String Id;
    private String name;
    private int Age;
    private String Place;

    private People()
    {
        //default constructor
    }
    public People(String name, int Age, String Place)
    {
        this.name = name;
        this.Age = Age;
        this.Place = Place;
    }
    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int Age) {
        this.Age = Age;
    }

    public String getPlace() {
        return Place;
    }

    public void setPlace(String Place) {
        this.Place = Place;
    }

}
