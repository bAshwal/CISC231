

public class test {

	public static void main(String[] args) {
		
	SortedDirectory d1 = new SortedDirectory();
	
	d1.addStudent("Abc", 12312314);
	System.out.println(d1.prettyStr());
	d1.addStudent("Abc", 12312314);
	System.out.println(d1.prettyStr());
	d1.addStudent("Abwec", 122312314);
	System.out.println(d1.prettyStr());
	d1.addStudent("Abwec", 1222314);
	d1.addStudent("Abwec", 121212314);
	System.out.println(d1.prettyStr());

	



	
	}

}
