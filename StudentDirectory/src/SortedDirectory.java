
public class SortedDirectory implements SDinterface {
	private String name;
	private int num;
	private Student studentList[];
	private Student tempStudentList[];
	
	protected SortedDirectory(){
		num=0;
		
		
	}
	private class Student{
		private int studentID;
		private String name;
		
		private Student(String name, int studentID){
			this.name = name;
			this.studentID = studentID;
		}
		
	}
	

	public void addStudent (String name, int studentID){
		
		num++; //Increment size of the directory by one, since we are adding
		
		tempStudentList = new Student[num]; // Create a temporary list to store orignal array
		
		if (num>1){ // copy the array only if the size of the list is greater than one
			for(int i=0; i<studentList.length;i++){// loop to copy current list to the temporary one.	
				tempStudentList[i] = studentList[i];
			}
		
		}
		studentList= new Student[num];// init. an array of objects with new size

		num--; // Decrement size to add a student object
		
		for(int i=0; i<studentList.length;i++){
			studentList[i] = tempStudentList[i];
		}
		studentList[num]= new Student(name,studentID);// adding a new student
		
		num++; // Increment to reflect current size
		
	}
	
	public String prettyStr(){
		String dir = new String();
		
		for (int i=0;i<studentList.length;i++){
			dir = dir + "Student name: " + studentList[i].name + "Student ID: " + studentList[i].studentID + "\n";
		}
		return dir;
		
	}
	public void removeStudent (int studentID){
		
	}
	
	public String studentLookup (int studentID){
		return null;
		
	}
	
	
	
}
