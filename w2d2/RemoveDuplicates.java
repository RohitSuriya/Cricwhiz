package assignments.w2d2;

import java.util.Iterator;

public class RemoveDuplicates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String text = "We learn java basics as part of java sessions in java week1";
		int count = 0;
		String[] strArray = text.split(" ");
		int length = strArray.length;
		System.out.println("Number of words in the sentence: " + length);
		for (int i = 0; i < length; i++) {
			if (strArray[i] != "") {
				for (int j = i + 1; j < length; j++) {
					if (strArray[i].equals(strArray[j])) {
						strArray[j] = "";
					}
				}
			}
		}
		for (int k = 0; k < length; k++) {
			System.out.print(strArray[k] + " ");
		}
	}

}
