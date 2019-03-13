/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ub.government.sispdb.model;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement(name="Sysvar") //Untuk Jersey
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name="sysvar")
public class Sysvar implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
    @Column(name="ID", length=35)
    private String id	="";

	/*
	 * JIKA COPY DARI TEMPAT LAIN: MAKA SEBAGAI LOG TRACK MENINGGALKAN SOURCE_ID = ID sumber asal dia dicopy
	 * keperluan diantaranya:
	 * 1. Clone Database. karena tidak mungkin menggunakan Kode External yang bisa jadi kemungkinan kembar, tapi harus pakai kode internal
	 * 2. 
	 */
	@Column(name="SOURCE_ID")
	private String sourceID = "";

    @Column(name="NOMOR_URUT")
	private int nomorUrut=0;
	
    @Column(name="VISIBLE")
	private boolean visible = true;
	
    @Column(name="GROUPSYSVAR", length=30)
    private String groupSysvar ="";
    
    @Column(name="DESKRIPSI", length=300)
    private String deskripsi ="";
    @Column(name="NOTES", length=300)
    private String notes ="";    
    @Column(name="TIPEDATA", length=10)
    private String tipeData ="";
    @Column(name="LENGHTDATA")
    private int lenghtData =0;

    @Column(name="PREFIX", length=10) 
    private String prefix = "";
    
    @Column(name="SUFFIX", length=10) 
    private String suffix = "";

    
    @Column(name="NILAISTRING1", length=300)
    private String nilaiString1 ="";
    @Column(name="NILAISTRING2", length=300)    
    private String nilaiString2 ="";
    @Column(name="NILAIBOL1") 
    private boolean nilaiBol1 =false;
    @Column(name="NILAIBOL2") 
    private boolean nilaiBol2 =false;

    @Column(name="NILAIINT1") 
    private int nilaiInt1 = 0;
    @Column(name="NILAIINT2") 
    private int nilaiInt2=0;
    @Column(name="NILAIDOUBLE1") 
    private double nilaiDouble1 = 0;
    @Column(name="NILAIDOUBLE2") 
    private double nilaiDouble2 = 0;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    @Column(name="NILAIDATE1") 
    private Date nilaiDate1;
    @Temporal(javax.persistence.TemporalType.DATE)
    @Column(name="NILAIDATE2")    
    private Date nilaiDate2;
    
    @Temporal(javax.persistence.TemporalType.DATE) //date bisa time juga kok
    @Column(name="NILAITIME1") 
    private Date nilaiTime1;
    @Temporal(javax.persistence.TemporalType.DATE) //date bisa time juga kok
    @Column(name="NILAITIME2") 
    private Date nilaiTime2;

    /*
     * DIPAKAI UNTUK 
     * Level 1= Level Aplikasi
     * Level 2= Level Company
     * Level 3= Level Division
     */
	@ManyToOne
	@JoinColumn(name="pemProvBean", referencedColumnName="ID")
	private PemProv pemProvBean;
    
	@ManyToOne
	@JoinColumn(name="unitKerjaBean", referencedColumnName="ID")
	private UnitKerja unitKerjaBean;
    
    
	@Column(name="CREATED")
	@Temporal(TemporalType.TIMESTAMP)
	private Date created = new Date();
	@Column(name="MODIFIED")
	@Temporal(TemporalType.TIMESTAMP)
	private Date modified = new Date();
	@Column(name="MODIFIED_BY", length=20) 
	private String modifiedBy =""; //User ID
	//** End Tools
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSourceID() {
		return sourceID;
	}
	public void setSourceID(String sourceID) {
		this.sourceID = sourceID;
	}
	public int getNomorUrut() {
		return nomorUrut;
	}
	public void setNomorUrut(int nomorUrut) {
		this.nomorUrut = nomorUrut;
	}
	public boolean isVisible() {
		return visible;
	}
	public void setVisible(boolean visible) {
		this.visible = visible;
	}
	public String getGroupSysvar() {
		return groupSysvar;
	}
	public void setGroupSysvar(String groupSysvar) {
		this.groupSysvar = groupSysvar;
	}
	public String getDeskripsi() {
		return deskripsi;
	}
	public void setDeskripsi(String deskripsi) {
		this.deskripsi = deskripsi;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public String getTipeData() {
		return tipeData;
	}
	public void setTipeData(String tipeData) {
		this.tipeData = tipeData;
	}
	public int getLenghtData() {
		return lenghtData;
	}
	public void setLenghtData(int lenghtData) {
		this.lenghtData = lenghtData;
	}
	public String getPrefix() {
		return prefix;
	}
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	public String getSuffix() {
		return suffix;
	}
	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}
	public String getNilaiString1() {
		return nilaiString1;
	}
	public void setNilaiString1(String nilaiString1) {
		this.nilaiString1 = nilaiString1;
	}
	public String getNilaiString2() {
		return nilaiString2;
	}
	public void setNilaiString2(String nilaiString2) {
		this.nilaiString2 = nilaiString2;
	}
	public boolean isNilaiBol1() {
		return nilaiBol1;
	}
	public void setNilaiBol1(boolean nilaiBol1) {
		this.nilaiBol1 = nilaiBol1;
	}
	public boolean isNilaiBol2() {
		return nilaiBol2;
	}
	public void setNilaiBol2(boolean nilaiBol2) {
		this.nilaiBol2 = nilaiBol2;
	}
	public int getNilaiInt1() {
		return nilaiInt1;
	}
	public void setNilaiInt1(int nilaiInt1) {
		this.nilaiInt1 = nilaiInt1;
	}
	public int getNilaiInt2() {
		return nilaiInt2;
	}
	public void setNilaiInt2(int nilaiInt2) {
		this.nilaiInt2 = nilaiInt2;
	}
	public double getNilaiDouble1() {
		return nilaiDouble1;
	}
	public void setNilaiDouble1(double nilaiDouble1) {
		this.nilaiDouble1 = nilaiDouble1;
	}
	public double getNilaiDouble2() {
		return nilaiDouble2;
	}
	public void setNilaiDouble2(double nilaiDouble2) {
		this.nilaiDouble2 = nilaiDouble2;
	}
	public Date getNilaiDate1() {
		return nilaiDate1;
	}
	public void setNilaiDate1(Date nilaiDate1) {
		this.nilaiDate1 = nilaiDate1;
	}
	public Date getNilaiDate2() {
		return nilaiDate2;
	}
	public void setNilaiDate2(Date nilaiDate2) {
		this.nilaiDate2 = nilaiDate2;
	}
	public Date getNilaiTime1() {
		return nilaiTime1;
	}
	public void setNilaiTime1(Date nilaiTime1) {
		this.nilaiTime1 = nilaiTime1;
	}
	public Date getNilaiTime2() {
		return nilaiTime2;
	}
	public void setNilaiTime2(Date nilaiTime2) {
		this.nilaiTime2 = nilaiTime2;
	}
	public PemProv getPemProvBean() {
		return pemProvBean;
	}
	public void setPemProvBean(PemProv pemProvBean) {
		this.pemProvBean = pemProvBean;
	}
	public UnitKerja getUnitKerjaBean() {
		return unitKerjaBean;
	}
	public void setUnitKerjaBean(UnitKerja unitKerjaBean) {
		this.unitKerjaBean = unitKerjaBean;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public Date getModified() {
		return modified;
	}
	public void setModified(Date modified) {
		this.modified = modified;
	}
	public String getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Sysvar other = (Sysvar) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Sysvar [id=" + id + ", deskripsi=" + deskripsi + "]";
	}
   
	
	

    
}
