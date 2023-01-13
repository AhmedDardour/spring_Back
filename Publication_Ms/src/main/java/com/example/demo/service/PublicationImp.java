package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.PublicationRepository;
import com.example.demo.entities.Publication;
@Service
public class PublicationImp implements IPublicationService {
	
	@Autowired
	PublicationRepository publicationRepository;

	@Override
	public Publication addPublication(Publication p) {
		publicationRepository.save(p);
		return p;
	
	}

	@Override
	public void deletePublication(Long id) {
		if(publicationRepository.findById(id).isPresent())
			publicationRepository.deleteById(id);	
	}
		
	

	@Override
	public Publication updatePublication(Publication p) {
		return publicationRepository.saveAndFlush(p);
	}

	@Override
	public Publication findPublication(Long id) {
		Publication p = (Publication)publicationRepository .findById(id).get();
		return p;
	}

	@Override
	public List<Publication> findAll() {
		return publicationRepository.findAll();
	}

	@Override
	public Publication findBytitre(String titre) {
		
		return publicationRepository.findByTitre(titre);
	}

	@Override
	public Publication findBytype(String type) {
		
		return publicationRepository.findByType(type);
	}

}
