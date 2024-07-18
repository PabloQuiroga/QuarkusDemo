package com.pabloquiroga.essentials.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Dates {

    private static final String localPattern = "dd/MM/yyyy";

    public static LocalDate parseDate(String date){
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern(localPattern);
        return LocalDate.parse(date, fmt);
    }
}
