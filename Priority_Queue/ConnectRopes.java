package Priority_Queue;

import java.util.PriorityQueue;

public class ConnectRopes {
    public static int minCost(int[] ropes) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<ropes.length;i++){
            pq.add(ropes[i]);
        }

        int minCost = 0;

        while(pq.size()>1){
            int num1 = pq.remove();
            int num2 = pq.remove();

            int sumOfNums = num1+num2;

            pq.add(sumOfNums);
            minCost += sumOfNums;
        }

        return minCost;
    }
    public static void main(String[] args) {
        int[] ropes = {2,3,3,4,6};
        System.out.println(minCost(ropes));
        
    }
}
