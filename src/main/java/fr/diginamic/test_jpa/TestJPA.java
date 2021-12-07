package fr.diginamic.test_jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import fr.diginamic.test_jpa.bo.Livre;

public class TestJPA {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
		EntityManager em = emf.createEntityManager();
		// Ouverture de transation JPA
		EntityTransaction et = em.getTransaction();
		et.begin();

		// 1) Réalisez un find simple permettant d’extraire un livre en fonction de son
		// identifiant et affichez son titre et son auteur.
		Livre livre = em.find(Livre.class, 3);

		System.out.println("1er livre : " + livre);

		// 2) Insérez un nouveau Livre de votre choix en base de données
		Livre livreACreer = new Livre();
		livreACreer.setTitle("Les Misérables");
		livreACreer.setAuthor("Victor Hugo");
		em.persist(livreACreer);
		System.out.println("Livre à créer : " + livreACreer);

		// 3) Modifiez le titre du livre d’identifiant 5 : le nouveau titre doit être
		// « Du plaisir dans la cuisine » au lieu de « 1001 recettes de Cuisine ».
		Livre livreAModif = em.find(Livre.class, 5);
		System.out.println("Livre à modifier : " + livreAModif);
		if (livreAModif != null) {
			livreAModif.setTitle("Du plaisir dans la cuisine");
			em.merge(livreAModif);
		}
		System.out.println("Livre modifié : " + livreAModif);

		// 4) Faites une requête JPQL pour extraire de la base un livre en fonction de
		// son titre.
		TypedQuery<Livre> query1 = em.createQuery("SELECT l from Livre l where l.title='Germinal'", Livre.class);
		Livre livreQ1 = query1.getResultList().get(0);
		System.out.println("Livre JPQL1 : " + livreQ1);

		// 5) Faites une requête JPQL pour extraire de la base un livre en fonction de
		// son auteur.
		TypedQuery<Livre> query2 = em.createQuery("SELECT l from Livre l where l.author='Gaston Pouet'", Livre.class);
		List<Livre> pouet = query2.getResultList();
		System.out.println("Livre JPQL2 : " + pouet);

		// 6) Supprimez un livre de votre choix en base de données.
		Livre livreASupp = em.find(Livre.class, 1);
		System.out.println("Livre à supprimer : " + livreASupp);
		if (livreASupp != null) {
			em.remove(livreASupp);
		}

		// 7) Affichez la liste de tous les livres présents en base de données (titre et
		// auteur).
		List<Livre> livres = em.createQuery("From Livre", Livre.class).getResultList();
		for (Livre liv : livres) {
			System.out.println(liv);
		}

		// Commiter & fermer
		et.commit();
		em.close();
		emf.close();

	}

}
