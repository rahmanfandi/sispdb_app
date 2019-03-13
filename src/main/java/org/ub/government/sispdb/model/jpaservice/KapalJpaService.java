package org.ub.government.sispdb.model.jpaservice;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import org.ub.government.sispdb.model.Kapal;
import org.ub.government.sispdb.model.PemProv;
import org.ub.government.sispdb.model.Pemda;
import org.ub.government.sispdb.model.SatuanKerja;
import org.ub.government.sispdb.model.UnitKerja;
import org.ub.government.sispdb.model.Upt;
import org.ub.government.sispdb.model.jpaservice.generic.GenericJpaService;


public interface KapalJpaService extends GenericJpaService<Kapal, Serializable>{
	public List<Kapal> findAll_By();
	
//	public List<Kapal> findAllBy(Date trDateFrom, Date trDateTo);
	public List<Kapal> findAllByPemProvOnly(PemProv pemProvBean);
	public List<Kapal> findAllByPemdaOnly(Pemda pemdaBean);	
	public List<Kapal> findAllBySatuanKerjaOnly(SatuanKerja satuanKerjaBean);
	public List<Kapal> findAllByUnitKerjaOnly(UnitKerja unitKerjaBean);

}
