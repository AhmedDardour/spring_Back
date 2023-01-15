package com.example.demo.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.Lob;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.example.demo.publicationBean.PublicationBean;
@Entity
@Inheritance(strategy= javax.persistence.InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name= "type_mbr", discriminatorType = DiscriminatorType.STRING,length = 3)
public abstract class Membre implements Serializable{
	private static final long serialVersionUID =1L;
	@Id @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String cin , nom , prenom , cv , email , password ;
    @Temporal (TemporalType.DATE)
    private Date date;
    @Lob 
    private byte [] photo;
    

    @Transient
    private String type;
    
    
    
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	@Transient
	Collection<PublicationBean> pubs;
	public Long getId() {
		return id;
	}
	public Collection<PublicationBean> getPubs() {
		return pubs;
	}
	public void setPubs(Collection<PublicationBean> pubs) {
		this.pubs = pubs;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public String getCin() {
		return cin;
	}
	public void setCin(String cin) {
		this.cin = cin;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getCv() {
		return cv;
	}
	public void setCv(String cv) {
		this.cv = cv;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getDate() {
		return date;
	}
	public Membre( String cin, String nom, String prenom, String cv, String email, String password, Date date,
			byte[] photo) {
		super();
		
		this.cin = cin;
		this.nom = nom;
		this.prenom = prenom;
		this.cv = cv;
		this.email = email;
		this.password = password;
		this.date = date;
		this.photo = photo;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public byte[] getPhoto() {
		return photo;
	}
	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
   public Membre() {
	   super();
   }
}