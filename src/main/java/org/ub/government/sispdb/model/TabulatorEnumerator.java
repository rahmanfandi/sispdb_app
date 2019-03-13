package org.ub.government.sispdb.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.ub.government.sispdb.model_enum.EnumOrganizationLevel;
import org.ub.government.sispdb.model_enum.EnumTabEnumerator;

@Entity
@Table(name="tabulator_enumerator")
public class TabulatorEnumerator {

	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int ID;

	@ManyToOne
	@JoinColumn(name="unitKerjaBean", referencedColumnName="ID")
	private UnitKerja unitKerjaBean;
	
	@OneToMany(mappedBy="enumeratorBean", fetch=FetchType.LAZY)	
	@Fetch(FetchMode.JOIN)
	private Set<Tangkaph> tangkaphSet;

	@OneToMany(mappedBy="tabulatorEnumeratorBean", fetch=FetchType.LAZY)	
	@Fetch(FetchMode.JOIN)
	private Set<UserLog> userLogSet;
	
	@Column(name="TYPE")
	@Enumerated(EnumType.ORDINAL)
	private EnumTabEnumerator type;
	@Column(name="ORGANIZATION_LEVEL")
	@Enumerated(EnumType.ORDINAL)
	private EnumOrganizationLevel organizationLevel;
	
	@Column(name="USER_ID", length=100)
	private String userID;
	@Column(name="PASSWORD", length=100)
	private String password;
	
	@Column(name="IMAGE_FILE1", length=200)
	private String imageFile1;
	
	@Column(name="STATUS_ACTIVE")
	private boolean statusActive = true;

	//MENCATAT TRANSAKSI TERAKHIR USER
	@Column(name="LAST_TRANSACTION")
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastTransaction = new Date();

	@Column(name="CREATED")
	@Temporal(TemporalType.TIMESTAMP)
	private Date created;
	@Column(name="LAST_MODIFIED")
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastModified;
	@Column(name="MODIFIED_BY", length=20) 
	private String modifiedBy;
	
	
	public Set<UserLog> getUserLogSet() {
		return userLogSet;
	}
	public void setUserLogSet(Set<UserLog> userLogSet) {
		this.userLogSet = userLogSet;
	}
	public boolean isStatusActive() {
		return statusActive;
	}
	public void setStatusActive(boolean statusActive) {
		this.statusActive = statusActive;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public UnitKerja getUnitKerjaBean() {
		return unitKerjaBean;
	}
	public void setUnitKerjaBean(UnitKerja unitKerjaBean) {
		this.unitKerjaBean = unitKerjaBean;
	}
	public Set<Tangkaph> getTangkaphSet() {
		return tangkaphSet;
	}
	public void setTangkaphSet(Set<Tangkaph> tangkaphSet) {
		this.tangkaphSet = tangkaphSet;
	}
	public EnumTabEnumerator getType() {
		return type;
	}
	public void setType(EnumTabEnumerator type) {
		this.type = type;
	}
	public EnumOrganizationLevel getOrganizationLevel() {
		return organizationLevel;
	}
	public void setOrganizationLevel(EnumOrganizationLevel organizationLevel) {
		this.organizationLevel = organizationLevel;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getImageFile1() {
		return imageFile1;
	}
	public void setImageFile1(String imageFile1) {
		this.imageFile1 = imageFile1;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public Date getLastModified() {
		return lastModified;
	}
	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}
	public String getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	
	public Date getLastTransaction() {
		return lastTransaction;
	}
	public void setLastTransaction(Date lastTransaction) {
		this.lastTransaction = lastTransaction;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ID;
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
		TabulatorEnumerator other = (TabulatorEnumerator) obj;
		if (ID != other.ID)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "TabulatorEnumerator [ID=" + ID + ", userID=" + userID + "]";
	}

	
}