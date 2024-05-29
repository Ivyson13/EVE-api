package br.com.opendrive.Drive.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String email;
	private String sehna;
	
	public Usuario(String email, String sehna) {
		super();
		this.email = email;
		this.sehna = sehna;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSehna() {
		return sehna;
	}

	public void setSehna(String sehna) {
		this.sehna = sehna;
	}

	public long getId() {
		return id;
	}
	
	
	
}
