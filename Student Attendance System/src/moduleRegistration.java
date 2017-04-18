//creating the class moduleRegistration
public class moduleRegistration {
	
	//declaring the objects and making the access specifier private
	private String StudentNumber;
	private String UnitID;
	
	//constructor for objects
	public moduleRegistration(String studentNumber, String unitID) {
		super();
		StudentNumber = studentNumber;
		UnitID = unitID;
	}
	// using getters for each objects
	public String getStudentNumber() {
		return StudentNumber;
	}
	
	public String getUnitID() {
		return UnitID;
	}
	
	
	

}
