package JCF.List_Interface._3_Stack;

import java.util.Stack;

public class DuplicateParenthesis {

    public static boolean hasDuplicateParenthesis(String str, Stack<Character> s) {
        for(int i=0; i<str.length(); i++) {
            char ch = str.charAt(i);

            if(ch == ')') {
                if(s.peek() == '(') {
                    return true;
                } else{
                    while(s.peek() != '(') {
                        s.pop();
                    }
                    s.pop();
                }
            } else{
                s.push(ch);
            }
        }

        return false;
    }
    public static void main(String[] args) {
        String str = "(((a+b))+c)"; // true
        // String str = "((a+b)+(c+d))"; // false

        Stack<Character> s = new Stack<>();

        System.out.println(hasDuplicateParenthesis(str, s));
    } 
}
