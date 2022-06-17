package com.example.conexionbd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ConexionbdApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConexionbdApplication.class, args);
	}

}
