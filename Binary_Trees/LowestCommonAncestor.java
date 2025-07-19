package Binary_Trees;

import Binary_Trees.BinaryTrees.Node;

public class LowestCommonAncestor{
    public static Node LCA(Node root, int n1, int n2){
        if(root == null || root.data == n1 || root.data == n2){
            return root;
        }

        Node leftLCA = LCA(root.left, n1, n2); // leftLCA: Meaning any node which is containing n1 or n2 in leftSubtree.
        Node rightLCA = LCA(root.right, n1, n2); // rightLCA: Meaning any node which is containing n1 or n2 in rightSubtree

        // The final answer comes from below two conditions if one node is ancestor of another.
        if(rightLCA == null) return leftLCA; // If there is no node containing n1 or n2 in right subtree, pass leftSubtree. 
        if(leftLCA == null) return rightLCA; // If there is no node containing n1 or n2 in left subtree, pass rightSubtree

        return root; //If it reaches here, means both leftLCA and rightLCA are true, that is, the node has both n1 and n2.
    }
    public static void main(String[] args){
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

        int n1 = 4;
        int n2 = 7;

        Node ancestor = LCA(root, n1, n2);
        System.out.println(ancestor.data);
    }

// Your first attempt on this challenge. Works but only beats 5% of the world:

//     static Node ancestor = null;
//     static class Info{
//         boolean n1Found;
//         boolean n2Found;
//         Info(boolean n1Found, boolean n2Found){
//             this.n1Found = n1Found;
//             this.n2Found = n2Found;
//         }
//     }
//     public static Info LCA(Node root, int n1, int n2) {
//         if(root == null){
//             return new Info(false, false);
//         }

//         Info nodeInfo = new Info(false, false);

//         if(root.data == n1) {
//             nodeInfo = new Info(true, false);
//         }

//         if(root.data == n2) {
//             nodeInfo = new Info(false, true);
//         }

//         Info leftSubtreeInfo = LCA(root.left, n1, n2);
//         Info rightSubtreeInfo = LCA(root.right, n1, n2);

//         boolean n1Found = nodeInfo.n1Found || leftSubtreeInfo.n1Found || rightSubtreeInfo.n1Found;
//         boolean n2Found = nodeInfo.n2Found || leftSubtreeInfo.n2Found || rightSubtreeInfo.n2Found;

//         if(ancestor==null && n1Found && n2Found ) {
//             ancestor = root;
//         }
//         return new Info(n1Found, n2Found);       
//     }
}
