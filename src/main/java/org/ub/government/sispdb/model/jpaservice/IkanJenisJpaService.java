package org.ub.government.sispdb.model.jpaservice;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import org.ub.government.sispdb.model.IkanJenis;
import org.ub.government.sispdb.model.jpaservice.generic.GenericJpaService;


public interface IkanJenisJpaService extends GenericJpaService<IkanJenis, Serializable>{
	public List<IkanJenis> findAll_By();
	
}
