package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Membre;

import java.util.List;
@Repository

public interface MemberRepository extends JpaRepository<Membre,Long>
{

    Membre findByCin(String cin);
    List<Membre>findByNomStartingWith(String caractere);
    Membre findByEmail(String email);

}
