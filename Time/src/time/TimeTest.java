package time;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class TimeTest {

	// test of GetTotalSeonds Good,Bad,Boundary 
	@Test
	void testGetTotalSecondsGood() {
		int seconds = Time.getTotalSeconds("05:05:05:00");
		assertTrue("the seconds were not calculated properly", seconds == 18305);
	}

	@Test
	void testGetTotalSecondsBad() {
		assertThrows(
				StringIndexOutOfBoundsException.class, ()-> {Time.getTotalSeconds("10:00");});
		
	}
	
	@Test
	void testGetTotalSecondsBooundary() {
		 assertTrue(Time.getTotalSeconds("00:00:00:00") == 0);
		 assertTrue(Time.getTotalSeconds("23:59:59:59") <= Integer.MAX_VALUE);
		
	}
	
	// Good Test for all 
	
	@ParameterizedTest
	@ValueSource(strings = { "05:00:00:00", "05:15:15:15",
	"05:59:59:59" })
	void testGetTotalHoursGood(String candidate) {
	int hours = Time.getTotalHours(candidate);
	assertTrue("The hours were not calculated properly",
	hours ==5);
	}
	

	@Test
	void testGetTotalMinutesGood() {
		
		assertTrue(Time.getTotalMinutes("02:00:00:00") == 0);
		assertTrue(Time.getTotalMinutes("01:59:00:00") == 59);
		
	}
	
	@Test
	void testGetSecondsGood() {
		assertTrue(Time.getSeconds("05:05:05:05") == 5);
	}
	
	
	// Bad Test for all 
	@Test
	void testGetTotalHourBad() {
		assertThrows(
				StringIndexOutOfBoundsException.class, ()-> {Time.getTotalHours("");});
				
	}
	
	@Test
	void testGetTotalMinutesBad() {
		assertThrows(
				StringIndexOutOfBoundsException.class, ()-> {Time.getTotalMinutes("10:");});
				
	}
	@Test
	void testGetSecondsBad() {
		assertThrows(
				StringIndexOutOfBoundsException.class, ()-> {Time.getSeconds("10:00");});
				
	}
	
	 
	// Boundray Test for all 
	
	@Test
	void testGetTotalHoursBoundary() {
		assertTrue(Time.getTotalHours("00:00:00:41")== 0);
		assertTrue(Time.getTotalHours("23:00:00:23")== 23);
	}
	
	@Test
	void testGetTotalMinutesBoundary() {
		assertTrue(Time.getTotalMinutes("00:00:00:00")== 0);
		assertTrue(Time.getTotalMinutes("23:59:00:00")== 59);
	}
	
	@Test
	void testGetSecondsBoundary() {
		assertTrue(Time.getSeconds("00:00:00:00")== 0);
		assertTrue(Time.getSeconds("23:59:59:00")== 59);
	}
	
	
	
	// Test for the milliseconds 
	
	@Test 
	void testGetMilliseondsGood() {
		assertTrue(Time.getMilliseconds("02:00:00:06") == 06);
	}
	
	@Test 
	void testGetMillisecondsBad() {
		assertThrows(
				StringIndexOutOfBoundsException.class, ()-> {Time.getMilliseconds("12:20:20:");});
		
	}
	
	@Test
	void testGetMillisecondsBoundary() {
		assertTrue(Time.getMilliseconds("12:05:05:01") == 01);
	}
	

	
	
	
	
	
	
}
