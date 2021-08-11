package assignments.w1d2;

import java.util.Arrays;

public class MissingElementInAnArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {1, 2, 3, 4, 5, 6, 8};
		Arrays.sort(array);
		
		 for (int i = 1; i <= array.length; i++) {
			 if(i != array[i-1]) {
				System.out.println("The missing number is: " + i);
				break;	
			 }						 
		 }
		 }
	}
