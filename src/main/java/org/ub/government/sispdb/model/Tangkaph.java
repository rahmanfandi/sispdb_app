package org.ub.government.sispdb.model;

import java.util.Date;
import java.util.Set;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.ub.government.sispdb.model_enum.EnumLautDarat;
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

@Entity
@Table(name="tangkaph")
public class Tangkaph {

	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long ID;
	
	@ManyToOne
	@JoinColumn(name="unitKerjaBean", referencedColumnName="ID")
	private UnitKerja unitKerjaBean;
	
	@ManyToOne
	@JoinColumn(name="enumeratorBean", referencedColumnName="ID")
	private TabulatorEnumerator enumeratorBean;
	
	@ManyToOne
	@JoinColumn(name="uptBean", referencedColumnName="ID")
	private Upt uptBean;
	
	@Column(name="TYPE")
	@Enumerated(EnumType.ORDINAL)
	private EnumLautDarat type;
	
	@OneToMany(mappedBy="tangkaphBean", fetch=FetchType.LAZY)	
	@Fetch(FetchMode.JOIN)
	private Set<TangkapItem> tangkapItemsSet;
	
	@Column(name="NO_DOC", length=20)
	private String noDoc;	
	
	@Column(name="TRDATE")
	@Temporal(TemporalType.DATE)
	private Date trDate;
	
	@Column(name="WPP_LAUT_DOUBLE")
	private double wppLautDouble;
	@Column(name="WPP_LAUT_STRING", length=20)
	private String wppLautString;
	@Column(name="FAKTOR")
	private double faktor;

	@Column(name = "UPLOADED")
	private boolean uploaded = false;
	
	@Column(name="END_OF_DAY")
	private boolean endOfDay = false;

	@Column(name="CREATED")
	@Temporal(TemporalType.TIMESTAMP)
	private Date created;
	@Column(name="LAST_MODIFIED")
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastModified;
	@Column(name="MODIFIED_BY", length=20) 
	private String modifiedBy;
	
	
	public boolean isUploaded() {
		return uploaded;
	}
	public void setUploaded(boolean uploaded) {
		this.uploaded = uploaded;
	}
	public boolean isEndOfDay() {
		return endOfDay;
	}
	public void setEndOfDay(boolean endOfDay) {
		this.endOfDay = endOfDay;
	}
	public long getID() {
		return ID;
	}
	public void setID(long iD) {
		ID = iD;
	}
	public UnitKerja getUnitKerjaBean() {
		return unitKerjaBean;
	}
	public void setUnitKerjaBean(UnitKerja unitKerjaBean) {
		this.unitKerjaBean = unitKerjaBean;
	}
	public TabulatorEnumerator getEnumeratorBean() {
		return enumeratorBean;
	}
	public void setEnumeratorBean(TabulatorEnumerator enumeratorBean) {
		this.enumeratorBean = enumeratorBean;
	}
	public Upt getUptBean() {
		return uptBean;
	}
	public void setUptBean(Upt uptBean) {
		this.uptBean = uptBean;
	}
	public EnumLautDarat getType() {
		return type;
	}
	public void setType(EnumLautDarat type) {
		this.type = type;
	}
	public Set<TangkapItem> getTangkapItemsSet() {
		return tangkapItemsSet;
	}
	public void setTangkapItemsSet(Set<TangkapItem> tangkapItemsSet) {
		this.tangkapItemsSet = tangkapItemsSet;
	}
	public String getNoDoc() {
		return noDoc;
	}
	public void setNoDoc(String noDoc) {
		this.noDoc = noDoc;
	}
	public Date getTrDate() {
		return trDate;
	}
	public void setTrDate(Date trDate) {
		this.trDate = trDate;
	}
	public double getWppLautDouble() {
		return wppLautDouble;
	}
	public void setWppLautDouble(double wppLautDouble) {
		this.wppLautDouble = wppLautDouble;
	}
	public String getWppLautString() {
		return wppLautString;
	}
	public void setWppLautString(String wppLautString) {
		this.wppLautString = wppLautString;
	}
	public double getFaktor() {
		return faktor;
	}
	public void setFaktor(double faktor) {
		this.faktor = faktor;
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
		Tangkaph other = (Tangkaph) obj;
		if (ID != other.ID)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Tangkaph [ID=" + ID + ", noDoc=" + noDoc + "]";
	}

	
}