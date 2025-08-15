package JCF.Set_Interface;

import java.util.Set;
import java.util.TreeSet;

public class _3_TreeSet {
    public static void main(String[] args) {
        /*
                                                =======================================
                                                |             3) TreeSet              |
                                                =======================================
         
        
        Sorted in ascending order
        NULL values are not allowed (As sorting needs to be done, we need to have a value)
        Internally implemented as TreeMap (which itself uses Red-Black tree)
        Because of sorting, operation such as insert, remove, etc take TC: O(logn), whereas LinkedHashSet and HashSet has TC: O(1) for those operations
        
        */

        Set<Integer> tset=new TreeSet<>();// Operation happen in O(log n)
    }
}
