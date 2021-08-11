package assignments.w1d2;

public class MyCalc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Calculator obj = new Calculator();
		
		int sum = obj.add(10, 20 , 30);
		System.out.println("The sum of the given numbers is: " + sum);
		
		int difference = obj.sub(100, 93);
		System.out.println("The difference of the given numbers is: " + difference);
		
		double product = obj.mul(15.85, 8.5);
		System.out.println("The product of the given numbers is: " + product);
		
		float quotient = obj.divide(250, 75);
		System.out.println("The quotient of the given numbers is: " + quotient);
	}

}
