package webd4201sujaa;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.Vector;





/**
 * 
 * @author Amal Suja Biju
 * @since 23/01/2023
 *
 */
public class Student extends User{
	
	
	/**
	 * The program code
	 */
	 public static final String DEFAULT_PROGRAM_CODE = "UNDC";
	 
	 
	 /**
	  * default program description
	  */
	 
	 public static final String DEFAULT_PROGRAM_DESCRIPTION ="undeclared";
	 
	 /**
	  * Default year of type  int that stores 1
	  */
	 public static final int DEFAULT_YEAR =1;
	 
	 
	 
	 //ATTRIBUTES
	 
	 private String programCode;
	 private String programDescription;
	 private int year;
	 private Vector<Mark> marks;
	 
	 
	 
	 /**
	  * 
	  * @return program code
	  */
	 public String getProgramCode(){
		 return programCode;
	 }
	 
	 
	 /**
		 * @param programCode the programCode to set
		 */
		public void setProgramCode(String programCode) {
			this.programCode = programCode;
		}

		/**
		 * @return the programDescription
		 */
		public String getProgramDescription() {
			return programDescription;
		}

		/**
		 * @param programDescription the programDescription to set
		 */
		public void setProgramDescription(String programDescription) {
			this.programDescription = programDescription;
		}
		
		/**
	     * An Override method that returns the object in a string format
	     * @return object as a string
	     */
	    @Override
	    public String toString()
	    {
	        return  "Student" + "\n{\n" +
	                getFirstName() + " " + getLastName() + "(" + getId() + ")" + "\n" +
	                "Currently in " + getYear() + " year of " + getProgramDescription() + " " + getProgramCode() + "\n" +
	                "Enrolled: " + getEnrolDate() +
	                '}';
	    }
	    
	    public String getTypeForDisplay() {
			
			return null;
		}

		/**
		 * @return the year
		 */
		public int getYear() {
			return year;
		}

		/**
		 * @param year the year to set
		 */
		public void setYear(int year) {
			this.year = year;
		}

		/**
		 * @return the marks
		 */
		public Vector<Mark> getMarks() {
			return marks;
		}

		/**
		 * @param marks the marks to set
		 */
		public void setMarks(Vector<Mark> marks) {
			this.marks = marks;
		}
		//
		// Constructors:
		/**
	     * Parameterized Constructor
	     * @exception InvalidUserDataException 
		 * @throws InvalidException 
	     */
	    public Student(long id, String password, String firstName, String lastName, String emailAddress, Date lastAccess, Date enrolDate, boolean enabled, char type, String programCode, String programDescription, int year, Vector<Mark> marks)
	            throws InvalidUserDataException, InvalidException
	    {
	        super(id, password, firstName, lastName, emailAddress, lastAccess, enrolDate, enabled, type);
	        setProgramCode(programCode);
	        setProgramDescription(programDescription);
	        setYear(year);
	        setMarks(marks);
	    }
	    
	    public Student(long id, String password, String firstName, String lastName, String emailAddress,
                Date lastAccess, Date enrolDate, boolean enabled, char type, String programCode,
                String programDescription, int year) throws InvalidUserDataException, InvalidException
            {
		     this(id, password, firstName, lastName, emailAddress, lastAccess, enrolDate,
		             enabled, type, programCode, programDescription, year, new Vector<>());
		     //System.out.println("ID: " + id);
            }
		    
	    /**
	     * Default Constructor 
	     */
	    public Student() throws InvalidNameException, InvalidException, InvalidPasswordException, InvalidUserDataException {
	        this(DEFAULT_ID, DEFAULT_PASSWORD, DEFAULT_FIRST_NAME, DEFAULT_LAST_NAME, DEFAULT_EMAIL_ADDRESS,
	                new Date(), new Date(), DEFAULT_ENABLED_STATUS, DEFAULT_TYPE,  DEFAULT_PROGRAM_CODE,
	                DEFAULT_PROGRAM_DESCRIPTION, DEFAULT_YEAR, new Vector<>());
	    }


	 // Database methods
	    /**
	     * 
	     * @param c
	     */
	    public static void initialize(Connection c)
	    {
	        StudentDA.initialize(c);
	    }
	    /**
	     * 
	     * @param id
	     * @return
	     * @throws NotFoundException
	     * @throws SQLException
	     * @throws InvalidUserDataException
	     * @throws InvalidIdException
	     * @throws InvalidNameException
	     * @throws InvalidPasswordException
	     * @throws javax.naming.InvalidNameException
	     */
	    public static Student retrieve(long id) throws NotFoundException, SQLException, InvalidUserDataException, InvalidException, InvalidNameException, InvalidPasswordException, javax.naming.InvalidNameException {
	        return StudentDA.retrieve(id);
	    }
	    
	    public static void terminate()
	    {
	        StudentDA.terminate();
	    }
	    /**
	     * 
	     * @return
	     * @throws InvalidIdException
	     * @throws javax.naming.InvalidNameException
	     * @throws Exception 
	     */
	    public boolean create() throws Exception {
	        return StudentDA.create(this);
	    }
	    
	    public int update() throws NotFoundException,InvalidUserDataException, DuplicateException, InvalidException, InvalidNameException, InvalidPasswordException, SQLException, NoSuchAlgorithmException, javax.naming.InvalidNameException {
	        return StudentDA.update(this);
	    }
	    /**
	     * 
	     * @return
	     * @throws NotFoundException
	     * @throws InvalidUserDataException
	     * @throws InvalidIdException
	     * @throws InvalidNameException
	     * @throws InvalidPasswordException
	     * @throws SQLException
	     * @throws javax.naming.InvalidNameException
	     */
	    public int delete() throws NotFoundException, InvalidUserDataException, InvalidException, InvalidNameException, InvalidPasswordException, SQLException, javax.naming.InvalidNameException {
	        return  StudentDA.delete(this);
	    }
	    /**
	     * Method to hash the password
	     * @param input
	     * @return
	     *
	     */
	    //hashing the password
		public String encryptPassword(String value) {
			
			try {
				// getInstance() method is called with algorithm SHA-1
				MessageDigest md = MessageDigest.getInstance("SHA-1");

				// digest() method is called
				// to calculate message digest of the value string
				// returned as array of byte
				byte[] messageDigest = md.digest(value.getBytes());

				// Convert byte array into signum representation
				BigInteger no = new BigInteger(1, messageDigest);

				// Convert message digest into hex value
				String hashtext = no.toString(16);

				// Add preceding 0s to make it 32 bit
				while (hashtext.length() < 32) {
					hashtext = "0" + hashtext;
				}

				// return the HashText
				return hashtext;
			}

			// For specifying wrong message digest algorithms
			catch (NoSuchAlgorithmException e) {
				throw new RuntimeException(e);
			}
		}
	

	    
	    
	}

	 


