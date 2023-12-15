package webd4201sujaa;


public class Test {
	public static void main(String[] args) throws InvalidException, InvalidNameException, InvalidPasswordException{
		try {
	      User u1 = new User();
	      System.out.println(u1);
	  } catch (InvalidUserDataException e) {
	      // Auto-generated catch block
	      System.out.println(e);
	  }
		
		try {
			Faculty f1 = new Faculty();
	      System.out.println(f1);
	  } catch (InvalidUserDataException e) {
	      //  Auto-generated catch block
	      System.out.println(e);
	  }
		
		try {
			Student s1 = new Student();
	      System.out.println(s1);
	  } catch (InvalidUserDataException e) {
	      //  Auto-generated catch block
	      System.out.println(e);
	  }

	//  int[] arr = new int[5];
	//  arr[0] = 4;
	//  for(int i=0;i<arr.length;i++){
//	      System.out.println(arr[i]);
	//  }
	//  arr = new int[10];
	//
	//  Vector<User> vec = new Vector();
	//  try {
//	      vec.add(new User());
//	      //vec.add("Hi");
//	      //vec.add(4);
//	      System.out.print("Number of elements in the vector right now: "+vec.size());
//	      System.out.println(vec.get(0));
	//
	//
	//  } catch (InvalidIdException e) {
//	      //  Auto-generated catch block
//	      e.printStackTrace();
	//  }



	}


}
