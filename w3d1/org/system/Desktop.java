package assignments.w3d1.org.system;

public class Desktop extends Computer{

	public void desktopSize() {
		System.out.println("The desktop size is 16 inches");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Desktop obj = new Desktop();
		
		obj.computerModel();
		obj.desktopSize();
	}

}
