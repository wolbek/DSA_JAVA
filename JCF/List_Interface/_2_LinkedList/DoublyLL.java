package JCF.List_Interface._2_LinkedList;

public class DoublyLL {
    class Node {
        int data;
        Node next;
        Node prev;

        public Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    public void addFirst(int data) {
        Node newNode = new Node(data);

        if(head == null) {
            head = tail = newNode;
        } else{
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }

        size++;
    }

    public void print() {
        Node temp = head;

        while(temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        
        System.out.println("null");
    }

    public int removeFirst() {
        if(head == null) {
            System.out.println("DLL is empty");
            return Integer.MIN_VALUE;
        }

        if(size == 1) {
            int val = head.data;
            head = tail = null;
            size--;
            return val;
        }

        int val = head.data;
        head = head.next;
        head.prev = null;
        size--;
        return val;
    }

    public void reverse() {
        Node prevElem = null;
        Node currElem = null;
        Node nextElem = head;
        tail = head;

        while(nextElem != null){
            prevElem = currElem;
            currElem = nextElem;
            nextElem = nextElem.next;

            currElem.next = prevElem;
            currElem.prev = nextElem;
        }

        head = currElem;
    }

    public static void main(String[] args) {
        DoublyLL dll = new DoublyLL();

        // Add First
        dll.addFirst(3);
        dll.addFirst(2);
        dll.addFirst(1);

        // Print
        dll.print();
        System.out.println(dll.size);

        // Remove First
        dll.removeFirst();
        dll.print();
        System.out.println(dll.size);

        // Reverse
        System.out.println("Reverse:");
        dll.reverse();
        dll.print();
    }
}
