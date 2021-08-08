package assignments.w1d1;

public class Factorial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int num = 5, temp = 1;
		
		for (int i = 1; i<=num; i++) {
			temp = temp * i;
		}
		
		System.out.println(num + " factorial is " + temp);
	}

}
