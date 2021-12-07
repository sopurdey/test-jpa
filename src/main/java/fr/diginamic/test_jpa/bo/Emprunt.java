package fr.diginamic.test_jpa.bo;

import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "EMPRUNT")
public class Emprunt implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "DATE_DEBUT")
	private Date startDate;

	@Column(name = "DATE_FIN")
	private Date endDate;

	@Column(name = "DELAI")
	private Integer timeLimit;

	@ManyToOne
	@JoinColumn(name = "ID_CLIENT")
	private Client client;

	@ManyToMany
	@JoinTable(name = "COMPO", joinColumns = @JoinColumn(name = "ID_EMP", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "ID_LIV", referencedColumnName = "ID"))
	private Set<Livre> livres;

	public Emprunt() {
		this.livres = new HashSet<>();
	}

	public Emprunt(Date startDate, Date endDate, Integer timeLimit, Client client) {
		this.startDate = startDate;
		this.endDate = endDate;
		this.timeLimit = timeLimit;
		this.client = client;
		this.livres = new HashSet<>();
	}

	@Override
	public String toString() {
		return "Emprunt [id=" + id + ", startDate=" + startDate + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Integer getTimeLimit() {
		return timeLimit;
	}

	public void setTimeLimit(Integer timeLimit) {
		this.timeLimit = timeLimit;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Set<Livre> getLivres() {
		return livres;
	}

	public void setLivres(Set<Livre> livres) {
		this.livres = livres;
	}

}
