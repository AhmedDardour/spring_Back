package com.example.demo.Service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.publicationBean.PublicationBean;


@FeignClient(name = "publication-service" , url = "/publications")
public interface PublicationProxyService {
	@GetMapping("/{id}")
	public  PublicationBean findById(@PathVariable(name = "id") Long id) ;


}
