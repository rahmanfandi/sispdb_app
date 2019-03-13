package org.ub.government.sispdb.model.jpaservice;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.ub.government.sispdb.model.PemProv;
import org.ub.government.sispdb.model.Pemda;
import org.ub.government.sispdb.model.SatuanKerja;
import org.ub.government.sispdb.model.UserLog;
import org.ub.government.sispdb.model.UnitKerja;
import org.ub.government.sispdb.model.UserLog;
import org.ub.government.sispdb.model.jpaservice.generic.GenericJpaServiceImpl;

public class UserLogJpaServiceImpl extends GenericJpaServiceImpl<UserLog, Serializable> implements UserLogJpaService{

	@Override
	public List<UserLog> findAll_By() {
		EntityManager em = getFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			String query = "";
			query = "SELECT a FROM UserLog a "
					+ " ";

			List<UserLog> list = em.createQuery(query)
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

	@Override
	public List<UserLog> findAllByPemProvOnly(PemProv pemProvBean ) {
		EntityManager em = getFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			String query = "";
			query = "SELECT a FROM UserLog a WHERE a.unitKerjaBean.satuanKerjaBean.pemdaBean.pemProvBean.ID = :pemProvBeanID "
					+	" "
					+ 	" ";

			List<UserLog> list = em.createQuery(query)
					.setParameter("pemProvBeanID", pemProvBean.getID())
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

	@Override
	public List<UserLog> findAllByPemdaOnly(Pemda pemdaBean ) {
		EntityManager em = getFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			String query = "";
			query = "SELECT a FROM UserLog a WHERE a.unitKerjaBean.satuanKerjaBean.pemdaBean.ID = :pemdaBeanID "
					+	" "
					+ 	" ";

			List<UserLog> list = em.createQuery(query)
					.setParameter("pemdaBeanID", pemdaBean.getID())
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

	@Override
	public List<UserLog> findAllBySatuanKerjaOnly(SatuanKerja satuanKerjaBean ) {
		EntityManager em = getFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			String query = "";
			query = "SELECT a FROM UserLog a WHERE a.unitKerjaBean.satuanKerjaBean.ID = :satuanKerjaBeanID "
					+	" "
					+ 	" ";

			List<UserLog> list = em.createQuery(query)
					.setParameter("satuanKerjaBeanID", satuanKerjaBean.getID())
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

	@Override
	public List<UserLog> findAllByUnitKerjaOnly(UnitKerja unitKerjaBean ) {
		EntityManager em = getFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			String query = "";
			query = "SELECT a FROM UserLog a WHERE a.unitKerjaBean.ID = :unitKerjaBeanID "
					+	" "
					+ 	" ";

			List<UserLog> list = em.createQuery(query)
					.setParameter("unitKerjaBeanID", unitKerjaBean.getID())
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
