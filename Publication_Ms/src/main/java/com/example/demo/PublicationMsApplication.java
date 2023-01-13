package com.example.demo;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.example.demo.dao.PublicationRepository;
import com.example.demo.entities.Publication;

@SpringBootApplication
@EnableDiscoveryClient
public class PublicationMsApplication implements CommandLineRunner {
	@Autowired
	PublicationRepository publicationRepository;
	@Autowired
    RepositoryRestConfiguration repositoryRestConfig;

	public static void main(String[] args) {
		SpringApplication.run(PublicationMsApplication.class, args);
	}
	
    @Override
	public void run(String... args) throws Exception {
		repositoryRestConfig.exposeIdsFor(Publication.class);
		Publication pub1 = new Publication("service oriented architecture", "aaa", "book","bbb",new Date(20,02,2021));
		publicationRepository.save(pub1);
		@SuppressWarnings("deprecation")
		Publication pub2= new Publication("bitcoin", "book","white paper","book2",new Date(19,11,2021));
		publicationRepository.save(pub2);
	

	}

}
