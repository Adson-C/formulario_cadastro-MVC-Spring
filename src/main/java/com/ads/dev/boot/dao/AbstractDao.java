package com.ads.dev.boot.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;
                                                               // PK tipo chave primaria que vai ter(Long,Integer...)
public abstract class AbstractDao<T, PK extends Serializable> { // T representa a entidade(cargo,fun,depart..)
	
	@SuppressWarnings("unchecked")
	private final Class<T> entityClass =  // serve para pegar as entidade como assinatura
			(Class<T>) ( (java.lang.reflect.ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];

	@PersistenceContext
	private EntityManager entityManager; // Objeto EntityManager JPA
	
	protected EntityManager getEntityManager() { // metodo getEntityM
		return entityManager;
	}
	
	public void save(T entity) {
		entityManager.persist(entity);
	}

	public void update(T entity) {
		entityManager.merge(entity);
	}
	
	public void delete(PK id) {
		entityManager.remove(entityManager.getReference(entityClass, id));
	}
	
	public T findById(PK id) {
		return entityManager.find(entityClass, id);
	}
	
	public List<T> findAll() {
		return entityManager
				.createQuery("from " + entityClass.getSimpleName(), entityClass)
				.getResultList();
	}
	
	protected List<T> createQuery(String jpql, Object... params) { // para raelizar as consultas 
		TypedQuery<T> query  = entityManager.createQuery(jpql, entityClass);
		for (int i = 0; i < params.length; i++) {
			query.setParameter(i+1, params[i]);
		}
		
		return query.getResultList();
	}
}
