package org.ub.government.sispdb.model.jpaservice;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.ub.government.sispdb.model.PemProv;
import org.ub.government.sispdb.model.Pemda;
import org.ub.government.sispdb.model.SatuanKerja;
import org.ub.government.sispdb.model.Sysvar;
import org.ub.government.sispdb.model.UnitKerja;
import org.ub.government.sispdb.model.jpaservice.generic.GenericJpaServiceImpl;

public class SysvarJpaServiceImpl extends GenericJpaServiceImpl<Sysvar, Serializable> implements SysvarJpaService{
	
	@Override
	public List<Sysvar> findAllByCompanyId(int companyId) {
	       EntityManager em = getFactory().createEntityManager();
	        try {
	            em.getTransaction().begin();
	            String query = "SELECT a FROM Sysvar a WHERE a.unitKerjaBean.satuanKerjaBean.pemdaBean.pemProvBean.ID = :pemProvBeanID ";
	            
	            List<Sysvar> list = em.createQuery(query)
	            		 .setParameter("pemProvBeanID", companyId)
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
	public List<Sysvar> findAllByDivisionId(int divisionId) {
	       EntityManager em = getFactory().createEntityManager();
	        try {
	            em.getTransaction().begin();
	            String query = "SELECT a FROM Sysvar a WHERE a.unitKerjaBean.ID = :unitKerjaBeanID ";
	            
	            List<Sysvar> list = em.createQuery(query)
	            		 .setParameter("unitKerjaBeanID", divisionId)
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
	public List<Sysvar> findAll(PemProv fCompanyBean, String idToFind) {
	       EntityManager em = getFactory().createEntityManager();
	        try {
	            em.getTransaction().begin();
	            String query = "SELECT a FROM Sysvar a WHERE a.unitKerjaBean.satuanKerjaBean.pemdaBean.pemProvBean.ID = :pemProvBeanID "
	            		+ " AND a.id LIKE :idToFind ";
	            
	            List<Sysvar> list = em.createQuery(query)
	            		 .setParameter("pemProvBeanID", fCompanyBean.getID())
	            		 .setParameter("idToFind", idToFind)
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
	public List<Sysvar> findAll(UnitKerja fDivisionBean, String idToFind) {
	       EntityManager em = getFactory().createEntityManager();
	        try {
	            em.getTransaction().begin();
	            String query = "SELECT a FROM Sysvar a WHERE a.unitKerjaBean.ID = :unitKerjaBeanID "
	            		+ " AND a.id LIKE :idToFind ";
	            
	            List<Sysvar> list = em.createQuery(query)
	            		 .setParameter("unitKerjaBeanID", fDivisionBean.getID())
	            		 .setParameter("idToFind", idToFind)
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
	public Sysvar findById(PemProv fcompanyBean, String idToFind) {
	       EntityManager em = getFactory().createEntityManager();	        
	       try {
	            em.getTransaction().begin();
	            String query = "SELECT a FROM Sysvar a WHERE a.unitKerjaBean.satuanKerjaBean.pemdaBean.pemProvBean.ID = :pemProvBeanID "
	            		+ " AND a.id LIKE :idToFind ";
	            
	            List<Sysvar> list = em.createQuery(query)
	            		 .setParameter("pemProvBeanID", fcompanyBean.getID())
	            		 .setParameter("idToFind", idToFind)
	            		 .setHint(QueryHints.REFRESH, HintValues.TRUE)
	            		 .getResultList();
	            em.getTransaction().commit();
	            return list.get(0);
	        } catch (PersistenceException exception) {
	            em.getTransaction().rollback();
	            throw exception;
	        } finally {
	            em.close();
	        }    
	}

	@Override
	public Sysvar findById(UnitKerja fdivisionBean, String idToFind) {
	       EntityManager em = getFactory().createEntityManager();
	       
	        try {
	            em.getTransaction().begin();
	            String query = "SELECT a FROM Sysvar a WHERE a.unitKerjaBean.ID = :unitKerjaBeanID "
	            		+ " AND a.id LIKE :idToFind ";
	            
	            List<Sysvar> list = em.createQuery(query)
	            		 .setParameter("unitKerjaBeanID", fdivisionBean.getID())
	            		 .setParameter("idToFind", idToFind)
	            		 .setHint(QueryHints.REFRESH, HintValues.TRUE)
	            		 .getResultList();
	            em.getTransaction().commit();
	            return list.get(0);
	        } catch (PersistenceException exception) {
	            em.getTransaction().rollback();
	            throw exception;
	        } finally {
	            em.close();
	        }    
	}
	
	@Override
	public List<Sysvar> findAllByCompanyOnly(PemProv fcompanyBean) {
		EntityManager em = getFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			String query = "";
			query = "SELECT a FROM Sysvar a WHERE a.fdivisionBean.fcompanyBean.ID = :fcompanyBeanId "
				+ " ";

			List<Sysvar> list = em.createQuery(query)
					.setParameter("fcompanyBeanId", fcompanyBean.getID())
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
	public List<Sysvar> findAllByDivisionOnly(UnitKerja fdivisionBean ) {
		EntityManager em = getFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			String query = "";
			query = "SELECT a FROM Sysvar a WHERE a.fdivisionBean.ID = :fdivisionBeanId "
				+ " ";

			List<Sysvar> list = em.createQuery(query)
					.setParameter("fdivisionBeanId", fdivisionBean.getID())
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
	public List<Sysvar> findAll_By() {
		EntityManager em = getFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			String query = "";
			query = "SELECT a FROM Sysvar a "
					+ " ";

			List<Sysvar> list = em.createQuery(query)
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
	public List<Sysvar> findAllByPemProvOnly(PemProv pemProvBean ) {
		EntityManager em = getFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			String query = "";
			query = "SELECT a FROM Sysvar a WHERE a.unitKerjaBean.satuanKerjaBean.pemdaBean.pemProvBean.ID = :pemProvBeanID "
					+ 	" ";

			List<Sysvar> list = em.createQuery(query)
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
	public List<Sysvar> findAllByPemdaOnly(Pemda pemdaBean ) {
		EntityManager em = getFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			String query = "";
			query = "SELECT a FROM Sysvar a WHERE a.unitKerjaBean.satuanKerjaBean.pemdaBean.ID = :pemdaBeanID "
					+	" "
					+ 	" ";

			List<Sysvar> list = em.createQuery(query)
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
	public List<Sysvar> findAllBySatuanKerjaOnly(SatuanKerja satuanKerjaBean ) {
		EntityManager em = getFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			String query = "";
			query = "SELECT a FROM Sysvar a WHERE a.unitKerjaBean.satuanKerjaBean.ID = :satuanKerjaBeanID "
					+	" "
					+ 	" ";

			List<Sysvar> list = em.createQuery(query)
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
	public List<Sysvar> findAllByUnitKerjaOnly(UnitKerja unitKerjaBean ) {
		EntityManager em = getFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			String query = "";
			query = "SELECT a FROM Sysvar a WHERE a.unitKerjaBean.ID = :unitKerjaBeanID "
					+ 	" ";

			List<Sysvar> list = em.createQuery(query)
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
