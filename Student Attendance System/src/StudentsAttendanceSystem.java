import java.io.File; //importing the File
import java.io.FileNotFoundException; //importing the java IO exception
import java.io.FileWriter; //importing the File writer
import java.io.IOException; //importing the IOException
import java.io.PrintWriter; //importing the PrintWriter
import java.util.ArrayList; //importing the ArrayList
import java.util.InputMismatchException; //importing the InputMisMatchException
import java.util.Scanner; //importing the Scanner
import java.util.StringTokenizer; //importing the StringTokenizer
import java.util.TreeSet; //importing the TreeSet
import javax.swing.JOptionPane; //importing the JOptionPane to show error messages

public class StudentsAttendanceSystem {

	// Creating a file object to store the generated report
	static File generatedReport = new File("AttendanceReport.txt");

	public static void main(String[] args) {
		// Setting up some instructions to follow before proceeding to print the
		// report
		System.out.println("           WELCOME TO UOG STUDENTS ATTENDANCE SYSTEM                     ");
		System.out.println("_________________________________________________________________________");
		System.out.println(" READ the following information before proceeding.");
		System.out.println("_________________________________________________________________________");
		System.out.println("1. Enter (1) to Print the Students Attendance Report for the day.");
		System.out.println("2. Enter (2) to update or Edit the current data.");
		System.out.println("_________________________________________________________________________");

		// creating a Scanner object and wrapping the System.in
		Scanner sc = new Scanner(System.in);

		// declaring two input variables and inizializing it to zero
		int input1 = 0;
		int input2 = 0;

		do { // do loop to run the process again and again
			try { // using try to catch InputMissmatchException

				// Output message to enter the data and assigning the input data
				// to the variable
				// from the scanner
				System.out.print("Please Enter here: ");
				input1 = sc.nextInt();

				// using a if condition to validate the integer inputs
				if ((input1 <= 0) || (input1 >= 3)) {

					// showing the error message
					System.err.println("Please enter a valid number.");
				}

			} catch (InputMismatchException e) { // catching the input missmatch
													// exception

				// showing the error message to the exception
				System.err.println("Please enter a valid character.");
			}

			// moving to next line
			sc.nextLine();

			// validating the inputs entered
		} while ((input1 != 1) && (input1 != 2));

		// if the input1 is 1
		if (input1 == 1) {

			// calling the Printing Several reports method
			printingSeveralReports();
			System.out.println("-Completed-");

			// if the input1 is 2
		} else if (input1 == 2) {

			// Assigtning some Instructions need to be followed
			System.out.println("_________________________________________________________________________");
			System.out.println(" READ the following information before proceeding.");
			System.out.println("_________________________________________________________________________");
			System.out.println("1. Enter (1) to add a new student record.");
			System.out.println("2. Enter (2) to edit an existing student record.");
			System.out.println("3. Enter (3) to delete an existing student record.");
			System.out.println("4. Enter (4) to add a new lecturer record.");
			System.out.println("5. Enter (5) to edit an existing lecturer record.");
			System.out.println("6. Enter (6) to delete an existing lecturer record.");
			System.out.println("_________________________________________________________________________");

			do { // do loop to run the process again and again
				try { // using try to catch InputMissmatchException

					// Output message to enter the data and assigning the input
					// data to the variable
					// from the scanner
					System.out.print("Please Enter here: ");
					input2 = sc.nextInt();

					// using a if condition to validate the integer inputs
					if ((input2 <= 0) || (input2 >= 7)) {

						// showing the error message
						System.err.println("Please enter a valid number.");
					}

				} catch (InputMismatchException e) { // catching the input
														// missmatch exception

					// showing the error message to the exception
					System.err.println("Please enter a valid character.");
				}
				// moving to next line
				sc.nextLine();

				// validating the inputs entered
			} while ((input2 != 1) && (input2 != 2) && (input2 != 3) && (input2 != 4) && (input2 != 5)
					&& (input2 != 6));

			// if the input2 is 1
			if (input2 == 1) {

				// calling the add student record method
				addStudentRecord();
				System.out.println("The Data have been successfully stored.");

				// if the input2 is 2
			} else if (input2 == 2) {

				// calling the edit student record method
				editStudentRecord();
				System.out.println("The Data have been successfully edited.");

				// if the input2 is 3
			} else if (input2 == 3) {

				// calling the delete existing student records
				// method
				deleteExistingStudentRecords();
				System.out.println("The Data have been successfully deleted.");

				// if the input2 is 4
			} else if (input2 == 4) {

				// calling the add lecture records method
				addLectureRecord();
				System.out.println("The Data have been successfully stored.");

				// if input2 is 5
			} else if (input2 == 5) {

				// calling the edit lecture records method
				editLecturerRecords();
				System.out.println("The Data have been successfully edited.");

				// if input2 is 6
			} else if (input2 == 6) {

				// calling the delete Existing lecture record
				deleteExistingLecturerRecords();
				System.out.println("The Data have been successfully deleted.");

			}
		}
		// closing the Scanner
		sc.close();
	}

	// creating a method to print the students who are present for the lecture
	// by referring to the files and returning the value to report method
	public static int attendanceListInReport(String unitID, String date, String weekNo) {

		// initializing a count coz it needs to be returned
		int count = 0;

		try { // using a try to validate File not Found Exception and
				// IOException

			// creating a file object to read the students details
			// creating a scanner and wrapping it to the file object
			File studentDetailsFile = new File("studentdetails.txt");
			Scanner sc = new Scanner(studentDetailsFile);

			// excluding the first line of the file containing the headings
			sc.nextLine();

			// creating the file writer object to write the data to the auto
			// generate file
			// wrapping the file writer with print writer and flushing it with
			// boolean value
			FileWriter fw = new FileWriter(generatedReport, true);
			PrintWriter pw = new PrintWriter(fw, true);

			// creating the output headings in the console with tab spaces
			// writing the output headings in the auto generating file
			System.out.println("Student No. \tLast Name \tFirstName \tPresent ");
			System.out.println(); // moving to nextline
			pw.println("Student No. \tLast Name \t\tFirstName \t\tPresent ");
			pw.println(); // moving to next line

			// using a while loop to navigate through the entered data
			// using hasNextLine function
			while (sc.hasNextLine()) {

				// creating a String variable and getting the input using
				// scanner
				// creating a String Tokenizer object to tokenize the data input
				// data
				String data = sc.nextLine();
				StringTokenizer token = new StringTokenizer(data);

				// creating the studentDetails object using the studentDetails
				// class
				// adding tokens for the object
				studentDetails object = new studentDetails(token.nextToken(), token.nextToken(), token.nextToken());

				// inizialising a empty string variable
				String present1 = "";

				// inizialising a boolean variable and calling the
				// attendanceCheck method
				// getting the student number using a getter from the Object
				boolean present = attendanceCheck(object.getStudentNumber(), unitID, date, weekNo);

				// if the result from the present is true
				if (present == true) {
					// assigninng the present1 with Y
					present1 = "Y";
					count++; // adding 1 to the count

				} else {
					// asigning the present1 with N
					present1 = "N";

				}

				// inizialising a boolean variable and assigning it to false
				boolean commencingUnit = false;

				// creating a file object to read the moduleRegistration details
				// creating a scanner and wrapping it to the file object
				File moduleRegistrationFile = new File("moduleRegistration.txt");
				Scanner input = new Scanner(moduleRegistrationFile);

				// excluding the first line of the file containing the headings
				input.nextLine();

				// using a while loop to navigate through the entered data
				// using hasNextLine function
				while (input.hasNextLine()) {

					// creating a String variable and getting the input using
					// scanner
					// creating a String Tokenizer object to tokenize the data
					// input data
					String data1 = input.nextLine();
					StringTokenizer token1 = new StringTokenizer(data1);

					// creating the moduleRegistration object using the
					// moduleRegistration class
					// adding tokens for the object
					moduleRegistration object1 = new moduleRegistration(token1.nextToken(), token1.nextToken());

					// using a if compare the values in the object and object1
					// created
					if ((object.getStudentNumber().equals(object1.getStudentNumber())
							&& (object1.getUnitID().equals(unitID)))) {
						commencingUnit = true; // if it is true then assign
												// commencingUnit with true
					}

				}
				// if the commencing unit is true then the objects get printed
				if (commencingUnit == true) {

					// using prinf to write the objects in console and the file
					System.out.printf("%s\t\t%s\t\t%s\t\t%s\n", object.getStudentNumber(), object.getLastName(),
							object.getFirstName(), present1);
					pw.printf("%s\t\t%s\t\t%s\t\t%s\n", object.getStudentNumber(), object.getLastName(),
							object.getFirstName(), present1);
					pw.println();
				}
				// closing the scanner
				input.close();
			}
			// closing the scanner and the print writer
			sc.close();
			pw.close();

		} catch (FileNotFoundException e) { // catching the File not Found
											// exception
			// using show message dialog to show the error message
			JOptionPane.showMessageDialog(null, "File not found.");

		} catch (IOException ex) { // catching the IO exception
			ex.printStackTrace(); // to print the throwable and it's backtrace
									// to the standard error stream
		}
		return count; // returning the count

	}

	// creating a method to print the report with a return value to
	// printingSeveralReports method
	public static void report(String moduleName, String date, String weekNo) {

		try { // using a try to validate File not Found Exception and
				// IOException

			// declaring and initializing two variables to zero
			int numberOfStudentsEnrolled = 0;
			int roomCapacity = 0;

			// creating a file object to read the lecturer details
			// creating a scanner and wrapping it to the file object
			File lecturerFile = new File("lecturer.txt");
			Scanner sc = new Scanner(lecturerFile);

			// excluding the first line of the file containing the headings
			sc.nextLine();

			// creating the file writer object to write the data to the auto
			// generate file
			// wrapping the file writer with print writer and flushing it with
			// boolean value
			FileWriter fw = new FileWriter(generatedReport, true);
			PrintWriter pw = new PrintWriter(fw, true);

			// creating the Heading output in console
			// writing the heading output in the auto generating file
			System.out.println();
			System.out.println("_________________________________________________________________________");
			System.out.println("Attendance Report\n");
			System.out.println("-------------------------------------------------------------------------");
			pw.println();
			pw.println("________________________________________________________________");
			pw.println("Attendance Report");
			pw.println("----------------------------------------------------------------");
			pw.println();

			// using a while loop to navigate through the entered data
			// using hasNextLine function
			while (sc.hasNextLine()) {

				// creating a String variable and getting the input using
				// scanner
				// creating a String Tokenizer object to tokenize the data input
				// data
				String data = sc.nextLine();
				StringTokenizer token = new StringTokenizer(data);

				// creating the lecturer object using the lecturer class
				// adding tokens for the object
				lecturer object = new lecturer(token.nextToken(), token.nextToken(), token.nextToken(),
						token.nextToken(), token.nextToken(), Integer.parseInt(token.nextToken()),
						Integer.parseInt(token.nextToken()));

				// if the item in the object lecturer is equal the imported
				// parameter
				if (object.getUnitId().equals(moduleName)) {

					// to print the report
					System.out.println("Unit \t\t\t:\t" + object.getUnitId());
					System.out.println("Unit Name \t\t:\t" + object.getUnitName());
					System.out.println("Room Number \t\t:\t" + object.getRoomNumber());
					System.out.println("Room Name \t\t:\t" + object.getRoomName());
					System.out.println("Lecturer \t\t:\t" + object.getLecturerName());
					System.out.println("Week# \t\t\t:\t" + weekNo);
					System.out.println("Date \t\t\t:\t" + date + "\n");
					System.out.println("-------------------------------------------------------------------------");

					// To write to the file
					pw.println("Unit \t\t\t:\t" + object.getUnitId());
					pw.println("Unit Name \t\t:\t" + object.getUnitName());
					pw.println("Room Number \t:\t" + object.getRoomNumber());
					pw.println("Room Name \t\t:\t" + object.getRoomName());
					pw.println("Lecturer \t\t:\t" + object.getLecturerName());
					pw.println("Week# \t\t:\t" + weekNo);
					pw.println("Date \t\t\t:\t" + date + "\n");
					pw.println("----------------------------------------------------------------");
					pw.println();

					// assigning the object values to these variables
					// to calculate the percentage occupancy
					numberOfStudentsEnrolled = object.getNumberOfStudentsEnrolled();
					roomCapacity = object.getRoomCapacity();
				}
			}

			// inizializing a variable and calling the method
			// attendanceListInReport
			// leaving a line space
			int attendanceCheck = attendanceListInReport(moduleName, date, weekNo);
			System.out.println();
			pw.println();

			// creating the format and assigning the variables accordingly in
			// the console
			System.out.println("-------------------------------------------------------------------------");
			System.out.println("Lecturer Confirmed Attendance \t : YES/NO");
			System.out.println("Students Enrolled \t\t : " + numberOfStudentsEnrolled);
			System.out.println("Attendance \t\t\t : " + attendanceCheck);
			System.out.println("Room Capacity \t\t\t : " + roomCapacity);
			System.out.println("Percentage Occupancy \t\t : "
					+ (((double) Math.round(((attendanceCheck * 1.0) / roomCapacity) * 100.0))) + "%");
			System.out.println("_________________________________________________________________________");

			// creating the format and assigning the variables accordingly in
			// the AttendanceReport text file
			pw.println("----------------------------------------------------------------");
			pw.println("Lecturer Confirmed Attendance \t : YES/NO");
			pw.println("Students Enrolled \t\t\t : " + numberOfStudentsEnrolled);
			pw.println("Attendance \t\t\t\t : " + attendanceCheck);
			pw.println("Room Capacity \t\t\t\t : " + roomCapacity);
			pw.println("Percentage Occupancy \t\t\t : "
					+ (((double) Math.round(((attendanceCheck * 1.0) / roomCapacity) * 100.0))) + "%");
			pw.println("________________________________________________________________");

			// leaving two lines of space in the text file
			pw.println();
			pw.println();

			// closing the scanner and the printWriter
			sc.close();
			pw.close();

		} catch (FileNotFoundException e) {// catching the File not Found
											// exception
			// using show message dialog to show the error message
			JOptionPane.showMessageDialog(null, "File not found.");

		} catch (IOException ex) {// catching the IO exception
			ex.printStackTrace(); // to print the throwable and it's backtrace
									// to the standard error stream
		}
	}

	// creating a method to printing mutiple reports without a return value
	public static void printingSeveralReports() {

		try { // using a try to validate File not Found Exception

			// creating a file object to read the attendacelog
			// creating a scanner and wrapping it to the file object
			File attendanceLogFile = new File("attendancelog.txt");
			Scanner sc = new Scanner(attendanceLogFile);

			// excluding the first line of the file containing the headings
			sc.nextLine();

			// creating a print writer to the file where report needs to be
			// printed
			PrintWriter pw = new PrintWriter(generatedReport);

			// creating an arraylist to store the string values
			ArrayList<String> arr = new ArrayList<String>();

			// using a while loop to navigate through the entered data
			// using hasNextLine function
			while (sc.hasNextLine()) {

				// creating a String variable and getting the input using
				// scanner
				// creating a String Tokenizer object to tokenize the data
				// input data
				String data = sc.nextLine();
				StringTokenizer token = new StringTokenizer(data);

				// creating the attendance object using the attendance
				// class
				// adding tokens for the object
				attendance object = new attendance(token.nextToken(), token.nextToken(), token.nextToken(),
						token.nextToken(), token.nextToken(), token.nextToken());

				// initializing a String variable and Storing the unit ID, date
				// and week number obtained from the object
				// adding them to the arraylist arr
				String checkingLines = (object.getUnitID() + " " + object.getDate() + " " + object.getWeekNo());
				arr.add(checkingLines);

			}
			// Using TreeSet to order the reports respectively
			// creating the object TreeSet and assigning the arraylist arr to it
			TreeSet<String> treeSetList = new TreeSet<String>(arr);

			// creating a for enchanced loop to navigate through the treesetlist
			for (String count : treeSetList) {

				// creating a new String tokenizer and assigning the count value
				// into it
				StringTokenizer token1 = new StringTokenizer(count);

				// tokenizing each component separately
				String moduleName = token1.nextToken();
				String date = token1.nextToken();
				String weekNo = token1.nextToken();

				// calling the method report
				report(moduleName, date, weekNo);

				// leaving one line of space in both console and file
				System.out.println();
				pw.println();

			}
			// closing the scanner and the printWriter
			sc.close();
			pw.close();

		} catch (FileNotFoundException e) { // catching the File not Found
											// exception
			// using show message dialog to show the error message
			JOptionPane.showMessageDialog(null, "File not found.");
		}
	}

	// creating a method to check the attendance of the students with a return
	// value boolean to the attendanceListInReport method
	public static boolean attendanceCheck(String studentId, String unitId, String date, String weekNo) {

		// inizialising a boolean variable and assigning it to false
		boolean present = false;

		try { // using a try to validate File not Found Exception

			// creating a file object to read the students details
			// creating a scanner and wrapping it to the file object
			File attendanceLogFile = new File("attendancelog.txt");
			Scanner sc = new Scanner(attendanceLogFile);

			// excluding the first line of the file containing the headings
			sc.nextLine();

			// using a while loop to navigate through the entered data
			// using hasNextLine function
			while (sc.hasNextLine()) {

				// creating a String variable and getting the input using
				// scanner
				// creating a String Tokenizer object to tokenize the data
				// input data
				String data = sc.nextLine();
				StringTokenizer token = new StringTokenizer(data);

				// creating the attendance object using the
				// attendance class
				// adding tokens for the object
				attendance object = new attendance(token.nextToken(), token.nextToken(), token.nextToken(),
						token.nextToken(), token.nextToken(), token.nextToken());

				// comparing whether the objects equal to the parameters
				// obtained
				if ((object.getStudentID().equals(studentId)) && (object.getUnitID().equals(unitId))
						&& (object.getDate().equals(date)) && (object.getWeekNo().equals(weekNo))) {

					present = true; // assigning present true
					return present;// returning the value

				}

			}
		} catch (FileNotFoundException e) { // catching the File not Found
											// exception
			// using show message dialog to show the error message
			JOptionPane.showMessageDialog(null, "File not found.");
		}
		return present; // returning the present
	}

	// creating a method to add new Student records to student details file and
	// module registration file
	public static void addStudentRecord() {

		try { // using a try to validate File not Found Exception and
				// IOException

			// creating a scanner to take the input from user
			Scanner sc = new Scanner(System.in);

			// setting up some instructions to user
			System.out.println("_________________________________________________________________________");
			System.out.println("                         ADD A NEW STUDENT DATA                          ");
			System.out.println("-------------------------------------------------------------------------");
			System.out.println("Please Enter the student details as follows,");
			System.out.println();
			System.out.println("Eg :StudentID(2014xxx) LastName(Amber) FirstName(Kate) UnitID(ECSIXXX)");
			System.out.println();
			System.out.println("Make sure that above data entered are followed by a SPACE.");
			System.out.println("-------------------------------------------------------------------------");
			System.out.print("Enter the data : ");

			// creating variables and storing the input from the user
			String studentNumber = sc.next();
			String lastName = sc.next();
			String firstName = sc.next();
			String unitID = sc.next();

			// creating a file object to write the students details
			File studentDetailsFile = new File("studentdetails.txt");

			// creating a file writer to write to the specific file
			// wrapping the file writer with print writer and flushing it with a
			// boolean value
			FileWriter fw = new FileWriter(studentDetailsFile, true);
			PrintWriter pw = new PrintWriter(fw, true);

			// writing to the file
			// closing the printwriter
			pw.println(studentNumber + "\t\t" + lastName + "\t\t\t" + firstName);
			pw.close();

			// creating a file object to write the students details
			File moduleRegistrationFile = new File("moduleRegistration.txt");

			// creating a file writer to write to the specific file
			// wrapping the file writer with print writer and flushing it with a
			// boolean value
			FileWriter fw1 = new FileWriter(moduleRegistrationFile, true);
			PrintWriter pw1 = new PrintWriter(fw1, true);

			// writing to the file
			// closing the printwriter
			// closing the scanner
			pw1.println(studentNumber + "\t\t\t" + unitID);
			pw1.close();
			sc.close();

		} catch (FileNotFoundException e) {// catching the File not Found
											// exception
			// using show message dialog to show the error message
			JOptionPane.showMessageDialog(null, "File not found.");

		} catch (IOException ex) {// catching the IO exception
			ex.printStackTrace(); // to print the throwable and it's backtrace
									// to the standard error stream
		}
	}

	// creating a method to add new lecturer records to lecturer file
	public static void addLectureRecord() {

		try { // using a try to validate File not Found Exception and
				// IOException

			// creating a scanner to take the input from user
			Scanner sc = new Scanner(System.in);

			// setting up some instructions to user
			System.out.println("_________________________________________________________________________");
			System.out.println("                         ADD A NEW LECTURER DATA                         ");
			System.out.println("-------------------------------------------------------------------------");
			System.out.println("Please Enter the Lecturer as follows,");
			System.out.println();
			System.out.println("Eg :UnitID(ECISXXX) UnitName(SDP01) RoomNumber(201) \n   "
					+ " RoomName(BreakdownRoom) LecturerName(Dr.Furious) RoomCapacty(6) \n    "
					+ "NumberOfStudentsEnrolled(5)");
			System.out.println();
			System.out.println("Make sure that above data entered are followed by a SPACE, \n"
					+ "and should be in one single LINE.");
			System.out.println("-------------------------------------------------------------------------");
			System.out.print("Enter the data : ");

			// creating variables and storing the input from the user
			String unitID = sc.next();
			String unitName = sc.next();
			String roomNumber = sc.next();
			String roomName = sc.next();
			String lecturerName = sc.next();
			int roomCapacity = sc.nextInt();
			int numberOfStudentsEnrolled = sc.nextInt();

			// creating a file object to write the lecturer details
			File lecturerFile = new File("lecturer.txt");

			// creating a file writer to write to the specific file
			// wrapping the file writer with print writer and flushing it with a
			// boolean value
			FileWriter fw = new FileWriter(lecturerFile, true);
			PrintWriter pw = new PrintWriter(fw, true);

			// writing to the file
			// closing the printwriter
			// closing the scanner
			pw.println(unitID + "\t\t" + unitName + "\t\t" + roomNumber + "\t\t\t\t" + roomName + "\t\t" + lecturerName
					+ "\t\t\t" + roomCapacity + "\t\t\t\t\t" + numberOfStudentsEnrolled);
			pw.close();
			sc.close();

		} catch (FileNotFoundException e) {// catching the File not Found
											// exception
			// using show message dialog to show the error message
			JOptionPane.showMessageDialog(null, "File not found.");

		} catch (IOException ex) {// catching the IO exception
			ex.printStackTrace(); // to print the throwable and it's backtrace
									// to the standard error stream
		}
	}

	// creating a method to edit the existing student records
	public static void editStudentRecord() {

		try { // using a try to validate File not Found Exception and
				// IOException

			// creating a scanner to take the input from user
			Scanner sc = new Scanner(System.in);

			// setting up some instructions to user
			System.out.println("_________________________________________________________________________");
			System.out.println("                      EDIT AN EXISTING STUDENT DATA                      ");
			System.out.println("-------------------------------------------------------------------------");
			System.out.println("Please Enter the student details as follows,");
			System.out.println();
			System.out.println("Eg :StudentID(2014xxx) LastName(Amber) FirstName(Kate) UnitID(ECSIXXX)");
			System.out.println();
			System.out.println("Make sure that above data entered are followed by a SPACE.");
			System.out.println("-------------------------------------------------------------------------");
			System.out.print("Enter the data : ");

			// creating variables and storing the input from the user
			String studentNumber = sc.next();
			String lastName = sc.next();
			String firstName = sc.next();
			String unitID = sc.next();

			// creating a file object to read the students details
			// creating a scanner and wrapping it to the file object
			File studentdetailsFile = new File("studentdetails.txt");
			Scanner sc1 = new Scanner(studentdetailsFile);

			// leaving the first line
			sc1.nextLine();

			// creating a temporary file
			// creating a Printwriter and wrapping the temporary file
			File tempFile = new File("temp.txt");
			PrintWriter pw = new PrintWriter(tempFile);

			// creating the headings
			pw.println("StudentNo\tLastName\tFirstName");

			// using a while loop to navigate through the entered data
			// using hasNextLine function
			while (sc1.hasNextLine()) {

				// creating a String variable and getting the input using
				// scanner
				// creating a String Tokenizer object to tokenize the data
				// input data
				String data = sc1.nextLine();
				StringTokenizer token = new StringTokenizer(data);

				// creating the studentDetails object using the studentDetails
				// class
				// adding tokens for the object
				studentDetails object = new studentDetails(token.nextToken(), token.nextToken(), token.nextToken());

				// comparing whether the object deatils are equals to input data
				if (object.getStudentNumber().equals(studentNumber)) {
					// printing the following data to the temporary file
					pw.println(studentNumber + "\t\t" + lastName + "\t\t" + firstName);

				} else {
					// printing the following data to the temporary file
					pw.println(
							object.getStudentNumber() + "\t\t" + object.getLastName() + "\t\t" + object.getFirstName());
				}
			}
			// closing the print writer
			// closing the scanner
			pw.close();
			sc.close();
			sc1.close();

			// deleting the student details file
			// renaming the temporary file to students details file
			studentdetailsFile.delete();
			tempFile.renameTo(studentdetailsFile);

			// creating a file object to read the module regisration details
			// creating a scanner and wrapping it to the file object
			File moduleRegistrationFile = new File("moduleRegistration.txt");
			Scanner sc2 = new Scanner(moduleRegistrationFile);

			// leaving the first line
			sc2.nextLine();

			// creating a temporary file
			// creating a Printwriter and wrapping the temporary file
			File tempFile1 = new File("temp1.txt");
			PrintWriter pw1 = new PrintWriter(tempFile1);

			// creating the headings
			pw1.println("StudentNo\tUnitID");

			// using a while loop to navigate through the entered data
			// using hasNextLine function
			while (sc2.hasNextLine()) {

				// creating a String variable and getting the input using
				// scanner
				// creating a String Tokenizer object to tokenize the data
				// input data
				String data1 = sc2.nextLine();
				StringTokenizer token1 = new StringTokenizer(data1);

				// creating the moduleRegistration object using the
				// moduleRegistration
				// class
				// adding tokens for the object
				moduleRegistration object1 = new moduleRegistration(token1.nextToken(), token1.nextToken());

				// comparing whether the object deatils are equals to input data
				if (object1.getStudentNumber().equals(studentNumber)) {
					// printing the following data to the temporary file
					pw1.println(studentNumber + "\t\t" + unitID);

				} else {
					// printing the following data to the temporary file
					pw1.println(object1.getStudentNumber() + "\t\t" + object1.getUnitID());
				}
			}
			// closing the print writer
			// closing the scanner
			pw1.close();
			sc2.close();

			// deleting the student details file
			// renaming the temporary file to students details file
			moduleRegistrationFile.delete();
			tempFile1.renameTo(moduleRegistrationFile);

		} catch (FileNotFoundException e) {// catching the File not Found
											// exception
			// using show message dialog to show the error message
			JOptionPane.showMessageDialog(null, "File not found.");
		}
	}

	// creating a method to edit the existing lecturer records
	public static void editLecturerRecords() {

		try { // using a try to validate File not Found Exception and
				// IOException

			// creating a scanner to take the input from user
			Scanner sc = new Scanner(System.in);

			// setting up some instructions to user
			System.out.println("_________________________________________________________________________");
			System.out.println("                     EDIT AN EXISTING LECTURER DATA                      ");
			System.out.println("-------------------------------------------------------------------------");
			System.out.println("Please Enter the Lecturer as follows,");
			System.out.println();
			System.out.println("Eg :UnitID(ECISXXX) UnitName(SDP01) RoomNumber(201) \n   "
					+ " RoomName(BreakdownRoom) LecturerName(Dr.Furious) RoomCapacty(6) \n    "
					+ "NumberOfStudentsEnrolled(5)");
			System.out.println();
			System.out.println("Make sure that above data entered are followed by a SPACE, \n"
					+ "and should be in one single LINE.");
			System.out.println("-------------------------------------------------------------------------");
			System.out.print("Enter the data : ");

			// creating variables and storing the input from the user
			String unitID = sc.next();
			String unitName = sc.next();
			String roomNumber = sc.next();
			String roomName = sc.next();
			String lecturerName = sc.next();
			int roomCapacity = sc.nextInt();
			int numberOfStudentsEnrolled = sc.nextInt();

			// creating a file object to read the module lecturer details
			// creating a scanner and wrapping it to the file object
			File lecturerFile = new File("lecturer.txt");
			Scanner sc1 = new Scanner(lecturerFile);

			// leaving the first line
			sc1.nextLine();

			// creating a temporary file
			// creating a Printwriter and wrapping the temporary file
			File tempFile = new File("temp.txt");
			PrintWriter pw = new PrintWriter(tempFile);

			// creating the headings
			pw.println("UnitID\tUnitName\tRoomNumber\tRoomName\tLecturerName\tRoomCapacity\tNumberOfStudentsEnrolled");

			// using a while loop to navigate through the entered data
			// using hasNextLine function
			while (sc1.hasNextLine()) {

				// creating a String variable and getting the input using
				// scanner
				// creating a String Tokenizer object to tokenize the data
				// input data
				String data = sc1.nextLine();
				StringTokenizer token = new StringTokenizer(data);

				// creating the lecturer object using the lecturer class
				// adding tokens for the object
				lecturer object = new lecturer(token.nextToken(), token.nextToken(), token.nextToken(),
						token.nextToken(), token.nextToken(), Integer.parseInt(token.nextToken()),
						Integer.parseInt(token.nextToken()));

				// comparing whether the object deatils are equals to input data
				if (object.getUnitId().equals(unitID)) {
					// printing the following data to the temporary file
					pw.println(unitID + "\t\t" + unitName + "\t\t" + roomNumber + "\t\t" + roomName + "\t\t"
							+ lecturerName + "\t\t" + roomCapacity + "\t\t" + numberOfStudentsEnrolled);

				} else {
					// printing the following data to the temporary file
					pw.println(object.getUnitId() + "\t\t" + object.getUnitName() + "\t\t" + object.getRoomNumber()
							+ "\t\t" + object.getRoomName() + "\t\t" + object.getLecturerName() + "\t\t"
							+ object.getRoomCapacity() + "\t\t\t" + object.getNumberOfStudentsEnrolled());
				}
			}
			// closing the print writer
			// closing the scanner
			pw.close();
			sc.close();
			sc1.close();

			// deleting the student details file
			// renaming the temporary file to students details file
			lecturerFile.delete();
			tempFile.renameTo(lecturerFile);

		} catch (FileNotFoundException e) { // catching the File not Found
											// exception
			// using show message dialog to show the error message
			JOptionPane.showMessageDialog(null, "File not found.");
		}
	}

	// creating a method to delete the existing students records
	public static void deleteExistingStudentRecords() {

		try { // using a try to validate File not Found Exception and
				// IOException

			// creating a scanner to take the input from user
			Scanner sc = new Scanner(System.in);

			// setting up some instructions to user
			System.out.println("_________________________________________________________________________");
			System.out.println("                     DELETE AN EXISTING STUDENT DATA                      ");
			System.out.println("-------------------------------------------------------------------------");
			System.out.println("Please Enter the student detail as follows,");
			System.out.println();
			System.out.println("Eg :StudentID(2014xxx)");
			System.out.println();
			System.out.println("-------------------------------------------------------------------------");
			System.out.print("Enter the data : ");

			// creating a variable and storing the input from the user
			String studentNumber = sc.next();

			// creating a file object to read the students details
			// creating a scanner and wrapping it to the file object
			File studentdetailsFile = new File("studentdetails.txt");
			Scanner sc1 = new Scanner(studentdetailsFile);

			// leaving the first line
			sc1.nextLine();

			// creating a temporary file
			// creating a Printwriter and wrapping the temporary file
			File tempFile = new File("temp.txt");
			PrintWriter pw = new PrintWriter(tempFile);

			// creating the heading in the temporary file
			pw.println("StudentNo\tLastName\tFirstName");

			// using a while loop to navigate through the entered data
			// using hasNextLine function
			while (sc1.hasNextLine()) {

				// creating a String variable and getting the input using
				// scanner
				// creating a String Tokenizer object to tokenize the data
				// input data
				String data = sc1.nextLine();
				StringTokenizer token = new StringTokenizer(data);

				// creating the studentDetails object using the studentDetails
				// class
				// adding tokens for the object
				studentDetails object = new studentDetails(token.nextToken(), token.nextToken(), token.nextToken());

				// comparing the object and entered input to not be equal
				if (!(object.getStudentNumber().equals(studentNumber))) {
					// printing the following data to the temporary file
					pw.println(
							object.getStudentNumber() + "\t\t" + object.getLastName() + "\t\t" + object.getFirstName());
				}
			}
			// closing the print writer
			// closing the scanner
			pw.close();
			sc.close();
			sc1.close();

			// deleting the student details file
			// renaming the temporary file to students details file
			studentdetailsFile.delete();
			tempFile.renameTo(studentdetailsFile);

			// creating a file object to read the module regisration details
			// creating a scanner and wrapping it to the file object
			File moduleRegistrationFile = new File("moduleRegistration.txt");
			Scanner sc2 = new Scanner(moduleRegistrationFile);

			// leaving the first line
			sc2.nextLine();

			// creating a temporary file
			// creating a Printwriter and wrapping the temporary file
			File tempFile1 = new File("temp1.txt");
			PrintWriter pw1 = new PrintWriter(tempFile1);

			// creating the heading in the temporary file
			pw1.println("StudentNo\tUnitID");

			// using a while loop to navigate through the entered data
			// using hasNextLine function
			while (sc2.hasNextLine()) {

				// creating a String variable and getting the input using
				// scanner
				// creating a String Tokenizer object to tokenize the data
				// input data
				String data1 = sc2.nextLine();
				StringTokenizer token1 = new StringTokenizer(data1);

				// creating the moduleRegistration object using the
				// moduleRegistration
				// class
				// adding tokens for the object
				moduleRegistration object1 = new moduleRegistration(token1.nextToken(), token1.nextToken());

				// comparing the object and entered input to not be equal
				if (!(object1.getStudentNumber().equals(studentNumber))) {
					// printing the following data to the temporary file
					pw1.println(object1.getStudentNumber() + "\t\t" + object1.getUnitID());

				}

			}
			// closing the print writer
			// closing the scanner
			pw1.close();
			sc2.close();

			// deleting the student details file
			// renaming the temporary file to students details file
			moduleRegistrationFile.delete();
			tempFile1.renameTo(moduleRegistrationFile);

		} catch (FileNotFoundException e) {// catching the File not Found
											// exception
			// using show message dialog to show the error message
			JOptionPane.showMessageDialog(null, "File not found.");
		}

	}

	// creating a method to delete the existing lecturer records
	public static void deleteExistingLecturerRecords() {

		try { // using a try to validate File not Found Exception and
				// IOException

			// creating a scanner to take the input from user
			Scanner sc = new Scanner(System.in);

			// setting up some instructions to user
			System.out.println("_________________________________________________________________________");
			System.out.println("                   DELETE AN EXISTING LECTURER DATA                      ");
			System.out.println("-------------------------------------------------------------------------");
			System.out.println("Please Enter the Unit ID as follows,");
			System.out.println();
			System.out.println("Eg :UnitID(ECISXXX).");
			System.out.println();
			System.out.println("-------------------------------------------------------------------------");
			System.out.print("Enter the data : ");

			// creating a variable and storing the input from the user
			String unitID = sc.next();

			// creating a file object to read the lecturer details
			// creating a scanner and wrapping it to the file object
			File lecturerFile = new File("lecturer.txt");
			Scanner sc1 = new Scanner(lecturerFile);

			// leaving the first line
			sc1.nextLine();

			// creating a temporary file
			// creating a Printwriter and wrapping the temporary file
			File tempFile = new File("temp.txt");
			PrintWriter pw = new PrintWriter(tempFile);

			// creating the headings in the temporary file
			pw.println(
					"UnitID\t\tUnitName\tRoomNumber\tRoomName\t\t\tLecturerName\tRoomCapacity\tNumberOfStudentsEnrolled");

			// using a while loop to navigate through the entered data
			// using hasNextLine function
			while (sc1.hasNextLine()) {

				// creating a String variable and getting the input using
				// scanner
				// creating a String Tokenizer object to tokenize the data
				// input data
				String data = sc1.nextLine();
				StringTokenizer token = new StringTokenizer(data);

				// creating the lecturer object using the lecturer class
				// adding tokens for the object
				lecturer object = new lecturer(token.nextToken(), token.nextToken(), token.nextToken(),
						token.nextToken(), token.nextToken(), Integer.parseInt(token.nextToken()),
						Integer.parseInt(token.nextToken()));

				// comparing the object and entered input to not be equal
				if (!(object.getUnitId().equals(unitID))) {
					// printing the following data to the temporary file
					pw.println(object.getUnitId() + "\t\t" + object.getUnitName() + "\t\t" + object.getRoomNumber()
							+ "\t\t\t" + object.getRoomName() + "\t\t\t" + object.getLecturerName() + "\t\t\t"
							+ object.getRoomCapacity() + "\t\t\t\t\t" + object.getNumberOfStudentsEnrolled());
				}
			}
			// closing the print writer
			// closing the scanner
			pw.close();
			sc.close();
			sc1.close();

			// deleting the student details file
			// renaming the temporary file to students details file
			lecturerFile.delete();
			tempFile.renameTo(lecturerFile);

		} catch (FileNotFoundException e) {// catching the File not Found
											// exception
			// using show message dialog to show the error message
			JOptionPane.showMessageDialog(null, "File not found.");
		}
	}
}
