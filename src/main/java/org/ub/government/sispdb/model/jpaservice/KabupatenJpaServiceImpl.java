package org.ub.government.sispdb.model.jpaservice;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.ub.government.sispdb.model.Kabupaten;
import org.ub.government.sispdb.model.jpaservice.generic.GenericJpaServiceImpl;

public class KabupatenJpaServiceImpl extends GenericJpaServiceImpl<Kabupaten, Serializable> implements KabupatenJpaService{

	@Override
	public List<Kabupaten> findAll_By() {
		EntityManager em = getFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			String query = "";
			query = "SELECT a FROM Kabupaten a "
					+ " ";

			List<Kabupaten> list = em.createQuery(query)
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
