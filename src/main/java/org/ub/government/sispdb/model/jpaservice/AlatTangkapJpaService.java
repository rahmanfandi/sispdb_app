package org.ub.government.sispdb.model.jpaservice;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import org.ub.government.sispdb.model.AlatTangkap;
import org.ub.government.sispdb.model.jpaservice.generic.GenericJpaService;


public interface AlatTangkapJpaService extends GenericJpaService<AlatTangkap, Serializable>{
	public List<AlatTangkap> findAll_By();
	
}
