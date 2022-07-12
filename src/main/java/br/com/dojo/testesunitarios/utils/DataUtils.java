package br.com.dojo.testesunitarios.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DataUtils {

    public static LocalDate convertStringToDate(String date) {
        return LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }
}
