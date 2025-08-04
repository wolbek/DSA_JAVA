package Heaps;

import java.util.ArrayList;

public class Heaps {
    static class Heap{
        // Implementing min heap
        ArrayList<Integer> arr = new ArrayList<>();

        public void add(int data){
            arr.add(data);

            int cIdx = arr.size()-1; // child index
            int pIdx = (cIdx - 1)/2; // parent index

            while(arr.get(cIdx) < arr.get(pIdx)){ // O(log n)
                // swap
                int temp = arr.get(cIdx);
                arr.set(cIdx, arr.get(pIdx));
                arr.set(pIdx, temp);

                cIdx = pIdx;
                pIdx = (cIdx-1)/2;
            }

        }

        public int peek(){
            return arr.get(0);
        }

    }

    public static void main(String[] args){
        Heap h = new Heap();
        h.add(3);
        h.add(4);
        h.add(1);
        h.add(5);

        System.out.println(h.peek());
    }
}
