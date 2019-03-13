package org.ub.government.sispdb.model.jpaservice;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import org.ub.government.sispdb.model.Kecamatan;
import org.ub.government.sispdb.model.jpaservice.generic.GenericJpaService;


public interface KecamatanJpaService extends GenericJpaService<Kecamatan, Serializable>{
	public List<Kecamatan> findAll_By();
	
}
