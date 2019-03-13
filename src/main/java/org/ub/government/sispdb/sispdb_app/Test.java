package org.ub.government.sispdb.sispdb_app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.ub.government.sispdb.model.Propinsi;
import org.ub.government.sispdb.model.jpaservice.PropinsiJpaService;
import org.ub.government.sispdb.model.jpaservice.PropinsiJpaServiceImpl;

public class Test {
	
	private static final String PERSISTENCE_UNIT = "erpPU";

	public static void main(String [] args) {
		EntityManagerFactory factory;
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
		
		Propinsi propinsi1 = new Propinsi();
		
		propinsi1.setID(3);
		propinsi1.setKode1("Dua");
		propinsi1.setDescription("Description Dua");

	    EntityManager em1 = factory.createEntityManager();
  		em1.getTransaction().begin();
  		em1.persist(propinsi1);
	      
         String query = "SELECT a FROM Propinsi a";
         List<Propinsi> list = em1.createQuery(query)
          		.setHint(QueryHints.REFRESH, HintValues.TRUE)
          		.getResultList();
	      
  			em1.getTransaction().commit();
	      
	      em1.close();
	      
	      for (Propinsi domain: list) {
	    	  	System.out.println(domain.getKode1() + "\t" + domain.getDescription());
	      }

	}
}
