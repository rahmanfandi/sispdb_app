package org.ub.government.sispdb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tangkap_item")
public class TangkapItem {

	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long ID;

	@ManyToOne
	@JoinColumn(name="tangkaphBean", referencedColumnName="ID")
	private Tangkaph tangkaphBean;

	@ManyToOne
	@JoinColumn(name="alatTangkapBean", referencedColumnName="ID")
	private AlatTangkap alatTangkapBean;
	
	@ManyToOne
	@JoinColumn(name="kapalBean", referencedColumnName="ID")
	private Kapal kapalBean;

	@ManyToOne
	@JoinColumn(name="ikanJenisBean", referencedColumnName="ID")
	private IkanJenis ikanJenisBean;

	@Column(name="NO_URUT")
	private int noUrut;
	@Column(name="JUMLAH_ABK")
	private int jumlahAbk;
	@Column(name="TOTAL_BERAT")
	private double totalBerat;
	@Column(name="TOTAL_HARGA")
	private double totalHarga;
	@Column(name="LAWUHAN")
	private double lawuhan;
	public long getID() {
		return ID;
	}
	public void setID(long iD) {
		ID = iD;
	}
	public Tangkaph getTangkaphBean() {
		return tangkaphBean;
	}
	public void setTangkaphBean(Tangkaph tangkaphBean) {
		this.tangkaphBean = tangkaphBean;
	}
	public AlatTangkap getAlatTangkapBean() {
		return alatTangkapBean;
	}
	public void setAlatTangkapBean(AlatTangkap alatTangkapBean) {
		this.alatTangkapBean = alatTangkapBean;
	}
	public Kapal getKapalBean() {
		return kapalBean;
	}
	public void setKapalBean(Kapal kapalBean) {
		this.kapalBean = kapalBean;
	}
	public IkanJenis getIkanJenisBean() {
		return ikanJenisBean;
	}
	public void setIkanJenisBean(IkanJenis ikanJenisBean) {
		this.ikanJenisBean = ikanJenisBean;
	}
	public int getNoUrut() {
		return noUrut;
	}
	public void setNoUrut(int noUrut) {
		this.noUrut = noUrut;
	}
	public int getJumlahAbk() {
		return jumlahAbk;
	}
	public void setJumlahAbk(int jumlahAbk) {
		this.jumlahAbk = jumlahAbk;
	}
	public double getTotalBerat() {
		return totalBerat;
	}
	public void setTotalBerat(double totalBerat) {
		this.totalBerat = totalBerat;
	}
	public double getTotalHarga() {
		return totalHarga;
	}
	public void setTotalHarga(double totalHarga) {
		this.totalHarga = totalHarga;
	}
	public double getLawuhan() {
		return lawuhan;
	}
	public void setLawuhan(double lawuhan) {
		this.lawuhan = lawuhan;
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
		TangkapItem other = (TangkapItem) obj;
		if (ID != other.ID)
			return false;
		return true;
	}

	
}