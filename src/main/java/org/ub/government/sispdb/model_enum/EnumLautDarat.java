package org.ub.government.sispdb.model_enum;

public enum EnumLautDarat {
    LAUT(0, "LAUT", "LAUT", "Perairan Laut"),
    DARAT(1, "DARAT", "DARAT",  "Perairan Darat"),
    ;
    
    private int intCode;
    private String stringCode;
    private String stringCodeLong;
    private String description;
    
    private EnumLautDarat(int intCode, String strCode, String stringCodeLong, String description){
        this.intCode = intCode;
        this.stringCode = strCode;
        this.stringCodeLong = stringCodeLong;
        this.description = description;    
    }
    public String getStrCode(){
        return stringCode;
    }
    public int getIntCode(){
        return intCode;
    }
    public String getDescription(){
        return description;
    }
	public String getStringCode() {
		return stringCode;
	}
	public void setStringCode(String stringCode) {
		this.stringCode = stringCode;
	}
	public String getStringCodeLong() {
		return stringCodeLong;
	}
	public void setStringCodeLong(String stringCodeLong) {
		this.stringCodeLong = stringCodeLong;
	}
	public void setIntCode(int intCode) {
		this.intCode = intCode;
	}
	public void setDescription(String description) {
		this.description = description;
	}

}
