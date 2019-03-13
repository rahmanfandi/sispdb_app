package org.ub.government.sispdb.model.jpaservice;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import org.ub.government.sispdb.model.PemProv;
import org.ub.government.sispdb.model.Pemda;
import org.ub.government.sispdb.model.SatuanKerja;
import org.ub.government.sispdb.model.TabulatorEnumerator;
import org.ub.government.sispdb.model.UnitKerja;
import org.ub.government.sispdb.model.TabulatorEnumerator;
import org.ub.government.sispdb.model.jpaservice.generic.GenericJpaService;


public interface TabulatorEnumeratorJpaService extends GenericJpaService<TabulatorEnumerator, Serializable>{
	public List<TabulatorEnumerator> findAll_By();
	
//	public List<TabulatorEnumerator> findAllBy(Date trDateFrom, Date trDateTo);
	public List<TabulatorEnumerator> findAllByPemProvOnly(PemProv pemProvBean);
	public List<TabulatorEnumerator> findAllByPemdaOnly(Pemda pemdaBean);	
	public List<TabulatorEnumerator> findAllBySatuanKerjaOnly(SatuanKerja satuanKerjaBean);
	public List<TabulatorEnumerator> findAllByUnitKerjaOnly(UnitKerja unitKerjaBean);

}
