package JCF.Queue_Interface._1_Queue;

public class CircularQueueUsingArray {
    static class Queue {
        static int[] arr;
        static int size;
        static int rear;
        static int front;

        Queue(int n) {
            arr = new int[n];
            size = n;
            rear = -1;
            front = -1;
        }

        // isEmpty - O(1)
        public boolean isEmpty() {
            return rear == -1 && front == -1;
        }

        // isFull - O(1)
        public static boolean isFull() {
            return (rear+1) % size == front;
        }

        //add - O(1)
        public void add(int data) {
            if(isFull()) {
                System.out.println("Queue is full");
            } else{
                if(front == -1) {
                    front = 0;
                }
                rear = (rear + 1) % size;
                arr[rear] = data;
            }
        }

        // remove - O(1)
        public int remove() {
            if(isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            } else{
                int deletedElem = arr[front]; // front element

                if(front == rear) {
                    front = rear = -1;
                } else{
                    front = (front + 1) % size;
                }

                return deletedElem;
            }
        }

        // peek - O(1)
        public int peek() {
            if(isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            } else{
                return arr[front]; // front element
            }
        }
    }
    
    public static void main(String[] args) {
        Queue q = new Queue(3);
        q.add(1); // {1,0,0}
        q.add(2); // {1,2,0}
        q.add(3); // {1,2,3}
        System.out.println(q.remove()); // {-,2,3} :Front at 2, Rear at 3
        q.add(4); // {4,2,3} : Front at 2, Rear at 4
        System.out.println(q.remove()); // {4,-,3} : Front at 3, Rear at 4
        q.add(5); // {4,5,3} : Front at 3, Rear at 5

        // Print circular queue

        while(!q.isEmpty()) {
            System.out.print(q.peek() + " ");
            q.remove();
        }

        /*
        The other way to print is this (above way is better):

        int i=q.front;
        while(i!=q.rear) {
            System.out.print(q.arr[i] + " ");
            i = (i+1)%q.size;
        }
        System.out.print(q.arr[i]); // Printing rear element
        */

    }
}
