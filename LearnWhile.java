package week1.day1;

public class LearnWhile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int num = 6857;
		int num1;
		int sum = 0;
		while (num>0) {
		
			num1 = num%10;
			sum = sum + num1;
			num = num/10;			
	}
		System.out.println("The sum of digits is:" + sum);

}
}
