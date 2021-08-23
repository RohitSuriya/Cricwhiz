package assignments.w3d1.general;

public class Student {

	public void getStudentInfo() {
		System.out.println("No arguments");
	}
	
	public void getStudentInfo(String str) {
		System.out.println("Passing string as argument");
	}
	
	public void getStudentInfo(int id) {
		System.out.println("Passing student id as argument ");
	}
	
	public void getStudentInfo(int id, String str) {
		System.out.println("Student id and name are passed as arguments");
	}
	
	public void getStudentInfo(long phoneNo, String mailId) {
		System.out.println("Phone number and mail id are passed as arguments");
	}
	public static void main(String[] args) {

		Student obj = new Student();
		obj.getStudentInfo();
		obj.getStudentInfo(11604469);
		obj.getStudentInfo("Name");
		obj.getStudentInfo(123, "Name1");
		obj.getStudentInfo(1234567890L, "Naame2");
	}

}
