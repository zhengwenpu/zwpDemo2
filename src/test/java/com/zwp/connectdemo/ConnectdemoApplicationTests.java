package com.zwp.connectdemo;

import com.zwp.entity.Person;
import com.zwp.entity.User;
import com.zwp.service.PersonIService;
import com.zwp.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;


@SpringBootTest
class ConnectdemoApplicationTests {

    @Autowired
    private UserService userService;

    @Autowired
    private PersonIService personIService;

    @Test
    public void testSaveUser() throws Exception {
        User user=new User();
        user.setId(new Long(9));
        user.setUserName("小红");
        user.setCreateTime(new Date());
        userService.saveUser(user);
    }

    @Test
    public void findUserByUserName(){
        User user= userService.findUserByUserName("小明");
        System.out.println("user is "+user);
    }

    @Test
    public void updateUser(){
        User user=new User();
        user.setId(new Long(9));
        user.setUserName("天空");
        user.setCreateTime(new Date());
        userService.updateUser(user);
    }

    @Test
    public void deleteUserById(){
        userService.deleteUserById(9);
    }

    @Test
    public void queryList(){
        List<User> userList = userService.queryList();
        for(User user:userList){
            System.out.println(user.getUserName());
        }
    }


    @Test
    public void findPersonById(){
        Person person= personIService.findByid(1);
        System.out.println("person is "+person);


    }
}
