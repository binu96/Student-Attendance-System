//creating the class studentDetails
public class studentDetails {
	
	//declaring the objects and making the access specifier private
	private String StudentNumber;
	private String LastName;
	private String FirstName;
	
	//constructor for objects
	public studentDetails(String studentNumber, String lastName, String firstName) {
		super();
		StudentNumber = studentNumber;
		LastName = lastName;
		FirstName = firstName;
	}
	
	// using getters for each objects
	public String getStudentNumber() {
		return StudentNumber;
	}
	
	public String getLastName() {
		return LastName;
	}
	
	public String getFirstName() {
		return FirstName;
	}
	
	
}
