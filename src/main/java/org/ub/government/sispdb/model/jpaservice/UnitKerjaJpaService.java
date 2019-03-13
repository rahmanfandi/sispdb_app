package org.ub.government.sispdb.model.jpaservice;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import org.ub.government.sispdb.model.PemProv;
import org.ub.government.sispdb.model.Pemda;
import org.ub.government.sispdb.model.SatuanKerja;
import org.ub.government.sispdb.model.UnitKerja;
import org.ub.government.sispdb.model.UnitKerja;
import org.ub.government.sispdb.model.jpaservice.generic.GenericJpaService;


public interface UnitKerjaJpaService extends GenericJpaService<UnitKerja, Serializable>{
	public List<UnitKerja> findAll_By();

//	public List<UnitKerja> findAllBy(Date trDateFrom, Date trDateTo);
	public List<UnitKerja> findAllByPemProvOnly(PemProv pemProvBean);
	public List<UnitKerja> findAllByPemdaOnly(Pemda pemdaBean);	
	public List<UnitKerja> findAllBySatuanKerjaOnly(SatuanKerja satuanKerjaBean);
	public List<UnitKerja> findAllByUnitKerjaOnly(UnitKerja unitKerjaBean);

}
