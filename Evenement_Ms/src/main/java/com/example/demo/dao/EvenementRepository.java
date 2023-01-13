package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Evenement;

@Repository
public interface EvenementRepository extends JpaRepository<Evenement, Long> {
	List<Evenement> findByTitre(String titre);
	List<Evenement> findByLieu(String lieu);

	List<Evenement> findByLieuStartingWith(String caractere);

}
