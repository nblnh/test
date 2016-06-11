package org.nn.sc.empty.jet.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

public abstract class JpaDAO<E> {
	protected Class<E> entityClass;

	protected EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	public JpaDAO() {
		ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
		this.entityClass = (Class<E>) genericSuperclass.getActualTypeArguments()[0];
		entityManager = EntityManagerUtil.getEntityManager();
	}

	public synchronized void persist(E entity) {
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.persist(entity);
		tx.commit();
	}

	public synchronized void remove(E entity) {
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.remove(entityManager.merge(entity));
		tx.commit();
	}
	
	public synchronized E merge(E entity) {
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entity = entityManager.merge(entity);
		tx.commit();
		return entity;
	}
	
	public synchronized void refresh(E entity) {
		entityManager.refresh(entity);
	}

	public synchronized E findById(Long id) {
		return entityManager.find(entityClass, id);
	}
	
	public synchronized E flush(E entity) {
		entityManager.flush();
		return entity;
	}
	
	@SuppressWarnings("unchecked")
	public synchronized List<E> findAll() {
		Query q = entityManager.createQuery("SELECT h FROM " + entityClass.getSimpleName() + " h");
		return q.getResultList();
	}
	
	public Class<E> getEntityClass() {
		return entityClass;
	}

	public void setEntityClass(Class<E> entityClass) {
		this.entityClass = entityClass;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}	
}
