package assignments.w3d2;

public class Desktop implements Hardware, Software {

	public void desktopModel() {
		System.out.println("Model of the desktop is AXD-31");
	}

	public void softwareResources() {
		System.out.println("Software resources' method");
	}

	public void hardwareResources() {
		System.out.println("Hardware resources' method");
	}

	public static void main(String[] args) {

		Desktop obj = new Desktop();

		obj.hardwareResources();
		obj.softwareResources();
		obj.desktopModel();
	}

}
