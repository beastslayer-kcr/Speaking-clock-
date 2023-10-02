package time_conversion_app.time_conversion_app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.time_conversion_app.service.NumberToWords;
import com.time_conversion_app.service.TimeConversionService;



public class TimeConversionServiceTest {
    
    @InjectMocks
    private TimeConversionService timeConversionService;
    
    @Mock
    private NumberToWords numberToWords;

	private String time;
    
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }
     
    @Test
    public void testValidTimeConversion() {
        String time = "08:30";
        String expected = "It's eight thirty o'clock";
        String actual = timeConversionService.convertTimeToWords(time);
        assertEquals(expected, actual);
    }

    @Test
    public void testMiddayConversion() {
        String time = "12:00";
        String expected = "It's Midday";
        String actual = timeConversionService.convertTimeToWords(time);
        assertEquals(expected, actual);
    }

    @Test
    public void testMidnightConversion() {
        String time = "00:00";
        String expected = "It's Midnight";
        String actual = timeConversionService.convertTimeToWords(time);
        assertEquals(expected, actual);
    }

    @Test
    public void testInvalidTimeFormat() {
        String time = "abc"; // Invalid format
        assertThrows(IllegalArgumentException.class, () -> timeConversionService.convertTimeToWords(time));
    }
    // Add more test cases here
}
