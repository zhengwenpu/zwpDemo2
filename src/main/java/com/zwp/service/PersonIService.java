package com.zwp.service;

import com.zwp.entity.Person;

import java.util.List;

public interface PersonIService {

    public List<Person> findAll();

    public Person
    findByid(Integer id);
}