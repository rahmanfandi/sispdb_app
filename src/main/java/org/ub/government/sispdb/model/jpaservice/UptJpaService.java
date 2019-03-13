package org.ub.government.sispdb.model.jpaservice;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.ub.government.sispdb.model.PemProv;
import org.ub.government.sispdb.model.Pemda;
import org.ub.government.sispdb.model.SatuanKerja;
import org.ub.government.sispdb.model.Tangkaph;
import org.ub.government.sispdb.model.UnitKerja;
import org.ub.government.sispdb.model.Upt;
import org.ub.government.sispdb.model.jpaservice.generic.GenericJpaService;


public interface UptJpaService extends GenericJpaService<Upt, Serializable>{
	public List<Upt> findAll_By();

//	public List<Upt> findAllBy(Date trDateFrom, Date trDateTo);
	public List<Upt> findAllByPemProvOnly(PemProv pemProvBean);
	public List<Upt> findAllByPemdaOnly(Pemda pemdaBean);	
	public List<Upt> findAllBySatuanKerjaOnly(SatuanKerja satuanKerjaBean);
	public List<Upt> findAllByUnitKerjaOnly(UnitKerja unitKerjaBean);

}
