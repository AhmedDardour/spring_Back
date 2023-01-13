package com.example.demo.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

@Entity
@DiscriminatorValue("etd")
public class Etudiant extends Membre implements Serializable {

    public Etudiant() {
    	super();
    }
	
    

	public Etudiant(String cin, String nom, String prenom, String cv, String email, String password, Date date,
			byte[] photo) {
		super(cin, nom, prenom, cv, email, password, date, photo);
	}


	private static final long serialVersionUID =1L;

    private Date dateInscription ;
    private String diplome ;
    private String sujet ;
	public Date getDateInscription() {
		return dateInscription;
	}

	public void setDateInscription(Date dateInscription) {
		this.dateInscription = dateInscription;
	}

	public String getDiplome() {
		return diplome;
	}

	public void setDiplome(String diplome) {
		this.diplome = diplome;
	}

	public String getSujet() {
		return sujet;
	}

	public void setSujet(String sujet) {
		this.sujet = sujet;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	@ManyToOne
	private EnseignantChercheur encadrant; //kol etudiant 3ando un seul encadrant

	public EnseignantChercheur getEncadrant() {
		return encadrant;
	}

	public void setEncadrant(EnseignantChercheur encadrant) {
		this.encadrant = encadrant;
	}
}