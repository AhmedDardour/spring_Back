package com.example.demo.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity @DiscriminatorValue("ens")
public class EnseignantChercheur extends Membre implements Serializable {
	public EnseignantChercheur( String cin, String nom, String prenom, String cv, String email, String password,
			Date date, byte[] photo) {
		super( cin, nom, prenom, cv, email, password, date, photo);
		// TODO Auto-generated constructor stub
	}
	private static final long serialVersionUID= 1L;
	private String grade;
	private String etablissement;
 
	public String getGrade() {
		return grade;
	}
	
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getEtablissement() {
		return etablissement;
	}
	public void setEtablissement(String etablissement) {
		this.etablissement = etablissement;
	}
	public Collection<Etudiant> getEtudiant() {
		return etudiant;
	}
	public void setEtudiant(Collection<Etudiant> etudiant) {
		this.etudiant = etudiant;
	}
	public EnseignantChercheur() {
		super();
	}
	@OneToMany(mappedBy="encadrant")
    private Collection<Etudiant> etudiant;
}
