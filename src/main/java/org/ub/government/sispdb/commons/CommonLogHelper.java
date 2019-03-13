package org.ub.government.sispdb.commons;

import java.util.Date;

import org.ub.government.sispdb.model.TabulatorEnumerator;
import org.ub.government.sispdb.model.UserLog;
import org.ub.government.sispdb.model.jpaservice.TabulatorEnumeratorJpaService;
import org.ub.government.sispdb.model.jpaservice.UserLogJpaService;

public class CommonLogHelper{
	private static CommonLogHelper instance;
	
	private TabulatorEnumerator userBean = null;
	private UserLogJpaService logSistemJpaService;
	private UserLog logSistem = new UserLog();
	protected TabulatorEnumeratorJpaService userJpaService;

	/*
	 * Tiidak akan bisa update user untuk user active jika diikutkan userJpaService
	 */
	public static CommonLogHelper createLogCommon(TabulatorEnumeratorJpaService userJpaService, UserLogJpaService logSistemJpaService) {
		instance = new CommonLogHelper();
		instance.logSistemJpaService = logSistemJpaService;		
		instance.userJpaService = userJpaService;
		
		//Init default value
		instance.logSistem = new UserLog();
		instance.logSistem.setDateLogTr(new Date());
		instance.logSistem.setTimeToUpdate(new Date());
//		instance.logSistem.setUserId("test_admin");
		return instance;
		
	}
	public static CommonLogHelper createLogCommon( UserLogJpaService logSistemJpaService) {
		instance = new CommonLogHelper();
		instance.logSistemJpaService = logSistemJpaService;		
//		instance.userJpaService = userJpaService; //tidak dipakai supaya user active bisa update
		
		//Init default value
		instance.logSistem = new UserLog();
		instance.logSistem.setDateLogTr(new Date());
		instance.logSistem.setTimeToUpdate(new Date());
//		instance.logSistem.setUserId("test_admin");
		return instance;
		
	}
	
	/*
	 * THE LAST METHOD SOULD CALLED
	 */
	public void writeStreamToDb() {
		try {
			if (instance.userBean !=null) {
				instance.userBean.setLastTransaction(new Date());
				instance.userJpaService.updateObject(instance.userBean);
			}
			instance.logSistemJpaService.createObject(instance.logSistem);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void writeWithThread() {
		Thread thread1 = new Thread(runnableWriteLog);        		
		thread1.start();
		
	}
	/*
	 * THE LAST METHOD
	 */
	
	
	public CommonLogHelper setTanggalTransaksi(Date dateLogTr) {
		instance.logSistem.setDateLogTr(dateLogTr);
		return instance;
	}
	public CommonLogHelper setWaktuTransaksi(Date timeToUpdate) {
		instance.logSistem.setTimeToUpdate(timeToUpdate);
		return instance;
	}
	public CommonLogHelper setUserBean(TabulatorEnumerator userBean) {
		this.userBean = userBean;
		instance.userBean = userBean;
//		instance.logSistem.setUserBean(userBean);
		instance.logSistem.setTabulatorEnumeratorBean(userBean);
		return instance;
	}
	public CommonLogHelper setOperasi(String operasi) {
		instance.logSistem.setOperasi(operasi);
		return instance;
	}
	
	
	public static void main(String [] args) {
		
//		CommonLogHelper.createLogCommon(new UserLogJpaServiceImpl())
//			.setTanggalTransaksi(new Date())
//			.setWaktuTransaksi(new Date())
////			.setUserId("Bagus")
//			.writeStreamToDb();
			
	}
	
	
	Runnable runnableWriteLog = new Runnable() {		
		@Override
		public void run() {
			try{
				if (instance.userBean !=null) {
					instance.userBean.setLastTransaction(new Date());
					instance.userJpaService.updateObject(instance.userBean);
				}
				instance.logSistemJpaService.createObject(instance.logSistem);				
	    		} catch(Exception ex){ 
//	    			ex.printStackTrace();
	    		}
			
		}
	};
	
}
