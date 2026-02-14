package com.tempshare.tempshare_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;

@SpringBootApplication
@EntityScan
public class TempshareBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(TempshareBackendApplication.class, args);
	}
}
