package assignments.w1d2;

import java.util.Arrays;

import com.beust.jcommander.Strings;

public class ReverseEvenWords {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "I am a software tester";
		String rev = "";
		
//		for (int i = str.length()-1; i >= 0; i--) {
//			rev += str.charAt(i);
//		}
//		//System.out.println("Reversed string: " + rev);
	 String[] split = str.split(" ");
	 for (int i = 0; i < split.length; i++) {
		System.out.print(split[i] + " ");
	}
	 String str1 = "";
	 for (int k = 0; k < split.length; k++) {
		if (k%2 != 0) {
			 for (int j  = split[k].length()-1; j >= 0; j--) {
				 str1 += split[k].charAt(j);
			}
			 System.out.println('\n' + str1);
		}
	}
	 System.out.println('\n' + split[0] + " " + str1 + " " + split[2] + " " + split[4]);
		/*
		 * System.out.println('\n' + str1); for (int j = split[3].length()-1; j >= 0;
		 * j--) { rev += split[3].charAt(j); } System.out.println(rev);
		 */
	}
}
