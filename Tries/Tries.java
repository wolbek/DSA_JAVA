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

    public static void insert(Node root, String word) { // O(L)
        Node curr = root;
        for(int i=0; i<word.length(); i++){
            int idx = word.charAt(i) - 'a';
            if(curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }

        curr.eow = true;
    }

    public static boolean search(Node root, String key){ // O(L)
        Node curr = root;
        for(int i=0; i<key.length(); i++){
            int idx = key.charAt(i) - 'a';
            if(curr.children[idx] == null){
                return false;
            }
            curr = curr.children[idx];
        }
       
        return curr.eow;
    }

    public static void main(String[] args){
        String[] words = {"the", "a", "there", "their", "any", "thee"};

        Node root = new Node();

        // Insert
        for(int i =0;i<words.length;i++){
            insert(root, words[i]);
        }

        // Search
        System.out.println(search(root, "thee"));
        System.out.println(search(root, "thor"));
        System.out.println(search(root, "any"));
        System.out.println(search(root, "an"));
    }
}

