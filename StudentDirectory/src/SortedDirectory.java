

public class SortedDirectory implements SDinterface {

	private int listSize;
	private Student studentList[];
	private Student tempStudentList[];

	protected SortedDirectory(){
		listSize=0;
		studentList = new Student[listSize];
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

		if (getStudentIndex(studentList,studentID)>=0){

			System.out.println("Sorry, you cannot add " + name + ",because his/her Student ID [" + studentID + "]already exist.");

		}else{


			listSize++; 

			tempStudentList = new Student[listSize]; 

			if (listSize>1){ 

				copyCurListToTemp(studentList,tempStudentList);
			}

			studentList= new Student[listSize];
			
			listSize--; 

			copyTempListToCur(studentList,tempStudentList);

			studentList[listSize]= new Student(name,studentID);

			listSize++; 
		}
		orderStudents(listSize);

	}

	public String prettyStr(){

		String dir = "Student Name : Student ID: \n";

		for (int i=0;i<studentList.length;i++){
			dir = dir + studentList[i].name + "          "+ studentList[i].studentID + "\n";
		}
		return dir;

	}

	public void removeStudent (int studentID){

		if (getStudentIndex(studentList,studentID)>=0){
			listSize--;
			for (int i =0; i<studentList.length;i++){
				if ((studentList[i].studentID == studentID) && listSize ==0)
				{
					studentList = new Student[listSize];
				}else if (studentList[i].studentID == studentID)
				{
					Student toRemove = studentList[i];
					studentList[i] = studentList[listSize];
					studentList[listSize] = toRemove;

				}
			}

			if (listSize>0){ // copy the array only if the size of the list is greater than one	
				copyCurListToTemp(studentList,tempStudentList);
			}
			studentList= new Student[listSize];// init. an array of objects with new size

			if (listSize>=0){
				copyTempListToCur(studentList,tempStudentList);
			}
		}else{

			System.out.println("Sorry, you cannot remove this student, because his/her Student ID #[" + studentID + "] does not exist.");

		}
		orderStudents(listSize);
	}

	public String studentLookup (int studentID){

		String output= new String();
		int studentIndex = getStudentIndex(studentList,studentID);
		if (studentIndex<0){
			output = "The student you are looking for is not in the directory.";
		}else{
			output = "The student you are looking for is " + studentList[studentIndex].name + ", with Student ID # [" + studentList[studentIndex].studentID + "] .\n";
		}
		return output;
	}

	private int getStudentIndex(Student studentList[], int num){
		for (int i=0; i<studentList.length;i++)
		{
			if (studentList[i].studentID == num)
			{
				return i;
			}

		}
		return -1;
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
	private void orderStudents(int size)
	{
		if (size==0){

		}else{

			for (int i=0; i < studentList.length; i++)
			{
				Student Temp1 = studentList[i];
				Student Temp2 = studentList[size-1];

				if(studentList[i].studentID < studentList[size-1].studentID){

					studentList[i] = Temp2;
					studentList[size-1] = Temp1;

				}

				orderStudents(size-1);

			}

		}

	}

}
