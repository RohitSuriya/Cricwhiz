package assignments.w3d1.org.department;

import assignments.w3d1.org.college.College;

public class Department extends College {

	public void deptName() {
		System.out.println("Department name-Public");
	}
	
	//Trying private and protected access specifiers
	
	private void deptName1() {
		System.out.println("Department name1");
	}
	
	protected void deptName2() {
		System.out.println("Department name2-Protected");
	}
}
