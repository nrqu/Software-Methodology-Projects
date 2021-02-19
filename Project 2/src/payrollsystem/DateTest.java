/**
 * 
 */
package payrollsystem;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @hidden
 */
public class DateTest {
			
			
			
	/**
	 * Test method for {@link payrollsystem.Date#isValid()}.
	 */
	@Test
	public void testIsValid() {
		Date date = new Date("999/30/2020");
		assertFalse(date.isValid());
		
		date = new Date("2/28/2020"); //valid
		assertTrue(date.isValid());
		
		date = new Date("-2/28/2020"); //invalid
		assertFalse(date.isValid());
		
		date = new Date("2/28/2021"); //invalid
		assertFalse(date.isValid());
			
	}

	
	/**
	 * Test method for {@link payrollsystem.Date#compareTo(payrollsystem.Date)}.
	 */
	@Test
	public void testCompareTo() {
		Date date = new Date("1/25/2020");
		Date date2 = new Date("1/25/2020");
		int[] arr = new int[] {-1,0,1};
		
		assertEquals(arr[1],date.compareTo(date2));//equal
		
		
		date = new Date("1/26/2020");
		assertEquals(arr[2],date.compareTo(date2));//greater
		
		
		
		date = new Date("1/24/2020");
		assertEquals(arr[0],date.compareTo(date2));//less
		
		
	}
	
	
	/**
	 * Test method for {@link payrollsystem.Date#getDate()}.
	 */
	@Test
	public void testGetDate() {
		Date date = new Date("1/25/2020");
		
		assertEquals("1/25/2020",date.getDate());
		
		date = new Date("2/29/2020");
		
		assertEquals("2/29/2020",date.getDate());
		
	}

	
	/**
	 * Test method for {@link payrollsystem.Date#getDateSortFormat()}.
	 */
	@Test
	public void testGetDateSortFormat() {
		Date date = new Date("1/25/2020");
		
		assertEquals("2020/1/25",date.getDateSortFormat());
		
		
		date = new Date("2/29/2020");
		
		
		assertEquals("2020/2/29",date.getDateSortFormat());
		
		
		
	}

}
