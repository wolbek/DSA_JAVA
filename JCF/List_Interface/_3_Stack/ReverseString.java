package JCF.List_Interface._3_Stack;

import java.util.Stack;

public class ReverseString {
    public static void main(String[] args) {
        String str = "aakash";

        Stack<Character> s = new Stack<>();

        for(int i=0; i<str.length(); i++) {
            s.push(str.charAt(i));
        }

        StringBuilder result = new StringBuilder("");
        while(!s.isEmpty()) {
            char curr = s.pop();
            result.append(curr);
        }

        str = result.toString();

        System.out.println(str);
    }
}
