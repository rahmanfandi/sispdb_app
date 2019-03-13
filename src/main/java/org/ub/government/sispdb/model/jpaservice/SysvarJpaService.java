package org.ub.government.sispdb.model.jpaservice;

import java.io.Serializable;
import java.util.List;

import org.ub.government.sispdb.model.PemProv;
import org.ub.government.sispdb.model.Pemda;
import org.ub.government.sispdb.model.SatuanKerja;
import org.ub.government.sispdb.model.Sysvar;
import org.ub.government.sispdb.model.UnitKerja;
import org.ub.government.sispdb.model.jpaservice.generic.GenericJpaService;


public interface SysvarJpaService extends GenericJpaService<Sysvar, Serializable>{
	public List<Sysvar> findAll_By();

	public List<Sysvar> findAllByCompanyId(int companyId);
	public List<Sysvar> findAllByDivisionId(int divisionId);
	
	public List<Sysvar> findAll(PemProv fcompanyBean, String idToFind);
	public List<Sysvar> findAll(UnitKerja fdivisionBean, String idToFind);
	public Sysvar findById(PemProv fcompanyBean, String idToFind);
	public Sysvar findById(UnitKerja fdivisionBean, String idToFind);
	
	public List<Sysvar> findAllByCompanyOnly(PemProv fcompanyBean);
	public List<Sysvar> findAllByDivisionOnly(UnitKerja fdivisionBean);
	
	/*
	 * TEST
	 */
//	public List<Sysvar> findAllBy(Date trDateFrom, Date trDateTo);
	public List<Sysvar> findAllByPemProvOnly(PemProv pemProvBean);
	public List<Sysvar> findAllByPemdaOnly(Pemda pemdaBean);	
	public List<Sysvar> findAllBySatuanKerjaOnly(SatuanKerja satuanKerjaBean);
	public List<Sysvar> findAllByUnitKerjaOnly(UnitKerja unitKerjaBean);

}
