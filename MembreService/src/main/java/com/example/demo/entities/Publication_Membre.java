package com.example.demo.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Entity

public class Publication_Membre {
public Membre_Pub_Ids getId() {
		return id;
	}
	public void setId(Membre_Pub_Ids id) {
		this.id = id;
	}
	public Membre getAuteur() {
		return auteur;
	}
	public void setAuteur(Membre auteur) {
		this.auteur = auteur;
	}
@EmbeddedId
private Membre_Pub_Ids id;
@ManyToOne @MapsId("auteur_id")
private Membre auteur;
}
