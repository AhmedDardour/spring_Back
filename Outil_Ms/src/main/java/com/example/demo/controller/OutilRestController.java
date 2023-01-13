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

import com.example.demo.entities.Outil;
import com.example.demo.services.IOutilService;

@CrossOrigin
@RestController
public class OutilRestController {
	@Autowired
	IOutilService outilService;
	@RequestMapping(value = "/outils", method = RequestMethod.GET)
	public List<Outil> findOutils() {
		return outilService.findAll();
	}

	@GetMapping(value = "/outil/{id}")
	public Outil findOneOutilById(@PathVariable Long id) {
		return outilService.findOutil(id);
	}

	@GetMapping(value = "/outil/Search/source")
	public List<Outil> findEventBySource(@PathVariable String e) {
		return outilService.findBySource(e);
	}

	@PostMapping(value = "/outil/newTool")
	public Outil addOutil(@RequestBody Outil m) {
		return outilService.addOutil(m);
	}

	@PutMapping(value = "/outils/outil/{id}")
	public Outil updateOutil(@PathVariable Long id, @RequestBody Outil p) {
		p.setId(id);
		return outilService.updateOutil(p);
	}

	@DeleteMapping(value = "/Outils/{id}")
	public void deleteOutil(@PathVariable Long id) {
		outilService.deleteOutil(id);
	}

}
