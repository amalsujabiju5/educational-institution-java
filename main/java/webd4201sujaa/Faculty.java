package webd4201sujaa;
import java.util.Date;
import java.util.Vector;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.SQLException;



/**
 * 
 * @author Amal Suja BIju
 * @since 24/01/2023
 *
 */
public class Faculty extends User {
	
	
	//constants
	
	/**
	 * Default school code
	 */

	
	public static final String DEFAULT_SCHOOL_CODE = "SET";
	
	
	/**
	 * 	DEFAULT_SCHOOL_DESCRIPTION of type String that stores �School of Engineering & Technology�
	 */
	public static final String DEFAULT_SCHOOL_DESCRIPTION = "School of Engineering & Technology";
	
	
	/**
	 * DEFAULT_OFFICE of type String that stores �H-140�
	 */
	
	public static final String DEFAULT_OFFICE = "H-140";
	
	/**
	 * iv.	DEFAULT_PHONE_EXTENSION of type int that stores 1234
	 */
	
	public static final int DEFAULT_PHONE_EXTENSION = 1234;
	
	public static final String PHONE_NUMBER = "(905)721-2000" ;
	
	
	
	
	
	// VARIABLES
	
	/**
	 * a String named schoolCode 
	 */
	
	private String schoolCode;
	/**
	 *	a String named schoolDescription that will store a code for the school the faculty is associated 
	 */
	private String schoolDescription;
		
	/**
	 * 	a String named office that will store the faculty member�s office location. 
	 */
	
	private String office;
	
	/**
	 *  primitive int named extension that will store the faculty member�s phone extension
	 */
	private int extension;
	
	
	//Getter
	/**
	 * 
	 * @return the school code
	 */
	
	public String getschoolCode() {
		return this.schoolCode;
	}
	
	/**
	 * 
	 * @return the school description
	 */
	public String getSchoolDescription() {
		return this.schoolDescription;
	}
	
	/**
	 * 
	 * @return the office
	 */
	public String getOffice() {
		return this.office;
	}
	
	/**'
	 * 
	 * @return Extension
	 */
	public int getExtension() {
		return this.getExtension();
	}
	
	
	    
	// setter
	
	/**
	 * 
	 * @param schoolCode
	 */
	 public void setSchoolCode(String schoolCode) {
		 this.schoolCode = schoolCode;
	 }
	 
	 /**
	  *  
	  * @param schoolDescription
	  */
	 public void setschoolDescription(String schoolDescription){
		 this.schoolDescription= schoolDescription;
	 }
	 
	 /**
	  * 
	  * @param Office
	  */
	 public void setOffice(String office){
		 this.office = office;
	 }
	
	 /**
	  * 
	  * @param extension
	  */
	 public void setExtension(int extension){
		 this.extension= extension;
	 }
	 
	 

		// CONSTRUCTORS:
		/**
		 * Parameterized Constructor
		 * @throws InvalidException 
		 * @throws InvalidUserDataException 
		 */
		public Faculty(long id, String password, String firstName, String lastName, String emailAddress, Date lastAccess,
				Date enrolDate, boolean enabled, char type, String schoolCode, String schoolDescription, String office, int extension)
				throws InvalidUserDataException, InvalidException {
			super(id, password, firstName, lastName, emailAddress, lastAccess, enrolDate, enabled, type);
			setSchoolCode(schoolCode);
			setschoolDescription(schoolDescription);
	        setOffice(office);
	        setExtension(extension);
			
		}
		
		/**
	     * default constructor 
		 * @throws InvalidUserDataException 
		 * @throws InvalidException 
	     */
	    public Faculty() throws InvalidUserDataException, InvalidException
	    {
	        super();
	        setSchoolCode(DEFAULT_SCHOOL_CODE);
	        setschoolDescription(DEFAULT_SCHOOL_DESCRIPTION);
	        setOffice(DEFAULT_OFFICE);
	        setExtension(DEFAULT_PHONE_EXTENSION);
	    }
	    
	    // Methods:
	    
	    /**
	     * An Override method that returns the object in a string format
	     * @return object as a string
	     */
	    @Override
	    public String toString()
	    {
	        return  "Faculty" + "\n{\n" +
	                "Faculty ID    = " + getId() + "\n" +
	                "Name          = " + getFirstName() + ' ' + getLastName() + "\n" +
	                "Email Address = " + getEmailAddress() + '\n' +
	                "Created On    = " + getEnrolDate() + "\n" +
	                "Last Access   = " + getLastAccess() + "\n" +
	                getSchoolDescription() + "\n" +
	                "Office        = " + getOffice() + "\n" +
	               
	                '}';
	    }
	    public String getTypeForDisplay() {
			
			return null;
		}

		public String getProgramCode() {
			// TODO Auto-generated method stub
			return null;
		}

		public String getProgramDescription() {
			// TODO Auto-generated method stub
			return null;
		}

		public int getYear() {
			// TODO Auto-generated method stub
			return 0;
		}

		public Vector<Mark> getMarks() {
			// TODO Auto-generated method stub
			return null;
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
	    public static Faculty retrieve(long id) throws NotFoundException, SQLException, InvalidUserDataException, InvalidException, InvalidNameException, InvalidPasswordException, javax.naming.InvalidNameException {
	        return FacultyDA.retrieve(id);
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
	        return FacultyDA.create(this);
	    }
	    
	    public int update() throws NotFoundException,InvalidUserDataException, DuplicateException, InvalidException, InvalidNameException, InvalidPasswordException, SQLException, NoSuchAlgorithmException, javax.naming.InvalidNameException {
	        return FacultyDA.update(this);
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
	        return  FacultyDA.delete(this);
	    }
		public String hashPassword(String input) {
			
			try {
				// getInstance() method is called with algorithm SHA-1
				MessageDigest md = MessageDigest.getInstance("SHA-1");

				// digest() method is called
				// to calculate message digest of the input string
				// returned as array of byte
				byte[] messageDigest = md.digest(input.getBytes());

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

	

