/**		Bakr Albakri && Mary Scholten	
 * 
 *  CISC231-01 		:	Assignment1		: 9/19/2016
 * 
 * UnsortedDirectory: a class that implements SDinterface. Its functionality includes
 * creating a dynamic directory for students, with ability to lookup, add, and remove from the directory.
 * 
 */

public class UnsortedDirectory implements SDinterface {

	private int listSize; // int: Actual size of the directory
	private Student studentList[]; //Student[]: Actual array of Student objects
	private Student cpyOfStudentList[]; //Student[]: A copy of the student objects array, to add dynamic functionality

	/**
	 * UnsortedDirectory constructor: initialize the size of the directory with 0 (empty list),
	 *	and initialize the empty list.
	 */
	protected UnsortedDirectory(){
		listSize=0;
		studentList = new Student[listSize];
	}

/**
 * Student: an internal class that creates objects of type students. It has two attributes
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
	 */

	public void addStudent (String name, int studentID){

		if (getStudentIndex(studentList,studentID)>=0){

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
				copyCurListToTemp(studentList,cpyOfStudentList);
			}
			studentList= new Student[listSize];// init. an array of objects with new size

			if (listSize>=0){
				copyTempListToCur(studentList,cpyOfStudentList);
			}
		}else{

			System.out.println("Sorry, you cannot remove this student, because his/her Student ID #[" + studentID + "] does not exist.");

		}
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
		int studentIndex = getStudentIndex(studentList,studentID);
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
	

}