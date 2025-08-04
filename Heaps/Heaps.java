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

        private void heapify(int i) {
            int left = 2*i+1;
            int right = 2*i+2;
            int minIdx = i;

            if(left < arr.size() && arr.get(left) < arr.get(minIdx)){
                minIdx = left;
            }

            if(right < arr.size() && arr.get(right) < arr.get(minIdx)) {
                minIdx = right;
            }

            if(minIdx != i) {
                // swap
                int temp = arr.get(i);
                arr.set(i, arr.get(minIdx));
                arr.set(minIdx, temp);

                // Now it can happen that the below heap is unfixed now
                // So we need to continue swapping top to bottom, to get the biggest element at bottom.

                heapify(minIdx);
            }
        } 

        public int remove(){
            int data = arr.get(0);

            // Step 1 - swap first & last
            int temp = arr.get(0);
            arr.set(0, arr.get(arr.size()-1));
            arr.set(arr.size()-1, temp);

            // Step 2 - delete last
            arr.remove(arr.size()-1);

            // Step 3 - heapify
            heapify(0);
            return data;
        }

        public boolean isEmpty() {
            return arr.size() == 0;
        }
    }

    public static void main(String[] args){
        Heap h = new Heap();
        h.add(3);
        h.add(4);
        h.add(1);
        h.add(5);

        while(!h.isEmpty()) {
            System.out.println(h.peek());
            h.remove();
        }
    }
}
