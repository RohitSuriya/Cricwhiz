package assignments.w1d1;

public class ArmstrongNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int input = 370;
		int temp,rem,sum=0;
		temp=input;
		while(input>0) {
			rem = input%10;
			input = input/10;
			sum = sum + (rem*rem*rem);
			
		}
		if (temp==sum) {
			System.out.println("The given number " + temp + " is an Armstrong number");
		}else
			System.out.println("The given number " + temp + " is not an Armstrong number");
	
	}

}
