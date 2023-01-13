package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entities.Membre_Pub_Ids;
import com.example.demo.entities.Publication_Membre;

public interface MembrePubRepository extends
JpaRepository<Publication_Membre, Membre_Pub_Ids> {
@Query("select m from Publication_Membre m where auteur_id=:x")
List<Publication_Membre> findpubId(@Param ("x") Long autId);
}
