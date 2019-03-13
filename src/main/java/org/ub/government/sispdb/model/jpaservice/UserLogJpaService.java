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
import org.ub.government.sispdb.model.UserLog;
import org.ub.government.sispdb.model.jpaservice.generic.GenericJpaService;


public interface UserLogJpaService extends GenericJpaService<UserLog, Serializable>{
	public List<UserLog> findAll_By();

//	public List<UserLog> findAllBy(Date trDateFrom, Date trDateTo);
	public List<UserLog> findAllByPemProvOnly(PemProv pemProvBean);
	public List<UserLog> findAllByPemdaOnly(Pemda pemdaBean);	
	public List<UserLog> findAllBySatuanKerjaOnly(SatuanKerja satuanKerjaBean);
	public List<UserLog> findAllByUnitKerjaOnly(UnitKerja unitKerjaBean);

}
