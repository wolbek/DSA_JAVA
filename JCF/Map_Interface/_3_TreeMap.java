package JCF.Map_Interface;

import java.util.Set;
import java.util.TreeMap;

public class _3_TreeMap {
    public static void main(String[] args) {
        /*
                                                =======================================
                                                |             3) TreeMap              |
                                                =======================================
         
        Keys are sorted
        Implemented using Red-Black trees (BST which are self-balancing)

        */

        //Creation
        TreeMap<String,Integer> tmap=new TreeMap<>();//Operations take O(log n)
        
        //To add element - TC: O(logn)
        tmap.put("Two", 2);

        //To remove element - TC: O(logn)
        System.out.println(tmap.remove("Two"));

        //To get a value of a key - TC: O(logn)
        System.out.println(tmap.get("Two"));

        // To print treemap in ascending order
        for (String key : tmap.keySet()) {
            System.out.println(key + "=" + tmap.get(key));
        }

        // To print treemap in descending order
        Set<String> reverseKeys = tmap.descendingKeySet();
        for (String key : reverseKeys) {
            System.out.println("Key: " + key + ", Value: " + tmap.get(key));
        }
    }
}
