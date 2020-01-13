package com.example.H2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.h2.tools.Server;

import java.sql.SQLException;

@SpringBootApplication
public class H2Application {

	public static void main(String[] args) {
		SpringApplication.run(H2Application.class, args);
	}

	@Bean(initMethod = "start", destroyMethod="stop")
	public Server H2DatabaseServer() throws SQLException{
		System.out.println("H2Server");
		return Server.createTcpServer("-tcp","-tcpAllowOthers","-tcpPort","9092");
	}

}
