package br.com.opendrive.Drive.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Pasta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private	String nome;
	private int criador;
	
	private int pai;
	private int[] listaPastas; 
	private int[] listaArquivos;
	
	
	public Pasta() {}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getId() {
		return id;
	}

	public int getCriador() {
		return criador;
	}

	public int[] getListaPastas() {
		return listaPastas;
	}
	
	public void addListaPastas(int id) {
		
		if(listaPastas == null) {
			this.listaPastas = new int[0];
		}
		
		int i;
		
		int newArray[] = new int[this.listaPastas.length + 1];
		for (i = 0; i < this.listaPastas.length; i++)
	           newArray[i] = this.listaPastas[i];
		newArray[this.listaPastas.length] = id;
		
		this.listaArquivos = newArray ;
	}

	public int[] getListaArquivos() {
		return listaArquivos;
	}

	public int getPai() {
		return pai;
	}

	public void setCriador(int criador) {
		this.criador = criador;
	}
	
	
	
}
