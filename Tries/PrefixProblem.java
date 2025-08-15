package Tries;

public class PrefixProblem {
    static class Node{
        Node[] children = new Node[26];
        boolean eow = false;
        int frequency = 0;
        
        Node(){
            for(int i=0;i<26;i++){
                children[i] = null;
            }
        }
    }

    public static void insert(Node root, String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
            curr.frequency++;
        }
        curr.eow = true;
    }

    public static String getPrefix(Node root, String word) {
        Node curr = root;
        String s = "";


        for(int i=0;i<word.length();i++){
            int idx = word.charAt(i) - 'a';
            
            if(curr.frequency==1 && curr!=root){
                break;
            }
            s+=word.charAt(i); // Adding child node
            curr = curr.children[idx];
        }

        return s;
    }
    public static void main(String[] args){
        String[] words = {"zebra", "dog", "duck", "dove"};

        Node root = new Node();

        for(int i=0;i<words.length;i++){
            insert(root, words[i]);
        }
        
        String[] wordsPrefix = new String[words.length];
        
        for(int i=0;i<words.length;i++){
            wordsPrefix[i] = getPrefix(root, words[i]);
        }

        for(int i=0;i<words.length;i++){
            System.out.print(wordsPrefix[i]+" ");
        }
    }

    /*
    
    Your  first implementation - calculating maxBranch for each Node and using it

    static class Node{
        Node[] children = new Node[26];
        boolean eow = false;
        int maxBranch = 0;
        
        Node(){
            for(int i=0;i<26;i++){
                children[i] = null;
            }
        }
    }

    public static int insert(Node curr, String word){
        if(word.length()==0){
            return 1;
        }

        int nodeIdx = word.charAt(0) - 'a';
        if(curr.children[nodeIdx] == null){
            curr.children[nodeIdx] = new Node();
        }

        curr.maxBranch = curr.maxBranch + insert(curr.children[nodeIdx], word.substring(1));
        return curr.maxBranch;
    }

    public static String getPrefix(Node root, String word) {
        Node curr = root;
        String s = "";


        for(int i=0;i<word.length();i++){
            int childNodeIdx = word.charAt(i) - 'a';
            
            if(curr.maxBranch==1 && curr!=root){
                break;
            }
            s+=word.charAt(i); // Adding child node
            curr = curr.children[childNodeIdx];
        }

        return s;
    }

    */
}
