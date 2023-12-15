package webd4201sujaa;



/**
 * 
 * @author Amal Suja Biju
 * @since 23/01/2023
 *
 */
public class Mark {
	
	//constants
	/**
	 *MINIMUM_GPA of type float that stores 0.0
	 */
	public static final float MINIMUM_GPA =(float) 0.0;
	
	/**
	 * MAXIMUM_GPA of type float that stores 5.0
	 */
	public static final float MAXIMUM_GPA =(float) 5.0;
	
	
	//Attributes
	
	/**
	 * string named course code
	 */
	private String courseCode;
	/**
	 * string course name
	 */
	
	private String courseName;
	/**
	 * primitive integer named result
	 * 
	 */
	private int result;
	
	/**
	 * float named gpaWeighting
	 */
	
	private float gpaWeighting;
	
	
	 // Getters 
		/**
		 * @return the courseCode
		 */
		public String getCourseCode() {
			return this.courseCode;
		}
		
		/**
		 * @return the courseName
		 */
		public String getCourseName() {
			return this.courseName;
		}
		
		/**
		 * @return the result
		 */
		public int getResult() {
			return this.result;
		}
		
		/**
		 * @return the gpaWeighting
		 */
		public float getGpaWeighting() {
			return this.gpaWeighting;
		}
		
		
		//setters
		/**
		 * 
		 * @param set courseCode
		 */
		public void setCourseCode(String courseCode){
			this.courseCode =courseCode;
		}
		
		/**
		 * 
		 * @param set courseName
		 */
		public void setCourseName(String courseName){
			this.courseName =courseName;
		}
		
		/**
		 * 
		 * @param set result
		 */
		public void setResult(int result) {
			this.result =result;
		}
		
		/**
		 * 
		 * @param set gpaWeighting
		 */
		public void setGpaWeighting(float gpaWeighting) {
			this.gpaWeighting = gpaWeighting;
		}


	
	//CONSTRUCTORS
	/**
	 * Parameterized Constructor
	 */
	public Mark(String courseCode, String courseName, int result, float gpaWeighting)
	{
	    setCourseCode(courseCode);
	    setCourseName(courseName);
	    setResult(result);
	    setGpaWeighting(gpaWeighting);
	}
	/**
	 * DEFAULT CONSTRUCTOR
	 */
	public Mark()
	{
	    this.courseCode = "00000";
	    this.courseName = "DEFAULT";
	    this.result = 0;
	    this.gpaWeighting = 0.0f;
	}
	
	//METHOD
	
	@Override
	public String toString()
	{
	    return  String.format("%-10", getCourseCode()) +
	            String.format("%-35", getCourseName()) + 
	            String.format("%-25", getResult()) + 
	            String.format("%-25", getGpaWeighting());

	}
	
	
	
	
	
	
	
	
}
