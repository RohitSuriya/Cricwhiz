package assignments.w1d1;

public class PrimeNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int a = 13;
		int var = 0;
			
			for (int i = 2; i <= a/2; i++) {
				if (a%i ==0) {
				System.out.println("The given number " + a + " is not a prime number");
				var = 1;
				break;
				}
				}
			if (var == 0) {
				System.out.println("The given number " + a + " is a prime number");
			}
	}

}
