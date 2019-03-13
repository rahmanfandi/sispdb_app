package org.ub.government.sispdb.model.jpaservice;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import org.ub.government.sispdb.model.Propinsi;
import org.ub.government.sispdb.model.jpaservice.generic.GenericJpaService;


public interface PropinsiJpaService extends GenericJpaService<Propinsi, Serializable>{
	public List<Propinsi> findAll_By();
	
}
