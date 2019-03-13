package org.ub.government.sispdb.model.jpaservice;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.ub.government.sispdb.model.Desa;
import org.ub.government.sispdb.model.jpaservice.generic.GenericJpaServiceImpl;

public class DesaJpaServiceImpl extends GenericJpaServiceImpl<Desa, Serializable> implements DesaJpaService{

	@Override
	public List<Desa> findAll_By() {
		EntityManager em = getFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			String query = "";
			query = "SELECT a FROM Desa a "
					+ " ";

			List<Desa> list = em.createQuery(query)
//					.setParameter("fcompanyBeanId", fcompanyBeanId)
//					.setParameter("isActiveOnly", isActiveOnly)
					.setHint(QueryHints.REFRESH, HintValues.TRUE)
					.getResultList();
			em.getTransaction().commit();
			return list;
		} catch (PersistenceException exception) {
			em.getTransaction().rollback();
			throw exception;
		} finally {
			em.close();
		}
	}


}
