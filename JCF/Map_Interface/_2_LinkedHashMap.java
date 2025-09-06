package JCF.Map_Interface;

import java.util.LinkedHashMap;

public class _2_LinkedHashMap {
    public static void main(String[] args){
        /*
                                                =======================================
                                                |          2) LinkedHashMap           |
                                                =======================================
         
        Immplementation: In array, it uses Doubly LinkedList inside rather than Linked List, that’s how its order is maintained.
        Has same time complexity like Hashmaps for all operations
        Keys are insertion ordered
        Performance somewhat lower than HashMap (due to the additional task of maintaining a doubly-linked list. )

        */

        //Creation (Key is of String type and Value is of Integer type)
        LinkedHashMap<String,Integer> lhmap=new LinkedHashMap<>();
        
        //Rest same functions as HashMap
    }
}
