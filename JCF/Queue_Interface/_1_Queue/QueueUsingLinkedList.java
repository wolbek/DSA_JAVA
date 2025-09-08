package JCF.Queue_Interface._1_Queue;

public class QueueUsingLinkedList {
    static class Node { // You could have written this inside Queue Class as well
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class Queue {
        Node head = null;
        Node tail = null;

        public boolean isEmpty() {
            return head == null;
        }

        public void add(int data) {
            Node newNode = new Node(data);
            if(isEmpty()) {
                head = tail = newNode;
            } else{
                tail.next = newNode;
                tail = newNode;
            }
        }

        public int remove() {
            if(isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            } else{
                int deletedElem = head.data;

                if(head==tail) {
                    head = tail = null;
                } else{
                    head = head.next;
                }

                return deletedElem;
            }
        }

        public int peek() {
            if(isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            } else{
                return head.data;
            }
        }

    }
    public static void main(String[] args) {
        Queue q = new Queue();
        q.add(1);
        q.add(2);
        q.add(3);

        while(!q.isEmpty()) {
            System.out.print(q.remove() + " ");
        }

    }
}
