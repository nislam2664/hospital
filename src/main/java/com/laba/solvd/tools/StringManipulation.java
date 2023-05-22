package com.laba.solvd.tools;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class StringManipulation {
    public static String capitalize(String str) {
        if (str == null)
            str = "";

        String[] arr = str.split(" ");
        StringBuilder sb = new StringBuilder();

        int i = 0;
        for (String s : arr) {
            if (!s.equals("") && arr.length > 1 && ++i < arr.length)
                sb.append(Character.toUpperCase(s.charAt(0))).append(s.substring(1).toLowerCase()).append(" ");
            else
                sb.append(Character.toUpperCase(s.charAt(0))).append(s.substring(1).toLowerCase());
        }

        return sb.toString();
    }

    public static boolean isAlphabetic(String str) {
        if (str == null || str.isBlank())
            return false;
        char[] ch = str.toCharArray();
        for (char c : ch)
            if (!Character.isLetter(c) && !Character.isWhitespace(c))
                return false;
        return true;
    }

    public static boolean isNumeric(String str) {
        if (str == null || str.isBlank())
            return false;
        char[] ch = str.toCharArray();
        for (char c : ch)
            if (!Character.isDigit(c) && c != '-' && c != '.')
                return false;
        return true;
    }

    public static boolean isInteger(String str) {
        if (str == null || str.isBlank())
            return false;
        char[] ch = str.toCharArray();
        for (char c : ch)
            if (!Character.isDigit(c) && c != '-')
                return false;
        return true;
    }

    public static boolean isValidDate(String str) {
        if (str == null || str.isBlank())
            return false;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        try {
            dateFormat.parse(str.trim());
        } catch (ParseException pe) {
            return false;
        }
        return true;
    }
}
