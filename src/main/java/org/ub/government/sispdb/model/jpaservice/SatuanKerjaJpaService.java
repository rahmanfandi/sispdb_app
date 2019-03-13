package org.ub.government.sispdb.model.jpaservice;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import org.ub.government.sispdb.model.SatuanKerja;
import org.ub.government.sispdb.model.jpaservice.generic.GenericJpaService;


public interface SatuanKerjaJpaService extends GenericJpaService<SatuanKerja, Serializable>{
	public List<SatuanKerja> findAll_By();
	
}
