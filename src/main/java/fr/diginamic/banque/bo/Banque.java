package fr.diginamic.banque.bo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Banque")
public class Banque implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column
	private String nom;

	@OneToMany(mappedBy = "banque", cascade = CascadeType.PERSIST)
	private Set<Client> clients;

	/**
	 * Constructeur
	 */
	public Banque() {
		this.clients = new HashSet<>();
	}

	/**
	 * Constucteur avec params
	 * 
	 * @param nom String
	 */
	public Banque(String nom) {
		this.nom = nom;
		this.clients = new HashSet<>();
	}

	@Override
	public String toString() {
		return "Banque [id=" + id + ", nom=" + nom + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Set<Client> getClients() {
		return clients;
	}

	public void setClients(Set<Client> clients) {
		this.clients = clients;
	}

}
