/**
/**
 * @author AMAL SUJA BIJU
 * @since January 20th, 2023
 */
package webd4201sujaa;



public interface CollegeInterface {
	
	//constants
	public static final String College_Name = "Durham College";
	public static final String Phone_Number ="(905) 721-2000";
	public static final long MINIMUM_ID_NUMBER = 100000000L;
    public static final long MAXIMUM_ID_NUMBER = 999999999L;

    /**
     * Returns the user type depending on the child class it is called.
     * @return String User type
     */
    public abstract String getTypeForDisplay();

}


































