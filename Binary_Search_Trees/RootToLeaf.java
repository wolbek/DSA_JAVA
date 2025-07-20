package Binary_Search_Trees;

import java.util.ArrayList;

import Binary_Search_Trees.BinarySearchTrees.Node;

public class RootToLeaf {
    public static void rootToLeaf(Node root, ArrayList<Integer> traversedNodes) {
        if(root == null){
            return;
        }
        
        traversedNodes.add(root.data);

        if(root.left == null && root.right == null){
            for(int i =0 ;i<traversedNodes.size();i++){
                System.out.print(traversedNodes.get(i));
            }
            System.out.println();
        }
        
        rootToLeaf(root.left, traversedNodes);
        rootToLeaf(root.right, traversedNodes);
        traversedNodes.remove(traversedNodes.size()-1);
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

        ArrayList<Integer> traversedNodes = new ArrayList<>();
        rootToLeaf(root, traversedNodes);
    }
}
