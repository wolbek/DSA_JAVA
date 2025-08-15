package JCF.Queue_Interface;

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
      
        Deque<Integer> deque=new ArrayDeque<>();

        //Add element at first/front
        deque.addFirst(20);
        deque.offerFirst(10);//adds element at front

        //Add element at last/rear
        deque.addLast(30);
        deque.offerLast(40);

        System.out.println("Deque: "+deque);

        //To see first and last element
        System.out.println("First element: "+deque.peekFirst()); // peekFirst(): If the deque is empty, it returns null without throwing an exception, unlike getFirst()
        System.out.println("Last element: "+deque.peekLast());


    }
}
