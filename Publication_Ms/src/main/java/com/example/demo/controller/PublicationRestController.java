package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Publication;
import com.example.demo.service.IPublicationService;

@CrossOrigin
@RestController
public class PublicationRestController {
	@Autowired
	IPublicationService PublicationService;

	@RequestMapping(value = "/Publications", method = RequestMethod.GET)
	public List<Publication> findPublications() {
		return PublicationService.findAll();
	}

	@GetMapping(value = "/publication/{id}")
	public Publication findOnePubById(@PathVariable Long id) {
		return PublicationService.findPublication(id);
	}

	@GetMapping(value = "/publication/Search/titre")
	public Publication findPublicationByTitre(@PathVariable String e) {
		return PublicationService.findBytitre(e);
	}

	@PostMapping(value = "/publication/newpub")
	public Publication addPublication(@RequestBody Publication m) {
		return PublicationService.addPublication(m);
	}

	@PutMapping(value = "/publications/publication/{id}")
	public Publication updatePublication(@PathVariable Long id, @RequestBody Publication p) {
		p.setId(id);
		return PublicationService.updatePublication(p);
	}

	@DeleteMapping(value = "/publications/{id}")
	public void deletePublication(@PathVariable Long id) {
		PublicationService.deletePublication(id);
	}

}
