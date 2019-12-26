package com.akshay.msdemo.h2dbserver;

import org.h2.tools.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.SQLException;

@SpringBootApplication
public class H2DbServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(H2DbServerApplication.class, args);
    }

    @Bean(initMethod = "start", destroyMethod = "stop")
    public Server h2Server() throws SQLException {
        System.out.println("-----------Entered inside the h2server----------------");
        return Server.createTcpServer("-tcp", "-tcpAllowOthers", "-tcpPort", "9500");
    }

}
