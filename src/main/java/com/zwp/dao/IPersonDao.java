package com.zwp.dao;

import com.zwp.entity.Person;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IPersonDao {

    public List<Person> findAll();
   // @Select("SELECT * FROM PERSON WHERE ID = #{id}")
    public Person findByid(@Param("id") Integer id);;;

}
