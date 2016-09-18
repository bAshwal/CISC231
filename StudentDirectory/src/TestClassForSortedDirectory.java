/**		Bakr Albakri && Mary Scholten
 *
 *  CISC231-01 		:	Assignment1		: 9/19/2016
 *
 *TestClassForSortedDirectory: Run test cases for UnsortedDirectory class
 *
 */

import java.util.Random;

public class TestClassForSortedDirectory {

	public static void main(String[] args) {

		SortedDirectory d1 = new SortedDirectory();

		System.out.println("======================================");
		System.out.println("    Testing SortedDirectory Class     ");
		System.out.println("======================================");
		System.out.println("Note: (*)statements are part of the testing class ");
		System.out.println("______________________________");

		// Removing from an empty directory
		System.out.println("*Test Case1: Removing a studentID# from an empty List");
		d1.removeStudent(100000001);
		System.out.println("______________________________");

		// Looking up an empty directory
		System.out.println("*Test Case2: Looking up a studentID# that doesn't exist");
		System.out.println(d1.studentLookup(123123123));
		System.out.println("______________________________");

		// Adding, looking up, removing a single student
		System.out.println("*Test Case3: Adding, looking up, and removing a single student");
		d1.addStudent("Mary", 100000007);
		System.out.println("*1)Added {Mary,100000007}:\n" + d1.prettyStr());
		System.out.println("*2)Lookup for Mary with studentID # {100000007}:\n" + d1.studentLookup(100000007));
		d1.removeStudent(100000007);
		System.out.println("*3)Removed {Mary} by her studentID#\n" + d1.prettyStr());
		System.out.println("*4)Looking up {Mary} after we removed her.\n" + d1.studentLookup(123123123));
		System.out.println("______________________________");

		// Adding 5 students, in recursive order
		System.out.println("*Test Case4: Adding 5 students with studentID#'s sorted recursively");
		System.out.println("*{(Bakr,100000010),(Mark,100000009),(Jack,100000008),(Mary,100000007),(Gary,100000006)})");
		d1.addStudent("Bakr", 100000010);
		d1.addStudent("Mark", 100000009);
		d1.addStudent("Jack", 100000008);
		d1.addStudent("Mary", 100000007);
		d1.addStudent("Gary", 100000006);
		System.out.print("*Added 5 students(Sorted):\n" + d1.prettyStr());
		System.out.println("______________________________");

		//Removing 2 of the students with their ID#'s
		System.out.println("*Test Case5: remove StudentID#'s {100000010,100000007} i.e. Bakr and Mary");
		d1.removeStudent(100000010);
		d1.removeStudent(100000007);
		System.out.print("*removed the 2 studentID#'s (Sorted):\n" + d1.prettyStr());
		System.out.println("______________________________");

		// Adding 2 students with ID#'s that already exist
		System.out.println("*Test Case6: adding back Bakr and Mary with StudentID#'s that already exist {100000006,100000008}");
		d1.addStudent("Bakr", 100000006);
		d1.addStudent("Mary", 100000008);
		System.out.print(d1.prettyStr());
		System.out.println("______________________________");

		// Adding 1 student to change list size from odd to even
		System.out.println("*Test Case6: adding {Mary,100000007} to test even size array");
		d1.addStudent("Mary", 100000007);
		System.out.print( d1.prettyStr());
		System.out.println("______________________________");

		// Adding 10 students to test dynamicity and sorting of the list
		System.out.println("*Test Case7: adding 10 random studentID#'s to test dynamicity & sorting");
		System.out.println("** This could be adjusted to more students from the source code. Tested up to 1000** ");
		Random randomNum = new Random();
		int randomID[] = new int [10]; //adjust for more students
		for (int i = 0; i<randomID.length; i++){
			randomID[i] = 100000000 + Math.abs(randomNum.nextInt(100));//adjust for more random ID#'s range
			d1.addStudent("Joe"+i,randomID[i]);
		}
		System.out.print(d1.prettyStr());
		System.out.println("______________________________");

		// Removing, adding, and lookingup students in the directory
		System.out.println("*Test Case8: Removing {Mark,100000009}, adding {Jane,123123123}, & lookingup {Mary,100000007}");
		d1.removeStudent(100000009);
		System.out.println("*1) {Mark,100000009}removed:");
		System.out.println(d1.prettyStr());
		System.out.println("*2) {Jane,123123123}added:");
		d1.addStudent("Jane", 123123123);
		System.out.println(d1.prettyStr());
		System.out.println("*3) Lookingup {Mary,100000007}:");
		System.out.println(d1.studentLookup(100000007));

		System.out.println("=============================================");
		System.out.println("    End of Testing SortedDirectory Class     ");
		System.out.println("=============================================");



	}



}
