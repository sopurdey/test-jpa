package fr.diginamic.banque.bo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Compte abstrait : Livret A ou Assurance Vie
 * 
 * @author Formation
 *
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "Compte")
public abstract class Compte implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Integer id;

	protected String numero;

	protected double solde;

	@OneToMany(mappedBy = "compte", cascade = CascadeType.PERSIST)
	protected Set<Operation> operations;

	@ManyToMany(mappedBy = "comptes", cascade = CascadeType.PERSIST)
	protected Set<Client> clients;

	/**
	 * Constructeur
	 */
	public Compte() {
		this.operations = new HashSet<>();
		this.clients = new HashSet<>();
	}

	/**
	 * Constructeur avec params
	 * 
	 * @param numero String
	 * @param solde  double
	 */
	public Compte(String numero, double solde) {
		this.numero = numero;
		this.solde = solde;
		this.operations = new HashSet<>();
		this.clients = new HashSet<>();
	}

	@Override
	public String toString() {
		return "Compte [id=" + id + ", numero=" + numero + ", solde=" + solde + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}

	public Set<Operation> getOperations() {
		return operations;
	}

	public void setOperations(Set<Operation> operations) {
		this.operations = operations;
	}

	public Set<Client> getClients() {
		return clients;
	}

	public void setClients(Set<Client> clients) {
		this.clients = clients;
	}

}
