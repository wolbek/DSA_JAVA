package Binary_Trees;

import java.util.*;

public class BinaryTrees {
    
    static class Node {
        // We're not keeping any of the members of this class as static, because every Node object will have its own data, left and right references.
        int data;
        Node left; // As left node should of root should refer to another data, meaning it should be a reference, meaning it should be an object, so it'll be an object of node. We're not instantiating here with new Node(), just declaring
        Node right;

        Node(int data){ // So that when data comes, we give a default value to its left and right referencing values. left and right are the references to that value.
            // Meaning: Any Node object should have all these properties with the following values.
            this.data = data;
            this.left = null; // We're not doing here new Node(), we're assigning it null directly.
            this.right = null;
        }
    }
    
    static class BinaryTree{
        static int idx = -1;
        public static Node buildTreeFromPreorderNodes(int[] nodes) {
            idx++;
            if(nodes[idx] == -1){// No need to check for idx > preorderSequence, because the array has all the elements, and at last it will have -1, and we're returning null at -1, so it'll never go beyond n elements.
                return null;
            }
            Node root = new Node(nodes[idx]);
            root.left = buildTreeFromPreorderNodes(nodes);
            root.right = buildTreeFromPreorderNodes(nodes);

            return root;
        }

        public static void preorder(Node root){
            if(root == null){
                return;
            }
            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }

        public static void inorder(Node root){
            if(root == null) {
                return;
            }
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }

        public static void postorder(Node root){
            if(root == null){
                return;
            }
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data + " ");
        }

        public static void levelOrder(Node root){
            if(root == null){ // Nothing to print if root is null
                return;
            }

            Queue<Node> q = new LinkedList<>(); // Here, as we will be storing null as Node object in queue, we have to use LinkedList, as ArrayDeque does not allow insertion of null. 
            Node poppedElement;
            q.add(root);
            q.add(null);
            while(!q.isEmpty()){
                poppedElement = q.remove();
                if(poppedElement==null){
                    System.out.println();
                    if(!q.isEmpty()) { // You know this would be hit many times and the next condition would hit single time, so keeping this at top in "if". Or else both conditions would be hit every time.
                        q.add(null);
                    }else{
                        break;
                    }
                } 
                else{
                    System.out.print(poppedElement.data + " ");
                    if(poppedElement.left!= null){
                        q.add(poppedElement.left);
                    }
                    if(poppedElement.right!=null){
                        q.add(poppedElement.right);
                    }
                } 
            }
        }
    }

    public static void main(String[] args) {
        /* 
         *           1
         *          / \
         *         2   3
         *        / \ / \
         *       4  5 6  7
        */
        int[] nodes = {1,2,4,-1,-1,5,-1,-1,3,6,-1,-1,7,-1,-1}; // nodes in preorder sequence.
        Node root = BinaryTree.buildTreeFromPreorderNodes(nodes); // buildTree is a static function, so you do not need to create object of the class to call it, you can call it using class.
        System.out.println(root.data); // root is a Node object, that is, a pointer to a value, not the value, so we need to print the value.
        BinaryTree.preorder(root);
        System.out.println();
        BinaryTree.inorder(root);
        System.out.println();
        BinaryTree.postorder(root);
        System.out.println();
        BinaryTree.levelOrder(root);
    }
}