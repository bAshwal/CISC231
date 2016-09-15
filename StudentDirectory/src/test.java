

public class test {

	public static void main(String[] args) {
		
	SortedDirectory d1 = new SortedDirectory();
	
	d1.addStudent("YoYo", 12312314);
	d1.addStudent("YoJYo", 12312534);
	d1.addStudent("YoLYo", 12314234);
	d1.addStudent("YoKYo", 12313234);
	d1.addStudent("YoYo", 12231234);
	d1.addStudent("YoYo", 12231234);
	d1.addStudent("YoYo", 12231234);
	d1.addStudent("YoYo", 12231234);
	d1.addStudent("YoYo", 12231234);
	System.out.println(d1.prettyStr());
	}

}
