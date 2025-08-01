package Binary_Trees;
import Binary_Trees.BinaryTrees.Node;

public class SumNodes {

    public static int sumNodes(Node root) {
        if(root == null) {
            return 0;
        }

        int leftSubtreeSum = sumNodes(root.left);
        int rightSubtreeSum = sumNodes(root.right);

        return leftSubtreeSum + rightSubtreeSum + root.data;
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

        System.out.println(sumNodes(root));
    }
}
