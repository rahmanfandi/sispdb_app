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
import org.ub.government.sispdb.model_enum.EnumLautDarat;

@Entity
@Table(name="ikan_jenis")
public class IkanJenis {

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
	
	@Column(name="TYPE")
	@Enumerated(EnumType.ORDINAL)
	private EnumLautDarat type;
	
	@ManyToOne
	@JoinColumn(name="ikanSubKelasBean", referencedColumnName="ID")
	private IkanSubKelas ikanSubKelasBean;
	
	@OneToMany(mappedBy="ikanJenisBean", fetch=FetchType.LAZY)	
	@Fetch(FetchMode.JOIN)
	private Set<TangkapItem> tangkapItemsSet;
	
	@Column(name="NOTES", length=350)
	private String notes;
	@Column(name="IMAGE_FILE1", length=200)
	private String imageFile1;
	@Column(name="IMAGE_FILE2", length=200)
	private String imageFile2;
	@Column(name="IMAGE_FILE3", length=200)
	private String imageFile3;
	
	@Column(name="STATUS_ACTIVE")
	private boolean statusActive = true;

	@Column(name="CREATED")
	@Temporal(TemporalType.TIMESTAMP)
	private Date created;
	@Column(name="LAST_MODIFIED")
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastModified;
	@Column(name="MODIFIED_BY", length=20) 
	private String modifiedBy;
	
	
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
	public EnumLautDarat getType() {
		return type;
	}
	public void setType(EnumLautDarat type) {
		this.type = type;
	}
	public IkanSubKelas getIkanSubKelasBean() {
		return ikanSubKelasBean;
	}
	public void setIkanSubKelasBean(IkanSubKelas ikanSubKelasBean) {
		this.ikanSubKelasBean = ikanSubKelasBean;
	}
	public Set<TangkapItem> getTangkapItemsSet() {
		return tangkapItemsSet;
	}
	public void setTangkapItemsSet(Set<TangkapItem> tangkapItemsSet) {
		this.tangkapItemsSet = tangkapItemsSet;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public String getImageFile1() {
		return imageFile1;
	}
	public void setImageFile1(String imageFile1) {
		this.imageFile1 = imageFile1;
	}
	public String getImageFile2() {
		return imageFile2;
	}
	public void setImageFile2(String imageFile2) {
		this.imageFile2 = imageFile2;
	}
	public String getImageFile3() {
		return imageFile3;
	}
	public void setImageFile3(String imageFile3) {
		this.imageFile3 = imageFile3;
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
		IkanJenis other = (IkanJenis) obj;
		if (ID != other.ID)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "IkanJenis [ID=" + ID + ", kode1=" + kode1 + "]";
	}
	
	
}