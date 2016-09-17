/**		Bakr Albakri && Mary Scholten	
 * 
 *  CISC231-01 		:	Assignment1		: 9/19/2016
 * 
 * SDinterface: an interface that provides methods to be implemented by 
 * our directory classes:
 * 
 * 1-studentLookup: search for a student via StudentID# and return a String with his/her name.
 * 2-addStudent: add a new student with his name and studentID #.
 * 3-removeStudent: remove a student via his StudentID#
 * 4- prettyStr(): prints a list of our directory with students' names and ID#'s
 * 
 */
public interface SDinterface {
	
	 String studentLookup (int studentID);
	 void addStudent (String name, int studentID);
	 void removeStudent (int studentID);
	 String prettyStr ();

}
