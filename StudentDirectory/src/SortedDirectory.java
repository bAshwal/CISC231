
public class SortedDirectory implements SDinterface {
	private String name;
	private int num;
	private Student studentList[];
	private Student tempStudentList[];
	
	protected SortedDirectory(){
		num=0;
		studentList = new Student[num];
		
		
		
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
		
		if (studentExist(studentList,studentID)){
			
			System.out.println("Sorry, you cannot add " + name + ",because his/her Student ID [" + studentID + "]already exist.");
			
		}else{
			

		num++; //Increment size of the directory by one, since we are adding
		
		tempStudentList = new Student[num]; // Create a temporary list to store orignal array
		
		if (num>1){ // copy the array only if the size of the list is greater than one
			
		copyCurListToTemp(studentList,tempStudentList);
		}
		
		studentList= new Student[num];// init. an array of objects with new size

		num--; // Decrement size to add a student object
		
		copyTempListToCur(studentList,tempStudentList);
		
		studentList[num]= new Student(name,studentID);// adding a new student
		
		num++; // Increment to reflect current size of our list
		}
	}
	
	public String prettyStr(){
		String dir = "Student Name : Student ID: \n";
		
		for (int i=0;i<studentList.length;i++){
			dir = dir + studentList[i].name + "          "+ studentList[i].studentID + "\n";
		}
		return dir;
		
	}
	public void removeStudent (int studentID){
		
		if (studentExist(studentList,studentID)){
			num--;
			for (int i =0; i<studentList.length;i++){
				if ((studentList[i].studentID == studentID) && num ==0)
				{
					studentList = new Student[num];
				}else if (studentList[i].studentID == studentID)
				{
					Student toRemove = studentList[i];
					studentList[i] = studentList[num];
					studentList[num] = toRemove;

				}
			}
			
			if (num>0){ // copy the array only if the size of the list is greater than one	
			copyCurListToTemp(studentList,tempStudentList);
			}
			studentList= new Student[num];// init. an array of objects with new size
			
			if (num>=0){
			copyTempListToCur(studentList,tempStudentList);
			}
		}else{
			
			System.out.println("Sorry, you cannot remove this student, because his/her Student ID [" + studentID + "]does not exist.");

		}
	}
	
	public String studentLookup (int studentID){
		
		String found= new String();
		if (studentExist(studentList,studentID)){
			found = "Student with ID #" + studentID + " exists!";
		}
		return found;
		
	}
	
	private boolean studentExist(Student studentList[], int num){
		for (int i=0; i<studentList.length;i++)
		{
			if (studentList[i].studentID == num)
			{
				return true;
			}
			
		}
		return false;
	}
	private void copyCurListToTemp(Student studentList[], Student tempStudentList[]){
		for(int i=0; i<studentList.length;i++){// loop to copy current list to the temporary one.	
			tempStudentList[i] = studentList[i];
		}
	}
	private void copyTempListToCur(Student studentList[], Student tempStudentList[]){
		for(int i=0; i<studentList.length;i++){
			studentList[i] = tempStudentList[i];
			}
		
	}
	
	
}
