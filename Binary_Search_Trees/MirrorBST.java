package Binary_Search_Trees;

import Binary_Search_Trees.BinarySearchTrees.Node;

public class MirrorBST {
    public static Node mirrorBST(Node root){
        if(root==null){
            return null;
        }
        Node leftSubtree = mirrorBST(root.left);
        Node rightSubtree = mirrorBST(root.right);

        root.left = rightSubtree;
        root.right = leftSubtree;
        return root;
    }
    public static void main(String[] args) {
        /*
         *              4
         *            /   \
         *           2     5
         *         /  \     \
         *        1    3     6
         */
        Node root = new Node(4);
        root.left = new Node(2);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        root.right = new Node(5);
        root.right.right = new Node(6);
        BinarySearchTrees.inorderTraversal(root);
        System.out.println();

        mirrorBST(root);

        BinarySearchTrees.inorderTraversal(root);
        System.out.println();
    }
}
