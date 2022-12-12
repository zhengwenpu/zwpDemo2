package com.zwp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;


@Document("user")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User{
    @Id
    private Long id;
    private String userName;
    private Date createTime;
}
