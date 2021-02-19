/**
 * 
 */
package payrollsystem;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @hidden
 */
public class ManagementTest {

	/**
	 * Test method for {@link payrollsystem.Management#equals(java.lang.Object)}.
	 */
	@Test
	public void testEqualsObject() {
		Employee employee = new Management(new Profile("name","CS", "1/20/2020"), 78000,2); 
		
		
		Employee employee2 = new Fulltime(new Profile("name","IT", "1/20/2020"), 78000);
		
		
		assertEquals(false,employee.equals(employee2));//different object type
		
		
		employee2 = new Fulltime(new Profile("name","CS", "1/20/2020"), 78000);
		
		assertEquals(true,employee.equals(employee2));//different object types but same profile
		
		
		employee2 = new Parttime(new Profile("different","CS", "1/20/2020"), 32.34f);
		
		assertEquals(false,employee.equals(employee2));//different object types and different information
		
	}



}
