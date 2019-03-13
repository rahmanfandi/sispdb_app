package org.ub.government.sispdb.model.jpaservice;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.ub.government.sispdb.model.Kapal;
import org.ub.government.sispdb.model.PemProv;
import org.ub.government.sispdb.model.Pemda;
import org.ub.government.sispdb.model.SatuanKerja;
import org.ub.government.sispdb.model.UnitKerja;
import org.ub.government.sispdb.model.Kapal;
import org.ub.government.sispdb.model.jpaservice.generic.GenericJpaServiceImpl;

public class KapalJpaServiceImpl extends GenericJpaServiceImpl<Kapal, Serializable> implements KapalJpaService{

	@Override
	public List<Kapal> findAll_By() {
		EntityManager em = getFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			String query = "";
			query = "SELECT a FROM Kapal a "
					+ " ";

			List<Kapal> list = em.createQuery(query)
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
	public List<Kapal> findAllByPemProvOnly(PemProv pemProvBean ) {
		EntityManager em = getFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			String query = "";
			query = "SELECT a FROM Kapal a WHERE a.unitKerjaBean.satuanKerjaBean.pemdaBean.pemProvBean.ID = :pemProvBeanID "
					+	" "
					+ 	" ";

			List<Kapal> list = em.createQuery(query)
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
	public List<Kapal> findAllByPemdaOnly(Pemda pemdaBean ) {
		EntityManager em = getFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			String query = "";
			query = "SELECT a FROM Kapal a WHERE a.unitKerjaBean.satuanKerjaBean.pemdaBean.ID = :pemdaBeanID "
					+	" "
					+ 	" ";

			List<Kapal> list = em.createQuery(query)
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
	public List<Kapal> findAllBySatuanKerjaOnly(SatuanKerja satuanKerjaBean ) {
		EntityManager em = getFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			String query = "";
			query = "SELECT a FROM Kapal a WHERE a.unitKerjaBean.satuanKerjaBean.ID = :satuanKerjaBeanID "
					+	" "
					+ 	" ";

			List<Kapal> list = em.createQuery(query)
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
	public List<Kapal> findAllByUnitKerjaOnly(UnitKerja unitKerjaBean ) {
		EntityManager em = getFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			String query = "";
			query = "SELECT a FROM Kapal a WHERE a.unitKerjaBean.ID = :unitKerjaBeanID "
					+	" "
					+ 	" ";

			List<Kapal> list = em.createQuery(query)
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
