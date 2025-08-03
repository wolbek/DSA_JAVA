package Tries;

import java.util.Arrays;

public class LongestPrefix {

    static class Node{
        Node[] children = new Node[26];
        boolean eow = false;
        
        Node(){
            for(int i=0;i<26;i++){
                children[i] = null;
            }
        }
    }

    public static StringBuilder insertAndFindLongestPrefix(Node root, String word) {
        StringBuilder longestPrefix = new StringBuilder("");
        boolean eowStreak = true;

        Node curr = root;
        int i=0;
        for (i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }

            curr = curr.children[idx];
            // i is also at curr letter. Now from here we're doing curr letter related things. 
            if(curr.eow==false && i != word.length() - 1){ // eowStreak only turn false when i is before the last character and eow is false. When i is at the last character and eow is false, we still take the last letter, so keeping eowStreak to true.
                eowStreak = false; 
                return longestPrefix; // You can skip this, if you want the trie to be made fully
            }

            if(eowStreak == true){
                longestPrefix.append(word.charAt(i)); // Storing the curr character. When we come to a node which doesn't exist, let's say 'e', and before that every letter existed in the node chain, it stores 'e' as well in longestSubstring.
            }
        }
        curr.eow = true;

        return longestPrefix;
    }

    public static void main(String[] args){
        String[] words = {"a", "banana", "app", "appl", "ap", "apply", "apple"};
        // String[] words = {"ab", "ac", "ad"};

        // Sort
        Arrays.sort(words);
        // for(int i=0;i<words.length;i++){
        //     System.out.println(words[i]);
        // }

        Node root = new Node();
        StringBuilder longestPrefix = new StringBuilder("");
        StringBuilder newPrefix = new StringBuilder("");

        for(int i=0;i<words.length;i++){
            newPrefix = insertAndFindLongestPrefix(root, words[i]);
            if(longestPrefix.length() <= newPrefix.length()){
                longestPrefix = newPrefix;
            }
        }

        System.out.println(longestPrefix);

    }
}

