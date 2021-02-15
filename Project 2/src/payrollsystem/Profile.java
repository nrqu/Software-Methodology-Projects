package payrollsystem;

public class Profile {
	private String name; //employee’s name in the form “lastname,firstname”
	private String department; //department code: CS, ECE, IT
	private Date dateHired;
	
	Profile(String name,String department,String dateHired){
		this.name = name;
		this.department= department;
		this.dateHired = new Date(dateHired);
	}
	
	
	//TODO
	@Override
	public String toString() {
		return name+"::"+department+"::"+dateHired.getDate(); }
	@Override
	public boolean equals(Object obj) {
		return false; } //compare name, department and dateHired
}
