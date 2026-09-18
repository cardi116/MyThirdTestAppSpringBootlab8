package ru.cher.MySecondTestAppSpringBoot.util;

import java.text.SimpleDateFormat;
import java.util.TimeZone;

public class DateTimeUtil {

    public static SimpleDateFormat getCustomFormat() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
        return sdf;
    }
}