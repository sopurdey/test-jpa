package fr.diginamic.banque.bo;

import java.util.HashSet;

import javax.persistence.Entity;

/**
 * Compte de type Livret A
 * 
 * @author Formation
 *
 */
@Entity
public class LivretA extends Compte {
	private double taux;

	/**
	 * Constructeur
	 */
	public LivretA() {
		super();
	}

	/**
	 * Constructeur avec params
	 * 
	 * @param numero String
	 * @param solde  double
	 * @param taux   double
	 */
	public LivretA(String numero, double solde, double taux) {
		super(numero, solde);
		this.taux = taux;
		this.operations = new HashSet<>();
		this.clients = new HashSet<>();
	}

	@Override
	public String toString() {
		return "LivretA [taux=" + taux + ", id=" + getId() + ", numéro=" + getNumero() + ", solde=" + getSolde() + "]";
	}

	public double getTaux() {
		return taux;
	}

	public void setTaux(double taux) {
		this.taux = taux;
	}

}
