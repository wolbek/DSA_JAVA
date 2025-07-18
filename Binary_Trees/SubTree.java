package Binary_Trees;
import Binary_Trees.BinaryTrees.Node;

public class SubTree {
    static boolean hasSubTree = false;

    public static boolean hasSubtree(Node root, Node subTreeRoot) {
        if(root == null) {
            return false;
        }
        if(root.data == subTreeRoot.data) {
            if(isIdentical(root, subTreeRoot)){
                return true;
            }
        }

        return hasSubtree(root.left, subTreeRoot) || hasSubtree(root.right, subTreeRoot);
    }

    public static boolean isIdentical(Node root, Node subTreeRoot) {
        if(root == null && subTreeRoot == null) {
            return true;
        } 
        else if(root == null || subTreeRoot == null || root.data != subTreeRoot.data) {
            return false;
        }

        return isIdentical(root.left, subTreeRoot.left) && isIdentical(root.right, subTreeRoot.right);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);

        Node subTreeRoot = new Node(2);
        subTreeRoot.left = new Node(4);
        subTreeRoot.right = new Node(5);

        System.out.println(hasSubtree(root, subTreeRoot));
    }
}

