package fr.diginamic.test_jpa.bo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "CLIENT")
public class Client implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "NOM")
	private String lastName;

	@Column(name = "PRENOM")
	private String firstName;

	@OneToMany(mappedBy = "client")
	private Set<Emprunt> emprunts;

	public Client() {
		this.emprunts = new HashSet<>();
	}

	public Client(String lastName, String firstName, Set<Emprunt> emprunts) {
		this.lastName = lastName;
		this.firstName = firstName;
		this.emprunts = new HashSet<>();

	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", lastName=" + lastName + ", firstName=" + firstName + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Set<Emprunt> getEmprunts() {
		return emprunts;
	}

	public void setEmprunts(Set<Emprunt> emprunts) {
		this.emprunts = emprunts;
	}

}
