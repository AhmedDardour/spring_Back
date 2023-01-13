package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.OutilRepository;

import com.example.demo.entities.Outil;

@Service
public class OutilImp implements IOutilService {
	@Autowired
	OutilRepository outilRepo;

	@Override
	public Outil addOutil(Outil e) {

		outilRepo.save(e);
		return e;
	}

	@Override
	public void deleteOutil(Long id) {
		if(outilRepo.findById(id).isPresent())
			outilRepo.deleteById(id);

	}

	@Override
	public Outil updateOutil(Outil p) {

		return outilRepo.saveAndFlush(p);
	}

	@Override
	public Outil findOutil(Long id) {

		Outil m = (Outil) outilRepo.findById(id).get();
		return m;
	}

	@Override
	public List<Outil> findAll() {

		return outilRepo.findAll();
	}

	@Override
	public List<Outil> findBySource(String source) {

		return outilRepo.findBySource(source);
	}

}
