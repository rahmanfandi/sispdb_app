package org.ub.government.sispdb.model.jpaservice;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import org.ub.government.sispdb.model.IkanSubKelas;
import org.ub.government.sispdb.model.jpaservice.generic.GenericJpaService;


public interface IkanSubKelasJpaService extends GenericJpaService<IkanSubKelas, Serializable>{
	public List<IkanSubKelas> findAll_By();
	
}
