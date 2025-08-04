package Priority_Queue;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueFunc {
    public static void main(String[] args){
        // PriorityQueue<Integer> pq = new PriorityQueue<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        pq.add(2); //O(log n)
        pq.add(3);
        pq.add(1);
        pq.add(5);
        pq.add(4);

        while(!pq.isEmpty()){
            System.out.println(pq.peek()); // O(1)
            pq.remove(); // O(log n)
        }
        // 5 4 3 2 1
    }
}
