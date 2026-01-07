package com.iheima;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class WebTlisasManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebTlisasManagementApplication.class, args);
	}

}
