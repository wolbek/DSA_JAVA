package JCF.List_Interface._2_LinkedList;

public class SinglyLL {
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

    public void print(Node head) {
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

    // Slow-Fast Approach
    public Node findMid(Node head) {
        Node slow = head;
        Node fast = head;

        while(fast!=null && fast.next!=null) {
            slow = slow.next; // +1
            fast = fast.next.next; // +2
        }

        return slow;
    }

    public boolean isPalindrome() {
        if(head == null || head.next==null) {
            return true;
        }

        // Step 1: Find Middle
        Node mid = findMid(head);

        // Step 2: Reverse linked list from mid
        Node prevElem = null;
        Node currElem = null;
        Node nextElem = mid;

        while(nextElem!=null) {
            prevElem = currElem;
            currElem = nextElem;
            nextElem = nextElem.next;
            currElem.next = prevElem;
        }

        // Step 3: Compare
        Node e1 = head;
        Node e2 = tail;

        while(e2!=null) { // As 1st half don't have null now
            if(e1.data!=e2.data) return false;
            e1 = e1.next;
            e2 = e2.next;
        }

        return true;
    }

    public static boolean isCycle(Node head) {
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast) {
                return true;
            }
        }

        return false;
    }

    public static void removeCycle(Node head) {
        // Detect cycle
        Node slow = head;
        Node fast = head;
        boolean cycle = false;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast) {
                cycle = true;
                break;
            }
        }

        if(cycle == false) {
            return;
        }

        // Find meeting point
        slow= head;
        Node prev = null; // will store last node
        while(slow != fast) {
            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }

        // remove cycle -> last.next = null
        prev.next = null;
    }

    public void zigZag(Node head) {
        //find mid
        Node slow = head;
        Node fast = head.next;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node mid = slow;

        // reverse 2nd half
        Node curr = mid.next;
        mid.next = null;
        Node prev = null;
        Node next;

        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Node left = head;
        Node right = prev;
        Node nextL, nextR;

        // zig-zag merge
        while(left != null && right != null) {
            nextL = left.next;
            left.next = right;
            nextR = right.next;
            right.next = nextL;

            left = nextL;
            right = nextR;
        }
    }

    public static void main(String[] args) {
        SinglyLL ll = new SinglyLL();

        // AddFirst
        ll.print(head);
        ll.addFirst(2);
        ll.print(head);
        ll.addFirst(1);
        ll.print(head);

        // AddLast
        ll.addLast(3);
        ll.print(head);
        ll.addLast(4);
        ll.print(head);

        // Add at index
        // For add() we're considering they'll pass proper index within valid range.
        ll.add(2,9);
        ll.print(head);

        // Print size of LL
        System.out.println(ll.size);

        // Remove - RemoveFirst and RemoveLast
        System.out.println(ll.removeFirst());
        ll.print(head);
        System.out.println(ll.removeLast());
        ll.print(head);

        // Search - Iteratively and Recursively
        System.out.println(ll.searchIteratively(9));
        System.out.println(ll.searchRecursively(9));

        // Reverse LL
        ll.reverse();
        ll.print(head);

        // Remove nth node from end
        ll.removeNthNodeFromEnd(3);
        ll.print(head);

        // Check for isPalindrome
        ll.addLast(2);
        ll.addLast(9);
        ll.print(head);
        System.out.println(ll.isPalindrome()); // Now 2nd half is reversed

        // Detect a cycle in LL
        System.out.println("LL has cycle?");

        // Creating a LL (without addFirst or addLast): 1 -> 2 -> 3 -> 2
        Node head1 = new Node(1);
        Node temp = new Node(2);
        head1.next = temp;
        head1.next.next = new Node(3);
        head1.next.next.next = temp;
        System.out.println(isCycle(head1));

        // Remove cycle
        removeCycle(head1);
        System.out.println("LL has cycle?");
        System.out.println(isCycle(head1));
        ll.print(head1);

        // Zigzag
        System.out.println("Zigzag: ");
        Node head2 = new Node(1);
        head2.next = new Node(2);
        head2.next.next = new Node(3);
        head2.next.next.next = new Node(4);
        head2.next.next.next.next = new Node(5);
        ll.zigZag(head2);
        ll.print(head2);
    }
}
