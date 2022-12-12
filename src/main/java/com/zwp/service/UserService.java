package com.zwp.service;

import com.zwp.entity.User;
import java.util.List;

public interface UserService {

    public void saveUser(User user);

    public User findUserByUserName(String userName);

    public long updateUser(User user);

    public void deleteUserById(Integer id);

    public List<User> queryList();
}
