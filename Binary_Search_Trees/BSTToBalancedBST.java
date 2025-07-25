package Binary_Search_Trees;

import java.util.ArrayList;

import Binary_Search_Trees.BinarySearchTrees.Node;

public class BSTToBalancedBST {
    
    public static void getInorder(Node root, ArrayList<Integer> inorder) {
        if(root == null){
            return;
        }
        getInorder(root.left, inorder);
        inorder.add(root.data);
        getInorder(root.right, inorder);
    }

    public static Node createBalancedBST(ArrayList<Integer> inorder, int start, int end) {
        if(start > end){
            return null;
        }
        int mid = (start+end)/2;
        Node root = new Node(inorder.get(mid));
        root.left = createBalancedBST(inorder, start, mid-1);
        root.right = createBalancedBST(inorder, mid+1, end);
        return root;
    }

    public static Node BSTToBalancedBST(Node root) {
        // Getting inorder array
        ArrayList<Integer> inorder = new ArrayList<>();
        getInorder(root, inorder);

        // Converting sorted array to BST
        Node rootBalancedBST = createBalancedBST(inorder, 0, inorder.size()-1);
        return rootBalancedBST;
    }
    public static void main(String[] args){
        /*
         * Given BST:
         *                  8
         *                 / \
         *                6   10
         *               /     \
         *              5       11
         *             /         \
         *            4           12
         */
        Node root = new Node(8);
        root.left = new Node(6);
        root.left.left = new Node(5);
        root.left.left.left = new Node(3);
        root.right = new Node(10);
        root.right.right = new Node(11);
        root.right.right.right = new Node(12);

        /*
         * Expected Balanced BST:
         *                  8
         *                /   \
         *               5     11
         *              / \    / \
         *             3   6  10  12
         *  
         */
        Node rootBalancedBST = BSTToBalancedBST(root);
        preorder(rootBalancedBST);
    }

    public static void preorder(Node root) {
        if(root == null){
            return;
        }

        System.out.print(root.data+ " ");
        preorder(root.left);
        preorder(root.right);
    }


}
