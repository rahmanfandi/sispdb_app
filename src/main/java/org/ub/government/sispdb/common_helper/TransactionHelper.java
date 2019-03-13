package org.ub.government.sispdb.common_helper;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.List;

import org.ub.government.sispdb.model.IkanJenis;
import org.ub.government.sispdb.model.PemProv;
import org.ub.government.sispdb.model.Sysvar;
import org.ub.government.sispdb.model.Tangkaph;
import org.ub.government.sispdb.model.UnitKerja;
import org.ub.government.sispdb.model.jpaservice.IkanJenisJpaService;
import org.ub.government.sispdb.model.jpaservice.IkanSubKelasJpaService;
import org.ub.government.sispdb.model.jpaservice.SysvarJpaService;
import org.ub.government.sispdb.model.jpaservice.SysvarJpaServiceImpl;
import org.ub.government.sispdb.model.jpaservice.TangkaphJpaService;
import org.ub.government.sispdb.model.jpaservice.TangkaphJpaServiceImpl;
import org.ub.government.sispdb.model_enum.EnumJenisNomorUrut;
import org.ub.government.sispdb.model_enum.EnumLautDarat;


public class TransactionHelper{
	private static TransactionHelper instance;
	private SysvarJpaService sysvarJpaService;
	
	/*
	 * Master
	 */
//	private FCustomerJpaService fCustomerJpaService;
//	private FMaterialJpaService fMaterialJpaService;
//	private FSalesmanJpaService fSalesmanJpaService;
//	private FVendorJpaService fVendorJpaService;
	
	/*
	 * Transaksi 1
	 */
	private TangkaphJpaService tangkaphJpaService;
	private IkanSubKelasJpaService ikanSubKelasJpaService;
	private IkanJenisJpaService ikanJenisJpaService;
//	private FtArPaymenthJpaService ftArPaymenthJpaService;
	
	

	/*
	 * Transaksi 2
	 */
//	private FtOpnamehJpaService ftOpnamehJpaService;
//	private FtStockTransferhJpaService ftStockTransferhJpaService;
//	private FPromotionRuleshJpaService fPromotionRuleshJpaService;
//	private FParamDiskonNotaJpaService fParamDiskonNotaJpaService;
	
	public static TransactionHelper getInstance() {
		instance = new TransactionHelper();
			
		return instance;
	}
	
	public void initVariableMaster(){
		//Sudah Dihindari tapi tidak isa untuk pisah dari Komponen View
		sysvarJpaService = new SysvarJpaServiceImpl();
		
		tangkaphJpaService = new TangkaphJpaServiceImpl();
//		fMaterialJpaService = (((DashboardUI) getUI().getCurrent()).getfMaterialJpaService());
		
	}
	public void initVariableTransaksi1(){
//	      DashboardUI dashboardUI = new DashboardUI();
//			
//			if (((DashboardUI) getUI().getCurrent()) ==null) {
//			      MyInitVariableHelperImpl appVar = new MyInitVariableHelperImpl(dashboardUI);
//			      appVar.initVariable();
//				
//			      sysvarJpaService = dashboardUI.getSysvarJpaService();
//			      
//			      ftPurchasehJpaService = dashboardUI.getFtPurchasehJpaService();
//			      ftSaleshJpaService = dashboardUI.getFtSaleshJpaService();
//			      ftApPaymenthJpaService = dashboardUI.getFtApPaymenthJpaService();
//			      ftArPaymenthJpaService = dashboardUI.getFtArPaymenthJpaService();
//				
//			}else {
//				//Sudah Dihindari tapi tidak isa untuk pisah dari Komponen View
//				sysvarJpaService = (((DashboardUI) getUI().getCurrent()).getSysvarJpaService());
//				
//				ftPurchasehJpaService = (((DashboardUI) getUI().getCurrent()).getFtPurchasehJpaService());
//				ftSaleshJpaService = (((DashboardUI) getUI().getCurrent()).getFtSaleshJpaService());
//				ftApPaymenthJpaService = (((DashboardUI) getUI().getCurrent()).getFtApPaymenthJpaService());
//				ftArPaymenthJpaService = (((DashboardUI) getUI().getCurrent()).getFtArPaymenthJpaService());
//			}
	}
	
	public void initVariableTransaksi2(){
	}
			
	public void initSpesificVariable(EnumJenisNomorUrut jenisNomorUrut) {
		/*
		 * supaya cepat saja: karena load variable tertentu saja
		 */
		if (jenisNomorUrut.equals(EnumJenisNomorUrut.URUT_TANGKAP_DARAT) || jenisNomorUrut.equals(EnumJenisNomorUrut.URUT_TANGKAP_LAUT) || 
				jenisNomorUrut.equals(EnumJenisNomorUrut.URUT_TANGKAP_LAUT)
				) {
			initVariableTransaksi1();
			
		}else if (jenisNomorUrut.equals(EnumJenisNomorUrut.URUT_TANGKAP_DARAT) || 
				jenisNomorUrut.equals(EnumJenisNomorUrut.URUT_TANGKAP_LAUT) || 
				jenisNomorUrut.equals(EnumJenisNomorUrut.URUT_TANGKAP_LAUT)
				) {
			initVariableTransaksi2();
			
		}else if (jenisNomorUrut.equals(EnumJenisNomorUrut.URUT_TANGKAP_LAUT) || jenisNomorUrut.equals(EnumJenisNomorUrut.URUT_TANGKAP_LAUT) 
				) {
			initVariableMaster();
		}else {
			initVariableTransaksi1();
			initVariableTransaksi2();
			initVariableMaster();
		}
		
		
	}
	
	public String getNextNomorUrut(EnumJenisNomorUrut jenisNomorUrut, boolean isSaved, boolean isCheckDuplicate, 
			PemProv fcompanyBean, UnitKerja fdivisionBean) {
		
		initSpesificVariable(jenisNomorUrut);
		
		Sysvar sysvar = new Sysvar();
		//Find Per Company atau Per Divisi
		String divisionOrCompanyID = fcompanyBean !=null? "C_" + fcompanyBean.getID():(fdivisionBean !=null? "D_" + fdivisionBean.getID():"") ;
		if (fcompanyBean != null) {
			sysvar = sysvarJpaService.findById(fcompanyBean, jenisNomorUrut.getSysvarCode() + divisionOrCompanyID);
		}else if (fdivisionBean !=null ) {
			sysvar = sysvarJpaService.findById(fdivisionBean, jenisNomorUrut.getSysvarCode()  + divisionOrCompanyID);
			
		}
		
		
		
		int panjangdefault = sysvar.getLenghtData();
		String prefix = sysvar.getPrefix();
		String suffix =  sysvar.getSuffix();

		//PEMBUATAN KODE BARU DIMULAI
		String newNilaiString = sysvar.getNilaiString1();
		String newNilaiStringWithPrefixSuffix = "";
		
		/*
		 * 1. Jadikan Integer atau Long
		 * 2. Tambahkan nilai +1
		 * 3. Tambah panjang sesuai dengan Length di parameter
		 */
		boolean isReleaseNow = false;
		while (isReleaseNow==false){
			String strKode  = ""; //New StrKode
			if (jenisNomorUrut.equals(EnumJenisNomorUrut.URUT_DISC_NOTA)) { //Yang pakai double
				DecimalFormat df = new DecimalFormat("##");
				
				Double doubleKode = 0.0;
				try {
					doubleKode = Double.valueOf(newNilaiString);
				}catch (Exception e) {
				}
				doubleKode +=1;
				strKode = df.format(doubleKode);
			}else {
				Integer intKode = 0;
				try {
					intKode = Integer.valueOf(newNilaiString);
				}catch (Exception e) {}
				
				intKode +=1;
				strKode = String.valueOf(intKode);			
			}
			
			int len = strKode.length();
			int jumlahTambahanNol = panjangdefault - len;
			String tambahanNol = "";
			/*
			 * Menambahkan 0 sesuai dengan setting panjang di parameter sistem
			 */
			for (int i=0; i<jumlahTambahanNol; i++) tambahanNol += "0";
			newNilaiString = tambahanNol + strKode;
			newNilaiStringWithPrefixSuffix = prefix + newNilaiString + suffix;
			
			/*
			 * Cek Duplicate: pada tabel dan kolom tertentu: ndak boleh gagal
			 */
			String columnToCek = "";
			if (jenisNomorUrut.equals(EnumJenisNomorUrut.URUT_TANGKAP_DARAT) || jenisNomorUrut.equals(EnumJenisNomorUrut.URUT_TANGKAP_LAUT) ) {
				columnToCek =  EnumJenisNomorUrut.URUT_TANGKAP_DARAT.getColumnToCek();
//			}else if (jenisNomorUrut.equals(EnumJenisNomorUrut.URUT_PENJ_INV)  ) {
//				columnToCek =  EnumJenisNomorUrut.URUT_PENJ_INV.getColumnToCek();			
			/*
			 * Pajak, SJ Pengiriman, SJ Penagihan tidak perlu di cek
			 */
//			}else if (jenisNomorUrut.equals(EnumJenisNomorUrut.URUT_SJ_PENAGIHAN)  ) {
//				columnToCek = "sjPenagihanNo";
//			}else if (jenisNomorUrut.equals(EnumJenisNomorUrut.URUT_SJ_PENGIRIMAN)  ) {
//				columnToCek = "sjPengirimanNo";
//				
				
			}else if (jenisNomorUrut.equals(EnumJenisNomorUrut.URUT_DISC_NOTA) ) {
				columnToCek = EnumJenisNomorUrut.URUT_DISC_NOTA.getColumnToCek();
			}else if (jenisNomorUrut.equals(EnumJenisNomorUrut.URUT_PROMO_RULES) ) {
				columnToCek = EnumJenisNomorUrut.URUT_PROMO_RULES.getColumnToCek();
				
			}else if (jenisNomorUrut.equals(EnumJenisNomorUrut.URUT_DISC_NOTA) ) {
				columnToCek = EnumJenisNomorUrut.URUT_DISC_NOTA.getColumnToCek();
				

			}else if (jenisNomorUrut.equals(EnumJenisNomorUrut.URUT_M_JENISIKAN)  ) {
				columnToCek = EnumJenisNomorUrut.URUT_M_JENISIKAN.getColumnToCek();
			}
			
			if (isCheckDuplicate) {
				if (isKodeExist(jenisNomorUrut, columnToCek, newNilaiString, fcompanyBean, fdivisionBean, false)) {
					isReleaseNow = false;
				}else {
					isReleaseNow = true;
				}
			}
			
		}
		
		/*
		 * Release kode baru:
		 * yang disimpan:
		 * 	:Nilai String saja
		 * yang diberikan nilai balik:
		 * 	:Nilai String degan Prefix dan Suffix
		 */
		sysvar.setNilaiString1(newNilaiString);
		
		/*
		 * Jika perlu disimpan: Nilai String saja
		 */
		if (isSaved) {
			sysvarJpaService.updateObject(sysvar);
		}
		
		return newNilaiStringWithPrefixSuffix;
		
	}
	
	public boolean isKodeExist(EnumJenisNomorUrut jenisNomorUrut, String columnToCek, String kodeToCek, 
			PemProv fcompanyBean, UnitKerja fdivisionBean, boolean isInitSpesificVariableAgain) {
		
		if (isInitSpesificVariableAgain) {
			initSpesificVariable(jenisNomorUrut);
		}
		
		boolean isExist = false;
		/*
		 * Transaksi 1 & 2
		 */
		if (jenisNomorUrut.equals(EnumJenisNomorUrut.URUT_TANGKAP_DARAT)) {
			List<Tangkaph> listToFind = tangkaphJpaService.findAllByField(columnToCek, kodeToCek.trim(), null);
			if (listToFind.size() >0) {
				for (Tangkaph domain: listToFind) {
					if (domain.getType().equals(EnumLautDarat.DARAT)) {
						try {						
							if (fcompanyBean !=null ) {
								if (domain.getUnitKerjaBean().getSatuanKerjaBean().getPemdaBean().getPemProvBean().equals(fcompanyBean) ) {
									isExist = true;
									break;
								}
							}else if (fdivisionBean !=null ){
								if (domain.getUnitKerjaBean().equals(fdivisionBean) ) {
									isExist = true;
									break;
								}						
							}
						}catch (Exception e) {}
					}
				}
			}
			
		}else if (jenisNomorUrut.equals(EnumJenisNomorUrut.URUT_TANGKAP_LAUT)){
			List<Tangkaph> listToFind = tangkaphJpaService.findAllByField(columnToCek, kodeToCek.trim(), null);
			if (listToFind.size() >0) {
				for (Tangkaph domain: listToFind) {
					if (domain.getType().equals(EnumLautDarat.LAUT)) {
						try {						
							if (fcompanyBean !=null ) {
								if (domain.getUnitKerjaBean().getSatuanKerjaBean().getPemdaBean().getPemProvBean().equals(fcompanyBean) ) {
									isExist = true;
									break;
								}
							}else if (fdivisionBean !=null ){
								if (domain.getUnitKerjaBean().equals(fdivisionBean) ) {
									isExist = true;
									break;
								}						
							}
						}catch (Exception e) {}
					}
				}
			}
			
		/*
		 * master	
		 */
//		}else if (jenisNomorUrut.equals(EnumJenisNomorUrut.URUT_M_JENISIKAN)){
//			List<IkanJenis> listToFind = ikanJenisJpaService.findAllByField(columnToCek, kodeToCek.trim(), null);
//			for (IkanJenis domain: listToFind) {
//				try {						
//					if (fcompanyBean !=null ) {
//						if (domain.get.getFcompanyBean().equals(fcompanyBean) ) {
//							isExist = true;
//							break;
//						}
//					}else if (fdivisionBean !=null ){
//						if (domain.getFdivisionBean().equals(fdivisionBean) ) {
//							isExist = true;
//							break;
//						}						
//					}
//				}catch (Exception e) {}
//			}
			
		}else {
			
			/*
			 * Selain diatas tidak perlu di cek: ex. SJ Penagihan, SJ Pengiriman, Pajak dll
			 */
			isExist = false;
		}
		
		return isExist;
	}
	
	public String getCurrentNomor(EnumJenisNomorUrut jenisNomorUrut, PemProv fcompanyBean, UnitKerja fdivisionBean, boolean isUsePrefixSuffix) {
		/*
		 * supaya cepat saja
		 */
		if (jenisNomorUrut.equals(EnumJenisNomorUrut.URUT_TANGKAP_DARAT) || jenisNomorUrut.equals(EnumJenisNomorUrut.URUT_TANGKAP_LAUT) || 
				jenisNomorUrut.equals(EnumJenisNomorUrut.URUT_TANGKAP_DARAT)
				) {
			initVariableTransaksi1();
			
		}else if (jenisNomorUrut.equals(EnumJenisNomorUrut.URUT_TANGKAP_DARAT) || 
				jenisNomorUrut.equals(EnumJenisNomorUrut.URUT_TANGKAP_LAUT) || 
				jenisNomorUrut.equals(EnumJenisNomorUrut.URUT_TANGKAP_LAUT) 
				) {
			initVariableTransaksi2();
			
		}else if (jenisNomorUrut.equals(EnumJenisNomorUrut.URUT_PROMO_RULES) || 
				jenisNomorUrut.equals(EnumJenisNomorUrut.URUT_DISC_NOTA) || 
				jenisNomorUrut.equals(EnumJenisNomorUrut.URUT_TANGKAP_DARAT) || 
				jenisNomorUrut.equals(EnumJenisNomorUrut.URUT_TANGKAP_LAUT) 
				) {
			initVariableMaster();
			
		}else {
			initVariableTransaksi1();
			initVariableTransaksi2();
			initVariableMaster();
		}
		
		Sysvar sysvar = new Sysvar();
		//Find Per Company atau Per Divisi
		if (fcompanyBean != null) {
			sysvar = sysvarJpaService.findById(fcompanyBean, jenisNomorUrut.getSysvarCode());
		}else if (fdivisionBean !=null ) {
			
		}else {
			sysvar = sysvarJpaService.findById(fdivisionBean, jenisNomorUrut.getSysvarCode());
		}
		
		String nomorUrutDefault = "00001";
		int panjangdefault = sysvar.getLenghtData();
		String prefix = sysvar.getPrefix();
		String suffix =  sysvar.getSuffix();

		//PEMBUATAN KODE BARU DIMULAI
		String currentNomerUrut = sysvar.getNilaiString1();
		if (isUsePrefixSuffix) {
			currentNomerUrut = prefix + currentNomerUrut + suffix;
		}
		
		return currentNomerUrut;
		
	}


	public boolean isTransactionDateBeforeAccountingDate(Date trDate, PemProv fcompanyBean) {
		boolean isYes = false; //Normal jika False 
		
		return isYes;
	}
}
