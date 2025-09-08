package JCF.List_Interface._3_Stack;

import java.util.Stack;

public class NextGreaterElement {
    
    public static void main(String[] args) {
        int[] arr = {6,8,0,1,3};
        int[] nextGreater = new int[arr.length];

        Stack<Integer> s = new Stack<>();

        nextGreater[0] = -1;
        s.push(0);

        for(int i=1; i<arr.length; i++) {
            nextGreater[i] = -1;
            while(!s.isEmpty() && arr[i] > arr[s.peek()]){
                int nextGreaterElementOf = s.pop();
                int nextGreaterElement = arr[i];
                nextGreater[nextGreaterElementOf] = nextGreaterElement;
            }
            s.push(i);
        }

        for(int i=0; i<nextGreater.length; i++) {
            System.out.print(nextGreater[i] + " ");
        }
    }

    /*
    Shraddha didi's logic: 
    Traverses from last to first

    public static void main(String[] args) {
        int[] arr = {6,8,0,1,3};
        Stack<Integer> s = new Stack<>();
        int[] nextGreater = new int[arr.length];

        for(int i=arr.length-1; i>=0; i--) {
            // 1) while
            while(!s.isEmpty() && arr[s.peek()] <= arr[i]) {
                s.pop();
            }

            // 2) if-else
            if(s.isEmpty()) {
                nextGreater[i] = -1;
            } else{
                nextGreater[i] = arr[s.peek()];
            }

            // 3) push in stack
            s.push(i);
        }

        for(int i=0; i<nextGreater.length; i++) {
            System.out.print(nextGreater[i] + " ");
        }
    }
    */
}
