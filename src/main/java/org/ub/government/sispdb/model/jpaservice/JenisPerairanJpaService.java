package org.ub.government.sispdb.model.jpaservice;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import org.ub.government.sispdb.model.JenisPerairan;
import org.ub.government.sispdb.model.jpaservice.generic.GenericJpaService;


public interface JenisPerairanJpaService extends GenericJpaService<JenisPerairan, Serializable>{
	public List<JenisPerairan> findAll_By();
	
}
