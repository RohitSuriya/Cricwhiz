package assignments.w3d2;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveDuplicatesUsingSet_2 {

	public static void main(String[] args) {

		String str = "We learn java basics as part of java sessions in java week1";
		Set<String> strSet = new LinkedHashSet<String>();
		String[] split = str.split(" ");

		for (int i = 0; i < split.length; i++) {
			strSet.add(split[i]);
		}
		for (String unique : strSet) {
			System.out.print(unique + " ");
		}
	}

}
