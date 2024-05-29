package br.com.opendrive.Drive.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Arquivo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private	String nome;
	private long criador;
	
	private String extensao;
	private byte[] base64;
	
	public Arquivo(String nome, long criador, String extensao, byte[] base64) {
		super();
		this.nome = nome;
		this.criador = criador;
		this.extensao = extensao;
		this.base64 = base64;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public long getCriador() {
		return criador;
	}

	public void setCriador(long criador) {
		this.criador = criador;
	}

	public String getExtensao() {
		return extensao;
	}

	public void setExtensao(String extensao) {
		this.extensao = extensao;
	}

	public byte[] getBase64() {
		return base64;
	}

	public void setBase64(byte[] base64) {
		this.base64 = base64;
	}

	public long getId() {
		return id;
	}
	
	
	

	
}
