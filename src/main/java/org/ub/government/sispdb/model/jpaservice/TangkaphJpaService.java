package org.ub.government.sispdb.model.jpaservice;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.ub.government.sispdb.model.PemProv;
import org.ub.government.sispdb.model.Pemda;
import org.ub.government.sispdb.model.Propinsi;
import org.ub.government.sispdb.model.SatuanKerja;
import org.ub.government.sispdb.model.Tangkaph;
import org.ub.government.sispdb.model.UnitKerja;
import org.ub.government.sispdb.model.jpaservice.generic.GenericJpaService;


public interface TangkaphJpaService extends GenericJpaService<Tangkaph, Serializable>{
	public List<Tangkaph> findAll_By();
	
	public List<Tangkaph> findAllBy(Date trDateFrom, Date trDateTo);
	public List<Tangkaph> findAllByPemProvOnly(PemProv pemProvBean, Date trDateFrom, Date trDateTo);
	public List<Tangkaph> findAllByPemdaOnly(Pemda pemdaBean, Date trDateFrom, Date trDateTo);	
	public List<Tangkaph> findAllBySatuanKerjaOnly(SatuanKerja satuanKerjaBean, Date trDateFrom, Date trDateTo);
	public List<Tangkaph> findAllByUnitKerjaOnly(UnitKerja unitKerjaBean, Date trDateFrom, Date trDateTo );
					
}
