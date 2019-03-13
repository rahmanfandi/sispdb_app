package org.ub.government.sispdb.model_enum;

public enum EnumJenisNomorUrut {
	
    URUT_M_JENISIKAN("URUT_M_JENISIKAN", "URUT_M_JENISIKAN_", "kode1", "Nomor Jenis Ikan"),
    URUT_M_SUBKELAS("URUT_M_SUBKELAS", "URUT_M_SUBKELAS_", "kode1", "Nomor Sub Kelas"),
//    URUT_M_SATKER("URUT_M_SATKER", "URUT_M_SATKER_", "kode1", "Nomor Satuan Kerja"),
    
    URUT_TANGKAP_DARAT("URUT_TNKP_DARAT", "URUT_TNKP_DARAT_", "noDoc", "Nomor urut TANGKAP DARAT"),
    URUT_TANGKAP_LAUT("URUT_TNKP_LAUT", "URUT_TNKP_LAUT_", "noDoc", "Nomor urut TANGKAP LAUT"),

    
    URUT_PROMO_RULES("URUT_PROMO_RULE", "URUT_PROMO_RULE_", "kode1", "Nomor urut Promotion Rules/Aktifitas Promo"),
    URUT_DISC_NOTA("URUT_DISC_NOTA", "URUT_DISC_NOTA_", "kode1", "Nomor urut Diskon Nota"),
    ;
    
    private String stringId;
    private String sysvarCode;
    private String columnToCek;
    private String description;
    
    private EnumJenisNomorUrut(String stringId, String sysvarCode, String columnToCek, String description){
        this.stringId = stringId;
        this.sysvarCode = sysvarCode;
        this.columnToCek = columnToCek;
        this.description = description;    
    }

	public String getStringId() {
		return stringId;
	}

	public void setStringId(String stringId) {
		this.stringId = stringId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSysvarCode() {
		return sysvarCode;
	}

	public void setSysvarCode(String sysvarCode) {
		this.sysvarCode = sysvarCode;
	}

	public String getColumnToCek() {
		return columnToCek;
	}

	public void setColumnToCek(String columnToCek) {
		this.columnToCek = columnToCek;
	}
    
    

}
