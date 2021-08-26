package assignments.w3d2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class IntersectionUsingCollections {

	public static void main(String[] args) {
		/*
		 * int arr1[] = {3,2,11,4,6,7}; 
		 * int arr2[] = {1,2,8,4,9,7};
		 */
		
		List<Integer> l1 = new ArrayList<Integer>();
		List<Integer> l2 = new ArrayList<Integer>();
		
		l1.add(3);
		l1.add(2);
		l1.add(11);
		l1.add(4);
		l1.add(6);
		l1.add(7);
		
		l2.add(1);
		l2.add(2);
		l2.add(8);
		l2.add(4);
		l2.add(9);
		l2.add(7);
		
		l1.retainAll(l2);
		System.out.println("Common elements in both lists:" + l1);
		
		
		
		
		
		
		
		
		
		
	}

}
