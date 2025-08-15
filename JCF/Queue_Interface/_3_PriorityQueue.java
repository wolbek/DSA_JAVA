package JCF.Queue_Interface;

import java.util.PriorityQueue;

public class _3_PriorityQueue {
    public static void main(String[] args){
        /*
                                                =============================================
                                                |             3) Priority Queue             |
                                                =============================================  

        Definition - Adds priority to the element. Uses Minheap(Minimum number comes at beginning rest can be in any order) or Maxheap(Maximum number comes at beginning rest can be in any order).
        
        Queue follow FIFO order - Entry at rear. Removal from front.
        Priority Queue follow priority order - Entry at proper priority place. Removal from front.

        The methods of PQ are same as queue. Just their internal implementation is different now.

         */

        //Creation
        PriorityQueue<Integer> pq=new PriorityQueue<>();//Uses Min Heap by default. So lower integer means high priority.
        // You can store anything in Priroity queue. In fact any class’s object.

        
        //Creation - user comparator for max heap. You can also make your own anonymous comparator
        //Queue<Integer> pq=new PriorityQueue<>(Comparator.reverseOrder()) 
        
        //To add element - O(log n) - Because min heap is implemented, minimum number comes at beginning (rest can be in any order)
        // n is the no. of elements which exists in PQ at that point in time.
        // the distinction between add() and offer() becomes relevant when dealing with capacity-constrained Queue implementations. 
        pq.add(20); // This method, derived from the Collection interface, throws an IllegalStateException if the element cannot be added due to capacity restrictions.
        pq.add(30);
        pq.offer(10); // This method, specific to the Queue interface, returns false if the element cannot be inserted due to capacity restrictions, instead of throwing an exception.
        //[10,20,30]

        //To remove top priority element - O(log n)
        pq.remove(); // throws NoSuchElementException if queue is empty
        pq.poll(); // returns null if queue is empty


        //To see top priority element - O(1)
        pq.peek();

        //To check if PQ is empty
        System.out.println(pq.isEmpty());
    }
}
