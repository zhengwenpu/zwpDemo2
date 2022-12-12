package com.zwp.util;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.Route;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

import java.util.List;

public class Quartz2Demo {
    public static void main(String[] args) throws Exception {
        CamelContext camelContext = new DefaultCamelContext();
        camelContext.start();
        camelContext.addRoutes(new RouteBuilder() {

            @Override
            public void configure() throws Exception {
                // TODO Auto-generated method stub
                from("quartz2:quartz2Demo?cron=1 * * * * ?").process(new Processor() {
                    @Override
                    public void process(Exchange exchange) throws Exception {
                        // TODO Auto-generated method stub

                        System.out.println("Quartz2 执行....");
                    }
                });
            }
        });

        List<Route> routes = camelContext.getRoutes();
        for (Route route : routes) {
            System.out.println("id:"+route.getId() + " , Properties:" + route.getProperties());
        }

        synchronized (Quartz2Demo.class) {
            Quartz2Demo.class.wait();
        }
    }
}

