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

import com.example.demo.entities.Evenement;

import com.example.demo.services.IEvenementService;

@CrossOrigin
@RestController
public class EventRestController {
	@Autowired
	IEvenementService eventService;

	@RequestMapping(value = "/events", method = RequestMethod.GET)
	public List<Evenement> findEvents() {
		return eventService.findAll();
	}

	@GetMapping(value = "/event/{id}")
	public Evenement findOneEventById(@PathVariable Long id) {
		return eventService.findEvenement(id);
	}

	@GetMapping(value = "/events/Search/titre")
	public List<Evenement> findEventByTitre(@PathVariable String e) {
		return eventService.findByTitre(e);
	}

	@PostMapping(value = "/events/evenement")
	public Evenement addEvenement(@RequestBody Evenement m) {
		return eventService.addEvenement(m);
	}

	@PutMapping(value = "/events/evenement/{id}")
	public Evenement updateEvenement(@PathVariable Long id, @RequestBody Evenement p) {
		p.setId(id);
		return eventService.updateEvenement(p);
	}

	@DeleteMapping(value = "/events/{id}")
	public void deleteEvenement(@PathVariable Long id) {
		eventService.deleteEvenement(id);
	}

}
