package Binary_Search_Trees;

public class BinarySearchTrees {
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static Node insert(Node root, int val){
        if(root == null){
            return new Node(val);
        }

        if(val < root.data){
            root.left = insert(root.left, val);
        }
        else if(val> root.data){
            root.right = insert(root.right, val);
        }

        return root;
    }

    public static void inorderTraversal(Node root){
        if(root == null){
            return;
        }
        inorderTraversal(root.left);
        System.out.print(root.data+ " ");
        inorderTraversal(root.right);
    }

    public static void main(String[] args) {
        int[] values = {5,1,3,4,2,7};

        Node root = null;

        for(int i=0;i<values.length;i++){
           root = insert(root, values[i]);
        }

        inorderTraversal(root);
    }

    // Your first try:

    // public static void main(String[] args) {
    //     int[] values = {5,1,3,4,2,7};
    //     Node root = new Node(values[0]);
    //     for(int i = 1;i<values.length;i++){
    //         Node newNode = new Node(values[i]);
    //         buildBST(newNode, root);
    //     }

    //     inorderTraversal(root);
    // }

    // public static void buildBST(Node newNode, Node root) {
        
    //     if(newNode.data < root.data){
    //         if(root.left == null){
    //             root.left = newNode;
    //         } else{
    //             buildBST(newNode, root.left);
    //         }
    //     }

    //     else if(newNode.data > root.data){
    //         if(root.right == null){
    //             root.right = newNode;
    //         } else{
    //             buildBST(newNode, root.right);
    //         }
    //     }
    // }
}
