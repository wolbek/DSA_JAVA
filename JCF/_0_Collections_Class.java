package JCF;

import java.util.ArrayList;
import java.util.Collections;

public class _0_Collections_Class {
    public static void main(String[] args) {
        /*
                                    *-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*_*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*
                                    |   Collections Class (Collections is a class, Collection is an interface)    |
                                    *-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*_*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*
        */

        //Creation
        ArrayList<Integer> list1 = new ArrayList<>();

        //Add element 
        list1.add(10); //O(1)
        list1.add(20);
        list1.add(30); 
        list1.add(40); 
        list1.add(4,50);

        // Get minimum
        System.out.println("Min in list: "+Collections.min(list1));

        //Get maximum
        System.out.println("Max in list: "+Collections.max(list1));

        //Get frequency of an element
        System.out.println("Frequency of element 20 in list"+Collections.frequency(list1,20));

        //Sort in asending order
        Collections.sort(list1);
        System.out.println("List in sorted order: "+list1);
        
        //Sort in descending order 
        Collections.sort(list1, Collections.reverseOrder());
        System.out.println("List in revers sorted order: "+list1);

        //Comparator - an interface that provides a way to compare objects for ordering purposes. It allows you to define custom comparison logic.

        //What does the comment written below mean?
        //Sorting Custom collections
        //Comparable interface -one class one comparable method
        //Comparator interface -one class multiple comparable method
    }
}
