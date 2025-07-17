package Binary_Trees;

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
    }

    public static void main(String[] args) {
        int[] nodes = {1,2,4,-1,-1,5,-1,-1,3,6,-1,-1,7,-1,-1}; // nodes in preorder sequence.
        Node root = BinaryTree.buildTreeFromPreorderNodes(nodes); // buildTree is a static function, so you do not need to create object of the class to call it, you can call it using class.
        System.out.println(root.data); // root is a Node object, that is, a pointer to a value, not the value, so we need to print the value.
        BinaryTree.preorder(root);
    }
}