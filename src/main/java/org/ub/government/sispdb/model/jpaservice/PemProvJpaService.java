package org.ub.government.sispdb.model.jpaservice;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import org.ub.government.sispdb.model.PemProv;
import org.ub.government.sispdb.model.jpaservice.generic.GenericJpaService;


public interface PemProvJpaService extends GenericJpaService<PemProv, Serializable>{
	public List<PemProv> findAll_By();
	
}
