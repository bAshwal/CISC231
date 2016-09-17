/**		Bakr Albakri && Mary Scholten	
 * 
 *  CISC231-01 		:	Assignment1		: 9/19/2016
 * 
 * SortedDirectory: a class that implements SDinterface. Its functionality includes
 * creating a dynamic directory for students, sorted by their ID#, while adding, removing,
 * from the directory.
 * 
 */

public class SortedDirectory implements SDinterface {

	private int listSize; // int: Actual size of the directory
	private Student studentList[]; //Student[]: Actual array of Student objects
	private Student cpyOfStudentList[]; //Student[]: A copy of the student objects array, to add dynamic functionality

	/**
	 * SortedDirectory constructor: initialize the size of the directory with 0 (empty list),
	 *	and initialize the empty list.
	 */
	protected SortedDirectory(){
		listSize=0;
		studentList = new Student[listSize];
	}

	/**
	 * Student: an internal class that creates objects of type Student and used to fill 
	 * in our directory list.
	 *  It has two attributes:
	 * 1- studentID (int): stores student ID # .
	 * 2- name (String): stores student name.
	 */
	private class Student{
		private int studentID;
		private String name;

		private Student(String name, int studentID){
			this.name = name;
			this.studentID = studentID;
		}	

	}
	/**
	 * Method1: addStudent(String,int) -> returns void
	 * 
	 * First, checks if studentID# exists, if so -> don't add duplicate. Else
	 * 
	 * Increase the list size by one -> initialize cpyOfStudentList array with the 
	 * new size then check if the current list size is greater than one (its the only 
	 * case that we need to copy the list)-> then initialize studentlist with the new 
	 * size -> decrement the list size (to add the student at the end of the list) -> copy
	 * back our list to current list and add a new student at the end of the list -> 
	 * increment list size to reflect the new size of the list 
	 * 
	 * Then -> call the orderStudent method to order our list
	 * 
	 */
	public void addStudent (String name, int studentID){


		if (getStudentIndex(studentID)>=0){

			System.out.println("Sorry, you cannot add " + name + ",because his/her Student ID [" + studentID + "]already exist.");

		}else{


			listSize++; 

			cpyOfStudentList = new Student[listSize]; 

			if (listSize>1){ 

				copyCurListToTemp(studentList,cpyOfStudentList);
			}

			studentList= new Student[listSize];

			listSize--; 

			copyTempListToCur(studentList,cpyOfStudentList);

			studentList[listSize]= new Student(name,studentID);

			listSize++; 
		}
		orderStudents();

	}

	/**
	 * Method2: removeStudent(int) -> returns void
	 * 
	 * First, checks if studentID# exists, Else -> prints that ID# doesn't exist.
	 * 
	 * if studentID# exists -> decrement the list size and look through the list 
	 * for our student (2 possible scenarios):
	 * 
	 * 	a. If the list has one student (listSize ==0)and his ID# matches,
	 *  then we just need to create a new empty list
	 * 	   
	 *  b. The list has more than one student, then:
	 *  	1) We put him at the end of the list
	 *  	2) Copy current list to a new list with the size-1
	 *  	3) Initialize a new student list
	 *  	4) copy back our list to original list array
	 *  
	 *  Then -> call the orderStudent method to order our list
	 */

	public void removeStudent (int studentID){

		if (listSize ==0){
			System.out.println("The directory is empty, you can't remove.");
		}
		if (getStudentIndex(studentID)>=0){
			listSize--;
			for (int i =0; i<studentList.length;i++){
				if ((studentList[i].studentID == studentID) && listSize == 0)
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
				copyCurListToTemp(studentList,cpyOfStudentList);
			}
			studentList= new Student[listSize];// init. an array of objects with new size

			if (listSize>=0){
				copyTempListToCur(studentList,cpyOfStudentList);
			}
		}else if (listSize != 0){

			System.out.println("Sorry, you cannot remove this student, because his/her Student ID #[" + studentID + "] does not exist.");

		}
		orderStudents();
	}

	/**
	 * Method3: prettyStr() -> returns String
	 * 
	 * This method will return a string of our current directory students, concatenating
	 * their attributes (i.e. name, student ID#)
	 */
	public String prettyStr(){

		String dir = "Student Name : Student ID: \n";

		for (int i=0;i<studentList.length;i++){
			dir = dir + studentList[i].name + "          "+ studentList[i].studentID + "\n";
		}
		return dir;

	}

	/**
	 * Method4: studentLookup() -> returns String
	 * 
	 * This method will return a string that shows, either:
	 * 
	 * a- Student is in the directory: gives his name and studentID#
	 * b- Student is not in the directory: says so!
	 */
	public String studentLookup (int studentID){

		String output= new String();
		int studentIndex = getStudentIndex(studentID);
		if (studentIndex<0){
			output = "The student you are looking for is not in the directory.";
		}else{
			output = "The student you are looking for is " + studentList[studentIndex].name + ", with Student ID # [" + studentList[studentIndex].studentID + "] .\n";
		}

		return output;
	}

	/**
	 * Method5: getStudentIndex(Student [], int) -> returns int
	 * 
	 * This method is useful to check if the studentID# exists,it returns either:
	 * 
	 * n(when n>=0) : thats the index of the student we are looking for
	 * -1 : if the studentID# isn't in the directory
	 * 
	 */

	private int getStudentIndex(int num){
		for (int i=0; i<studentList.length;i++)
		{
			if (studentList[i].studentID == num)
			{
				return i;
			}

		}
		return -1;
	}

	/**
	 * Method6: copyCurListToTemp(Student [],Student []) -> returns void
	 * 
	 * This method iterate through our list, and assigns current list Students to 
	 * a temporary list(copyOfStudentList)
	 * It is important because we need a dynamic array, therefore, it is used whenever
	 * we change the list size to add/remove students
	 * 
	 */
	private void copyCurListToTemp(Student studentList[], Student cpyOfStudentList[]){
		for(int i=0; i<studentList.length;i++){// loop to copy current list to the temporary one.	
			cpyOfStudentList[i] = studentList[i];
		}
	}
	/**
	 * Method7: copyTempListToCur(Student [],Student []) -> returns void
	 * 
	 * This method iterate through our temporary list(copyOfStudentList) to retrieve our
	 * original list after the change of adding/removing a student has been applied
	 * 
	 */
	private void copyTempListToCur(Student studentList[], Student cpyOfStudentList[]){
		for(int i=0; i<studentList.length;i++){
			studentList[i] = cpyOfStudentList[i];
		}

	}
	/**
	 * Method9: orderStudents() -> returns void
	 * 
	 *This method order our students array by their studentID#
	 *
	 *The basic idea is to compare two consecutive students ID#'s for the (listSize -1)
	 *(Because the last student will not have a next Student to compare his ID# with)
	 *Then, the last student compare his ID # with the student previous to him.
	 *
	 *So, in the loop we compare 2 consecutive student ID#'s and keep switching/moving the bigger up in the directory and
	 *and reseting the index until we reach the last two students. Then: we check the last two to see whom has the bigger student ID # and reset the index.
	 * 
	 * Lastly, we need to compare the first two students ID#'s, which is greater, because if the ID'#s were ordered recursively
	 * the second Student will miss comparing with the first student, the next student ID # will always be greater than the previous one.
	 */
	private void orderStudents()
	{
		Student iStudent;
		Student nextStudent;
		
		for (int i =0; i<studentList.length-1; i++){
			 iStudent = studentList[i];
			 nextStudent = studentList[i+1];

			if ((iStudent.studentID > nextStudent.studentID) && i<listSize-2){
				studentList[i] = nextStudent;
				studentList[i+1]= iStudent;
				i=0;
			}
			if (i==(listSize-2))
			{
				iStudent = studentList[listSize-2];
				nextStudent = studentList[listSize-1];
				
				if ((iStudent.studentID > nextStudent.studentID))
				{
					studentList[i] = nextStudent;
					studentList[i+1]= iStudent;
					i=0;
				}
			}
			
		}
		if ( (listSize>1)&& studentList[0].studentID > studentList[1].studentID)
		{
			iStudent = studentList[0];
			studentList[0] = studentList[1];
			studentList[1]= iStudent;
		}
		
	}


} // end orderStudents


