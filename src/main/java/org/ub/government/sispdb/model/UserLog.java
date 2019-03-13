package org.ub.government.sispdb.model;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.ub.government.sispdb.model_enum.EnumTabEnumerator;

@XmlRootElement(name="UserLog") //Untuk Jersey
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name="user_log")
public class UserLog  implements Serializable{


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID")
	private long ID=0;
	
	
	@Temporal(TemporalType.DATE)
    @Column(name="DATE_LOG_TR", length=20)
    private Date dateLogTr=new Date();
	
	@Temporal(TemporalType.TIMESTAMP)
    @Column(name="TIME_TO_UPDATE")
    private Date timeToUpdate = new Date();
	
    @Column(name="OPERASI", length=255)
	private String operasi = "";

    //ID DARI TRANSAKSI-TRANSAKSI
	@Column(name="SOURCE_ID")
	private long sourceID=0;
    
    //DAPAT DIPAKAI UNTUK MEMFILTER BY DIVISION: GANTINYA USER
	@ManyToOne
	@JoinColumn(name="tabulatorEnumeratorBean", referencedColumnName="ID")
	private TabulatorEnumerator tabulatorEnumeratorBean;
	
//	@ManyToOne
//	@JoinColumn(name="userBean", referencedColumnName="ID")
//	private User userBean;
//    
//    
//
//	public User getUserBean() {
//		return userBean;
//	}
//
//
//
//
//	public void setUserBean(User userBean) {
//		this.userBean = userBean;
//	}




	public long getID() {
		return ID;
	}




	public TabulatorEnumerator getTabulatorEnumeratorBean() {
		return tabulatorEnumeratorBean;
	}




	public void setTabulatorEnumeratorBean(TabulatorEnumerator tabulatorEnumeratorBean) {
		this.tabulatorEnumeratorBean = tabulatorEnumeratorBean;
	}




	public void setID(long iD) {
		ID = iD;
	}






	public Date getDateLogTr() {
		return dateLogTr;
	}




	public void setDateLogTr(Date dateLogTr) {
		this.dateLogTr = dateLogTr;
	}




	public Date getTimeToUpdate() {
		return timeToUpdate;
	}




	public void setTimeToUpdate(Date timeToUpdate) {
		this.timeToUpdate = timeToUpdate;
	}




	public String getOperasi() {
		return operasi;
	}




	public void setOperasi(String operasi) {
		this.operasi = operasi;
	}




	public long getSourceID() {
		return sourceID;
	}




	public void setSourceID(long sourceID) {
		this.sourceID = sourceID;
	}




	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (ID ^ (ID >>> 32));
		return result;
	}




	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserLog other = (UserLog) obj;
		if (ID != other.ID)
			return false;
		return true;
	}




	@Override
	public String toString() {
		return timeToUpdate + "  " + operasi;
	}
    
    

}