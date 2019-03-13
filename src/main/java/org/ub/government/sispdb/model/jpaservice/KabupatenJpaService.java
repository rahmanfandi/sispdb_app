package org.ub.government.sispdb.model.jpaservice;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import org.ub.government.sispdb.model.Kabupaten;
import org.ub.government.sispdb.model.jpaservice.generic.GenericJpaService;


public interface KabupatenJpaService extends GenericJpaService<Kabupaten, Serializable>{
	public List<Kabupaten> findAll_By();
	
}
