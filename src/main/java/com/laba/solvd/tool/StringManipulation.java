package com.laba.solvd.tool;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringManipulation {
    public static String capitalize(String str) {
        if (str == null)
            str = "";

        List<String> arr = Arrays.asList(str.split(" "));
        StringBuilder sb = new StringBuilder();

        arr.stream().forEach(s -> {
            if (!s.equals("") && arr.size() > 1)
                sb.append(Character.toUpperCase(s.charAt(0))).append(s.substring(1).toLowerCase()).append(" ");
            else
                sb.append(Character.toUpperCase(s.charAt(0))).append(s.substring(1).toLowerCase());
        });

        return sb.toString();
    }

    public static boolean isAlphabetic(String str) {
        if (str == null || str.isBlank())
            return false;

        return str.chars().mapToObj(c -> (char) c).collect(Collectors.toList()).stream().allMatch(c -> Character.isLetter(c) || Character.isWhitespace(c));
    }

    public static boolean isNumeric(String str) {
        if (str == null || str.isBlank())
            return false;

        return str.chars().mapToObj(c -> (char) c).collect(Collectors.toList()).stream().allMatch(c -> Character.isDigit(c) || c == '-' || c == '.');
    }

    public static boolean isInteger(String str) {
        if (str == null || str.isBlank())
            return false;

        return str.chars().mapToObj(c -> (char) c).collect(Collectors.toList()).stream().allMatch(c -> Character.isDigit(c) || c == '-');
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
