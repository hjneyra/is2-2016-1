package ucsp.is2.repository;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import ucsp.is2.model.Usuario;
@Repository
public class UsuarioRepository {
	@PersistenceContext
	public EntityManager entityManager;

	public List<Usuario> findAll() {
		TypedQuery<Usuario> query = entityManager.createQuery("SELECT c FROM public.usuario c", 							Usuario.class);
		List<Usuario> results = query.getResultList();
		System.out.println(results.size());
		return results;
	}
}
