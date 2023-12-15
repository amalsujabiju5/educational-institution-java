package webd4201sujaa;

import java.beans.Statement;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import java.sql.*;



@SuppressWarnings("unused")
public class FacultyDA {
	
	static Vector<Faculty> faculty = new Vector<>(); // contains student
	// references
static Faculty afaculty;

// declare variables for the database connection
static Connection aConnection;
static Statement aStatement;

// declare static variables for all student instance attribute values
/**
* This variable is of type long to store the user�s unique identification number
*/
private static long id;
/**
* This variable is of type String to store the user�s password
*/
private static String password;
/**
* This variable is of type String to store the user�s first name
*/
private static String firstName;
/**
* This variable is of type String to store the user�s last name
*/
private static String lastName;
/**
* This variable is of type String that will be used to store the user�s email address. 
*/
private static String emailAddress;
/**
* This variable is of type Date to store the last time the user accessed the system 
*/
private static Date lastAccess;
/**
* This variable is of type Date to store when the user was created in the system
*/
private static Date enrolDate;
/**
* This variable is of type boolean to store whether the user is enabled in the system (false would mean the user is disabled)
*/
private static boolean enabled;
/**
* This variable is of type char to store the user�s type as a single character
*/
private static char type;
/**
* Private Data variable that will store the program code for the Student object
*/
private static String programCode;
/**
* Private Data variable that will store the program description for the Student object
*/
private static String programDescription;
/**
* Private Data variable that will hold the year of the program they are currently enrolled in 1 for first year, 2 for second year, 3 for third year.
*/
private static int year;
/**
* Private Vector of Mark objects named marks
*/
private static Vector<Mark> marks;
private static PreparedStatement sqlfacultyDelete;

// Class Constant
/**
* Updates the date format to be the same everywhere
*/
private static final SimpleDateFormat SQL_DF = new SimpleDateFormat(
"yyyy-MM-dd");

// establish the database connection
/**
* This method will create a statement to be used in DB connection
* 
* @param c
*            A string that holds the DB connection
*/
public static void initialize(Connection c) {
try {
aConnection = c;
aStatement = (Statement) aConnection.createStatement();
} catch (SQLException e) {
System.out.println(e.getMessage());
}
}

/**
* This method will terminate (close) a statement that is used in DB
* connection
*/
public static void terminate() {
try { // close the statement
((Connection) aStatement).close();
} catch (SQLException e) {
System.out.println(e.getMessage());
}
}

/**
* The retrieve() method determines if a record already exists in the database or not.
* @param id      Checks the id of the potential new user against all existing users
* @return Student  Object form of the data collected for a student
* @throws NotFoundException    throws an exception if the user cannot be found
*/
public static Faculty retrieve(long id) throws NotFoundException, SQLException, InvalidException, InvalidNameException, InvalidPasswordException, InvalidUserDataException { // retrieve Customer and Boat data

afaculty = new Faculty();
PreparedStatement sqlQuery = aConnection.prepareStatement("SELECT users.id, password, first_name, last_name, email_address, last_access, enrol_date, enabled, type, program_code, program_description, year FROM users, Faculty WHERE users.id = Faculty.id AND Faculty.id = ?;");
sqlQuery.setLong(1, id);
try
{
ResultSet rs = sqlQuery.executeQuery();
boolean gotIt = rs.next();
if (gotIt)
{	
id = rs.getLong("id");
password = rs.getString("password");
firstName = rs.getString("first_name");
lastName = rs.getString("last_name");
emailAddress = rs.getString("email_address");
lastAccess = rs.getDate("last_access");
enrolDate = rs.getDate("enrol_date");
enabled = rs.getBoolean("enabled");
type = 's';
programCode = rs.getString("program_code");
programDescription = rs.getString("program_description");
year = rs.getInt("year");
marks = new Vector<>();

try
{
afaculty = new Faculty(id, password, firstName, lastName, emailAddress, lastAccess, enrolDate, enabled, type, programCode, programDescription, emailAddress, year);
}
catch (InvalidUserDataException e)
{

System.out.println("Record for "
+ firstName
+ " contains an invalid ID.  Verify and correct.");
}

}
else	// nothing was retrieved
{
throw (new NotFoundException("Problem retrieving Faculty record, ID " + id +" does not exist in the system."));
}
rs.close();
}
catch (SQLException e)
{
System.out.println(e.getMessage());
}

return afaculty;
}

/**
* @param afaculty      an object that contains Faculty details
* @return inserted     a boolean to tell if the insert passed/failed
* @throws Exception 
*/
public static boolean create(Faculty afaculty) throws Exception {

boolean inserted = false;
id = afaculty.getId();
password = afaculty.getPassword();
firstName = afaculty.getFirstName();
lastName = afaculty.getLastName();
emailAddress = afaculty.getEmailAddress();
lastAccess = afaculty.getLastAccess();
enrolDate = afaculty.getEnrolDate();
enabled = afaculty.isEnabled();
type = afaculty.getType();
programCode = afaculty.getProgramCode();
programDescription = afaculty.getProgramDescription();
year = afaculty.getYear();
marks = afaculty.getMarks();
java.sql.Date lastAccessDate = new java.sql.Date(lastAccess.getTime());
java.sql.Date ogEnrolDate = new java.sql.Date(enrolDate.getTime());
PreparedStatement sqlUserQuery = aConnection.prepareStatement("INSERT INTO users (id, password, first_name, last_name, email_address, last_access, enrol_date, enabled, type) " +
"VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);");
PreparedStatement sqlStudentQuery = aConnection.prepareStatement("INSERT INTO students (id, program_code, program_description, year) " +
"VALUES (?, ?, ?, ?);");
sqlUserQuery.setLong(1, id);
sqlUserQuery.setString(2, password);
sqlUserQuery.setString(3, firstName);
sqlUserQuery.setString(4, lastName);
sqlUserQuery.setString(5, emailAddress);
sqlUserQuery.setDate(6, lastAccessDate);
sqlUserQuery.setDate(7, ogEnrolDate);
sqlUserQuery.setBoolean(8, enabled);
sqlUserQuery.setString(9, String.valueOf(type));
sqlStudentQuery.setLong(1, id);
sqlStudentQuery.setString(2, programCode);
sqlStudentQuery.setString(3, programDescription);
sqlStudentQuery.setInt(4, year);


String sqlInsertFaculty = "INSERT INTO faculty (id, program_code, program_description, year) " +
"VALUES ('" + id + "', '" + programCode + "', '" + programDescription + "', '" + year +"');";
try
{
retrieve(id);
throw (new DuplicateException("Problem with creating faculty record, the Faculty ID: " + id +"; already exists in the system."));
}
catch(DuplicateException | NotFoundException | SQLException e)
{
try
{  
int rs = sqlUserQuery.executeUpdate();
PreparedStatement sqlFacultyQuery = null;
int rs1 = sqlFacultyQuery.executeUpdate();
if (rs > 0 && rs1 > 0)
{
inserted = true;
}

}
catch (SQLException ee)
{ System.out.println(ee.getMessage());	}
}
return inserted;
}

/**
* Method that deletes a user and faculty from the DB
* @param aStudent      object containing data
* @return records      number of records changed
* @throws NotFoundException     throws an exception if the user cannot be found
*/
public static int delete(Faculty afaculty) throws NotFoundException, InvalidException, InvalidNameException, InvalidPasswordException, InvalidUserDataException, SQLException {
int records = 0;
id = afaculty.getId();
String sqlDeletefaculty = "DELETE FROM faculty WHERE id = ?;";
String sqlDeleteUser = "DELETE FROM users WHERE id = ?;";
PreparedStatement sqlUserDelete = aConnection.prepareStatement(sqlDeleteUser);
PreparedStatement sqlStudentDelete = aConnection.prepareStatement(sqlDeletefaculty);
sqlUserDelete.setLong(1, id);
sqlStudentDelete.setLong(1, id);
try
{
retrieve(id);  
records = sqlfacultyDelete.executeUpdate();
records = sqlUserDelete.executeUpdate();
}catch(NotFoundException e)
{
throw new NotFoundException("Faculty with id " + id
+ " cannot be deleted, does not exist.");
}catch (SQLException e)
{ System.out.println(e.getMessage());	}
return records;
}

/**
* A static method named update() that accepts a faculty argument, return an integer (the number of records updated) and modifies an existing student using a SQL UPDATE command
* @param aStudent      object that contains data
* @return records      number of records updated
* @throws NotFoundException    throws an exception if the user cannot be found
*/
public static int update(Faculty afaculty) throws NotFoundException, InvalidException, InvalidNameException, InvalidPasswordException, InvalidUserDataException, SQLException {
int records = 0;  //records updated in method

id = afaculty.getId();
password = afaculty.getPassword();
firstName = afaculty.getFirstName();
lastName = afaculty.getLastName();
emailAddress = afaculty.getEmailAddress();
lastAccess = afaculty.getLastAccess();
enrolDate = afaculty.getEnrolDate();
enabled = afaculty.isEnabled();
type = afaculty.getType();
programCode = afaculty.getProgramCode();
programDescription = afaculty.getProgramDescription();
year = afaculty.getYear();
marks = afaculty.getMarks();
java.sql.Date lastAccessDate = new java.sql.Date(lastAccess.getTime());
java.sql.Date ogEnrolDate = new java.sql.Date(enrolDate.getTime());

String sqlUpdateUser = "UPDATE users " +
"SET first_name = ?, " +
"last_name = ?, " +
"email_address = ?, " +
"last_access = ?, " +
"enrol_date = ?, " +
"type = ?, " +
"enabled = ? " +
"WHERE id = ?";
PreparedStatement sqlUserUpdate = aConnection.prepareStatement(sqlUpdateUser);
sqlUserUpdate.setString(1, firstName);
sqlUserUpdate.setString(2, lastName);
sqlUserUpdate.setString(3, emailAddress);
sqlUserUpdate.setDate(4, lastAccessDate);
sqlUserUpdate.setDate(5, ogEnrolDate);
sqlUserUpdate.setString(6, String.valueOf(type));
sqlUserUpdate.setBoolean(7, enabled);
sqlUserUpdate.setLong(8, id);

String sqlUpdateStudent = "UPDATE students " +
"SET program_code = ?, " +
"program_description = ?, " +
"year = ? " +
"WHERE id = ?";
PreparedStatement sqlfacultyUpdate = aConnection.prepareStatement(sqlUpdateStudent);
sqlfacultyUpdate.setString(1, programCode);
sqlfacultyUpdate.setString(2, programDescription);
sqlfacultyUpdate.setInt(3, year);
sqlfacultyUpdate.setLong(4, id);

try
{
retrieve(id);  
records = sqlUserUpdate.executeUpdate();
records = sqlfacultyUpdate.executeUpdate();
}catch(NotFoundException e)
{
throw new NotFoundException("Student with id " + id
+ " cannot be updated, does not exist in the system.");
}catch (SQLException e)
{ System.out.println(e.getMessage());}
return records;
}

  

}
