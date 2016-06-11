package org.nn.sc.empty.jet.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;

public class EntityManagerUtil {

	@PersistenceUnit
	private static EntityManagerFactory emf;

	public static final ThreadLocal<EntityManager> entitymanager = new ThreadLocal<EntityManager>();

	public static void initEntityManagerFactory(String persistenceUnitName) {
		if (emf == null) {
			emf = Persistence.createEntityManagerFactory(persistenceUnitName);
		}
	}

	public static EntityManager getEntityManager() {
		EntityManager em = entitymanager.get();

		if (emf == null) {
			initEntityManagerFactory("privateEmptyJet");
		}

		// Create a new EntityManager
		if (em == null) {
			em = emf.createEntityManager();
			entitymanager.set(em);
		}
		return em;
	}

	public static void closeEntityManager() {
		EntityManager em = entitymanager.get();
		entitymanager.set(null);
		if (em != null)
			em.close();
	}
}