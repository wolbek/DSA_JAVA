package JCF.Queue_Interface._1_Queue;

public class QueueUsingArray {
    static class Queue {
        static int[] arr;
        static int size;
        static int rear;

        Queue(int n) {
            arr = new int[n];
            size = n;
            rear = -1;
        }

        // isEmpty - O(1)
        public boolean isEmpty() {
            return rear == -1;
        }

        //add - O(1)
        public void add(int data) {
            if(rear == size-1) {
                System.out.println("Queue is full");
            } else{
                rear = rear + 1;
                arr[rear] = data;
            }
        }

        // remove - O(n)
        public int remove() {
            if(isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            } else{
                int deletedElem = arr[0]; // front element
                for(int i=0; i<rear; i++) {
                    arr[i] = arr[i+1];
                }
                rear--;
                return deletedElem;
            }
        }

        // peek - O(1)
        public int peek() {
            if(isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            } else{
                return arr[0]; // front element
            }
        }
    }
    
    public static void main(String[] args) {
        Queue q = new Queue(5);
        q.add(1);
        q.add(2);
        q.add(3);

        // Print queue
        while(!q.isEmpty()) {
            System.out.print(q.peek() + " ");
            q.remove();
        }

    }
}
