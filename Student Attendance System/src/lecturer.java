//creating the class lecturer
public class lecturer {
	
	//declaring the objects and making the access specifier private
	private String UnitId;
	private String UnitName;
	private String RoomNumber;
	private String RoomName;
	private String LecturerName;
	private int RoomCapacity;
	private int NumberOfStudentsEnrolled;
	
	//constructor for objects
	public lecturer(String unitId, String unitName, String roomNumber, String roomName, String lecturerName,
			int roomCapacity, int numberOfStudentsEnrolled) {
		super();
		this.UnitId = unitId;
		this.UnitName = unitName;
		this.RoomNumber = roomNumber;
		this.RoomName = roomName;
		this.LecturerName = lecturerName;
		this.RoomCapacity = roomCapacity;
		this.NumberOfStudentsEnrolled = numberOfStudentsEnrolled;
	}
	
	// using getters for each objects
	public String getUnitId() {
		return UnitId;
	}
	
	public String getUnitName() {
		return UnitName;
	}
	
	public String getRoomNumber() {
		return RoomNumber;
	}
	
	public String getRoomName() {
		return RoomName;
	}
	
	public String getLecturerName() {
		return LecturerName;
	}
	
	public int getRoomCapacity() {
		return RoomCapacity;
	}
	
	public int getNumberOfStudentsEnrolled() {
		return NumberOfStudentsEnrolled;
	}
	
	

}
