package com.mike.forexservice.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class StringUtil {

    public static boolean currencyStringValidate(String currency) {
        var currencyPattern = "[A-Z]{3}";
        return currency.matches(currencyPattern);
    }

    public static LocalDate parseStringToLocalDate(String dateString) {
        var formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.parse(dateString, formatter);
    }
}
