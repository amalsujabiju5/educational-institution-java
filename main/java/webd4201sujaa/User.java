

package webd4201sujaa;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


	




	/**
	 * 
	 * @author Amal Suja Biju
	 * @Date 20/01/2023
	 *
	 */


//constants

	public  class User implements CollegeInterface {
		/**
	     * This constant is the Default ID for a default constructor
	     
	     */
		public static final long DEFAULT_ID = 100123456;
		
		/**
		 * string that store password
		 */
		public static final String DEFAULT_PASSWORD ="password";
		
		/*
		 * Minimum password length 
		 */
		public static final byte MINIMUM_PASSWORD_LENGTH =8;
		
		/**
		 * Maximum password length
		 */
		public static final byte MAXIMUM_PASSWORD_LENGTH =40;
		

		 /**
		  * Default  First name
		  */
		
		public static final String DEFAULT_FIRST_NAME  ="John";
		
		/**
		 * Default last name
		 */
		
		public static final String DEFAULT_LAST_NAME  ="Doe";
		
		/**
		 * Default string that  stores the email address
		 * 
		 */
		public static final String DEFAULT_EMAIL_ADDRESS  = "john.doe@dcmail.com";
		
		/**
		 * DEFAULT_ENABLED_STATUS of type boolean that stores �true�
		 */
		
		public static final boolean DEFAULT_ENABLED_STATUS  = true;
		
		/**
		 * 	DEFAULT_TYPE of type char that stores �s�
		 */
		
		public static final char DEFAULT_TYPE  = 's';
		
		
		
		/**	ID_NUMBER_LENGTH of type byte that stores 9
		 */
		
		public static final byte ID_NUMBER_LENGTH  = 9;
		
		
		/**
		 * Dta format of canada
		 */
		public static final DateFormat DF = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.CANADA); 
		
		
		// variables
		
		/**
		 * id of type long to store the user�s unique identification number
		 */
		
		 private long id;
		 private String password;
		 private String firstName;
		 private String lastName;
		 private String emailAddress;
		 private Date lastAccess;
		 private Date enrolDate;
		 private boolean enabled;
		 private char type;
		 
		 
 //setters
		 /**
		  * 
		  * @param id
		  */
			 
	 public void setId(long id)throws InvalidException{
		 if(id <= this.MAXIMUM_ID_NUMBER && id >= this.MINIMUM_ID_NUMBER){ 
			 this.id = id;
		 
		 }
		 else {
				throw new InvalidException(id + " is not a valid ID number.");
			}	
	 }
	 
			
	 
	 public void setPassword(String password) throws InvalidPasswordException {
			if(password.length() <= this.MAXIMUM_PASSWORD_LENGTH && password.length() >=this.MINIMUM_PASSWORD_LENGTH) {
				this.password = password;
			}
			else {
				throw new InvalidPasswordException("The length of the password must be between " + MINIMUM_PASSWORD_LENGTH + " and " + MAXIMUM_PASSWORD_LENGTH + " characters long.");
			}
		}

/*
 * method to set the first name
 */

 /**
  *  @param firstName the firstName to set
  */
		
		
	@SuppressWarnings("used")
	public void setFirstName(String firstName)throws InvalidNameException{
		boolean flag =false;
		/*
		 * validating using try and catch
		 */
		try
		{
			double test = Double.parseDouble(firstName);
		}
		catch (NumberFormatException ex)
		{
			flag =true;
			
		}
		 if (!(firstName.isEmpty()) && flag)
	        {
	        	this.firstName = firstName;
	        }
	        else
	        {
	            throw new InvalidNameException(firstName + " is not a valid name. Make sure there are no numbers or special characters.");
	        }
		}
	/**
	 * the last name
	 * @param  lastName to set
	 */
	@SuppressWarnings("unused")
	public void SetLastName(String lastName) throws InvalidNameException {
		boolean flag = false;
        try
        {
            double test = Double.parseDouble(lastName);
        }
        catch (NumberFormatException ex)
        {
            flag = true;
        }

        if (!(lastName.isEmpty()) && flag)
        {
            this.lastName = lastName;
        }
        else
        {
            throw new InvalidNameException(lastName + " is not a valid name. Make sure there are no numbers or special characters.");
        }
	}

	 
	 /**
	  * set the email addess
	  * @param emailAddress the emailAddress to set
	  */

	 public void setEmailAddress(String emailAddress) {
		 this.emailAddress = emailAddress;
	 }
	 
	 
	 /**
	  * set the last access
	  *  @param lastAccess  set
	  */

	 
	 public void SetLastAccess(Date lastAccess){
		 this.lastAccess =lastAccess;
	 }
	 
	 
	 
	 /**
	  * set the email address
	  * @param enroll date
	  * 
	  */

	 public void SetEnrolDate(Date enrolDate){
		 this.enrolDate = enrolDate;
	 }

	 /**
	  * set the enabled status
	  * @param enabled status
	  * 
	  */
	 
	 
	 public void SetEnabled (boolean enabled){
		 this.enabled =enabled;
	 }
	 
	 
	 /**
	  * Method to set the user type
	  * @param user type
	  */
	 
	 public void SetType (char type){
		 this.type =type;
	 }
	 
	 
	 
	 
 //Getters
	 
	 /**
	  * To get the id
	  * @return get id
	  */


	 
	 public long getId() {
		 return this.id;
	 }
	 
	 /**
	  * To get the password
	  * @return Get password
	  */
	 
	 public String getPassword(){
		 return this.password;
		 
	 }
	 
	 /**
		 * To get the first name
		 * @return  firstName
		 */
		public String getFirstName() {
			return this.firstName;
		}
		
		/**
		 * to get the last name
		 * @return  lastName
		 */
		public String getLastName() {
			return this.lastName;
		}
		
		/**
		 * return the email address
		 * @return the emailAddress
		 */
		public String getEmailAddress() {
			return this.emailAddress;
		}
		
		/**
		 * Mlast access date
		 * @return the lastAccess
		 */
		public Date getLastAccess() {
			return this.lastAccess;
		}
		
		/**
		 *  enrollment date
		 * @return the enrolDate
		 */
		public Date getEnrolDate() {
			return this.enrolDate;
		}
		
		/**
		 *  enabled status
		 * @return the enabled
		 */
		public boolean isEnabled() {
			return this. enabled;
		}
		
		/**
		 *  the user type
		 * @return the type
		 */
		public char getType() {
			return this. type;
		}
		
		
		@Override
		/**
	     * Returns the user type depending on the child class it is called.
	     * @return String of null
	     */
		public String getTypeForDisplay() {
			
			return null;
		}
		
		//constructors
		
		
		public User(long id, String password, String firstName, String lastName, String emailAddress, Date lastAccess, Date enrolDate, boolean enabled, char type) throws InvalidException, InvalidUserDataException{
			try{
				setId(id);
				setPassword(password);
				setFirstName(firstName);
				SetLastName(lastName);
				setEmailAddress(emailAddress);
				SetLastAccess(lastAccess);
				SetEnrolDate(enrolDate);
				SetEnabled(enabled);
				SetType(type);
					
			}
			catch(Exception e)
			{
				throw new InvalidUserDataException(e.getMessage());
			}
		}
			/**
		     * Default Constructor uses all of the default constants and the current date it is called
			 * @throws InvalidException 
			 * 
			 * 
		     */
			public User() throws InvalidUserDataException, InvalidException {
				this(User.DEFAULT_ID, User.DEFAULT_PASSWORD,
						User.DEFAULT_FIRST_NAME, User.DEFAULT_LAST_NAME, User.DEFAULT_EMAIL_ADDRESS, new Date(), new Date(), User.DEFAULT_ENABLED_STATUS, User.DEFAULT_TYPE);
			}
			
			@Override
			public String toString() {
				return  "User" + "\n{\n" +
		                "Student ID    = " + getId() + "\n" +
		                "Name          = " + getFirstName() + ' ' + getLastName() + "\n" +
		                "Email Address = " + getEmailAddress() + '\n' +
		                "Created On    = " + getEnrolDate() + "\n" +
		                "Last Access   = " + getLastAccess() + "\n" +
		                '}';
			}
			
			
			
			/**
			 * 
			 * @param email
			 * @return to validate the email 
			 */
			
			public static boolean isValidEmailAddress(String email) {
				
				String regex = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
		        Pattern pattern = Pattern.compile(regex);
		        Matcher matcher = pattern.matcher(email);
		        return matcher.matches();
			}
			
			
			
			/**
		     *This only displays the function toString() { [native code] }() method's returned string without taking any parameters or returning anything.
		     */
		    public void dump()
		    {
		       System.out.println(toString());
		    }
		    
		    /**
		     * @return boolean
		     */
		    public static boolean verifyId(long id)
		    {
		        boolean flag = true;

		        if (id > MAXIMUM_ID_NUMBER || id < MINIMUM_ID_NUMBER)
		        {
		            flag = false;
		        }

		        return flag;
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


    
    
	// Database methods
    /**
     * 
     * @param c
     */
    public static void initialize(Connection c)
    {
        userDA.initialize(c);
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
    public static User retrieve(long id) throws NotFoundException, SQLException, InvalidUserDataException, InvalidException, InvalidNameException, InvalidPasswordException, javax.naming.InvalidNameException {
        return userDA.retrieve(id);
    }
    
    public static void terminate()
    {
    	userDA.terminate();
    }
    /**
     * 
     * @return
     * @throws InvalidIdException
     * @throws javax.naming.InvalidNameException
     * @throws Exception 
     */
    public boolean create() throws Exception {
        return userDA.create(this);
    }
    
    public int update() throws NotFoundException,InvalidUserDataException, DuplicateException, InvalidException, InvalidNameException, InvalidPasswordException, SQLException, NoSuchAlgorithmException, javax.naming.InvalidNameException {
        return userDA.update(this);
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
        return  userDA.delete(this);
    }
	}
				
				
			
		
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 