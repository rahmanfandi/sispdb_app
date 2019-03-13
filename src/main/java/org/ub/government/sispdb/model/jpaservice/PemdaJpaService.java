package org.ub.government.sispdb.model.jpaservice;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import org.ub.government.sispdb.model.Pemda;
import org.ub.government.sispdb.model.jpaservice.generic.GenericJpaService;


public interface PemdaJpaService extends GenericJpaService<Pemda, Serializable>{
	public List<Pemda> findAll_By();
	
}
