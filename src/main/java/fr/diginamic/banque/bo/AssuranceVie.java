package fr.diginamic.banque.bo;

import java.time.LocalDate;
import java.util.HashSet;

import javax.persistence.Entity;

/**
 * Compte de type Assurance Vie
 * 
 * @author Formation
 *
 */
@Entity
public class AssuranceVie extends Compte {
	private LocalDate dateFin;
	private double taux;

	/**
	 * Constructeur
	 */
	public AssuranceVie() {
		super();
	}

	/**
	 * Constructeur avec params
	 * 
	 * @param numero  String
	 * @param solde   double
	 * @param dateFin LocalDate
	 * @param taux    double
	 */
	public AssuranceVie(String numero, double solde, LocalDate dateFin, double taux) {
		super(numero, solde);
		this.dateFin = dateFin;
		this.taux = taux;
		this.operations = new HashSet<>();
		this.clients = new HashSet<>();
	}

	@Override
	public String toString() {
		return "AssuranceVie [dateFin=" + dateFin + ", taux=" + taux + ", id=" + getId() + ", numéro=" + getNumero()
				+ ", solde=" + getSolde() + "]";
	}

	public LocalDate getDateFin() {
		return dateFin;
	}

	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
	}

	public double getTaux() {
		return taux;
	}

	public void setTaux(double taux) {
		this.taux = taux;
	}

}
