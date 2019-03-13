package org.ub.government.sispdb.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
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

@Entity
@Table(name="desa")
public class Desa {

	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int ID;

	@Column(name="KODE1", length=15)
	private String kode1;
	@Column(name="KODE2", length=20)
	private String kode2;
	@Column(name="DESCRIPTION", length=100)
	private String description;

	@ManyToOne
	@JoinColumn(name="kecamatanBean", referencedColumnName="ID")
	private Kecamatan kecamatanBean;
	
	@OneToMany(mappedBy="desaBean", fetch=FetchType.LAZY)	
	@Fetch(FetchMode.JOIN)
	private Set<Upt> uptSet;
		
	@Column(name="CREATED")
	@Temporal(TemporalType.TIMESTAMP)
	private Date created;
	@Column(name="LAST_MODIFIED")
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastModified;
	@Column(name="MODIFIED_BY", length=20) 
	private String modifiedBy;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getKode1() {
		return kode1;
	}
	public void setKode1(String kode1) {
		this.kode1 = kode1;
	}
	public String getKode2() {
		return kode2;
	}
	public void setKode2(String kode2) {
		this.kode2 = kode2;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Kecamatan getKecamatanBean() {
		return kecamatanBean;
	}
	public void setKecamatanBean(Kecamatan kecamatanBean) {
		this.kecamatanBean = kecamatanBean;
	}
	public Set<Upt> getUptSet() {
		return uptSet;
	}
	public void setUptSet(Set<Upt> uptSet) {
		this.uptSet = uptSet;
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
		Desa other = (Desa) obj;
		if (ID != other.ID)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Desa [ID=" + ID + ", kode1=" + kode1 + "]";
	}

	
}