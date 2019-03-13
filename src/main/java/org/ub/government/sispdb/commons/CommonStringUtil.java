package org.ub.government.sispdb.commons;

public class CommonStringUtil {
	
	public static Boolean caseInsensitiveContains(String where, String what) {
        return where.toLowerCase().contains(what.toLowerCase());
    }

}
