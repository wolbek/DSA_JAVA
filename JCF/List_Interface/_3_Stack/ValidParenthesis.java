package JCF.List_Interface._3_Stack;

import java.util.Stack;

public class ValidParenthesis {
    public static boolean checkValidParenthesis(String str, Stack<Character> s) {
        for(int i=0; i<str.length(); i++) {
            char ch = str.charAt(i);

            if(ch == '(' || ch == '{' || ch == '['){ // If opening bracket, then push
                s.push(ch);
            }
            else{ // If closing bracket then pop the top element and check for opening bracket
                if(s.isEmpty()) {
                    return false;
                }

                char topOpeningBracket = s.pop();
                if(
                    ch==')' && topOpeningBracket!= '(' ||
                    ch=='}' && topOpeningBracket!= '{' ||
                    ch==']' && topOpeningBracket!= '['
                ){
                    return false;
                }
            }
        }

        if(s.isEmpty()) {
            return true;
        } else{
            return false;
        }
    }
    public static void main(String[] args) {
        String str = "({[]})";

        Stack<Character> s = new Stack<>();

        System.out.println(checkValidParenthesis(str, s));
    }
}
