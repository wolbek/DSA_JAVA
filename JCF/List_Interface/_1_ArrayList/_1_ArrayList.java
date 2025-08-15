package JCF.List_Interface._1_ArrayList;

import java.util.ArrayList;
import java.util.Collections;

public class _1_ArrayList {
    // Using arraylist in functions
    public ArrayList<String> getNames(ArrayList<String> list){
        return list;
    }
    public static void main(String[] args) {
        //Creation
        ArrayList<Integer> list1 = new ArrayList<>(); // You have to specify the type of data it will store.

        //Clear the list
        list1.clear();
        System.out.println("Cleared the list: "+list1);

        //Add element 
        list1.add(10); //O(1) - As adds at end
        list1.add(20);
        list1.add(30); 
        list1.add(40); 
        list1.add(4,50); //O(n) - As all subsequent elements (from index to the end of the list) must be shifted one position to the right to make space for the new element. If 3rd element is not added, you cannot directly add 4th element

        System.out.println("ArrayList: "+list1);
        /*
         * When an ArrayList object is directly printed in Java, such as by passing it to System.out.println(), it returns a string representation of its contents. 
         * This behavior is due to the ArrayList class (which extends AbstractList and AbstractList extends AbstractCollection) overriding the toString() method inherited from the Object class.
         */

        //Get element
        System.out.println("Get element at index 4: "+list1.get(4)); //O(1) - As we can directly access the element at the index as we did in array.

        //Remove element
        System.out.println("Remove element at index 4: "+list1.remove(4)); //O(n) - As removes the element at given index, and shifts the next elements back by 1. Returns the removed element.
        /*
        To remove a specific value from a java.util.ArrayList rather than by its index, use the remove(Object obj) method. It returns true if removed else false.
        
        E.g.
        fruits.remove("Apple"); // Removing the first occurrence of "Apple" by value.

        In our case, if we want to delete a number, rather than the number itself, we've to pass it as object.

        TC: O(n) - Searching for the element, and shifting the elements after deleting.

        */ 
        System.out.println("Removing element 60: "+list1.remove(Integer.valueOf(60))); 
        
        //Set element at index
        list1.set(3,40); //O(1) - It updates the element at the given index with the given element. It cannot set for an index, equal or more than the size of the arraylist.

        //Contains element
        System.out.println("Contains 30?: "+list1.contains(30)); //O(n). Returns true if element exist, else false
        
        //Get size of arraylist
        System.out.println("Size of arraylist: "+list1.size());

        //Print arraylist
        System.out.println("Printing array list in 3 ways: 1) Direct, 2) for loop 3) for each");

        //1st way
        System.out.println(list1); //[30]

        //2nd way
        for(int i=0;i<list1.size();i++){
            System.out.print(list1.get(i)+", ");
        } //30
        System.out.println();

        //3rd way
        for(Integer element: list1){
            System.out.print(element+", ");
        } // 30
        System.out.println();

        // Sorting an ArrayList
        // We use Collections class (not Collection Interface). Have to import it first.
        Collections.sort(list1); // Sorts in ascending order. Sorts in place.
        Collections.sort(list1, Collections.reverseOrder()); // Sorts in descending order.
        
        /* 
        Collections.reverseOrder() is a comparator. 
        Comparators are functions in Java which defines the logic for sorting.
        In .sort(), soring is ascending order by default. But the logic to sort in descending order is written in comparator. So you can use it to sort in descending.
        Not just list, you can also apply these comparators on object.
        You can define custom logic of sorting using comaprators. In _0_Collections_Class file you can see.
        */

        //Add all elements of list 2 to list1
        ArrayList<Integer> list2 = new ArrayList<>(); 
        list2.add(50);
        list2.add(60);

        list1.addAll(list2);
        System.out.println("Added list2 to list1: "+list1);

        //Multidimensional Arraylist
        ArrayList<ArrayList<Integer>> mainList = new ArrayList<>(); // On right side, you only write one ArrayList<>, to initialize it.
        //The lists inside are allowed to have different sizes.

        ArrayList<Integer> list3 = new ArrayList<>();
        list3.add(10);
        list3.add(20);
        mainList.add(list3);

        ArrayList<Integer> list4 = new ArrayList<>();
        list4.add(30);
        list4.add(40);
        mainList.add(list4);

        //Printing Multidimensional Arraylist

        System.out.println("Multidimensional Arraylist: ");

        //1st way
        System.out.println(mainList);//[[10,20],[30,40]]

        //2nd way
        for(int i=0;i<mainList.size();i++){
            ArrayList<Integer> currList = mainList.get(i);
            for(int j=0;j<currList.size();j++){
                System.out.print(currList.get(j)+", ");
            }
            System.out.println();
        }
        // 10 20
        // 30 40     
    }
}
