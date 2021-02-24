
package payrollsystem;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @hidden
 */
public class CompanyTest {


	/**
	 * Test method for {@link payrollsystem.Company#add(payrollsystem.Employee)}.
	 */
	@Test
	public void testAdd() {
		Company company = new Company();
		Employee employee = new Parttime(new Profile("name","CS", "1/20/2020"), 32.34f); 
		
		assertTrue(company.add(employee));//insert new employee
		
		
		employee = new Fulltime(new Profile("name","CS", "1/20/2020"), 78000);
		
		assertFalse(company.add(employee));//employee profile is repeated
		
		employee = new Management(new Profile("name","CS", "1/20/2020"), 78000,2);

		assertFalse(company.add(employee));//employee profile is repeated 
		
		employee = new Management(new Profile("name","IT", "1/20/2020"), 78000,2);

		assertTrue(company.add(employee));//insert new employee
	}

	/**
	 * Test method for {@link payrollsystem.Company#remove(payrollsystem.Employee)}.
	 */
	@Test
	public void testRemove() {
		Company company = new Company();
		Employee employee = new Parttime(new Profile("name","CS", "1/20/2020"), 32.34f); 
		
		assertTrue(company.add(employee));//insert new employee
		assertTrue(company.remove(employee));//employee profile removed
		
		assertFalse(company.remove(employee));//employee list is empty
		
		
		employee = new Management(new Profile("name","CS", "1/20/2020"), 78000,2);
		assertTrue(company.add(employee));//insert new employee
		assertTrue(company.remove(employee));//employee profile is removed
		
		
		employee = new Management(new Profile("name","IT", "1/20/2020"), 78000,2);
		assertTrue(company.add(employee));//insert new employee
		assertTrue(company.remove(employee));//employee profile is removed
		
		assertFalse(company.remove(employee));//employee list is empty
	}

	/**
	 * Test method for {@link payrollsystem.Company#setHours(payrollsystem.Employee)}.
	 */
	@Test
	public void testSetHours() {
		Company company = new Company();
		Employee employee = new Parttime(new Profile("name","CS", "1/20/2020"), 100);
		assertTrue(company.add(employee));//insert new employee
		assertTrue(company.setHours(employee));//sets the hour
		
		assertTrue(company.remove(employee));//remove only employee
		
		assertFalse(company.setHours(employee));//list is empty
	}

}
