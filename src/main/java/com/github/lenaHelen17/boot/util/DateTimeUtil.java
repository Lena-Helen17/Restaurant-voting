package com.github.lenaHelen17.boot.util;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DateTimeUtil {
    public static final String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm";
    private static final String DATE_PATTERN  = "yyyy-MM-dd";
    public static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern(DATE_TIME_PATTERN);
    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern(DATE_PATTERN);
    public static final LocalTime TIME_STOP_VOTTING = LocalTime.of(11,00,00);


    public static Boolean UserVotingTime(LocalTime localTime) {
        if (localTime.isBefore(TIME_STOP_VOTTING)) {
            return true;
        }
        return false;
    }
}
