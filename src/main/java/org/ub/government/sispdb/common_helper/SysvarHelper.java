
package org.ub.government.sispdb.common_helper;

import java.util.Date;

import org.ub.government.sispdb.model.PemProv;
import org.ub.government.sispdb.model.Sysvar;
import org.ub.government.sispdb.model.UnitKerja;
import org.ub.government.sispdb.model.jpaservice.SysvarJpaService;
import org.ub.government.sispdb.model.jpaservice.SysvarJpaServiceImpl;

public class SysvarHelper{
	private SysvarJpaService sysvarJpaService = null;
//	private SysvarJpaService sysvarJpaService;
	
//	private DivisionJpaService divisionService = new DivisionJpaServiceImpl();
	
	//1. CEK PARAMETER SYSTEM KALAU TIDAK ADA BUAT DEFAULT

	public SysvarHelper(SysvarJpaService sysvarJpaService) {
		this.sysvarJpaService= sysvarJpaService;

		defaultConfigSysvar();
		
	}
	public SysvarHelper() {
		sysvarJpaService =  new  SysvarJpaServiceImpl();
		defaultConfigSysvar();		
	}
	
	public void defaultConfigSysvar(){
		
		cekOrCreateNewConfigSysvar();
	}

	/**		
	 * 
	 * 		_VERSION_PRG			= Program Version
	 * 		_RELEASE_PRG			= Release Number Of Version
	 * 		_SUM_PARAM_CORP  	= Jumlah parameter Company yang release 
	 * 		_SUM_PARAM_DIV  		= Jumlah parameter Divisi yang release 
	 * 
	 */
	
	public void cekOrCreateNewConfigSysvar(){
		Sysvar sysvar = new Sysvar();
		sysvar = sysvarJpaService.findById("_REPAIRMODE");
		if (sysvar==null){
			sysvar = new Sysvar();
			sysvar.setId("_REPAIRMODE");

			sysvar.setDeskripsi("Mode Repair/Perbaikan (Berbahaya Sebaiknya Backup Sebelum Melakukan Repair)");
			sysvar.setGroupSysvar("_SYSTEM");
			sysvar.setTipeData("BOL1");
			sysvar.setNilaiBol1(false);

			try {
				sysvarJpaService.createObject(sysvar);
			}catch (Exception e) {}
		}		
		
		sysvar = sysvarJpaService.findById("_VERSION_PRG");
		if (sysvar==null){
			sysvar = new Sysvar();
			sysvar.setId("_VERSION_PRG");

			sysvar.setDeskripsi("Program Version");
			sysvar.setGroupSysvar("_VERSION_PRG");
			sysvar.setTipeData("STRING1");
			sysvar.setNilaiString1("1.0");
			
			try {
				sysvarJpaService.createObject(sysvar);
			}catch (Exception e) {}
		}

		//Selalu Diupdate: -> COMPANY
		sysvar = sysvarJpaService.findById("_COUNT_PARAM_CORP");
		if (sysvar==null){
			sysvar = new Sysvar();
			sysvar.setId("_COUNT_PARAM_CORP");

			sysvar.setDeskripsi("Jumlah Parameter Company/Corporation pada Versi ini");
			sysvar.setGroupSysvar("_VERSION_PRG");
			sysvar.setTipeData("INTEGER1");
			sysvar.setNilaiString1("");
			sysvar.setNilaiInt1(76);
			
			try {
				sysvarJpaService.createObject(sysvar);
			}catch (Exception e) {}
		}else {
			sysvar.setNilaiInt1(76);
			try {
				sysvarJpaService.updateObject(sysvar);
			}catch (Exception e) {}
		}
		
		//Selalu Diupdate: ---> DIVISION
		sysvar = sysvarJpaService.findById("_COUNT_PARAM_DIV");
		if (sysvar==null){
			sysvar = new Sysvar();
			sysvar.setId("_COUNT_PARAM_DIV");

			sysvar.setDeskripsi("Jumlah Parameter Division pada Versi ini");
			sysvar.setGroupSysvar("_VERSION_PRG");
			sysvar.setTipeData("INTEGER1");
			sysvar.setNilaiString1("");
			sysvar.setNilaiInt1(76);
			
			try {
				sysvarJpaService.createObject(sysvar);
			}catch (Exception e) {}
		}else {
			sysvar.setNilaiInt1(76);
			try {
				sysvarJpaService.updateObject(sysvar);
			}catch (Exception e) {}
		}

		//Web Service		
		sysvar = sysvarJpaService.findById("_WSPORT_OPEN");
		if (sysvar==null){
			sysvar = new Sysvar();
			sysvar.setId("_WSPORT_OPEN");

			sysvar.setDeskripsi("Apakah Web Service untuk Aplikasi Server ini Dibuka? (true=Yes | false=No)");
			sysvar.setGroupSysvar("_WS_PORT");
			sysvar.setTipeData("BOL1");
			sysvar.setNilaiString1("");
			sysvar.setNilaiBol1(false);
			sysvar.setLenghtData(0);
			
			try {
				sysvarJpaService.createObject(sysvar);
			}catch (Exception e) {}
		}
		

//PARAMETER/CUSTOMIZE DISKON
		
		
		//TIDAK BOLEH ADA OUTSTANDING NOTA:: Jika ada outstanding nota maka akan muncul konfirmasi
//		sysvar = sysvarJpaService.findById("_NO_OSTD_SO");
//		if (sysvar==null){
//			sysvar = new Sysvar();		
//			sysvar.setId("_NO_OSTD_SO");
//			
//			sysvar.setDeskripsi("Tidak Boleh Ada Outstanding Sales Order Saat Proses Akhir Hari. Jika ada/boleh maka sebaiknya Param _ORD_PRS_STK=false");
//			sysvar.setGroupSysvar("_TRANSAKSI");
//			sysvar.setTipeData("BOL1");
//			sysvar.setNilaiBol1(true);
//			
//			sysvarJpaService.createObject(sysvar);
//			
//		}
//		sysvar = sysvarJpaService.findById("_NO_OSTD_PO");
//		if (sysvar==null){
//			sysvar = new Sysvar();		
//			sysvar.setId("_NO_OSTD_PO");
//			
//			sysvar.setDeskripsi("Tidak Boleh Ada Outstanding Purchase Order Saat Proses Akhir Hari. Jika ada/boleh maka sebaiknya Param _ORD_PRS_STK=false");
//			sysvar.setGroupSysvar("_TRANSAKSI");
//			sysvar.setTipeData("BOL1");
//			sysvar.setNilaiBol1(true);
//			
//			sysvarJpaService.createObject(sysvar);
//			
//		}
		
//PASTI				
//		sysvar = sysvarJpaService.findById("_FT_AUTO_K");
//		if (sysvar==null){
//			sysvar = new Sysvar();		
//			sysvar.setId("_FT_AUTO_K");
//			
//			sysvar.setDeskripsi("Faktur Penjualan dan Pembelian TUNAI Belum Lunas, Langsung jadi KREDIT Saat Proses Akhir Hari");
//			sysvar.setGroupSysvar("_TRANSAKSI");
//			sysvar.setTipeData("BOL1");
//			sysvar.setNilaiBol1(true);
//			
//			sysvarJpaService.createObject(sysvar);
//			
//		}
		
//		//#### TRANSAKSI PEMBELIAN/PURCHASE ORDER OUTLET #### :: digantikan oleh good receive date
//		sysvar = sysvarJpaService.findById("_BELI_AUTOP");
//		if (sysvar==null){
//			sysvar = new Sysvar();		
//			sysvar.setId("_BELI_AUTOP");
//			
//			sysvar.setDeskripsi("Barang Datang/Pembelian Auto Proses");
//			sysvar.setGroupSysvar("_TRANSAKSI");
//			sysvar.setTipeData("BOL1");
//			sysvar.setNilaiBol1(true);
//			
//			sysvarJpaService.createObject(sysvar);
//			
//		}
			
		sysvar = sysvarJpaService.findById("_UP_PICS_PATH");
		if (sysvar==null){
			sysvar = new Sysvar();
			sysvar.setId("_UP_PICS_PATH");

			sysvar.setDeskripsi("Lokasi Menyimpan File Upload Gambar/Picture yang di Upload (ex. /Users/yhawin/");
			sysvar.setGroupSysvar("_SISTEM");
			sysvar.setTipeData("STRING1");
			sysvar.setNilaiString1("/Users/yhawin/");
			sysvar.setPrefix("");
			sysvar.setLenghtData(0);
			
			try {
				sysvarJpaService.createObject(sysvar);
			}catch (Exception e) {}
		}

		sysvar = sysvarJpaService.findById("_UP_DOCS_PATH");
		if (sysvar==null){
			sysvar = new Sysvar();
			sysvar.setId("_UP_DOCS_PATH");

			sysvar.setDeskripsi("Lokasi Menyimpan File Dokument yang di Upload (ex. /Users/yhawin/");
			sysvar.setGroupSysvar("_SISTEM");
			sysvar.setTipeData("STRING1");
			sysvar.setNilaiString1("/Users/yhawin/");
			sysvar.setPrefix("");
			sysvar.setLenghtData(0);
			
			try {
				sysvarJpaService.createObject(sysvar);
			}catch (Exception e) {}
		}
		
		//PARAMETER IMPORT/SINCRONISASI FROM SERVER/SPECIFIC IP
//		sysvar = sysvarJpaService.findById("_IMPHJL_RET");
//		if (sysvar==null){
//			sysvar = new Sysvar();		
//			sysvar.setId("_IMPHJL_RET");
//			
//			sysvar.setDeskripsi("Import Harga Jual dari server hanya Harga Retail Saja (Harga Dist/Grosir1/Grosir2 tidak diimport)");
//			sysvar.setGroupSysvar("_IMP_SVR");
//			sysvar.setTipeData("BOL1");
//			sysvar.setLenghtData(1);
//			sysvar.setPrefix("");
//			sysvar.setNilaiBol1(false);
//			
//			sysvarJpaService.createObject(sysvar);
//		}
//		
//		sysvar = sysvarJpaService.findById("_IMPHRGJUAL_TOLE");
//		if (sysvar==null){
//			sysvar = new Sysvar();		
//			sysvar.setId("_IMPHRGJUAL_TOLE");
//			
//			sysvar.setDeskripsi("Toleransi Import/Update Harga Jual, dianggap berbeda dari Server (dalam persen ex. 0.01 =  1 persen)");
//			sysvar.setGroupSysvar("_IMP_SVR");
//			sysvar.setTipeData("DOUBLE1");
//			sysvar.setNilaiDouble1(0.01);
//			
//			sysvarJpaService.createObject(sysvar);
//			
//		}		
//		sysvar = sysvarJpaService.findById("_IMPHRGJUAL_SAJA");
//		if (sysvar==null){
//			sysvar = new Sysvar();		
//			sysvar.setId("_IMPHRGJUAL_SAJA");
//			
//			sysvar.setDeskripsi("Import Harga Jual Saja, Harga beli tidak diimport dan tidak di cek");
//			sysvar.setGroupSysvar("_IMP_SVR");
//			sysvar.setTipeData("BOL1");
//			sysvar.setLenghtData(1);
//			sysvar.setPrefix("");
//			sysvar.setNilaiBol1(false);
//			
//			sysvarJpaService.createObject(sysvar);
//			
//		}		
//	
//		//#### TRANSAKSI POINT OF SALES ####
//		sysvar = sysvarJpaService.findById("_POS_NOINV_PREFIX");
//		if (sysvar==null){
//			sysvar = new Sysvar();		
//			sysvar.setId("_POS_NOINV_PREFIX");
//			
//			sysvar.setDeskripsi("Nomor Invoice pada POS (Point Of Sales) menggunakan Prefix Kode Kassa");
//			sysvar.setGroupSysvar("_TRANSAKSI");
//			sysvar.setTipeData("BOL1");
//			sysvar.setNilaiBol1(true);
//			
//			sysvarJpaService.createObject(sysvar);
//			
//		}
		
	
		
	}///END BIKIN BARU ############
	

	public int getCountOfParameterCorporation(){
		return sysvarJpaService.findById("_COUNT_PARAM_CORP").getNilaiInt1();
	}
	public int getCountOfParameterDivision(){
		return sysvarJpaService.findById("_COUNT_PARAM_DIV").getNilaiInt1();
	}
	
	
//	 * A. UMUM SETTING APLIKASI	
	public String getCompanyCode3(PemProv fcompanyBean){
		String divisionOrCompanyID = "C_" + fcompanyBean.getID();
		String sysvarID = "COMP_CODE_";
		return sysvarJpaService.findById(fcompanyBean, sysvarID + divisionOrCompanyID).getNilaiString1();
	}
	public String getCompanyName4(PemProv fcompanyBean, UnitKerja fdivisionBean){
		String divisionOrCompanyID = fcompanyBean !=null? "C_" + fcompanyBean.getID():(fdivisionBean !=null? "D_" + fdivisionBean.getID():"") ;
		String sysvarID = "COMP_NAME_";		
		if (fcompanyBean !=null ) {
			return sysvarJpaService.findById(fcompanyBean, sysvarID + divisionOrCompanyID).getNilaiString1();
		} else {
			return sysvarJpaService.findById(fdivisionBean, sysvarID + divisionOrCompanyID).getNilaiString1();
		}		
	}
	public String getCompanyAddress5(PemProv fcompanyBean, UnitKerja fdivisionBean){ 
		String divisionOrCompanyID = fcompanyBean !=null? "C_" + fcompanyBean.getID():(fdivisionBean !=null? "D_" + fdivisionBean.getID():"") ;
		String sysvarID = "COMP_ADDR_";		
		if (fcompanyBean !=null ) {
			return sysvarJpaService.findById(fcompanyBean, sysvarID + divisionOrCompanyID).getNilaiString1();
		} else {
			return sysvarJpaService.findById(fdivisionBean, sysvarID + divisionOrCompanyID).getNilaiString1();
		}
	}
	public String getCompanyCity6(PemProv fcompanyBean, UnitKerja fdivisionBean){ 
		String divisionOrCompanyID = fcompanyBean !=null? "C_" + fcompanyBean.getID():(fdivisionBean !=null? "D_" + fdivisionBean.getID():"") ;
		String sysvarID = "COMP_CITY_";		
		if (fcompanyBean !=null ) {
			return sysvarJpaService.findById(fcompanyBean, sysvarID + divisionOrCompanyID).getNilaiString1();
		} else {
			return sysvarJpaService.findById(fdivisionBean, sysvarID + divisionOrCompanyID).getNilaiString1();
		}
	}
	public String getCompanyPhone7(PemProv fcompanyBean, UnitKerja fdivisionBean){
		String divisionOrCompanyID = fcompanyBean !=null? "C_" + fcompanyBean.getID():(fdivisionBean !=null? "D_" + fdivisionBean.getID():"") ;
		String sysvarID = "COMP_PHONE_";		
		if (fcompanyBean !=null ) {
			return sysvarJpaService.findById(fcompanyBean, sysvarID + divisionOrCompanyID).getNilaiString1();
		} else {
			return sysvarJpaService.findById(fdivisionBean, sysvarID + divisionOrCompanyID).getNilaiString1();
		}
	}
	public String getJudulPadaFakturPenjualanTunai8(PemProv fcompanyBean, UnitKerja fdivisionBean){
		String divisionOrCompanyID = fcompanyBean !=null? "C_" + fcompanyBean.getID():(fdivisionBean !=null? "D_" + fdivisionBean.getID():"") ;
		String sysvarID = "JUDUL_FAKTUR_J_T_";		
		if (fcompanyBean !=null ) {
			return sysvarJpaService.findById(fcompanyBean, sysvarID + divisionOrCompanyID).getNilaiString1();
		} else {
			return sysvarJpaService.findById(fdivisionBean, sysvarID + divisionOrCompanyID).getNilaiString1();
		}
	}
	public String getJudulPadaFakturPenjualanKredit9(PemProv fcompanyBean, UnitKerja fdivisionBean){
		String divisionOrCompanyID = fcompanyBean !=null? "C_" + fcompanyBean.getID():(fdivisionBean !=null? "D_" + fdivisionBean.getID():"") ;
		String sysvarID = "JUDUL_FAKTUR_J_K_";		
		if (fcompanyBean !=null ) {
			return sysvarJpaService.findById(fcompanyBean, sysvarID + divisionOrCompanyID).getNilaiString1();
		} else {
			return sysvarJpaService.findById(fdivisionBean, sysvarID + divisionOrCompanyID).getNilaiString1();
		}
	}
	public String getJudulPadaFakturPenjualanRetur10(PemProv fcompanyBean, UnitKerja fdivisionBean){
		String divisionOrCompanyID = fcompanyBean !=null? "C_" + fcompanyBean.getID():(fdivisionBean !=null? "D_" + fdivisionBean.getID():"") ;
		String sysvarID = "JUDUL_FAKTUR_J_R_";		
		if (fcompanyBean !=null ) {
			return sysvarJpaService.findById(fcompanyBean, sysvarID + divisionOrCompanyID).getNilaiString1();
		} else {
			return sysvarJpaService.findById(fdivisionBean, sysvarID + divisionOrCompanyID).getNilaiString1();
		}
	}
	public String getFooter1PadaFakturPenjualan11(PemProv fcompanyBean, UnitKerja fdivisionBean){
		String divisionOrCompanyID = fcompanyBean !=null? "C_" + fcompanyBean.getID():(fdivisionBean !=null? "D_" + fdivisionBean.getID():"") ;
		String sysvarID = "FOOTER1_FAK_J_R_";		
		if (fcompanyBean !=null ) {
			return sysvarJpaService.findById(fcompanyBean, sysvarID + divisionOrCompanyID).getNilaiString1();
		} else {
			return sysvarJpaService.findById(fdivisionBean, sysvarID + divisionOrCompanyID).getNilaiString1();
		}
	}
	public String getFooter2PadaFakturPenjualan12(PemProv fcompanyBean, UnitKerja fdivisionBean){
		String divisionOrCompanyID = fcompanyBean !=null? "C_" + fcompanyBean.getID():(fdivisionBean !=null? "D_" + fdivisionBean.getID():"") ;
		String sysvarID = "FOOTER2_FAK_J_R_";		
		if (fcompanyBean !=null ) {
			return sysvarJpaService.findById(fcompanyBean, sysvarID + divisionOrCompanyID).getNilaiString1();
		} else {
			return sysvarJpaService.findById(fdivisionBean, sysvarID + divisionOrCompanyID).getNilaiString1();
		}
	}

	
	public String getDefaultCurrency11(PemProv fcompanyBean, UnitKerja fdivisionBean){
		String divisionOrCompanyID = fcompanyBean !=null? "C_" + fcompanyBean.getID():(fdivisionBean !=null? "D_" + fdivisionBean.getID():"") ;
		String sysvarID = "CURRENCY_";	
		if (fcompanyBean !=null ) {
			return sysvarJpaService.findById(fcompanyBean, sysvarID + divisionOrCompanyID).getNilaiString1();
		} else {
			return sysvarJpaService.findById(fdivisionBean, sysvarID + divisionOrCompanyID).getNilaiString1();
		}
	}	
	
	public Date getTanggalTransaksiBerjalan12(PemProv fcompanyBean, UnitKerja fdivisionBean){
		String divisionOrCompanyID = fcompanyBean !=null? "C_" + fcompanyBean.getID():(fdivisionBean !=null? "D_" + fdivisionBean.getID():"") ;
		String sysvarID = "TR_DATE_";		
		if (fcompanyBean !=null ) {
			return sysvarJpaService.findById(fcompanyBean, sysvarID + divisionOrCompanyID).getNilaiDate1();
		} else {
			return sysvarJpaService.findById(fdivisionBean, sysvarID + divisionOrCompanyID).getNilaiDate1();
		}
	}
	public int getMaxStockBaseFromSystemDate12_2(PemProv fcompanyBean, UnitKerja fdivisionBean){
		String divisionOrCompanyID = fcompanyBean !=null? "C_" + fcompanyBean.getID():(fdivisionBean !=null? "D_" + fdivisionBean.getID():"") ;
		String sysvarID = "MAXDT_STK_BASE_";		
		if (fcompanyBean !=null ) {
			return sysvarJpaService.findById(fcompanyBean, sysvarID + divisionOrCompanyID).getNilaiInt1();
		} else {
			return sysvarJpaService.findById(fdivisionBean, sysvarID + divisionOrCompanyID).getNilaiInt1();
		}
	}
	
	public int getTahunTransaksiBerjalan13(PemProv fcompanyBean, UnitKerja fdivisionBean){
		String divisionOrCompanyID = fcompanyBean !=null? "C_" + fcompanyBean.getID():(fdivisionBean !=null? "D_" + fdivisionBean.getID():"") ;
		String sysvarID = "TR_YEAR_";		
		if (fcompanyBean !=null ) {
			return sysvarJpaService.findById(fcompanyBean, sysvarID + divisionOrCompanyID).getNilaiInt1();
		} else {
			return sysvarJpaService.findById(fdivisionBean, sysvarID + divisionOrCompanyID).getNilaiInt1();
		}
	}
	public int getPeriodeTahunAkuntansiBerjalan14(PemProv fcompanyBean, UnitKerja fdivisionBean){
		String divisionOrCompanyID = fcompanyBean !=null? "C_" + fcompanyBean.getID():(fdivisionBean !=null? "D_" + fdivisionBean.getID():"") ;
		String sysvarID = "TR_ACC_YEAR_";		
		if (fcompanyBean !=null ) {
			return sysvarJpaService.findById(fcompanyBean, sysvarID + divisionOrCompanyID).getNilaiInt1();
		} else {
			return sysvarJpaService.findById(fdivisionBean, sysvarID + divisionOrCompanyID).getNilaiInt1();
		}
	}
	public int getPeriodeBulanAkuntansiBerjalan15(PemProv fcompanyBean, UnitKerja fdivisionBean){
		String divisionOrCompanyID = fcompanyBean !=null? "C_" + fcompanyBean.getID():(fdivisionBean !=null? "D_" + fdivisionBean.getID():"") ;
		String sysvarID = "TR_ACC_MONTH_";		
		if (fcompanyBean !=null ) {
			return sysvarJpaService.findById(fcompanyBean, sysvarID + divisionOrCompanyID).getNilaiInt1();
		} else {
			return sysvarJpaService.findById(fdivisionBean, sysvarID + divisionOrCompanyID).getNilaiInt1();
		}
	}
	public boolean getStatusSistemSedangProsesAkhirHari16(PemProv fcompanyBean, UnitKerja fdivisionBean){
		String divisionOrCompanyID = fcompanyBean !=null? "C_" + fcompanyBean.getID():(fdivisionBean !=null? "D_" + fdivisionBean.getID():"") ;
		String sysvarID = "PAH_MODE_";		
		if (fcompanyBean !=null ) {
			return sysvarJpaService.findById(fcompanyBean, sysvarID + divisionOrCompanyID).isNilaiBol1();
		} else {
			return sysvarJpaService.findById(fdivisionBean, sysvarID + divisionOrCompanyID).isNilaiBol1();
		}
	}
	public boolean getStatusSistemSedangProsesAkhirTahun17(PemProv fcompanyBean, UnitKerja fdivisionBean){
		String divisionOrCompanyID = fcompanyBean !=null? "C_" + fcompanyBean.getID():(fdivisionBean !=null? "D_" + fdivisionBean.getID():"") ;
		String sysvarID = "PAT_MODE_";		
		if (fcompanyBean !=null ) {
			return sysvarJpaService.findById(fcompanyBean, sysvarID + divisionOrCompanyID).isNilaiBol1();
		} else {
			return sysvarJpaService.findById(fdivisionBean, sysvarID + divisionOrCompanyID).isNilaiBol1();
		}
	}

	public boolean isLockMenuScreenHutangDebitCredit_18_1(PemProv fcompanyBean, UnitKerja fdivisionBean){
		String divisionOrCompanyID = fcompanyBean !=null? "C_" + fcompanyBean.getID():(fdivisionBean !=null? "D_" + fdivisionBean.getID():"") ;
		String sysvarID = "LK_HUT_DBTCRDT";		
		if (fcompanyBean !=null ) {
			return sysvarJpaService.findById(fcompanyBean, sysvarID + divisionOrCompanyID).isNilaiBol1();
		} else {
			return sysvarJpaService.findById(fdivisionBean, sysvarID + divisionOrCompanyID).isNilaiBol1();
		}
	}
	public boolean isLockMenuScreenPiutangDebitCredit_18_2(PemProv fcompanyBean, UnitKerja fdivisionBean){
		String divisionOrCompanyID = fcompanyBean !=null? "C_" + fcompanyBean.getID():(fdivisionBean !=null? "D_" + fdivisionBean.getID():"") ;
		String sysvarID = "LK_PIUT_DBTCRDT";		
		if (fcompanyBean !=null ) {
			return sysvarJpaService.findById(fcompanyBean, sysvarID + divisionOrCompanyID).isNilaiBol1();
		} else {
			return sysvarJpaService.findById(fdivisionBean, sysvarID + divisionOrCompanyID).isNilaiBol1();
		}
	}
	
	//* B1. UMUM FORM PENJUALAN DAN PIUTANG##
	public int getMaxLamaKredit1(PemProv fcompanyBean, UnitKerja fdivisionBean){
		String divisionOrCompanyID = fcompanyBean !=null? "C_" + fcompanyBean.getID():(fdivisionBean !=null? "D_" + fdivisionBean.getID():"") ;
		String sysvarID = "LAMA_KREDIT_";		
		if (fcompanyBean !=null ) {
			return sysvarJpaService.findById(fcompanyBean, sysvarID + divisionOrCompanyID).getNilaiInt1();
		} else {
			return sysvarJpaService.findById(fdivisionBean, sysvarID + divisionOrCompanyID).getNilaiInt1();
		}
	}
	public String getProteksiInputPenjualanStokGudangBolehMinus2(PemProv fcompanyBean, UnitKerja fdivisionBean){
		String divisionOrCompanyID = fcompanyBean !=null? "C_" + fcompanyBean.getID():(fdivisionBean !=null? "D_" + fdivisionBean.getID():"") ;
		String sysvarID = "ALLOW_STOCK_MINUS_";		
		if (fcompanyBean !=null ) {
			return sysvarJpaService.findById(fcompanyBean, sysvarID + divisionOrCompanyID).getNilaiString1();
		} else {
			return sysvarJpaService.findById(fdivisionBean, sysvarID + divisionOrCompanyID).getNilaiString1();
		}
	}
	public int getToleransiLockTransaksiPenjualan3(PemProv fcompanyBean, UnitKerja fdivisionBean){
		String divisionOrCompanyID = fcompanyBean !=null? "C_" + fcompanyBean.getID():(fdivisionBean !=null? "D_" + fdivisionBean.getID():"") ;
		String sysvarID = "LOCK_TOLE_JUAL_";		
		if (fcompanyBean !=null ) {
			return sysvarJpaService.findById(fcompanyBean, sysvarID + divisionOrCompanyID).getNilaiInt1();
		} else {
			return sysvarJpaService.findById(fdivisionBean, sysvarID + divisionOrCompanyID).getNilaiInt1();
		}
	}
	public int getToleransiLockTransaksiPenjualan_Retur3_2(PemProv fcompanyBean, UnitKerja fdivisionBean){
		String divisionOrCompanyID = fcompanyBean !=null? "C_" + fcompanyBean.getID():(fdivisionBean !=null? "D_" + fdivisionBean.getID():"") ;
		String sysvarID = "LK_TL_JL_R_";
		if (fcompanyBean !=null ) {
			return sysvarJpaService.findById(fcompanyBean, sysvarID + divisionOrCompanyID).getNilaiInt1();			
		} else {
			System.out.println("test bos: " + sysvarJpaService.findById(fdivisionBean, sysvarID + divisionOrCompanyID).getId());
			return sysvarJpaService.findById(fdivisionBean, sysvarID + divisionOrCompanyID).getNilaiInt1();
		}
	}
	public int getToleransiLockPelunasanPiutang4(PemProv fcompanyBean, UnitKerja fdivisionBean){
		String divisionOrCompanyID = fcompanyBean !=null? "C_" + fcompanyBean.getID():(fdivisionBean !=null? "D_" + fdivisionBean.getID():"") ;
		String sysvarID = "LOCK_TOLE_AR";		
		if (fcompanyBean !=null ) {
			return sysvarJpaService.findById(fcompanyBean, sysvarID + divisionOrCompanyID).getNilaiInt1();
		} else {
			return sysvarJpaService.findById(fdivisionBean, sysvarID + divisionOrCompanyID).getNilaiInt1();
		}
	}
	public int getToleransiLockTransaksiPembelian32(PemProv fcompanyBean, UnitKerja fdivisionBean){
		String divisionOrCompanyID = fcompanyBean !=null? "C_" + fcompanyBean.getID():(fdivisionBean !=null? "D_" + fdivisionBean.getID():"") ;
		String sysvarID = "LOCK_TOLE_BELI_";		
		if (fcompanyBean !=null ) {
			return sysvarJpaService.findById(fcompanyBean, sysvarID + divisionOrCompanyID).getNilaiInt1();
		} else {
			return sysvarJpaService.findById(fdivisionBean, sysvarID + divisionOrCompanyID).getNilaiInt1();
		}
	}
	public int getToleransiLockTransaksiPembelian_Retur32_2(PemProv fcompanyBean, UnitKerja fdivisionBean){
		String divisionOrCompanyID = fcompanyBean !=null? "C_" + fcompanyBean.getID():(fdivisionBean !=null? "D_" + fdivisionBean.getID():"") ;
		String sysvarID = "LK_TL_BL_R_";		
		if (fcompanyBean !=null ) {
			return sysvarJpaService.findById(fcompanyBean, sysvarID + divisionOrCompanyID).getNilaiInt1();
		} else {
			return sysvarJpaService.findById(fdivisionBean, sysvarID + divisionOrCompanyID).getNilaiInt1();
		}
	}
	public int getToleransiLockPelunasanHutang42(PemProv fcompanyBean, UnitKerja fdivisionBean){
		String divisionOrCompanyID = fcompanyBean !=null? "C_" + fcompanyBean.getID():(fdivisionBean !=null? "D_" + fdivisionBean.getID():"") ;
		String sysvarID = "LOCK_TOLE_AP";		
		if (fcompanyBean !=null ) {
			return sysvarJpaService.findById(fcompanyBean, sysvarID + divisionOrCompanyID).getNilaiInt1();
		} else {
			return sysvarJpaService.findById(fdivisionBean, sysvarID + divisionOrCompanyID).getNilaiInt1();
		}
	}
	public int getToleransiLockCashBank16(PemProv fcompanyBean, UnitKerja fdivisionBean){
		String divisionOrCompanyID = fcompanyBean !=null? "C_" + fcompanyBean.getID():(fdivisionBean !=null? "D_" + fdivisionBean.getID():"") ;
		String sysvarID = "LOCK_TOLE_CB";		
		if (fcompanyBean !=null ) {
			return sysvarJpaService.findById(fcompanyBean, sysvarID + divisionOrCompanyID).getNilaiInt1();
		} else {
			return sysvarJpaService.findById(fdivisionBean, sysvarID + divisionOrCompanyID).getNilaiInt1();
		}
	}
	
	public String getJenisProteksiCreditLimitInvoice5(PemProv fcompanyBean, UnitKerja fdivisionBean){
		String divisionOrCompanyID = fcompanyBean !=null? "C_" + fcompanyBean.getID():(fdivisionBean !=null? "D_" + fdivisionBean.getID():"") ;
		String sysvarID = "PR_INV_CR_LIMIT_";		
		if (fcompanyBean !=null ) {
			return sysvarJpaService.findById(fcompanyBean, sysvarID + divisionOrCompanyID).getNilaiString1();
		} else {
			return sysvarJpaService.findById(fdivisionBean, sysvarID + divisionOrCompanyID).getNilaiString1();
		}
	}
	public String getJenisProteksiMaxInvoice6(PemProv fcompanyBean, UnitKerja fdivisionBean){
		String divisionOrCompanyID = fcompanyBean !=null? "C_" + fcompanyBean.getID():(fdivisionBean !=null? "D_" + fdivisionBean.getID():"") ;
		String sysvarID = "PR_INV_MAX_INV_";		
		if (fcompanyBean !=null ) {
			return sysvarJpaService.findById(fcompanyBean, sysvarID + divisionOrCompanyID).getNilaiString1();
		} else {
			return sysvarJpaService.findById(fdivisionBean, sysvarID + divisionOrCompanyID).getNilaiString1();
		}
	}
	public boolean isPlafonKreditPerSalesman7(PemProv fcompanyBean, UnitKerja fdivisionBean){
		String divisionOrCompanyID = fcompanyBean !=null? "C_" + fcompanyBean.getID():(fdivisionBean !=null? "D_" + fdivisionBean.getID():"") ;
		String sysvarID = "CR_LIM_PR_SLM_";		
		if (fcompanyBean !=null ) {
			return sysvarJpaService.findById(fcompanyBean, sysvarID + divisionOrCompanyID).isNilaiBol1();
		} else {
			return sysvarJpaService.findById(fdivisionBean, sysvarID + divisionOrCompanyID).isNilaiBol1();
		}
	}
	public boolean isMaxInvoicePerSalesman8(PemProv fcompanyBean, UnitKerja fdivisionBean){
		String divisionOrCompanyID = fcompanyBean !=null? "C_" + fcompanyBean.getID():(fdivisionBean !=null? "D_" + fdivisionBean.getID():"") ;
		String sysvarID = "MAX_INV_PR_SLM_";		
		if (fcompanyBean !=null ) {
			return sysvarJpaService.findById(fcompanyBean, sysvarID + divisionOrCompanyID).isNilaiBol1();
		} else {
			return sysvarJpaService.findById(fdivisionBean, sysvarID + divisionOrCompanyID).isNilaiBol1();
		}
	}

	public boolean isFakturTerbitTidakBolehEdit9(PemProv fcompanyBean, UnitKerja fdivisionBean){
		String divisionOrCompanyID = fcompanyBean !=null? "C_" + fcompanyBean.getID():(fdivisionBean !=null? "D_" + fdivisionBean.getID():"") ;
		String sysvarID = "NO_EDIT_PRN_INV_";		
		if (fcompanyBean !=null ) {
			return sysvarJpaService.findById(fcompanyBean, sysvarID + divisionOrCompanyID).isNilaiBol1();
		} else {
			return sysvarJpaService.findById(fdivisionBean, sysvarID + divisionOrCompanyID).isNilaiBol1();
		}
	}
	public boolean isFakturTerbitSJPengirimanTidakBolehEdit10(PemProv fcompanyBean, UnitKerja fdivisionBean){
		String divisionOrCompanyID = fcompanyBean !=null? "C_" + fcompanyBean.getID():(fdivisionBean !=null? "D_" + fdivisionBean.getID():"") ;
		String sysvarID = "NO_EDIT_PRN_SJP_";		
		if (fcompanyBean !=null ) {
			return sysvarJpaService.findById(fcompanyBean, sysvarID + divisionOrCompanyID).isNilaiBol1();
		} else {
			return sysvarJpaService.findById(fdivisionBean, sysvarID + divisionOrCompanyID).isNilaiBol1();
		}
	}
	
	public boolean isLockHargaJualPadaInputPenjualan11(PemProv fcompanyBean, UnitKerja fdivisionBean){
		String divisionOrCompanyID = fcompanyBean !=null? "C_" + fcompanyBean.getID():(fdivisionBean !=null? "D_" + fdivisionBean.getID():"") ;
		String sysvarID = "LOCK_HJUAL_FJUAL_";	
		if (fcompanyBean !=null ) {
			return sysvarJpaService.findById(fcompanyBean, sysvarID + divisionOrCompanyID).isNilaiBol1();
		} else {
			return sysvarJpaService.findById(fdivisionBean, sysvarID + divisionOrCompanyID).isNilaiBol1();
		}
	}
	public boolean isLockDiskonItemPadaInputPenjualan12(PemProv fcompanyBean, UnitKerja fdivisionBean){
		String divisionOrCompanyID = fcompanyBean !=null? "C_" + fcompanyBean.getID():(fdivisionBean !=null? "D_" + fdivisionBean.getID():"") ;
		String sysvarID = "LOCK_DISC_FJUAL_";		
		if (fcompanyBean !=null ) {
			return sysvarJpaService.findById(fcompanyBean, sysvarID + divisionOrCompanyID).isNilaiBol1();
		} else {
			return sysvarJpaService.findById(fdivisionBean, sysvarID + divisionOrCompanyID).isNilaiBol1();
		}
	}
	public boolean isLockHargaBeliPadaInputPembelian111(PemProv fcompanyBean, UnitKerja fdivisionBean){
		String divisionOrCompanyID = fcompanyBean !=null? "C_" + fcompanyBean.getID():(fdivisionBean !=null? "D_" + fdivisionBean.getID():"") ;
		String sysvarID = "LK_HBELI_FBELI_";	
		if (fcompanyBean !=null ) {
			return sysvarJpaService.findById(fcompanyBean, sysvarID + divisionOrCompanyID).isNilaiBol1();
		} else {
			return sysvarJpaService.findById(fdivisionBean, sysvarID + divisionOrCompanyID).isNilaiBol1();
		}
	}
	public boolean isLockDiskonItemPadaInputPembelian121(PemProv fcompanyBean, UnitKerja fdivisionBean){
		String divisionOrCompanyID = fcompanyBean !=null? "C_" + fcompanyBean.getID():(fdivisionBean !=null? "D_" + fdivisionBean.getID():"") ;
		String sysvarID = "LK_DISC_FBELI_";		
		if (fcompanyBean !=null ) {
			return sysvarJpaService.findById(fcompanyBean, sysvarID + divisionOrCompanyID).isNilaiBol1();
		} else {
			return sysvarJpaService.findById(fdivisionBean, sysvarID + divisionOrCompanyID).isNilaiBol1();
		}
	}
	
	public String getJenisProteksiCreditLimitInputOrder13(PemProv fcompanyBean, UnitKerja fdivisionBean){
		String divisionOrCompanyID = fcompanyBean !=null? "C_" + fcompanyBean.getID():(fdivisionBean !=null? "D_" + fdivisionBean.getID():"") ;
		String sysvarID = "PR_ORD_CR_LIMIT_";		
		if (fcompanyBean !=null ) {
			return sysvarJpaService.findById(fcompanyBean, sysvarID + divisionOrCompanyID).getNilaiString1();
		} else {
			return sysvarJpaService.findById(fdivisionBean, sysvarID + divisionOrCompanyID).getNilaiString1();
		}
	}
	public String getJenisProteksiMaxInvoiceInputOrder14(PemProv fcompanyBean, UnitKerja fdivisionBean){
		String divisionOrCompanyID = fcompanyBean !=null? "C_" + fcompanyBean.getID():(fdivisionBean !=null? "D_" + fdivisionBean.getID():"") ;
		String sysvarID = "PR_ORD_MAX_INV_";		
		if (fcompanyBean !=null ) {
			return sysvarJpaService.findById(fcompanyBean, sysvarID + divisionOrCompanyID).getNilaiString1();
		} else {
			return sysvarJpaService.findById(fdivisionBean, sysvarID + divisionOrCompanyID).getNilaiString1();
		}
	}
	public String getProteksiInputPenjualanStokAvailableBolehMinus15(PemProv fcompanyBean, UnitKerja fdivisionBean){
		String divisionOrCompanyID = fcompanyBean !=null? "C_" + fcompanyBean.getID():(fdivisionBean !=null? "D_" + fdivisionBean.getID():"") ;
		String sysvarID = "ALLOW_STO_AVAI_MIN_";		
		if (fcompanyBean !=null ) {
			return sysvarJpaService.findById(fcompanyBean, sysvarID + divisionOrCompanyID).getNilaiString1();
		} else {
			return sysvarJpaService.findById(fdivisionBean, sysvarID + divisionOrCompanyID).getNilaiString1();
		}
	}
	public boolean isLockIsianPotonganPenjualanPadaAR_16(PemProv fcompanyBean, UnitKerja fdivisionBean){
		String divisionOrCompanyID = fcompanyBean !=null? "C_" + fcompanyBean.getID():(fdivisionBean !=null? "D_" + fdivisionBean.getID():"") ;
		String sysvarID = "LK_POT_AR_";	
		if (fcompanyBean !=null ) {
			return sysvarJpaService.findById(fcompanyBean, sysvarID + divisionOrCompanyID).isNilaiBol1();
		} else {
			return sysvarJpaService.findById(fdivisionBean, sysvarID + divisionOrCompanyID).isNilaiBol1();
		}
	}
	
	
	public boolean getSalesmanDanWarehousePadaNewFormAmbilDariInputSebelumnya21(PemProv fcompanyBean, UnitKerja fdivisionBean){
		String divisionOrCompanyID = fcompanyBean !=null? "C_" + fcompanyBean.getID():(fdivisionBean !=null? "D_" + fdivisionBean.getID():"") ;
		String sysvarID = "CWH_FROM_BEF_";		
		if (fcompanyBean !=null ) {
			return sysvarJpaService.findById(fcompanyBean, sysvarID + divisionOrCompanyID).isNilaiBol1();
		} else {
			return sysvarJpaService.findById(fdivisionBean, sysvarID + divisionOrCompanyID).isNilaiBol1();
		}
	}	
	public int getDefaultHargaPadaReturPenjualan_22(PemProv fcompanyBean, UnitKerja fdivisionBean){
		String divisionOrCompanyID = fcompanyBean !=null? "C_" + fcompanyBean.getID():(fdivisionBean !=null? "D_" + fdivisionBean.getID():"") ;
		String sysvarID = "HRG_RET_JL_";		
		if (fcompanyBean !=null ) {
			return sysvarJpaService.findById(fcompanyBean, sysvarID + divisionOrCompanyID).getNilaiInt1();
		} else {
			return sysvarJpaService.findById(fdivisionBean, sysvarID + divisionOrCompanyID).getNilaiInt1();
		}
	}
	public boolean isCustomerTunaiBolehPenjualanKredit22(PemProv fcompanyBean, UnitKerja fdivisionBean){
		String divisionOrCompanyID = fcompanyBean !=null? "C_" + fcompanyBean.getID():(fdivisionBean !=null? "D_" + fdivisionBean.getID():"") ;
		String sysvarID = "CUST_T_JL_K_";		
		if (fcompanyBean !=null ) {
			return sysvarJpaService.findById(fcompanyBean, sysvarID + divisionOrCompanyID).isNilaiBol1();
		} else {
			return sysvarJpaService.findById(fdivisionBean, sysvarID + divisionOrCompanyID).isNilaiBol1();
		}
	}	
	
	
	
//	 * B2. UMUM FORM PEMBELIAN ##
	public boolean getEntryItemPembelianMenggunakanhargaAfterPpn1(PemProv fcompanyBean, UnitKerja fdivisionBean){
		String divisionOrCompanyID = fcompanyBean !=null? "C_" + fcompanyBean.getID():(fdivisionBean !=null? "D_" + fdivisionBean.getID():"") ;
		String sysvarID = "ENT_ITM_BL_AFTPPN_";		
		if (fcompanyBean !=null ) {
			return sysvarJpaService.findById(fcompanyBean, sysvarID + divisionOrCompanyID).isNilaiBol1();
		} else {
			return sysvarJpaService.findById(fdivisionBean, sysvarID + divisionOrCompanyID).isNilaiBol1();
		}
	}
	public boolean getEntryPembelianDanReturMenggunakanTanggalSistem2(PemProv fcompanyBean, UnitKerja fdivisionBean){
		String divisionOrCompanyID = fcompanyBean !=null? "C_" + fcompanyBean.getID():(fdivisionBean !=null? "D_" + fdivisionBean.getID():"") ;
		String sysvarID = "ENT_BL_R_TGL_APP_";		
		if (fcompanyBean !=null ) {
			return sysvarJpaService.findById(fcompanyBean, sysvarID + divisionOrCompanyID).isNilaiBol1();
		} else {
			return sysvarJpaService.findById(fdivisionBean, sysvarID + divisionOrCompanyID).isNilaiBol1();
		}
	}
	public boolean getAutoUpdateHrgBeliMasterBarangSaatInputPembelian3(PemProv fcompanyBean, UnitKerja fdivisionBean){
		String divisionOrCompanyID = fcompanyBean !=null? "C_" + fcompanyBean.getID():(fdivisionBean !=null? "D_" + fdivisionBean.getID():"") ;
		String sysvarID = "ENT_AU_UPD_H_BL";		
		if (fcompanyBean !=null ) {
			return sysvarJpaService.findById(fcompanyBean, sysvarID + divisionOrCompanyID).isNilaiBol1();
		} else {
			return sysvarJpaService.findById(fdivisionBean, sysvarID + divisionOrCompanyID).isNilaiBol1();
		}
	}
	public boolean getAutoUpdateHrgBeliAfterDiscMasterBarangSaatInputPembelian4(PemProv fcompanyBean, UnitKerja fdivisionBean){
		String divisionOrCompanyID = fcompanyBean !=null? "C_" + fcompanyBean.getID():(fdivisionBean !=null? "D_" + fdivisionBean.getID():"") ;
		String sysvarID = "ENT_AU_UPD_H_BL_PPN_";		
		if (fcompanyBean !=null ) {
			return sysvarJpaService.findById(fcompanyBean, sysvarID + divisionOrCompanyID).isNilaiBol1();
		} else {
			return sysvarJpaService.findById(fdivisionBean, sysvarID + divisionOrCompanyID).isNilaiBol1();
		}
	}
		
	
//	 * C. PERPAJAKAN ## : Tidak berlaku untuk divisi
	public String getNamaPerusahaanKenaPajak1(PemProv fcompanyBean, UnitKerja fdivisionBean){
		String divisionOrCompanyID = fcompanyBean !=null? "C_" + fcompanyBean.getID():(fdivisionBean !=null? "D_" + fdivisionBean.getID():"") ;
		String sysvarID = "PKP_PRSH_";		
		if (fcompanyBean !=null ) {
			return sysvarJpaService.findById(fcompanyBean, sysvarID + divisionOrCompanyID).getNilaiString1();
		} else {
			return sysvarJpaService.findById(fdivisionBean, sysvarID + divisionOrCompanyID).getNilaiString1();
		}
	}
	public String getNamaPengusahaKenaPajak2(PemProv fcompanyBean, UnitKerja fdivisionBean){
		String divisionOrCompanyID = fcompanyBean !=null? "C_" + fcompanyBean.getID():(fdivisionBean !=null? "D_" + fdivisionBean.getID():"") ;
		String sysvarID = "PKP_PENGUSAHA_";		
		if (fcompanyBean !=null ) {
			return sysvarJpaService.findById(fcompanyBean, sysvarID + divisionOrCompanyID).getNilaiString1();
		} else {
			return sysvarJpaService.findById(fdivisionBean, sysvarID + divisionOrCompanyID).getNilaiString1();
		}
	}
	public String getPkpNPWP3(PemProv fcompanyBean, UnitKerja fdivisionBean){
		String divisionOrCompanyID = fcompanyBean !=null? "C_" + fcompanyBean.getID():(fdivisionBean !=null? "D_" + fdivisionBean.getID():"") ;
		String sysvarID = "PKP_NPWP_";		
		if (fcompanyBean !=null ) {
			return sysvarJpaService.findById(fcompanyBean, sysvarID + divisionOrCompanyID).getNilaiString1();
		} else {
			return sysvarJpaService.findById(fdivisionBean, sysvarID + divisionOrCompanyID).getNilaiString1();
		}
	}
	public int getNomorUrutSeriPajakJatah31_Nilai1(PemProv fcompanyBean, UnitKerja fdivisionBean){
		String divisionOrCompanyID = fcompanyBean !=null? "C_" + fcompanyBean.getID():(fdivisionBean !=null? "D_" + fdivisionBean.getID():"") ;
		String sysvarID = "URUT_TAX_JTH_";		
		if (fcompanyBean !=null ) {
			return sysvarJpaService.findById(fcompanyBean, sysvarID + divisionOrCompanyID).getNilaiInt1();
		} else {
			return sysvarJpaService.findById(fdivisionBean, sysvarID + divisionOrCompanyID).getNilaiInt1();
		}
	}
	public int getNomorUrutSeriPajakJatah31_Nilai2(PemProv fcompanyBean, UnitKerja fdivisionBean){
		String divisionOrCompanyID = fcompanyBean !=null? "C_" + fcompanyBean.getID():(fdivisionBean !=null? "D_" + fdivisionBean.getID():"") ;
		String sysvarID = "URUT_TAX_";		
		if (fcompanyBean !=null ) {
			return sysvarJpaService.findById(fcompanyBean, sysvarID + divisionOrCompanyID).getNilaiInt2();
		} else {
			return sysvarJpaService.findById(fdivisionBean, sysvarID + divisionOrCompanyID).getNilaiInt2();
		}
	}
	
	public Sysvar getNomorUrutSeriPajakKeluaranBerjalan32(PemProv fcompanyBean, UnitKerja fdivisionBean){
		String divisionOrCompanyID = fcompanyBean !=null? "C_" + fcompanyBean.getID():(fdivisionBean !=null? "D_" + fdivisionBean.getID():"") ;
		String sysvarID = "URUT_TAX_";		
		if (fcompanyBean !=null ) {
			return sysvarJpaService.findById(fcompanyBean, sysvarID + divisionOrCompanyID);
		} else {
			return sysvarJpaService.findById(fdivisionBean, sysvarID + divisionOrCompanyID);
		}
	}
	public String getNomorUrutSeriPajakKeluaranBerjalan32_String1(PemProv fcompanyBean, UnitKerja fdivisionBean){
		String divisionOrCompanyID = fcompanyBean !=null? "C_" + fcompanyBean.getID():(fdivisionBean !=null? "D_" + fdivisionBean.getID():"") ;
		String sysvarID = "URUT_TAX_";		
		if (fcompanyBean !=null ) {
			return sysvarJpaService.findById(fcompanyBean, sysvarID + divisionOrCompanyID).getNilaiString1();
		} else {
			return sysvarJpaService.findById(fdivisionBean, sysvarID + divisionOrCompanyID).getNilaiString1();
		}
	}
	public String getNomorUrutSeriPajakKeluaranBerjalan32_String2(PemProv fcompanyBean, UnitKerja fdivisionBean){
		String divisionOrCompanyID = fcompanyBean !=null? "C_" + fcompanyBean.getID():(fdivisionBean !=null? "D_" + fdivisionBean.getID():"") ;
		String sysvarID = "URUT_TAX_";		
		if (fcompanyBean !=null ) {
			return sysvarJpaService.findById(fcompanyBean, sysvarID + divisionOrCompanyID).getNilaiString2();
		} else {
			return sysvarJpaService.findById(fdivisionBean, sysvarID + divisionOrCompanyID).getNilaiString2();
		}
	}
	
	public String getTanggalSkPengukuhanPKP4(PemProv fcompanyBean, UnitKerja fdivisionBean){
		String divisionOrCompanyID = fcompanyBean !=null? "C_" + fcompanyBean.getID():(fdivisionBean !=null? "D_" + fdivisionBean.getID():"") ;
		String sysvarID = "PKP_TGL_SK_";		
		if (fcompanyBean !=null ) {
			return sysvarJpaService.findById(fcompanyBean, sysvarID + divisionOrCompanyID).getNilaiString1();
		} else {
			return sysvarJpaService.findById(fdivisionBean, sysvarID + divisionOrCompanyID).getNilaiString1();
		}
	}
	public double getDefaultTaxPembelianPenjualan5(PemProv fcompanyBean, UnitKerja fdivisionBean){
		String divisionOrCompanyID = fcompanyBean !=null? "C_" + fcompanyBean.getID():(fdivisionBean !=null? "D_" + fdivisionBean.getID():"") ;
		String sysvarID = "TAX_PPN_PERCE_";		
		if (fcompanyBean !=null ) {
			return sysvarJpaService.findById(fcompanyBean, sysvarID + divisionOrCompanyID).getNilaiDouble1();
		} else {
			return sysvarJpaService.findById(fdivisionBean, sysvarID + divisionOrCompanyID).getNilaiDouble1();
		}
	}
	
//	 * D. NOMOR DOKUMEN MASTER## 	
	public String getNomorUrutCustomer1(PemProv fcompanyBean, UnitKerja fdivisionBean){
		String divisionOrCompanyID = fcompanyBean !=null? "C_" + fcompanyBean.getID():(fdivisionBean !=null? "D_" + fdivisionBean.getID():"") ;
		String sysvarID = "URUT_CUSTOMER_";		
		if (fcompanyBean !=null ) {
			return sysvarJpaService.findById(fcompanyBean, sysvarID + divisionOrCompanyID).getNilaiString1();
		} else {
			return sysvarJpaService.findById(fdivisionBean, sysvarID + divisionOrCompanyID).getNilaiString1();
		}
	}
	public String getNomorUrutMaterial2(PemProv fcompanyBean, UnitKerja fdivisionBean){
		String divisionOrCompanyID = fcompanyBean !=null? "C_" + fcompanyBean.getID():(fdivisionBean !=null? "D_" + fdivisionBean.getID():"") ;
		String sysvarID = "URUT_MATERIAL_";		
		if (fcompanyBean !=null ) {
			return sysvarJpaService.findById(fcompanyBean, sysvarID + divisionOrCompanyID).getNilaiString1();
		} else {
			return sysvarJpaService.findById(fdivisionBean, sysvarID + divisionOrCompanyID).getNilaiString1();
		}
	}
	public String getNomorUrutVendor3(PemProv fcompanyBean, UnitKerja fdivisionBean){
		String divisionOrCompanyID = fcompanyBean !=null? "C_" + fcompanyBean.getID():(fdivisionBean !=null? "D_" + fdivisionBean.getID():"") ;
		String sysvarID = "URUT_VENDOR_";		
		if (fcompanyBean !=null ) {
			return sysvarJpaService.findById(fcompanyBean, sysvarID + divisionOrCompanyID).getNilaiString1();
		} else {
			return sysvarJpaService.findById(fdivisionBean, sysvarID + divisionOrCompanyID).getNilaiString1();
		}
	}
	public String getNomorUrutSalesman4(PemProv fcompanyBean, UnitKerja fdivisionBean){
		String divisionOrCompanyID = fcompanyBean !=null? "C_" + fcompanyBean.getID():(fdivisionBean !=null? "D_" + fdivisionBean.getID():"") ;
		String sysvarID = "URUT_SALESMAN_";		
		if (fcompanyBean !=null ) {
			return sysvarJpaService.findById(fcompanyBean, sysvarID + divisionOrCompanyID).getNilaiString1();
		} else {
			return sysvarJpaService.findById(fdivisionBean, sysvarID + divisionOrCompanyID).getNilaiString1();
		}
	}

//	* E. NOMOR DOKUMEN TRANSAKSI## 
	public String getNomorUrutOrderPenjualan1(PemProv fcompanyBean, UnitKerja fdivisionBean){
		String divisionOrCompanyID = fcompanyBean !=null? "C_" + fcompanyBean.getID():(fdivisionBean !=null? "D_" + fdivisionBean.getID():"") ;
		String sysvarID = "URUT_ORDER_JUAL_";		
		if (fcompanyBean !=null ) {
			return sysvarJpaService.findById(fcompanyBean, sysvarID + divisionOrCompanyID).getNilaiString1();
		} else {
			return sysvarJpaService.findById(fdivisionBean, sysvarID + divisionOrCompanyID).getNilaiString1();
		}
	}
	public String getNomorUrutInvoicePenjualan2(PemProv fcompanyBean, UnitKerja fdivisionBean){
		String divisionOrCompanyID = fcompanyBean !=null? "C_" + fcompanyBean.getID():(fdivisionBean !=null? "D_" + fdivisionBean.getID():"") ;
		String sysvarID = "URUT_INV_JUAL_";		
		if (fcompanyBean !=null ) {
			return sysvarJpaService.findById(fcompanyBean, sysvarID + divisionOrCompanyID).getNilaiString1();
		} else {
			return sysvarJpaService.findById(fdivisionBean, sysvarID + divisionOrCompanyID).getNilaiString1();
		}
	}
	public String getNomorUrutDocReturPenjualan3(PemProv fcompanyBean, UnitKerja fdivisionBean){
		String divisionOrCompanyID = fcompanyBean !=null? "C_" + fcompanyBean.getID():(fdivisionBean !=null? "D_" + fdivisionBean.getID():"") ;
		String sysvarID = "URUT_RETUR_JUAL_";		
		if (fcompanyBean !=null ) {
			return sysvarJpaService.findById(fcompanyBean, sysvarID + divisionOrCompanyID).getNilaiString1();
		} else {
			return sysvarJpaService.findById(fdivisionBean, sysvarID + divisionOrCompanyID).getNilaiString1();
		}
	}
	public String getNomorUrutDocPOPembelian4(PemProv fcompanyBean, UnitKerja fdivisionBean){
		String divisionOrCompanyID = fcompanyBean !=null? "C_" + fcompanyBean.getID():(fdivisionBean !=null? "D_" + fdivisionBean.getID():"") ;
		String sysvarID = "URUT_PO_BELI_";		
		if (fcompanyBean !=null ) {
			return sysvarJpaService.findById(fcompanyBean, sysvarID + divisionOrCompanyID).getNilaiString1();
		} else {
			return sysvarJpaService.findById(fdivisionBean, sysvarID + divisionOrCompanyID).getNilaiString1();
		}
	}
	public String getNomorUrutDocReturPembelian5(PemProv fcompanyBean, UnitKerja fdivisionBean){
		String divisionOrCompanyID = fcompanyBean !=null? "C_" + fcompanyBean.getID():(fdivisionBean !=null? "D_" + fdivisionBean.getID():"") ;
		String sysvarID = "URUT_MUTASI_PER_";		
		if (fcompanyBean !=null ) {
			return sysvarJpaService.findById(fcompanyBean, sysvarID + divisionOrCompanyID).getNilaiString1();
		} else {
			return sysvarJpaService.findById(fdivisionBean, sysvarID + divisionOrCompanyID).getNilaiString1();
		}
	}
	public String getNomorUrutDocMutasiPersediaan6(PemProv fcompanyBean, UnitKerja fdivisionBean){
		String divisionOrCompanyID = fcompanyBean !=null? "C_" + fcompanyBean.getID():(fdivisionBean !=null? "D_" + fdivisionBean.getID():"") ;
		String sysvarID = "URUT_RETUR_BELI_";		
		if (fcompanyBean !=null ) {
			return sysvarJpaService.findById(fcompanyBean, sysvarID + divisionOrCompanyID).getNilaiString1();
		} else {
			return sysvarJpaService.findById(fdivisionBean, sysvarID + divisionOrCompanyID).getNilaiString1();
		}
	}
	public String getNomorUrutDocStockOpname7(PemProv fcompanyBean, UnitKerja fdivisionBean){
		String divisionOrCompanyID = fcompanyBean !=null? "C_" + fcompanyBean.getID():(fdivisionBean !=null? "D_" + fdivisionBean.getID():"") ;
		String sysvarID = "URUT_STOK_OPNAM_";		
		if (fcompanyBean !=null ) {
			return sysvarJpaService.findById(fcompanyBean, sysvarID + divisionOrCompanyID).getNilaiString1();
		} else {
			return sysvarJpaService.findById(fdivisionBean, sysvarID + divisionOrCompanyID).getNilaiString1();
		}
	}
	public String getNomorPromotionRules8(PemProv fcompanyBean, UnitKerja fdivisionBean){
		String divisionOrCompanyID = fcompanyBean !=null? "C_" + fcompanyBean.getID():(fdivisionBean !=null? "D_" + fdivisionBean.getID():"") ;
		String sysvarID = "URUT_PROMO_RULE_";		
		if (fcompanyBean !=null ) {
			return sysvarJpaService.findById(fcompanyBean, sysvarID + divisionOrCompanyID).getNilaiString1();
		} else {
			return sysvarJpaService.findById(fdivisionBean, sysvarID + divisionOrCompanyID).getNilaiString1();
		}
	}
	
	public String getNomorUrutSuratJalanPengiriman9(PemProv fcompanyBean, UnitKerja fdivisionBean){
		String divisionOrCompanyID = fcompanyBean !=null? "C_" + fcompanyBean.getID():(fdivisionBean !=null? "D_" + fdivisionBean.getID():"") ;
		String sysvarID = "URUT_SJ_KIRIM_";		
		if (fcompanyBean !=null ) {
			return sysvarJpaService.findById(fcompanyBean, sysvarID + divisionOrCompanyID).getNilaiString1();
		} else {
			return sysvarJpaService.findById(fdivisionBean, sysvarID + divisionOrCompanyID).getNilaiString1();
		}
	}
	public String getomorUrutSuratJalanPenagihan10(PemProv fcompanyBean, UnitKerja fdivisionBean){
		String divisionOrCompanyID = fcompanyBean !=null? "C_" + fcompanyBean.getID():(fdivisionBean !=null? "D_" + fdivisionBean.getID():"") ;
		String sysvarID = "URUT_SJ_PENAGIH_";		
		if (fcompanyBean !=null ) {
			return sysvarJpaService.findById(fcompanyBean, sysvarID + divisionOrCompanyID).getNilaiString1();
		} else {
			return sysvarJpaService.findById(fdivisionBean, sysvarID + divisionOrCompanyID).getNilaiString1();
		}
	}
	
	public String getNomorUrutAccountPayable11(PemProv fcompanyBean, UnitKerja fdivisionBean){
		String divisionOrCompanyID = fcompanyBean !=null? "C_" + fcompanyBean.getID():(fdivisionBean !=null? "D_" + fdivisionBean.getID():"") ;
		String sysvarID = "URUT_AP_";		
		if (fcompanyBean !=null ) {
			return sysvarJpaService.findById(fcompanyBean, sysvarID + divisionOrCompanyID).getNilaiString1();
		} else {
			return sysvarJpaService.findById(fdivisionBean, sysvarID + divisionOrCompanyID).getNilaiString1();
		}
	}
	public String getNomorUrutAccountReceivable12(PemProv fcompanyBean, UnitKerja fdivisionBean){
		String divisionOrCompanyID = fcompanyBean !=null? "C_" + fcompanyBean.getID():(fdivisionBean !=null? "D_" + fdivisionBean.getID():"") ;
		String sysvarID = "URUT_AR_";		
		if (fcompanyBean !=null ) {
			return sysvarJpaService.findById(fcompanyBean, sysvarID + divisionOrCompanyID).getNilaiString1();
		} else {
			return sysvarJpaService.findById(fdivisionBean, sysvarID + divisionOrCompanyID).getNilaiString1();
		}
	}
		
	public String getNomorUrutKasMasuk15(PemProv fcompanyBean, UnitKerja fdivisionBean){
		String divisionOrCompanyID = fcompanyBean !=null? "C_" + fcompanyBean.getID():(fdivisionBean !=null? "D_" + fdivisionBean.getID():"") ;
		String sysvarID = "URUT_KAS_MASUK_";		
		if (fcompanyBean !=null ) {
			return sysvarJpaService.findById(fcompanyBean, sysvarID + divisionOrCompanyID).getNilaiString1();
		} else {
			return sysvarJpaService.findById(fdivisionBean, sysvarID + divisionOrCompanyID).getNilaiString1();
		}
	}
	public String getNomorUrutKasKeluar16(PemProv fcompanyBean, UnitKerja fdivisionBean){
		String divisionOrCompanyID = fcompanyBean !=null? "C_" + fcompanyBean.getID():(fdivisionBean !=null? "D_" + fdivisionBean.getID():"") ;
		String sysvarID = "URUT_KAS_KELUAR_";		
		if (fcompanyBean !=null ) {
			return sysvarJpaService.findById(fcompanyBean, sysvarID + divisionOrCompanyID).getNilaiString1();
		} else {
			return sysvarJpaService.findById(fdivisionBean, sysvarID + divisionOrCompanyID).getNilaiString1();
		}
	}

	public String getNomorUrutJurnalAkuntansi17(PemProv fcompanyBean, UnitKerja fdivisionBean){
		String divisionOrCompanyID = fcompanyBean !=null? "C_" + fcompanyBean.getID():(fdivisionBean !=null? "D_" + fdivisionBean.getID():"") ;
		String sysvarID = "URUT_JURNAL_";		
		if (fcompanyBean !=null ) {
			return sysvarJpaService.findById(fcompanyBean, sysvarID + divisionOrCompanyID).getNilaiString1();
		} else {
			return sysvarJpaService.findById(fdivisionBean, sysvarID + divisionOrCompanyID).getNilaiString1();
		}
	}
	
//	 * E. FORMAT FAKTUR JUAL, beli, packingklist ##
	public int getFormatFakturPenjualan1_1(PemProv fcompanyBean, UnitKerja fdivisionBean){
		String divisionOrCompanyID = fcompanyBean !=null? "C_" + fcompanyBean.getID():(fdivisionBean !=null? "D_" + fdivisionBean.getID():"") ;
		String sysvarID = "FORMAT_FAK_J1_";		
		if (fcompanyBean !=null ) {
			return sysvarJpaService.findById(fcompanyBean, sysvarID + divisionOrCompanyID).getNilaiInt1();
		} else {
			return sysvarJpaService.findById(fdivisionBean, sysvarID + divisionOrCompanyID).getNilaiInt1();
		}
	}
	public int getFormatFakturPenjualan2_2(PemProv fcompanyBean, UnitKerja fdivisionBean){
		String divisionOrCompanyID = fcompanyBean !=null? "C_" + fcompanyBean.getID():(fdivisionBean !=null? "D_" + fdivisionBean.getID():"") ;
		String sysvarID = "FORMAT_FAK_J2_";		
		if (fcompanyBean !=null ) {
			return sysvarJpaService.findById(fcompanyBean, sysvarID + divisionOrCompanyID).getNilaiInt1();
		} else {
			return sysvarJpaService.findById(fdivisionBean, sysvarID + divisionOrCompanyID).getNilaiInt1();
		}
	}
	public boolean getNpwpDanSkPkpPadaFakturJual3(PemProv fcompanyBean, UnitKerja fdivisionBean){
		String divisionOrCompanyID = fcompanyBean !=null? "C_" + fcompanyBean.getID():(fdivisionBean !=null? "D_" + fdivisionBean.getID():"") ;
		String sysvarID = "NPWP_SK_FAK_J_";		
		if (fcompanyBean !=null ) {
			return sysvarJpaService.findById(fcompanyBean, sysvarID + divisionOrCompanyID).isNilaiBol1();
		} else {
			return sysvarJpaService.findById(fdivisionBean, sysvarID + divisionOrCompanyID).isNilaiBol1();
		}
	}
	
	public int getHargaJualPadaFakturJualStdInUom1234_41(PemProv fcompanyBean, UnitKerja fdivisionBean){
		String divisionOrCompanyID = fcompanyBean !=null? "C_" + fcompanyBean.getID():(fdivisionBean !=null? "D_" + fdivisionBean.getID():"") ;
		String sysvarID = "H_JL_NOTA_UOM_";		
		if (fcompanyBean !=null ) {
			return sysvarJpaService.findById(fcompanyBean, sysvarID + divisionOrCompanyID).getNilaiInt1();
		} else {
			return sysvarJpaService.findById(fdivisionBean, sysvarID + divisionOrCompanyID).getNilaiInt1();
		}
	}
	public int getHargaBeliPadaFakturBeliStdInUom1234_42(PemProv fcompanyBean, UnitKerja fdivisionBean){
		String divisionOrCompanyID = fcompanyBean !=null? "C_" + fcompanyBean.getID():(fdivisionBean !=null? "D_" + fdivisionBean.getID():"") ;
		String sysvarID = "H_BL_NOTA_UOM_";		
		if (fcompanyBean !=null ) {
			return sysvarJpaService.findById(fcompanyBean, sysvarID + divisionOrCompanyID).getNilaiInt1();
		} else {
			return sysvarJpaService.findById(fdivisionBean, sysvarID + divisionOrCompanyID).getNilaiInt1();
		}
	}
	
	public boolean getFakturJualMenggunakanShortName6(PemProv fcompanyBean, UnitKerja fdivisionBean){
		String divisionOrCompanyID = fcompanyBean !=null? "C_" + fcompanyBean.getID():(fdivisionBean !=null? "D_" + fdivisionBean.getID():"") ;
		String sysvarID = "SHORTNAME_FAK_J_";		
		if (fcompanyBean !=null ) {
			return sysvarJpaService.findById(fcompanyBean, sysvarID + divisionOrCompanyID).isNilaiBol1();
		} else {
			return sysvarJpaService.findById(fdivisionBean, sysvarID + divisionOrCompanyID).isNilaiBol1();
		}
	}
	
	public boolean isHargaBeliPadaFakturBeli_SebelumPajak_51(PemProv fcompanyBean, UnitKerja fdivisionBean){
		String divisionOrCompanyID = fcompanyBean !=null? "C_" + fcompanyBean.getID():(fdivisionBean !=null? "D_" + fdivisionBean.getID():"") ;
		String sysvarID = "H_BLNOTA_BEF_TAX_";		
		if (fcompanyBean !=null ) {
			return sysvarJpaService.findById(fcompanyBean, sysvarID + divisionOrCompanyID).isNilaiBol1();
		} else {
			return sysvarJpaService.findById(fdivisionBean, sysvarID + divisionOrCompanyID).isNilaiBol1();
		}
	}
	public boolean isHargaJualPadaFakturJual_SebelumPajak_52(PemProv fcompanyBean, UnitKerja fdivisionBean){
		String divisionOrCompanyID = fcompanyBean !=null? "C_" + fcompanyBean.getID():(fdivisionBean !=null? "D_" + fdivisionBean.getID():"") ;
		String sysvarID = "H_JLNOTA_BEF_TAX_";		
		if (fcompanyBean !=null ) {
			return sysvarJpaService.findById(fcompanyBean, sysvarID + divisionOrCompanyID).isNilaiBol1();
		} else {
			return sysvarJpaService.findById(fdivisionBean, sysvarID + divisionOrCompanyID).isNilaiBol1();
		}
	}
	
	public boolean isSuratJalanPengiriman_TidakTampilkanReturCustomer71(PemProv fcompanyBean, UnitKerja fdivisionBean) {
		String divisionOrCompanyID = fcompanyBean !=null? "C_" + fcompanyBean.getID():(fdivisionBean !=null? "D_" + fdivisionBean.getID():"") ;
		String sysvarID = "SJ_KRM_NO_RET_";		
		if (fcompanyBean !=null ) {
			return sysvarJpaService.findById(fcompanyBean, sysvarID + divisionOrCompanyID).isNilaiBol1();
		} else {
			return sysvarJpaService.findById(fdivisionBean, sysvarID + divisionOrCompanyID).isNilaiBol1();
		}
		
	}

	public boolean isPackingListMenggunakanShortName7(PemProv fcompanyBean, UnitKerja fdivisionBean){
		String divisionOrCompanyID = fcompanyBean !=null? "C_" + fcompanyBean.getID():(fdivisionBean !=null? "D_" + fdivisionBean.getID():"") ;
		String sysvarID = "SHORTNAME_PACKLI_";		
		if (fcompanyBean !=null ) {
			return sysvarJpaService.findById(fcompanyBean, sysvarID + divisionOrCompanyID).isNilaiBol1();
		} else {
			return sysvarJpaService.findById(fdivisionBean, sysvarID + divisionOrCompanyID).isNilaiBol1();
		}
	}
	
	public boolean isFakturJualMenggunakanKodeProduct8(PemProv fcompanyBean, UnitKerja fdivisionBean){
		String divisionOrCompanyID = fcompanyBean !=null? "C_" + fcompanyBean.getID():(fdivisionBean !=null? "D_" + fdivisionBean.getID():"") ;
		String sysvarID = "PCODE_FAK_J_";		
		if (fcompanyBean !=null ) {
			return sysvarJpaService.findById(fcompanyBean, sysvarID + divisionOrCompanyID).isNilaiBol1();
		} else {
			return sysvarJpaService.findById(fdivisionBean, sysvarID + divisionOrCompanyID).isNilaiBol1();
		}
	}
	
	public boolean isInputanPelunasanHanyaTampilReturCustomerTersebutSaja1(PemProv fcompanyBean, UnitKerja fdivisionBean){
		String divisionOrCompanyID = fcompanyBean !=null? "C_" + fcompanyBean.getID():(fdivisionBean !=null? "D_" + fdivisionBean.getID():"") ;
		String sysvarID = "AR_VIEW_RET";		
		if (fcompanyBean !=null ) {
			return sysvarJpaService.findById(fcompanyBean, sysvarID + divisionOrCompanyID).isNilaiBol1();
		} else {
			return sysvarJpaService.findById(fdivisionBean, sysvarID + divisionOrCompanyID).isNilaiBol1();
		}
	}
	public boolean isBGAndTransferBelumCairTidakBolehPelunasanAR(PemProv fcompanyBean, UnitKerja fdivisionBean){
		String divisionOrCompanyID = fcompanyBean !=null? "C_" + fcompanyBean.getID():(fdivisionBean !=null? "D_" + fdivisionBean.getID():"") ;
		String sysvarID = "BG_BLC_NOAR_";		
		if (fcompanyBean !=null ) {
			return sysvarJpaService.findById(fcompanyBean, sysvarID + divisionOrCompanyID).isNilaiBol1();
		} else {
			return sysvarJpaService.findById(fdivisionBean, sysvarID + divisionOrCompanyID).isNilaiBol1();
		}
	}
	
	
/*
 * ACCOUNTING	
 */
	public Sysvar getAccMappingPersediaan1_Object(PemProv fcompanyBean, UnitKerja fdivisionBean){
		String divisionOrCompanyID = fcompanyBean !=null? "C_" + fcompanyBean.getID():(fdivisionBean !=null? "D_" + fdivisionBean.getID():"") ;
		String sysvarID = "ACC_MAP_PERS_";		
		if (fcompanyBean !=null ) {
			return sysvarJpaService.findById(fcompanyBean, sysvarID + divisionOrCompanyID);
		} else {
			return sysvarJpaService.findById(fdivisionBean, sysvarID + divisionOrCompanyID);
		}
	}
	public Sysvar getAccMappingPenjualan2_Object(PemProv fcompanyBean, UnitKerja fdivisionBean){
		String divisionOrCompanyID = fcompanyBean !=null? "C_" + fcompanyBean.getID():(fdivisionBean !=null? "D_" + fdivisionBean.getID():"") ;
		String sysvarID = "ACC_MAP_PENJ_F_";		
		if (fcompanyBean !=null ) {
			return sysvarJpaService.findById(fcompanyBean, sysvarID + divisionOrCompanyID);
		} else {
			return sysvarJpaService.findById(fdivisionBean, sysvarID + divisionOrCompanyID);
		}
	}
	public Sysvar getAccMappingReturPenjualan3_Object(PemProv fcompanyBean, UnitKerja fdivisionBean){
		String divisionOrCompanyID = fcompanyBean !=null? "C_" + fcompanyBean.getID():(fdivisionBean !=null? "D_" + fdivisionBean.getID():"") ;
		String sysvarID = "ACC_MAP_PENJ_R_";		
		if (fcompanyBean !=null ) {
			return sysvarJpaService.findById(fcompanyBean, sysvarID + divisionOrCompanyID);
		} else {
			return sysvarJpaService.findById(fdivisionBean, sysvarID + divisionOrCompanyID);
		}
	}
	public Sysvar getAccMappingPotonganPenjualan4_Object(PemProv fcompanyBean, UnitKerja fdivisionBean){
		String divisionOrCompanyID = fcompanyBean !=null? "C_" + fcompanyBean.getID():(fdivisionBean !=null? "D_" + fdivisionBean.getID():"") ;
		String sysvarID = "ACC_MAP_PENJ_DIS_";		
		if (fcompanyBean !=null ) {
			return sysvarJpaService.findById(fcompanyBean, sysvarID + divisionOrCompanyID);
		} else {
			return sysvarJpaService.findById(fdivisionBean, sysvarID + divisionOrCompanyID);
		}
	}
	public Sysvar getAccMappingBarangTerkirim5_Object(PemProv fcompanyBean, UnitKerja fdivisionBean){
		String divisionOrCompanyID = fcompanyBean !=null? "C_" + fcompanyBean.getID():(fdivisionBean !=null? "D_" + fdivisionBean.getID():"") ;
		String sysvarID = "ACC_MAP_BRG_KRM_";		
		if (fcompanyBean !=null ) {
			return sysvarJpaService.findById(fcompanyBean, sysvarID + divisionOrCompanyID);
		} else {
			return sysvarJpaService.findById(fdivisionBean, sysvarID + divisionOrCompanyID);
		}
	}
	public Sysvar getAccMappingHppCogs6_Object(PemProv fcompanyBean, UnitKerja fdivisionBean){
		String divisionOrCompanyID = fcompanyBean !=null? "C_" + fcompanyBean.getID():(fdivisionBean !=null? "D_" + fdivisionBean.getID():"") ;
		String sysvarID = "ACC_MAP_HPP_";		
		if (fcompanyBean !=null ) {
			return sysvarJpaService.findById(fcompanyBean, sysvarID + divisionOrCompanyID);
		} else {
			return sysvarJpaService.findById(fdivisionBean, sysvarID + divisionOrCompanyID);
		}
	}
	public Sysvar getAccMappingReturPembelian7_Object(PemProv fcompanyBean, UnitKerja fdivisionBean){
		String divisionOrCompanyID = fcompanyBean !=null? "C_" + fcompanyBean.getID():(fdivisionBean !=null? "D_" + fdivisionBean.getID():"") ;
		String sysvarID = "ACC_MAP_BELI_R_";		
		if (fcompanyBean !=null ) {
			return sysvarJpaService.findById(fcompanyBean, sysvarID + divisionOrCompanyID);
		} else {
			return sysvarJpaService.findById(fdivisionBean, sysvarID + divisionOrCompanyID);
		}
	}
	public Sysvar getAccMappingPiutangReturPembelian7_1_Object(PemProv fcompanyBean, UnitKerja fdivisionBean){
		String divisionOrCompanyID = fcompanyBean !=null? "C_" + fcompanyBean.getID():(fdivisionBean !=null? "D_" + fdivisionBean.getID():"") ;
		String sysvarID = "ACC_PIUT_BELI_R_";		
		if (fcompanyBean !=null ) {
			return sysvarJpaService.findById(fcompanyBean, sysvarID + divisionOrCompanyID);
		} else {
			return sysvarJpaService.findById(fdivisionBean, sysvarID + divisionOrCompanyID);
		}
	}
	
	public Sysvar getAccMappingBeban8_Object(PemProv fcompanyBean, UnitKerja fdivisionBean){
		String divisionOrCompanyID = fcompanyBean !=null? "C_" + fcompanyBean.getID():(fdivisionBean !=null? "D_" + fdivisionBean.getID():"") ;
		String sysvarID = "ACC_MAP_BEBAN_";		
		if (fcompanyBean !=null ) {
			return sysvarJpaService.findById(fcompanyBean, sysvarID + divisionOrCompanyID);
		} else {
			return sysvarJpaService.findById(fdivisionBean, sysvarID + divisionOrCompanyID);
		}
	}
	public Sysvar getAccMappingHutangBelumTertagih9_Object(PemProv fcompanyBean, UnitKerja fdivisionBean){
		String divisionOrCompanyID = fcompanyBean !=null? "C_" + fcompanyBean.getID():(fdivisionBean !=null? "D_" + fdivisionBean.getID():"") ;
		String sysvarID = "ACC_MAP_BLM_TGH_";		
		if (fcompanyBean !=null ) {
			return sysvarJpaService.findById(fcompanyBean, sysvarID + divisionOrCompanyID);
		} else {
			return sysvarJpaService.findById(fdivisionBean, sysvarID + divisionOrCompanyID);
		}
	}
	
	public Sysvar getAccMappingKasBesarPenjualan10_Object(PemProv fcompanyBean, UnitKerja fdivisionBean){
		String divisionOrCompanyID = fcompanyBean !=null? "C_" + fcompanyBean.getID():(fdivisionBean !=null? "D_" + fdivisionBean.getID():"") ;
		String sysvarID = "ACC_MAP_KAS_BES_";		
		if (fcompanyBean !=null ) {
			return sysvarJpaService.findById(fcompanyBean, sysvarID + divisionOrCompanyID);
		} else {
			System.out.println("Sysvar ID: " + sysvarID + divisionOrCompanyID);
			return sysvarJpaService.findById(fdivisionBean, sysvarID + divisionOrCompanyID);
		}
	}
	
	public Sysvar getAccMappingPembelianTunai_Kas10_Object(PemProv fcompanyBean, UnitKerja fdivisionBean){
		String divisionOrCompanyID = fcompanyBean !=null? "C_" + fcompanyBean.getID():(fdivisionBean !=null? "D_" + fdivisionBean.getID():"") ;
		String sysvarID = "ACCMAP_INVTX_BL_";		
		if (fcompanyBean !=null ) {
			return sysvarJpaService.findById(fcompanyBean, sysvarID + divisionOrCompanyID);
		} else {
			return sysvarJpaService.findById(fdivisionBean, sysvarID + divisionOrCompanyID);
		}
	}
	
	public Sysvar getAccMappingPiutang11_Object(PemProv fcompanyBean, UnitKerja fdivisionBean){
		String divisionOrCompanyID = fcompanyBean !=null? "C_" + fcompanyBean.getID():(fdivisionBean !=null? "D_" + fdivisionBean.getID():"") ;
		String sysvarID = "ACC_MAP_PIUTANG_";		
		if (fcompanyBean !=null ) {
			return sysvarJpaService.findById(fcompanyBean, sysvarID + divisionOrCompanyID);
		} else {
			return sysvarJpaService.findById(fdivisionBean, sysvarID + divisionOrCompanyID);
		}
	}
	public Sysvar getAccMappingPembelianKredit_Hutang12_Object(PemProv fcompanyBean, UnitKerja fdivisionBean){
		String divisionOrCompanyID = fcompanyBean !=null? "C_" + fcompanyBean.getID():(fdivisionBean !=null? "D_" + fdivisionBean.getID():"") ;
		String sysvarID = "ACC_MAP_HUTANG_";		
		if (fcompanyBean !=null ) {
			return sysvarJpaService.findById(fcompanyBean, sysvarID + divisionOrCompanyID);
		} else {
			return sysvarJpaService.findById(fdivisionBean, sysvarID + divisionOrCompanyID);
		}
	}
	public Sysvar getAccMappingHutangRetur_12_2_Object(PemProv fcompanyBean, UnitKerja fdivisionBean){
		String divisionOrCompanyID = fcompanyBean !=null? "C_" + fcompanyBean.getID():(fdivisionBean !=null? "D_" + fdivisionBean.getID():"") ;
		String sysvarID = "ACC_MAP_HTG_RET_";		
		if (fcompanyBean !=null ) {
			return sysvarJpaService.findById(fcompanyBean, sysvarID + divisionOrCompanyID);
		} else {
			return sysvarJpaService.findById(fdivisionBean, sysvarID + divisionOrCompanyID);
		}
	}
	public Sysvar getAccMappingOpeningBalanceStock13_Object(PemProv fcompanyBean, UnitKerja fdivisionBean){
		String divisionOrCompanyID = fcompanyBean !=null? "C_" + fcompanyBean.getID():(fdivisionBean !=null? "D_" + fdivisionBean.getID():"") ;
		String sysvarID = "ACC_MAP_OPENBALST_";		
		if (fcompanyBean !=null ) {
			return sysvarJpaService.findById(fcompanyBean, sysvarID + divisionOrCompanyID);
		} else {
			return sysvarJpaService.findById(fdivisionBean, sysvarID + divisionOrCompanyID);
		}
	}
	
	public Sysvar getAccMappingApArPenerimaanCash14_Object(PemProv fcompanyBean, UnitKerja fdivisionBean){
		String divisionOrCompanyID = fcompanyBean !=null? "C_" + fcompanyBean.getID():(fdivisionBean !=null? "D_" + fdivisionBean.getID():"") ;
		String sysvarID = "ACC_MAP_APAR_CASH_";		
		if (fcompanyBean !=null ) {
			return sysvarJpaService.findById(fcompanyBean, sysvarID + divisionOrCompanyID);
		} else {
			return sysvarJpaService.findById(fdivisionBean, sysvarID + divisionOrCompanyID);
		}
	}
	
	public Sysvar getAccMappingArOnlyPotongan15_Object(PemProv fcompanyBean, UnitKerja fdivisionBean){
		String divisionOrCompanyID = fcompanyBean !=null? "C_" + fcompanyBean.getID():(fdivisionBean !=null? "D_" + fdivisionBean.getID():"") ;
		String sysvarID = "ACC_MAP_AR_POT_";		
		if (fcompanyBean !=null ) {
			return sysvarJpaService.findById(fcompanyBean, sysvarID + divisionOrCompanyID);
		} else {
			return sysvarJpaService.findById(fdivisionBean, sysvarID + divisionOrCompanyID);
		}
	}
	
	public Sysvar getAccMappingPiutangGiroOrBank16_Object(PemProv fcompanyBean, UnitKerja fdivisionBean){
		String divisionOrCompanyID = fcompanyBean !=null? "C_" + fcompanyBean.getID():(fdivisionBean !=null? "D_" + fdivisionBean.getID():"") ;
		String sysvarID = "ACC_MAP_PIUT_GIRO_";		
		if (fcompanyBean !=null ) {
			return sysvarJpaService.findById(fcompanyBean, sysvarID + divisionOrCompanyID);
		} else {
			return sysvarJpaService.findById(fdivisionBean, sysvarID + divisionOrCompanyID);
		}
	}
	public Sysvar getAccMappingHutangGiroOrBank17_Object(PemProv fcompanyBean, UnitKerja fdivisionBean){
		String divisionOrCompanyID = fcompanyBean !=null? "C_" + fcompanyBean.getID():(fdivisionBean !=null? "D_" + fdivisionBean.getID():"") ;
		String sysvarID = "ACC_MAP_HUT_GIRO_";		
		if (fcompanyBean !=null ) {
			return sysvarJpaService.findById(fcompanyBean, sysvarID + divisionOrCompanyID);
		} else {
			return sysvarJpaService.findById(fdivisionBean, sysvarID + divisionOrCompanyID);
		}
	}
	
	public Sysvar getAccMappingUangMukaPembelian18_Object(PemProv fcompanyBean, UnitKerja fdivisionBean){
		String divisionOrCompanyID = fcompanyBean !=null? "C_" + fcompanyBean.getID():(fdivisionBean !=null? "D_" + fdivisionBean.getID():"") ;
		String sysvarID = "ACC_MAP_UGMK_BL_";		
		if (fcompanyBean !=null ) {
			return sysvarJpaService.findById(fcompanyBean, sysvarID + divisionOrCompanyID);
		} else {
			return sysvarJpaService.findById(fdivisionBean, sysvarID + divisionOrCompanyID);
		}
	}
	public Sysvar getAccMappingUangMukaPenjualan19_Object(PemProv fcompanyBean, UnitKerja fdivisionBean){
		String divisionOrCompanyID = fcompanyBean !=null? "C_" + fcompanyBean.getID():(fdivisionBean !=null? "D_" + fdivisionBean.getID():"") ;
		String sysvarID = "ACC_MAP_UGMK_JL_";		
		if (fcompanyBean !=null ) {
			return sysvarJpaService.findById(fcompanyBean, sysvarID + divisionOrCompanyID);
		} else {
			return sysvarJpaService.findById(fdivisionBean, sysvarID + divisionOrCompanyID);
		}
	}
	
	
	public String getUploadPicturePath(){
		String filePath = sysvarJpaService.findById("_UP_PICS_PATH").getNilaiString1();
 	   	if (! filePath.trim().substring(filePath.length(), filePath.length()).equals("/")) {
 	   		filePath = filePath + "/";
 	   	}

		return filePath;
	}
	
	public String getUploadDocumentPath(){
		return sysvarJpaService.findById("_UP_DOCS_PATH").getNilaiString1();
	}

	/*
	 * PROSES AKHIR HARI
	 */
	
	
	
	
	
	
	
	//LANGSUNG MOTONG STOK SAAT PURCHASE
	public boolean isNoOutstandingSalesOrderSaatPAH(){
		//default = true
		return sysvarJpaService.findById("_NO_OSTD_SO").isNilaiBol1();
	}
	public boolean isNoOutstandingPurchaseSaatPAH(){
		//default=true
		return sysvarJpaService.findById("_NO_OSTD_PO").isNilaiBol1();
	}
		
	public boolean isSalesOrderSebelumTerbitNoInvoiceLangsungMotongStock(){
		//Default=true
		return sysvarJpaService.findById("_ORD_PRS_STK").isNilaiBol1();
	}
	public boolean isPurchaseSebelumTerbitNoInvoiceLangsungMotongStock(){
		//Default=true
		return sysvarJpaService.findById("_PO_PRS_STK").isNilaiBol1();
	}
	
	public String getJenisProteksiOpenInvoice(){
		return sysvarJpaService.findById("_PR_OPENINV").getNilaiString1();
	}
	public String getJenisProteksiCreditLimit(){
		return sysvarJpaService.findById("_PR_CRLMT").getNilaiString1();
	}

	
	
	
	public boolean isFakturTunaiBelumLunasLangsungKreditSaatProses(){
		return sysvarJpaService.findById("_FT_AUTO_K").isNilaiBol1();
	}
	
	//TRANSAKSI
	public boolean getBeliLangsungProses(){
		return sysvarJpaService.findById("_BELI_AUTOP").isNilaiBol1();
	}

	//PARAMETER IMPORT/SINCRONISASI FROM SERVER/SPECIFIC IP
	public boolean isImportHargaJualdariServerHanyaHargaRetailSaja(){
		return sysvarJpaService.findById("_IMPHJL_RET").isNilaiBol1();
	}
	public double getToleransiImportHargaJualDianggapBerbedaDariServer(){
		return sysvarJpaService.findById("_IMPHRGJUAL_TOLE").getNilaiDouble1();
	}
	public boolean isImportHargaJualSajaHargaBeliTidakIkut(){
		return sysvarJpaService.findById("_IMPHRGJUAL_SAJA").isNilaiBol1();
	}
	
	//WEBSERVICE INTERFACE
	public boolean isWsPortOpenOrNot(){
		return sysvarJpaService.findById("_WSPORT_OPEN").isNilaiBol1();
	}
	public String getWebServiceURLPrincipalOrServerPusat(){
		return sysvarJpaService.findById("_WS_URL_PR").getNilaiString1();
	}
	public String getWebSeriviceURLPabrik(){
		return sysvarJpaService.findById("_WS_URL_FA").getNilaiString1();
	}
	public String getWebSeriviceURLWarehouse(){
		return sysvarJpaService.findById("_WS_URL_WH").getNilaiString1();
	}
	public String getWebSeriviceURLDistributor(){
		return sysvarJpaService.findById("_WS_URL_DI").getNilaiString1();
	}
	
	public boolean isAktifkanPerekamanSistem(){
		return sysvarJpaService.findById("_REC_LOGSISTEM").isNilaiBol1();
	}
	
	public boolean isHargaJualAltSwalayan(){
		return sysvarJpaService.findById("_HJ_ALT_SWAL").isNilaiBol1();		
	}
	
	//POINT OF SALES
	public boolean isNomorInvoicePosMenggunakanPrefixKodeKassa(){
		return sysvarJpaService.findById("_POS_NOINV_PREFIX").isNilaiBol1();		
	}

		
	public static void main(String [] args){
		SysvarHelper helper = new SysvarHelper();
		helper.defaultConfigSysvar();
		
	}
}
