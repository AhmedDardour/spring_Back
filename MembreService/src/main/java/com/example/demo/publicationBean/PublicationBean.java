package com.example.demo.publicationBean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class PublicationBean implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String type;
	private String titre;
	private String lien;
	private String Sourcepdf;
	private Date date;

	public PublicationBean() {
		super();
	}



	public PublicationBean(String type, String titre, String lien, String sourcepdf, Date date) {
		super();

		this.type = type;
		this.titre = titre;
		this.lien = lien;
		Sourcepdf = sourcepdf;
		this.date = date;
	}

	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getLien() {
		return lien;
	}

	public void setLien(String lien) {
		this.lien = lien;
	}

	public String getSourcepdf() {
		return Sourcepdf;
	}

	public void setSourcepdf(String sourcepdf) {
		Sourcepdf = sourcepdf;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}