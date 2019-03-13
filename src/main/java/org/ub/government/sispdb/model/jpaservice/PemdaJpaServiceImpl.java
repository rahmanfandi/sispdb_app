package org.ub.government.sispdb.model.jpaservice;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.ub.government.sispdb.model.Pemda;
import org.ub.government.sispdb.model.jpaservice.generic.GenericJpaServiceImpl;

public class PemdaJpaServiceImpl extends GenericJpaServiceImpl<Pemda, Serializable> implements PemdaJpaService{

	@Override
	public List<Pemda> findAll_By() {
		EntityManager em = getFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			String query = "";
			query = "SELECT a FROM Pemda a "
					+ " ";

			List<Pemda> list = em.createQuery(query)
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
