package assignments.w1d2;

public class ChangeOddIndexToUpperCase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String test = "changeme";
		char[] arr = test.toCharArray();
		System.out.println("Characters at odd index changed to upper case:");
		for (int i = 0; i < arr.length; i++) {
			if (i%2 != 0) {
				char a = Character.toUpperCase(arr[i]);
				System.out.println("Character at index-" + i + " = " +a);
			}
			
		}
	}

}
