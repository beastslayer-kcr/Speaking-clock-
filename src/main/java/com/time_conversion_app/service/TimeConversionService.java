package com.time_conversion_app.service;



import org.springframework.stereotype.Service;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Service
public class TimeConversionService {

    public String convertTimeToWords(String time) {
        try {
            LocalTime localTime = LocalTime.parse(time, DateTimeFormatter.ofPattern("HH:mm"));
            
            // Check for special cases: Midday and Midnight
            if (localTime.equals(LocalTime.NOON)) {
                return "It's Midday";
            } else if (localTime.equals(LocalTime.MIDNIGHT)) {
                return "It's Midnight";
            }

            // Convert hours and minutes to words
            String hourWords = NumberToWords.convertToWords(localTime.getHour());
            String minuteWords = NumberToWords.convertToWords(localTime.getMinute());

            // Construct the time in words
            String result = "It's " + hourWords + " " + (minuteWords.equals("") ? "" : minuteWords + " ") + "o'clock";
            return result;
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid time format. Use 'HH:mm' format.");
        }
    }
}

