package fr.diginamic.test_jpa.bo;

import java.io.Serializable;
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
import javax.persistence.Table;

@Entity
@Table(name = "LIVRE")
public class Livre implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "TITRE")
	private String title;

	@Column(name = "AUTEUR")
	private String author;
	
	@ManyToMany(mappedBy="livres")
	private Set<Emprunt> emprunts;
	

	public Livre() {
		this.emprunts = new HashSet<>();
	}

	public Livre(String title, String author) {
		this.title = title;
		this.author = author;
	}

	@Override
	public String toString() {
		return "titre : " + title + ", auteur : " + author;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

}
