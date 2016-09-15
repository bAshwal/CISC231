

public class test {

	public static void main(String[] args) {

		SortedDirectory d1 = new SortedDirectory();
		
		d1.addStudent("abc", 0);
		d1.addStudent("def", 11);
		d1.addStudent("ghi", 2);
		d1.addStudent("jkl", 13);
		d1.addStudent("mno", 1);
		d1.addStudent("pqr", 14);
		d1.addStudent("stu",103);
		d1.addStudent("vwx", 0);
//		d1.addStudent("yza", 9);
//		d1.addStudent("bcd", 10);
//		d1.addStudent("efg", 11);
//		d1.addStudent("hij", 12);
//		d1.addStudent("klm", 13);
//		d1.addStudent("nop", 14);
//		d1.addStudent("qrs", 15);
//		d1.addStudent("tuv", 16);
//		d1.addStudent("wxy", 17);
//		d1.addStudent("zab", 18);
//		d1.addStudent("cde", 19);
//		d1.addStudent("fgh", 20);
//		d1.addStudent("ijk", 21);
//		d1.addStudent("lmn", 22);
//		d1.addStudent("opq", 23);
//		d1.addStudent("rst", 24);
//		d1.addStudent("uvw", 25);
//		d1.addStudent("xyz", 26);
//		d1.removeStudent(1);
//		System.out.println(d1.studentLookup(1));
//		System.out.println(d1.prettyStr());
		
		System.out.println(d1.prettyStr());
		System.out.println(d1.studentLookup(11));
		

	}

}
