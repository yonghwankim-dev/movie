package kr.com.yh.util.tlds;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.time.temporal.TemporalField;
import java.util.Locale;

public final class LocalDatetimeUtil {
    private LocalDatetimeUtil() {}

    public static String formatLocalDateTime(LocalDateTime localDateTime, String pattern) {
        return localDateTime.format(DateTimeFormatter.ofPattern(pattern));
    }
    
    public static Integer getDayOfMonth(LocalDateTime localDateTime) {
    	System.out.println("call getDayOfMonth");
    	return Integer.valueOf(localDateTime.getDayOfMonth());
    }
    
    public static String getDayOfWeek(LocalDateTime localDateTime) {
    	return localDateTime.getDayOfWeek().getDisplayName(TextStyle.SHORT, Locale.KOREAN);
    }
    
    public static int getMonthValue(LocalDateTime localDateTime) {
    	return localDateTime.getMonthValue();
    }
    
    public static LocalDateTime plusDays(LocalDateTime localDateTime, int day) {
    	return localDateTime.plusDays(day); 
    }  
}