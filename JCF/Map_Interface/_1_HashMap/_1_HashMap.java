package JCF.Map_Interface._1_HashMap;

import java.util.HashMap;
import java.util.Map;

public class _1_HashMap {
    // To take HashMap as argument and return HashMap from function:
    public HashMap<String, Integer> createEmployeeMap(HashMap<String, Integer> map) {
        return map;
    }
    public static void main(String[] args) {
        /*
                                                =======================================
                                                |               1) HashMap                |
                                                =======================================
         

        Definition - HashMap is a data structure that store 2 things: key & value
        Keys are stored in unordered fashion.
        Key is always unique.
        Add, remove, get all have O(1) Time complexity.

        */

        //Creation
        HashMap<String,Integer> map=new HashMap<>();

        //To clear the hashmap
        map.clear();

        //Add Element - TC: O(1)
        map.put("One",1);
        map.put("Two",2);//{One=1,Two=2}
        map.put("Three",3);//{One=1, Two=2, Three=3}
        System.out.println(map); //{One=1, Two=2, Three=3}

        //Remove Key - TC: O(1)
        map.remove("Three");//If a key is passed which does not exist then it returns null value

        //Get Size - TC: O(1)
        System.out.println(map.size());

        //Get Element - TC: O(1)
        map.get("One");//To get the value of the key passed as argument. If a key is passed which does not exist then it returns null value.
        map.getOrDefault("Three", 0);//To get the value of the key passed as argument. If key not present, return default value.

        //To overide value of a specific key - TC: O(1)
        map.put("Two",23);

        // Contains key - To check if map contains a key - TC: O(1)
        System.out.println("Map contains key 'Two'? : "+map.containsKey("Two"));

        //To Put a key if key not present:
        if(!map.containsKey("Two"))
        map.put("Two",23);
        //Or
        map.putIfAbsent("Two",23);

        // Question:-----------------------------------With if contains, can you have HashMap working as HashSet? Then what is the use of HashSet?
        // HashMaps in Java are inherently unordered; they do not maintain any specific order of elements. If a sorted order is required, the data needs to be transferred to a different data structure or a specialized Map implementation that supports ordering.
        // 1. Sorting by Key: To sort a HashMap by its keys, a TreeMap can be utilized. TreeMap automatically sorts its entries by their keys based on their natural ordering or a provided Comparator.
        // HashMap does not maintain any particular order of its entries, so when you iterate through it, the order may seem random. However, LinkedHashMap maintains the order in which you added elements, making it useful when the order of elements matters.

        for(Map.Entry<String,Integer> e:map.entrySet()){
            System.out.println(e);//One=1
            System.out.println(e.getKey());//One
            System.out.println(e.getValue());//1            
        }

        // Iteration on Hashmaps:
        // To run a loop on hashmap, we need to use sets. Hashmap has a method keySet(). Using this function, Hashmap makes a set of all the keys and return it
        // Set<String> keys = map.keySet()
        // System.out.println(keys)
        // This will print all the keys (in a random order of course)

        for(String key:map.keySet())
        System.out.println("Key,Value: "+key+","+map.get(key));
        for(Integer value:map.values())
        System.out.println(value);

        System.out.println(map.containsValue(3));

        //To check if hashmap is empty
        System.out.println(map.isEmpty());
    }
}
