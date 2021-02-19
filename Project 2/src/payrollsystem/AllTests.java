package payrollsystem;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ CompanyTest.class, DateTest.class, EmployeeTest.class,
				FulltimeTest.class, ManagementTest.class, ParttimeTest.class,
				PayrollProcessingTest.class, ProfileTest.class })
public class AllTests {

}
