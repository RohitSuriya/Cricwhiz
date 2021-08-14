package assignments.w1d2;

import java.util.Arrays;

import com.beust.jcommander.Strings;

public class ReverseEvenWords {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "I am a software tester";
		String rev = "";

		String[] split = str.split(" ");
		/*for (int i = 0; i < split.length; i++) {
			System.out.print(split[i] + " ");
		}*/
		String str1 = "";
		for (int k = 0; k < split.length; k++) {
			if (k % 2 == 1) {
				for (int j = split[k].length() - 1; j >= 0; j--) {
					System.out.print(split[k].charAt(j));
				}
				System.out.print(" ");
			} else {
				System.out.print(split[k] + " ");
			}
		}
	}
}
