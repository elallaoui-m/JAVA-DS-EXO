package com.ds1.annuaireTel;

import java.io.Serializable;

public class Annuaire implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String login;
	private String password;
	private String nom;
	private String prenom;
	private String tel;
	private int numero;

	public int getId() {
		return id;
	}

	public Annuaire() {
	}

	public Annuaire(String login, String password) {
		super();
		this.login = login;
		this.password = password;
	}

	public Annuaire(String nom, String prenom, String tel) {
		this.nom = nom;
		this.prenom = prenom;
		this.tel = tel;
	}
	public Annuaire(String login, String password, String nom, String prenom, String tel, int numero) {
		super();
		this.login = login;
		this.password = password;
		this.nom = nom;
		this.prenom = prenom;
		this.tel = tel;
		this.numero = numero;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	@Override
	public String toString() {
		return "Annuaire [id=" + id + ", login=" + login + ", password=" + password + ", nom=" + nom + ", prenom="
				+ prenom + ", tel=" + tel + ", numero=" + numero + "]";
	}

}
