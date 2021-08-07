package assignments.w1d1;

public class FibonacciSeries {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int limit=25,i=0,j=1,sum;
		System.out.println("Fibonacci series of first 25 numbers:-");
		System.out.println(i);
		for (int k = 1; k < limit; k++) {
			sum = i + j;
			i = j;
			j=sum;
			System.out.println(sum);
		}
	}

}
