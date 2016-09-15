

public class test {

	public static void main(String[] args) {
		
	SortedDirectory d1 = new SortedDirectory();
	
	d1.addStudent("Hubbly", 1);
	d1.addStudent("Dubbly", 2);
	d1.addStudent("Doohly", 3);
	d1.addStudent("Daahly", 4);
	d1.removeStudent(4);
	d1.removeStudent(3);
	d1.removeStudent(2);
	d1.removeStudent(1);
	d1.removeStudent(4);
	d1.addStudent("Daahly", 4);
	System.out.println(d1.prettyStr());




	
	}

}
