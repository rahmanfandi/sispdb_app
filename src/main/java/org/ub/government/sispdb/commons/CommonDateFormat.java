package org.ub.government.sispdb.commons;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class CommonDateFormat {
	 
	public static Date fromLocalDate(LocalDate localDate) {
		
		//Asia/Kuala_Lumpur +8
        ZoneId defaultZoneId = ZoneId.systemDefault();
        Instant instant = localDate.atStartOfDay(defaultZoneId).toInstant();
		Date date = Date.from(instant);
        
		return date;
	 }
	public static Date fromLocalDateTime(LocalDateTime localDateTime) {
		
	     //Asia/Kuala_Lumpur +8
	     ZoneId defaultZoneId = ZoneId.systemDefault();
	     Instant instant = localDateTime.atZone(defaultZoneId).toInstant();
	     Date date = Date.from(instant);
     
		return date;
	 }
	
	public static LocalDate fromDate(Date date) {
		//Asia/Kuala_Lumpur +8
        ZoneId defaultZoneId = ZoneId.systemDefault();
        //1. Convert Date -> Instant
        Instant instant = date.toInstant();
        //2. Instant + system default time zone + toLocalDate() = LocalDate
        LocalDate localDate = instant.atZone(defaultZoneId).toLocalDate();
		
        return localDate;
	}
	
	public static LocalDateTime fromDateTime(Date date) {
		//Asia/Kuala_Lumpur +8
        ZoneId defaultZoneId = ZoneId.systemDefault();
        //1. Convert Date -> Instant
        Instant instant = date.toInstant();
        //3. Instant + system default time zone + toLocalDateTime() = LocalDateTime
        LocalDateTime localDateTime = instant.atZone(defaultZoneId).toLocalDateTime();
		
        return localDateTime;
	}
}
