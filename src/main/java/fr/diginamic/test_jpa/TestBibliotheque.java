package fr.diginamic.test_jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import fr.diginamic.test_jpa.bo.Client;
import fr.diginamic.test_jpa.bo.Emprunt;

public class TestBibliotheque {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
		EntityManager em = emf.createEntityManager();
		// Ouverture de transation JPA
		EntityTransaction et = em.getTransaction();
	//	et.begin();
		/*
		// 1) Réalisez une requête qui permet d’extraire un emprunt et tous ses livres associés.
		Emprunt emprunt = em.find(Emprunt.class, 1);
		System.out.println(emprunt.getLivres());
		*/
		
		// 2) Réalisez une requête qui permet d’extraire tous les emprunts d’un client donné.
		Client client = em.find(Client.class, 3);
		for (Emprunt e: client.getEmprunts()) {
			System.out.println(e);
		}

		// Commiter & fermer
	//	et.commit();
		em.close();
		emf.close();

	}

}
