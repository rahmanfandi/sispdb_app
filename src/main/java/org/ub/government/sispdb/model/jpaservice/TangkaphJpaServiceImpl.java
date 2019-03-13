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
import org.ub.government.sispdb.model.Tangkaph;
import org.ub.government.sispdb.model.UnitKerja;
import org.ub.government.sispdb.model.jpaservice.generic.GenericJpaServiceImpl;

public class TangkaphJpaServiceImpl extends GenericJpaServiceImpl<Tangkaph, Serializable> implements TangkaphJpaService{

	@Override
	public List<Tangkaph> findAll_By() {
		EntityManager em = getFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			String query = "";
			query = "SELECT a FROM Tangkaph a "
					+ " ";

			List<Tangkaph> list = em.createQuery(query)
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
	public List<Tangkaph> findAllBy(Date trDateFrom, Date trDateTo) {
		EntityManager em = getFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			String query = "";
			query = "SELECT a FROM Tangkaph a WHERE  "
					+	" a.trDate BETWEEN :trDateFrom AND :trDateTo "
					+ 	" ";

			List<Tangkaph> list = em.createQuery(query)
					.setParameter("trDateFrom", trDateFrom )
					.setParameter("trDateTo", trDateTo )
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
	public List<Tangkaph> findAllByPemProvOnly(PemProv pemProvBean, Date trDateFrom, Date trDateTo) {
		EntityManager em = getFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			String query = "";
			query = "SELECT a FROM Tangkaph a WHERE a.unitKerjaBean.satuanKerjaBean.pemdaBean.pemProvBean.ID = :pemProvBeanID "
					+	" AND a.trDate BETWEEN :trDateFrom AND :trDateTo "
					+ 	" ";

			List<Tangkaph> list = em.createQuery(query)
					.setParameter("pemProvBeanID", pemProvBean.getID())
					.setParameter("trDateFrom", trDateFrom )
					.setParameter("trDateTo", trDateTo )
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
	public List<Tangkaph> findAllByPemdaOnly(Pemda pemdaBean, Date trDateFrom, Date trDateTo) {
		EntityManager em = getFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			String query = "";
			query = "SELECT a FROM Tangkaph a WHERE a.unitKerjaBean.satuanKerjaBean.pemdaBean.ID = :pemdaBeanID "
					+	" AND a.trDate BETWEEN :trDateFrom AND :trDateTo "
					+ 	" ";

			List<Tangkaph> list = em.createQuery(query)
					.setParameter("pemdaBeanID", pemdaBean.getID())
					.setParameter("trDateFrom", trDateFrom )
					.setParameter("trDateTo", trDateTo )
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
	public List<Tangkaph> findAllBySatuanKerjaOnly(SatuanKerja satuanKerjaBean, Date trDateFrom, Date trDateTo) {
		EntityManager em = getFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			String query = "";
			query = "SELECT a FROM Tangkaph a WHERE a.unitKerjaBean.satuanKerjaBean.ID = :satuanKerjaBeanID "
					+	" AND a.trDate BETWEEN :trDateFrom AND :trDateTo "
					+ 	" ";

			List<Tangkaph> list = em.createQuery(query)
					.setParameter("satuanKerjaBeanID", satuanKerjaBean.getID())
					.setParameter("trDateFrom", trDateFrom )
					.setParameter("trDateTo", trDateTo )
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
	public List<Tangkaph> findAllByUnitKerjaOnly(UnitKerja unitKerjaBean, Date trDateFrom, Date trDateTo) {
		EntityManager em = getFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			String query = "";
			query = "SELECT a FROM Tangkaph a WHERE a.unitKerjaBean.ID = :unitKerjaBeanID "
					+	" AND a.trDate BETWEEN :trDateFrom AND :trDateTo "
					+ 	" ";

			List<Tangkaph> list = em.createQuery(query)
					.setParameter("unitKerjaBeanID", unitKerjaBean.getID())
					.setParameter("trDateFrom", trDateFrom )
					.setParameter("trDateTo", trDateTo )
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
