package JCF.Queue_Interface._1_Queue;

import java.util.LinkedList;
import java.util.Queue;

public class InterleaveQueue2Halves {
    public static void interleave(Queue<Integer> q) {
        Queue<Integer> firstHalf = new LinkedList<>();

        // Adding 1st half in q1
        int size = q.size(); // Not using q.size() directly below, because when you're removing from q, the size gets updated.

        for(int i=0; i<size/2; i++) { // Element count would always be even in question. [1,2,3,4] size = 4, So 4/2 = 2
            firstHalf.add(q.remove());
        }

        while(!firstHalf.isEmpty()) {
            q.add(firstHalf.remove());
            q.add(q.remove());
        }
    }
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        q.add(7);
        q.add(8);
        q.add(9);
        q.add(10);

        interleave(q);

        System.out.println(q);
        /*
        Or to print q
        
        while(!q.isEmpty()) {
            System.out.print(q.remove() + " ");
        }
        System.out.println();
         */
    }
}
