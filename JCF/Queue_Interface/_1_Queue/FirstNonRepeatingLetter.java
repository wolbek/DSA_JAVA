package JCF.Queue_Interface._1_Queue;

import java.util.ArrayDeque;
import java.util.Queue;

public class FirstNonRepeatingLetter {
    public static void printNonRepeating(String str) {
        int[] freq = new int[26];
        Queue<Character> q = new ArrayDeque<>();

        for(int i=0; i<str.length(); i++) {
            char ch = str.charAt(i);
            q.add(ch);
            freq[ch-'a'] += 1;

            while(!q.isEmpty() && freq[q.peek()-'a'] > 1){
                q.remove();
            }
            if(q.isEmpty()) {
                System.out.print(-1 + " ");
            } else {
                System.out.print(q.peek() + " ");
            }
        }
    }
    public static void main(String[] args) {
        String str = "aabccxb";
        printNonRepeating(str);
    }
}
