
public class UnsortedDirectory implements SDinterface{

	private int [] studentID;
	private String[] name;
	private int numOfStu;
	

	
	public UnsortedDirectory(){
		numOfStu = 0;	
	}
	
	public void addStudent (String name, int studentID){
		
		this.studentID = new int [numOfStu+1];
		this.name = new String [numOfStu+1];
		
		this.name[numOfStu] = name;
		this.studentID [numOfStu] = studentID;
		
	
		
		}
		
	public String prettyStr(){
		String dir = new String();
		
		for (int i=0;i<numOfStu;i++){
			dir = name[i] + " " + studentID[i] + "\n Size of array is " + numOfStu;
		}
		return dir;
	}
	public void removeStudent (int studentID){
		
	}
	
	public String studentLookup (int studentID){
		
		return name[numOfStu];
	}
	
	
	
}
	

