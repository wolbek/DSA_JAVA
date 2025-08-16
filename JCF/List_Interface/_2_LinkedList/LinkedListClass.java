package JCF.List_Interface._2_LinkedList;

public class LinkedListClass {
    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    public void addFirst(int data) {
        Node newNode = new Node(data);

        if(head == null){
            head = tail = newNode;
        } else{
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    public void addLast(int data) {
        Node newNode = new Node(data);

        if(head == null){
            head = tail = newNode;
        } else{
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public void add(int idx, int data) {
        if(idx == 0){
            addFirst(data); 
            // Not doing size++ because we already have size++ in addFirst()
        } else{
            Node newNode = new Node(data);
            Node temp = head;
            int i = 0;

            while(i!=idx-1){
                temp = temp.next;
                i++;
            }

            newNode.next = temp.next;
            temp.next = newNode;
            size++;
        }
    }

    public void print() {
        if(head == null) {
            System.out.println("LL is empty");
            return;
        }

        Node temp = head;

        while(temp!=null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public int removeFirst() {
        if(head == null){
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        } else if(size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        } else{
            int val = head.data;
            head = head.next;
            size--;
            return val;
        }
    }

    public int removeLast() {
        if(head == null){
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        } else if(size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        } else{
            Node temp = head;

            while(temp.next.next!=null){
                temp = temp.next;
            }
            int val = temp.next.data;
            temp.next = null;
            tail = temp;
            size--;
            return val;
        }
    }

    public int searchIteratively(int key) {
        Node temp = head;
        int i = 0;

        while(temp!=null) {
            if(temp.data == key) { // key found
                return i;
            }
            temp=temp.next;
            i++;
        }

        // key not found
        return -1;
    }

    public int helper(Node head, int key) {
        if(head == null){
            return -1;
        }

        if(head.data == key) {
            return 0;
        }

        int idx = helper(head.next, key);

        if(idx == -1){
            return -1;
        }

        return idx+1;
    }

    public int searchRecursively(int key) {
        return helper(head, key);
    }

    public void reverse() {
        Node prevElem = null;
        Node currElem = null;
        Node nextElem = head;
        tail = head;
        
        while(nextElem!=null) {
            prevElem = currElem;
            currElem = nextElem;
            nextElem = nextElem.next;
            currElem.next = prevElem;
        }
        head = currElem;

        /*
        Shradhha's didi code
        
        Node prev = null;
        Node curr = tail = head;
        Node next;

        while(curr!=null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
         
         */
    }

    public void removeNthNodeFromEnd(int index) { // We're considering they would be passing valid range (from 1 to n)
        int idxToRemove = size - index;

        if(idxToRemove == 0){
            removeFirst();
        } else{

            Node temp = head;
            int i = 1; 
            // i is the index of next element
            // So that if i == idxToRemove, then temp would be the previous element in below while loop

            while(i < idxToRemove) { 
                temp = temp.next;
                i++;
            }

            temp.next = temp.next.next;
        }
    }

    public static void main(String[] args) {
        LinkedListClass ll = new LinkedListClass();
        ll.print();
        ll.addFirst(2);
        ll.print();
        ll.addFirst(1);
        ll.print();
        ll.addLast(3);
        ll.print();
        ll.addLast(4);
        ll.print();
        // For add we're considering they'll pass proper index within valid range.
        ll.add(2,9);
        ll.print();

        System.out.println(ll.size);

        System.out.println(ll.removeFirst());
        ll.print();
        System.out.println(ll.removeLast());
        ll.print();

        System.out.println(ll.searchIteratively(9));
        System.out.println(ll.searchRecursively(9));

        ll.reverse();
        ll.print();

        ll.removeNthNodeFromEnd(3);
        ll.print();

    }
}
