package org.ub.government.sispdb.model.jpaservice;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import org.ub.government.sispdb.model.TangkapItem;
import org.ub.government.sispdb.model.jpaservice.generic.GenericJpaService;


public interface TangkapItemJpaService extends GenericJpaService<TangkapItem, Serializable>{
	public List<TangkapItem> findAll_By();
	
}
