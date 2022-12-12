package com.zwp.controller;

import com.zwp.entity.Person;
import com.zwp.service.PersonIService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

//第一行可以写 @Restcontroller(返回json的controller)
//@Restcontroller = @Controller + @ResponseBody
@Controller
public class PersonController {
    @Resource
    private PersonIService personIService;

    @RequestMapping("/person")
    @ResponseBody//json返回
    public List<Person> findAll(){
        List<Person> list = personIService.findAll();
        return list;//[{}，{}]
    }

    @RequestMapping("/findPersonByid/{id}")
    @ResponseBody//返回json类型
    public Person findByid(@PathVariable("id") Integer id){
        return personIService.findByid(id);//{}
    }
}

