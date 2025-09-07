package JCF.List_Interface._3_Stack;

import java.util.ArrayList;

public class StackCodeArrayList {
    static class Stack {
        static ArrayList<Integer> arr = new ArrayList<>();

        // isEmpty
        public boolean isEmpty() {
            return arr.size() == 0;
        }

        // push
        public void push(int data) { // O(1)
            arr.add(data);
        }

        // pop
        public int pop() { // O(1)
            if(arr.isEmpty()) {
                return -1;
            }
            return arr.remove(arr.size()-1);
        }
        
        // peek
        public int peek() {
            if(arr.isEmpty()) {
                return -1;
            }
            return arr.get(arr.size()-1);
        }
    }

    public static void main(String[] args) {
        Stack stack = new Stack();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        while(!stack.isEmpty()) {
            System.out.println(stack.peek());
            stack.pop();
        }
    }
}
