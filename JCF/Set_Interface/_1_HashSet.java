package JCF.Set_Interface;

import java.util.HashSet;
import java.util.Iterator;

public class _1_HashSet {
    public static void main(String[] args){
        /*
                                                =======================================
                                                |             1) HashSet              |
                                                =======================================

        Set is a collection of unique elements
        Unordered
        NULL is allowed
        HashSet are implemented using HashMap

        */ 

        //Creation
        HashSet<Integer> set=new HashSet<>();//Operation happens in O(1)

        //To clear the set
        set.clear();

        //To add element - TC: O(1)
        set.add(30);
        set.add(31);
        set.add(32);
        set.add(32);//will ignore as it's already added

        //To remove element - TC: O(1)
        set.remove(32);

        //To check if it contains an element - TC: O(1)
        System.out.println(set.contains(32));

        //To get size
        set.size();

        System.out.println(set);//Prints in random way [32,65,2,21,54]

        //To check if set is empty or not
        set.isEmpty();

        //To iterate over the set

        //1st way - Using iterators
        /*
            Java has an iterator interface, it allows you to iterate over the set.

            If for any set, you call .iterator() , you’ll be returned a iterator for the set (this iterator points at null)
            E.g set.iterator()

            We store the iterator in iterator type object:

         */
        Iterator i = set.iterator();
        while(i.hasNext()){
            System.out.println(i.next());//i.next() leads to i changing its value 
        }

        //2nd way - Using for each loop
        for(Integer num: set){
            System.out.println(num);
        }

        //Set makes has of each element internally and that hash is getting used in the collection object
        //Every element is assigned a unique hash, so when you add an element, it is checked that if the element's hash is already present in the set

    }
}
