package com.lenaHelen17.project.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeUtil {
    public static final String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm";
    private static final String DATE_PATTERN  = "yyyy-MM-dd";
    public static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern(DATE_TIME_PATTERN);
    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern(DATE_PATTERN);

    private DateTimeUtil() {
    }


    public static LocalDate UserVotingTime (LocalDateTime localDateTimeUser) {
        if (localDateTimeUser.getHour() > 10) {
            return localDateTimeUser.plusDays(1).toLocalDate();
        }
        return localDateTimeUser.toLocalDate();
    }
}
