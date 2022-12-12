package com.zwp.connectdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.zwp.service","com.zwp.util"})//指定扫描包
@MapperScan({"com.zwp.dao"})
public class ConnectdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConnectdemoApplication.class, args);
    }

}
