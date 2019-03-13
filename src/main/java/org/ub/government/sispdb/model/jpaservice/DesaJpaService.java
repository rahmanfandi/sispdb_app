package org.ub.government.sispdb.model.jpaservice;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import org.ub.government.sispdb.model.Desa;
import org.ub.government.sispdb.model.jpaservice.generic.GenericJpaService;


public interface DesaJpaService extends GenericJpaService<Desa, Serializable>{
	public List<Desa> findAll_By();
	
}
