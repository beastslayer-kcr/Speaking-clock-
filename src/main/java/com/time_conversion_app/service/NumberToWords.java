package com.time_conversion_app.service;
public class NumberToWords {

    private static final String[] units = {
        "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
        "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"
    };

    private static final String[] tens = {
        "", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"
    };

    public static String convertToWords(int num) {
        if (num < 20) {
            return units[num];
        } else if (num < 100) {
            return tens[num / 10] + ((num % 10 != 0) ? " " + units[num % 10] : "");
        } else if (num < 1000) {
            return units[num / 100] + " hundred" + ((num % 100 != 0) ? " and " + convertToWords(num % 100) : "");
        }
        return "Invalid number";
    }
}

