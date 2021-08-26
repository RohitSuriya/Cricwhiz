package assignments.w3d2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SecondLargest_List {

	public static void main(String[] args) {

		List<Integer> l1 = new ArrayList<Integer>();

		l1.add(3);
		l1.add(2);
		l1.add(11);
		l1.add(4);
		l1.add(6);
		l1.add(7);

		System.out.println("The unsorted list is:" + l1);

		Collections.sort(l1);
		System.out.println("The sorted list is:" + l1);
		
		Integer a = l1.get(l1.size()-2);
		System.out.println("Second largest element: " + a);
	}

}
