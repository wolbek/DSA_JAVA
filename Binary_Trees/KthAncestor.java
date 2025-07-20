package Binary_Trees;

import Binary_Trees.BinaryTrees.Node;

public class KthAncestor {
    static class Info{
        Node ancestor;
        int ancestorAtHeight;
        Info(Node ancestor, int ancestorAtHeight) {
            this.ancestor = ancestor;
            this.ancestorAtHeight = ancestorAtHeight;
        }
    }
    public static Info kthAncestor(Node root, int n, int k, int currHeight) {
        if(root == null){
            return new Info(null, -1);
        }
        
        if(root.data == n) {
            if(k==0){
                return new Info(root, currHeight);
            } else{
                return new Info(null, currHeight-k);
            }
        }

        Info ancestorInfo = kthAncestor(root.left, n, k, currHeight + 1);
        if(ancestorInfo.ancestorAtHeight == -1) { // Meaning you haven't met the node n
            ancestorInfo = kthAncestor(root.right, n, k, currHeight + 1);
        }

        if(ancestorInfo.ancestorAtHeight == currHeight) {
            return new Info(root, currHeight);
        }

        return ancestorInfo;
    }
    public static void main(String[] args) {
        /* 
         *           1
         *          / \
         *         2   3
         *        / \ / \
         *       4  5 6  7
        */
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        int n = 5;
        int k = 2;
        int currHeight = 1;

        Info ancestorInfo = kthAncestor(root, n, k, currHeight); // kthAncestor is returning new Info(), so you're basically initializing the object here.
        System.out.println(ancestorInfo.ancestor.data);
    }
}
