package JCF.Queue_Interface;

import java.util.ArrayDeque;
import java.util.Queue;

public class _1_Queue_Using_ArrayDeque {
    public static void main(String[] args){
        /*
        
                                        =====================================================
                                        |             1) Queue using ArrayDeque             |
                                        =====================================================  

        Types: Simple queue, Circular queue, Priority queue, Deque
        Operations: Enqueue, Dequeue, Peek , isEmpty

        Programs to solve:
        1) Queue using Arrays
        2) Circular queue using arrays
        3) Queue using LL
        4) Queue using JCF
        5) Queue using 2 stacks
        6) Stack using 2 queues
        7) First non-repeating letter (good question)
        8) Implement Stack using deque (Stack element is pushed, popped, peeked fromm top, so to implement stack through deque we do addLast(), removeLast(), getLast())
        9) Implement Queue using deque (To implement queue through deque we do addLast(), removeFirst(), getFirst())

        */

        //Creation
        Queue<Integer> q=new ArrayDeque<>(); // You can make queue using LinkedList class too. ArrayDeque use less memory compared to LinkedList. Provides better performance compared to LinkedList in most cases.
        // Queue<Integer> q=new LinkedList<>(); //If implemented using Linkedlist, there's a cache difference
        // ArrayDeque does not allow insertion of null element: https://stackoverflow.com/questions/34851512/why-null-values-are-not-allowed-in-arraydeque
        // But LinkedList allows insertion of null element. In linkedList also, you can use .offer() or .add() to add the element.

        //You can use add() to add element but it returns exception if not added, offer returns false if not added
        q.offer(10);//add 12 at rear
        q.offer(20);
        q.offer(30);
        q.offer(40);
        q.add(50);//O(1)

        //Remove element
        System.out.println("Removing Element at front and return it: "+q.remove());//O(1)
        System.out.println("Removing Element 50: "+q.remove(50));
        System.out.println("Removing element at front and return it: "+q.poll());

        //See front element
        System.out.println("Front element:"+q.peek());//O(1)  

        //Check if queue is empty
        System.out.println(q.isEmpty());

        //Get size of queue
        System.out.println("Size of queue: "+q.size());

        //To print queue
        System.out.println("Printing queue in 2 ways: 1) Direct 2) For each");

        //1st way
        System.out.println(q);

        //2nd way
        for(Integer element: q){
            System.out.print(element+" ");
        }
        System.out.println();
    }
}
