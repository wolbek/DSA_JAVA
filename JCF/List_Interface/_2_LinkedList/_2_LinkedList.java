package JCF.List_Interface._2_LinkedList;

import java.util.LinkedList;

public class _2_LinkedList {
    public static void main(String[] args) {
        /*
        
                                                =======================================
                                                |           2) LinkedList             |
                                                =======================================     

        Operations: Insertion, Deletion, Searching, Updating, Sorting, Merging, Traversal (And Get)
        Types: Singly, Doubly, Circular Linked List

        Programs to solve:
        1) Merge Sort on LL
        2) Zig Zag LL
        3) Reverse a Doubly LL
        4) Doubly linked list (addFirst, removeFirst, addLast & removeLast homework)
        5) Circular linked list (last node connected to first) (In alpha reading material of Circular LL, you can get the implementation)

        */

        //Creation
        LinkedList<Integer> ll=new LinkedList<>();

        //Add first
        ll.addFirst(10);

        //Add last
        ll.addLast(20);

        // Add at given index
        ll.add(2,30);// adds at the given index.  The index you specify, before that all indexes should be filled.
        ll.add(40);//by default adds at last
        ll.add(50);//by default adds at last
        ll.add(60);//by default adds at last

        System.out.println("LinkedList: "+ll);

        //Remove first
        System.out.println("Remove first element: "+ll.removeFirst());

        //Remove last
        System.out.println("Remove last element: "+ll.removeLast());

        //Remove at specific index
        System.out.println("Remove element at index 2: "+ll.remove(2));
        System.out.println("By default removes first: "+ll.remove());


        //Get size of LinkedList
        System.out.println("Size of LinkedList: "+ll.size());

        //Print LinkedList
        System.out.println("Printing linkedlist in 2 ways: 1) Direct, 2) for loop");

        //1st way
        System.out.println(ll);

        //2nd way
        for(int i=0;i<ll.size();i++){
            System.out.print(ll.get(i)+" -> ");            
        }
        System.out.println("null");
    }
}
