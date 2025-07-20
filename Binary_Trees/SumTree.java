package Binary_Trees;

import Binary_Trees.BinaryTrees.Node;
import Binary_Trees.BinaryTrees.BinaryTree;

public class SumTree {
    public static int sumTree(Node root) {
        if(root == null){
            return 0;
        }
        int leftSubtreeSum = sumTree(root.left);
        int rightSubtreeSum = sumTree(root.right);

        int data = root.data;
        root.data = leftSubtreeSum + rightSubtreeSum; // For current Node value change, starting from leaf nodes

        return root.data + data;
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

        sumTree(root); // This will change the values of each node to the sum of its leftSubtree and rightSubtree. Though the value which you'll be returned is leftSubtreeSum + rightSubtreeSum + root value.
        BinaryTree.preorder(root);
    }

    // Your initial code, which would traverse the whole subtree for every node, which is very heavy computing.

    // public static void traverseTree(Node root) {
    //     if(root == null){
    //         return;
    //     }
    //     root.data = sumTree(root);
    //     traverseTree(root.left);
    //     traverseTree(root.left);
    // }

    // public static int sumTree(Node root) {
    //     if(root == null) {
    //         return 0;
    //     }

    //     int leftSubtreeSum = sumTree(root.left);
    //     int rightSubtreeSum = sumTree(root.right);

    //     return leftSubtreeSum + rightSubtreeSum;
    // }
}
