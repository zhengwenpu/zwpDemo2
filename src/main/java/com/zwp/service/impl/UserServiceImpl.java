package com.zwp.service.impl;

import com.mongodb.client.result.UpdateResult;
import com.zwp.entity.User;
import com.zwp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 创建对象
     * @param user
     */
    @Override
    public void saveUser(User user) {
        mongoTemplate.save(user);
    }

    /**
     * 根据用户名查询对象
     * @param userName
     * @return
     */
    @Override
    public User findUserByUserName(String userName) {
        Query query = new Query(Criteria.where("userName").is(userName));
        User user = mongoTemplate.findOne(query,User.class);
        return user;
    }



    /**
     * 更新对象
     * @param user
     */
    @Override
    public long updateUser(User user) {
        Query query = new Query(Criteria.where("id").is(user.getId()));
        Update update = new Update().set("userName",user.getUserName()).set("createTime",user.getCreateTime());
        //更新查询返回结果集的第一条
        UpdateResult result =mongoTemplate.updateFirst(query,update,User.class);
        if(result!=null)
            return result.getMatchedCount();
        else
            return 0;

    }

    /**
     * 删除对象
     * @param id
     */
    @Override
    public void deleteUserById(Integer id) {
        Query query=new Query(Criteria.where("id").is(id));
        mongoTemplate.remove(query,User.class);
    }

    /**
     * 查询所有的用户信息
     * @return
     */
    @Override
    public List<User> queryList() {
        Query query=new Query();
        List<User> userList = mongoTemplate.findAll(User.class);
        return userList;
    }
}
