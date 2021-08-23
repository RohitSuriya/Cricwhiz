package assignments.w3d1.org.student;

import assignments.w3d1.org.department.Department;

public class Student extends Department{

	public void studentName() {
		System.out.println("Student name");
	}
	
	
	public void studentDept() {
		System.out.println("Student department");
	}
	
	public void studentId() {
		System.out.println("Student ID");
	}
	
	public static void main(String[] args) {
		
		Student obj = new Student();
		
		obj.collegeName();
		obj.collegeCode();
		obj.collegeRank();
		obj.deptName();
		obj.studentName();
		obj.studentDept();
		obj.studentId();
		obj.deptName2();

	}

}
