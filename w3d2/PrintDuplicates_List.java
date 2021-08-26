package assignments.w3d2;

import java.util.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class PrintDuplicates_List {

	public static void main(String[] args) {

		List<Integer> l1 = new ArrayList<Integer>();
		Set<Integer> s1 = new LinkedHashSet<Integer>();

		l1.add(14);
		l1.add(12);
		l1.add(13);
		l1.add(11);
		l1.add(15);
		l1.add(14);
		l1.add(18);
		l1.add(16);
		l1.add(17);
		l1.add(19);
		l1.add(18);
		l1.add(17);
		l1.add(20);

		Collections.sort(l1);
		for (int i = 0; i < l1.size(); i++) {
			int count = Collections.frequency(l1, l1.get(i));
			if (count > 1) {
				s1.add(l1.get(i));
				//System.out.println("The count of " + l1.get(i) + " is " + count);
			}
		}
		System.out.println("Duplicate elements in the list: " + s1);
	}

}
