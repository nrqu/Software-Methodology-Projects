package payrollsystem;

/**
 * This class is used as an abstract data type to represent the profile of an employee it contains the name,department and date hired
 * 
 * @author HECTOR CERDA, LUIS FIGUEROAGIL
 *
 */
public class Profile {
	private String name; //employee’s name in the form “lastname,firstname”
	private String department; //department code: CS, ECE, IT
	private Date dateHired; //date hired
	/**
	 * CONSTRUCTOR: Creates a new object with a new profile containing Name,date Hired,Department
	 */
	Profile(String name,String department,String dateHired){
		this.name = name;
		this.department= department;
		this.dateHired = new Date(dateHired);
	}
	
	/**
	 * Creates a string consisting of name::department::date hired
	 * @return returns a string representation of the employee information
	 */
	@Override
	public String toString() {
		return name+"::"+department+"::"+dateHired.getDate(); 
	}
	
	/**
	 * Checks if two profile objects are equal by comparing their name,department and date hired
	 * @return returns true if equal false otherwise 
	 */
	@Override
	public boolean equals(Object obj) {
		Profile tmpObj = (Profile) obj;
		
		if(this.name.equals(tmpObj.name) && this.department.equals(tmpObj.department)
				&& this.dateHired.getDate().equals(tmpObj.dateHired.getDate()))
			return true;
		else
			return false; 			
	} //compare name, department and dateHired
	/**
	 * Getter method that returns the date the employee was hired
	 * @return returns a Date object representing the date hired
	 */
	public Date getDate() {
		return dateHired;
	}
	/**
	 * Getter method that returns the department of the employee
	 * @return returns a string representing the department of the employee
	 */
	public String getDepartment() {
		return this.department;
	}
}
