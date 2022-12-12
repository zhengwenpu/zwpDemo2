package com.zwp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;

@Document("person")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person  implements Serializable {

    @Id
    private Long id;
    private String userName;
    private Date createTime;
    private String addr;
}
