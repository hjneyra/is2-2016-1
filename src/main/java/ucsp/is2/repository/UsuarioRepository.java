package ucsp.is2.repository;

import java.lang.reflect.ParameterizedType;
import java.util.Collection;
import java.util.Collections;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import ucsp.is2.model.Usuario;

public class UsuarioRepository {
	@PersistenceContext
	transient EntityManager entityManager;

	protected Class<Usuario> entityClass = getEntityClass();
	
	@SuppressWarnings("unchecked")
	public Class<Usuario> getEntityClass() {
		if (entityClass == null) {
			ParameterizedType thisType = (ParameterizedType) getClass().getGenericSuperclass();
			entityClass = (Class<Usuario>) thisType.getActualTypeArguments()[0];
		}
		return entityClass;
	}
	public Collection<Usuario> findAll() {
		return entityManager.createQuery("SELECT o FROM " + entityClass.getSimpleName() + "o", entityClass).getResultList();
	}
}
