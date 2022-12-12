package com.zwp.service.impl;

import com.zwp.dao.IPersonDao;
import com.zwp.entity.Person;
import com.zwp.service.PersonIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonIService {
    @Autowired
    private IPersonDao iPersonDao;

    @Override
    public List<Person> findAll() {
        return iPersonDao.findAll();
    }
    @Override
    public Person findByid(Integer id) {
        return iPersonDao.findByid(id);
    }

}

