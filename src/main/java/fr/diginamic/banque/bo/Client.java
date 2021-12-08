package fr.diginamic.banque.bo;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Entité de Client
 * 
 * @author Formation
 *
 */
@Entity
@Table(name = "Client")
public class Client {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String nom;

	private String prenom;

	private LocalDate dateNaissance;

	@Embedded
	private Adresse adresse;

	@ManyToOne
	@JoinColumn(name = "banque_id")
	private Banque banque;

	@ManyToMany
	@JoinTable(name = "client_compte", joinColumns = @JoinColumn(name = "id_client", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "id_compte", referencedColumnName = "id"))
	private Set<Compte> comptes;

	/*
	 * Constructeur
	 */
	public Client() {
		this.comptes = new HashSet<>();
	}

	/**
	 * Constructeur avec params
	 * 
	 * @param nom           String
	 * @param prenom        String
	 * @param dateNaissance LocalDate
	 * @param adresse       Embedded
	 * @param banque        Banque
	 */
	public Client(String nom, String prenom, LocalDate dateNaissance, Adresse adresse, Banque banque) {
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.adresse = adresse;
		this.banque = banque;
		this.comptes = new HashSet<>();
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", dateNaissance=" + dateNaissance
				+ ", adresse=" + adresse + "]";
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

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public LocalDate getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public Banque getBanque() {
		return banque;
	}

	public void setBanque(Banque banque) {
		this.banque = banque;
	}

	public Set<Compte> getComptes() {
		return comptes;
	}

	public void setComptes(Set<Compte> comptes) {
		this.comptes = comptes;
	}

}
