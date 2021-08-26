package assignments.w3d2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MissingElement_Collections {

	public static void main(String[] args) {

		List<Integer> list1 = new ArrayList<Integer>();
		list1.add(1);
		list1.add(2);
		list1.add(3);
		list1.add(4);
		list1.add(5);
		list1.add(6);
		list1.add(8);

		Collections.sort(list1);

		for (int i = 1; i <= list1.size(); i++) {
			if (i != list1.get(i - 1)) {
				System.out.println("The missing number is: " + i);
				break;
			}
		}
	}
}