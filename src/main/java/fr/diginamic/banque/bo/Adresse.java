package fr.diginamic.banque.bo;

import javax.persistence.Embeddable;

/**
 * Adresse intégrée dans Client (embedded)
 * 
 * @author Formation
 *
 */
@Embeddable
public class Adresse {
	private int numero;
	private String rue;
	private int codePostal;
	private String ville;

	/**
	 * Constructeur
	 */
	public Adresse() {

	}

	/**
	 * Constructeur avec params
	 * 
	 * @param numero     int
	 * @param rue        String
	 * @param codePostal int
	 * @param ville      String
	 */
	public Adresse(int numero, String rue, int codePostal, String ville) {
		this.numero = numero;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
	}

	@Override
	public String toString() {
		return "Adresse : " + numero + " " + rue + " " + codePostal + " " + ville;
	}

}
