package JCF.Queue_Interface._2_Deque;

import java.util.ArrayDeque;
import java.util.Deque;

public class _2_Deque_Using_ArrayDeque {
    public static void main(String[] args){
         /*
                                             =====================================================
                                             |             2) Deque using ArrayDeque             |
                                             =====================================================  
         
        Definition- You can add, remove, peek from both ends

        */
      
        Deque<Integer> deque=new ArrayDeque<>(); // You can use Linked List for it too
        
        // Removes all elements
        deque.clear();

        //Add element at first/front
        deque.addFirst(20); // Returns exception if not added
        deque.offerFirst(10);// Returns false if not added. So it's better.

        //Add element at last/rear
        deque.addLast(30);
        deque.offerLast(40);

        System.out.println("Deque: "+deque);

        //To see first and last element
        System.out.println("First element: "+deque.peekFirst()); // peekFirst(): If the deque is empty, it returns null without throwing an exception, unlike getFirst()
        System.out.println("Last element: "+deque.peekLast());

        // Remove element from first/front
        System.out.println(deque.removeFirst()); // Gives error if deque is empty
        System.out.println(deque.pollFirst()); // Gives null if deque is empty. So it's better.

        // Remove element from last/rear
        System.out.println(deque.removeLast());
        System.out.println(deque.pollLast());

        // isEmpty
        System.out.println(deque.isEmpty());
    }
}
