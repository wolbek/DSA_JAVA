package Tries;

public class Tries {

    static class Node{
        Node[] children = new Node[26];
        boolean eow = false;

        Node() {
            for(int i=0; i<26; i++){
                children[i] = null;
            }
        }
    }

    public static Node root = new Node();

    public static void insert(String word) { // O(L)
        Node curr = root;
        for(int level=0;level<word.length();level++){
            int i = word.charAt(level) - 'a';
            if(curr.children[i] == null) {
                curr.children[i] = new Node();
            }
            curr = curr.children[i];
        }

        curr.eow = true;
    }

    public static boolean search(String key){ // O(L)
        Node curr = root;
        for(int level=0;level<key.length();level++){
            int i = key.charAt(level) - 'a';
            if(curr.children[i] == null){
                return false;
            }
            curr = curr.children[i];
        }
       
        return curr.eow;
    }

    public static void main(String[] args){
        String[] words = {"the", "a", "there", "their", "any", "thee"};

        // Insert
        for(int i =0;i<words.length;i++){
            insert(words[i]);
        }

        // Search
        System.out.println(search("thee"));
        System.out.println(search("thor"));
        System.out.println(search("any"));
        System.out.println(search("an"));
    }
}




