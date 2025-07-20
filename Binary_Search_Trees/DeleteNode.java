package Binary_Search_Trees;
import Binary_Search_Trees.BinarySearchTrees.Node;

public class DeleteNode {
    public static Node delete(Node curr, int deleteNode){
        if(curr == null){
            return null;
        }

        if(deleteNode == curr.data) {
            // Case 1: No child
            if(curr.left==null && curr.right==null){
                return null;
            }
            // Case 2: Single child
            else if(curr.left==null){
                return curr.right;
            } 
            else if(curr.right==null){
                return curr.left;
            }

            // Case 3: Two child
            else if(curr.left!=null && curr.right!=null){
                Node iS = inorderSuccessor(curr.right);
                curr.data = iS.data;
                curr.right = delete(curr.right, iS.data); 
                // As we've used inorderSuccessor have, now it's his turn to be deleted.
                // Now 3 will become 4. And (Node(4),4) is passed.
                // So null is returned, and that 4 is deleted.
            }
        }

        else if(deleteNode<curr.data){
            curr.left = delete(curr.left, deleteNode);
        }
        else{
            curr.right = delete(curr.right, deleteNode);
        }

        return curr;
    }

    public static Node inorderSuccessor(Node curr) {
        while(curr.left != null){
            curr = curr.left;
        }

        return curr;
    }
    public static void main(String[] args) {
        /*
         *              7
         *            /   \
         *           2     8
         *         /  \     \
         *        1    5     9
         *           /   \    \
         *          3     6    10
         *           \
         *            4
         */
        Node root = new Node(7);
        root.left = new Node(2);
        root.left.left = new Node(1);
        root.left.right = new Node(5);
        root.left.right.left = new Node(3);
        root.left.right.left.right = new Node(4);
        root.left.right.right = new Node(6);
        root.right = new Node(8);
        root.right.right = new Node(9);
        root.right.right.right = new Node(10);

        BinarySearchTrees.inorderTraversal(root);
        System.out.println();

        int deleteNode = 2;
        root = delete(root, deleteNode);

        BinarySearchTrees.inorderTraversal(root); // BinarySearchTrees is a public class, so you can access it in the same package without importing.

    }
}
