package Binary_Trees;
import Binary_Trees.BinaryTrees.Node;

public class TreeHeight {

    public static int treeHeight(Node root){
        if(root==null){
            return 0;
        }
        int leftSubtreeHeight = treeHeight(root.left);
        int rightSubtreeHeight = treeHeight(root.right);

        return Math.max(leftSubtreeHeight, rightSubtreeHeight) + 1;
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

        System.out.println(treeHeight(root));
    }
}
