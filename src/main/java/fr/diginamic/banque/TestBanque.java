package fr.diginamic.banque;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashSet;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import fr.diginamic.banque.bo.Adresse;
import fr.diginamic.banque.bo.AssuranceVie;
import fr.diginamic.banque.bo.Banque;
import fr.diginamic.banque.bo.Client;
import fr.diginamic.banque.bo.Compte;
import fr.diginamic.banque.bo.LivretA;
import fr.diginamic.banque.bo.Operation;
import fr.diginamic.banque.bo.Virement;

/**
 * Classe d'éxucution pour tester les entités et la persistence des données
 * 
 * @author Formation
 *
 */
public class TestBanque {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("banque");
		EntityManager em = emf.createEntityManager();
		/* Ouverture de transation JPA */
		EntityTransaction et = em.getTransaction();
		et.begin();

		// 1) insérer en bdd un compte associé à 2 clients
		Banque digiBanque = new Banque("La Digi Banque");
		em.persist(digiBanque);
		Client james = new Client("Gosling", "James", LocalDate.of(1955, 5, 19), null, digiBanque);
		james.setAdresse(new Adresse(6455, "Macleod Trail", 20811, "Calgary"));
		Client tim = new Client("Berners-Lee", "Tim", LocalDate.of(1955, 6, 8), null, digiBanque);
		tim.setAdresse(new Adresse(221, "Baker Street", 10643, "London"));
		em.persist(james);
		em.persist(tim);

		Compte compteJoint = new LivretA("CJ12345", 400000, 0.5);
		em.persist(compteJoint);
		james.setComptes(new HashSet<>(Arrays.asList(compteJoint)));
		tim.setComptes(new HashSet<>(Arrays.asList(compteJoint)));
		compteJoint.setClients(new HashSet<>(Arrays.asList(james, tim)));

		// 2) insérer un client avec plusieurs comptes :
		// 1 compte de type assurance vie
		// 1 compte de type livret A
		Client mark = new Client("Zuckerberg", "Mark", LocalDate.of(1984, 5, 14), null, digiBanque);
		mark.setAdresse(new Adresse(1, "Hacker Way", 94025, "Menlo Park"));

		Compte assuranceVie = new AssuranceVie("AV98765", 500000, LocalDate.of(2029, 9, 10), 1.5);
		Compte livretA = new LivretA("LA54321", 250000, 0.6);
		em.persist(assuranceVie);
		em.persist(livretA);

		mark.setComptes(new HashSet<>(Arrays.asList(assuranceVie, livretA)));
		em.persist(mark);

		// 3) insérer des opérations de type virements sur un compte
		Virement virement = new Virement(LocalDateTime.of(2021, 9, 20, 14, 30), 10000, "Cadeau", livretA,
				"Eduardo Saverin");
		Operation operation = new Operation(LocalDateTime.of(2021, 10, 5, 18, 05), 5000, null, livretA);
		em.persist(virement);
		em.persist(operation);
		livretA.setOperations(new HashSet<>(Arrays.asList(virement, operation)));
		;

		System.out.println(livretA);

		// Commiter & fermer
		et.commit();
		em.close();
		emf.close();
	}

}
