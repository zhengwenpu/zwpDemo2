package com.zwp.util;

import com.zwp.entity.User;
import com.zwp.service.UserService;
import org.apache.camel.Exchange;
import org.apache.camel.LoggingLevel;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

@Configuration
public class CamelScheduler extends RouteBuilder {

    @Autowired
    private  UserService userService;

    @Override
    public void configure() throws Exception {
        from("quartz2://group1/trigger1?cron=0/9+*+*+*+*+?&stateful=true")
                .routeId("quartztimer")
                .setHeader("ROUTING_KEY", simple("'trigger1'"))
                .log(LoggingLevel.INFO, "Yeah quartz rocks, routingKey: ${header.ROUTING_KEY}").process(new Processor() {
                    @Override
                    public void process(Exchange exchange) throws Exception {
                        // TODO Auto-generated method stub
                        System.out.println("Quartz2 执行....");
                        User user = new User();
                        user.setUserName("bbb");
                        user.setId(222L);
                        user.setCreateTime(new Date());
                        userService.saveUser(user);
                    }
                });;
    }
}
