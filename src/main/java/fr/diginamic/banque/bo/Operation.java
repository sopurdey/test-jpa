package fr.diginamic.banque.bo;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Opération (qui peut avoir un type de Virement
 * 
 * @author Formation
 *
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type")
@Table(name = "Operation")
public class Operation implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Integer id;

	protected LocalDateTime date;

	protected double montant;

	protected String motif;

	@ManyToOne
	@JoinColumn(name = "compte_id")
	protected Compte compte;

	/**
	 * Constructeur
	 */
	public Operation() {

	}

	/**
	 * Constructeur avec params
	 * 
	 * @param date    LocalDateTime
	 * @param montant double
	 * @param motif   String
	 * @param compte  Compte
	 */
	public Operation(LocalDateTime date, double montant, String motif, Compte compte) {
		this.date = date;
		this.montant = montant;
		this.motif = motif;
		this.compte = compte;
	}

	@Override
	public String toString() {
		return "Operation [id=" + id + ", date=" + date + ", montant=" + montant + ", motif=" + motif + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public String getMotif() {
		return motif;
	}

	public void setMotif(String motif) {
		this.motif = motif;
	}

	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}

}
