package JCF.List_Interface._3_Stack;

import java.util.Stack;

public class _3_Stack {
    public static void main(String[] args) {
        /*
                                                =======================================
                                                |             3) Stack                |
                                                =======================================  

        Operations: Push, Pop, Peek, (isEmpty)

        Programs to solve:
        1) Stack using LL
        2) Stack using ArrayList
        3) Reverse a string using stack. (Hint: You need to make and use pushAtBottom function)
        4) Stock Span problem 
        5) Next Greater Element (Hint: Use logic of Prefix and Postfix)
        6) Valid Parenthesis Problem 
        7) Duplicate parenthesis (Asked in Google and Microsoft, Medium level question, looks easy for me though)
        8) Max Area in Histogram (Asked in Microsoft, Paytm, facebook, Considered in hard level) (Hint: Make next smaller left array, and next smaller right array) (Linear time complexity)

        */

        //Creation
        Stack<Integer> s=new Stack<>();//stack functions are different, push() is not defined for List<Integer> but it's defined for Stack<Integer>
        
        //Add at top
        s.push(10);
        s.push(20);
        s.push(30);
        s.push(40);
        s.push(50);

        System.out.println("Stack: "+s);

        //Check if stack is empty
        System.out.println("Is Empty?: "+s.isEmpty());

        //See value at top
        System.out.println("Top element: "+s.peek());

        //To pop value at top and return that value
        System.out.println("Popped top Element"+s.pop());

        //Print stack
        System.out.println("Printing stack in 2 ways: 1) Direct 2) For each");
        
        //1st way
        System.out.println(s);

        //2nd way
        //To traverse stack (can do using for loop and get() function here, but you cannot do it in queue because there's no get() function for Queue, so we'll use for each )
        for(Integer element: s)
        System.out.print(element+" ");

        //Get element at index
        System.out.println("Element at index 2"+s.get(2));

        //One of the ways to clear stack
        s = new Stack<>();
        System.out.println("Cleared the stack: "+s);
        
    }
}
