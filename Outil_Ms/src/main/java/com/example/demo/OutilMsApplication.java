package com.example.demo;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.example.demo.entities.Outil;


@SpringBootApplication
@EnableDiscoveryClient
public class OutilMsApplication implements CommandLineRunner {
	@Autowired
    RepositoryRestConfiguration repositoryRestConfig;
	

	public static void main(String[] args) {
		SpringApplication.run(OutilMsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		repositoryRestConfig.exposeIdsFor(Outil.class);
		
	
		
	}

}
