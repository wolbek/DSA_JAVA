package Binary_Search_Trees;

import Binary_Search_Trees.BinarySearchTrees.Node;

public class LargestBST {

    static class Info {
        Node min;
        Node max;
        int maxSizeOfValidBST;
        boolean isValidBST;
        Info(Node min, Node max, int maxSizeOfValidBST, boolean isValidBST){
            this.min = min;
            this.max = max;
            this.maxSizeOfValidBST = maxSizeOfValidBST;
            this.isValidBST = isValidBST;
        }
    }

    public static Info validBST(Node root) {
        if (root == null) {
            return new Info(null, null, 0, true);
        }

        Info left = validBST(root.left);
        Info right = validBST(root.right);

        boolean leftValid = left.isValidBST;
        boolean rightValid = right.isValidBST;

        boolean rootValid =
            (left.max == null || root.data > left.max.data) &&
            (right.min == null || root.data < right.min.data);

        if (leftValid && rightValid && rootValid) {
            Node minNode = (left.min != null) ? left.min : root;
            Node maxNode = (right.max != null) ? right.max : root;
            int size = left.maxSizeOfValidBST + right.maxSizeOfValidBST + 1;
            return new Info(minNode, maxNode, size, true);
        }

        int largest = Math.max(left.maxSizeOfValidBST, right.maxSizeOfValidBST);
        return new Info(null, null, largest, false);
    }
    public static void main(String[] args){
        /*
         *              50
         *            /    \
         *          30      60
         *         /  \    /  \
         *        5    20 45   70
         *                    /  \
         *                   65   80 
         */
        Node root = new Node(50);
        root.left = new Node(30);
        root.left.left = new Node(5);
        root.left.right = new Node(20);
        root.right = new Node(60);
        root.right.left = new Node(45);
        root.right.right = new Node(70);
        root.right.right.left = new Node(65);
        root.right.right.right = new Node(80);

        Info largestBSTInfo = validBST(root);
        System.out.println(largestBSTInfo.maxSizeOfValidBST);

    }

    /*
    
    Your first attempt. You used checks for invalidity. But in this case checks for validity were much less. So should've used that here.

    public static Info validBST(Node root){

        if(root == null){
            return new Info(null,null,0, true);
        }

        Info leftSubtreeInfo = validBST(root.left);
        Info rightSubtreeInfo = validBST(root.right);

        if(leftSubtreeInfo.isValidBST == false || rightSubtreeInfo.isValidBST == false){ // If either or both are not valid BST return with the current max
            return new Info(null, null, Math.max(leftSubtreeInfo.maxSizeOfValidBST, rightSubtreeInfo.maxSizeOfValidBST), false);
        }

        if((leftSubtreeInfo.maxSizeOfValidBST==0 && leftSubtreeInfo.isValidBST == true) || (rightSubtreeInfo.maxSizeOfValidBST==0 && rightSubtreeInfo.isValidBST == true)){
            return new Info(root, root, 1, true);
        }
        if(leftSubtreeInfo.max == null){
            if(root.data >= rightSubtreeInfo.max.data){
                return new Info(root, rightSubtreeInfo.max, rightSubtreeInfo.maxSizeOfValidBST, false);
            } else{
                return new Info(root, rightSubtreeInfo.max, rightSubtreeInfo.maxSizeOfValidBST + 1, true);
            }
        }
        if(rightSubtreeInfo.min == null){
            if(root.data <= leftSubtreeInfo.max.data){
                return new Info(leftSubtreeInfo.min, root, leftSubtreeInfo.maxSizeOfValidBST, false);
            } else{
                 return new Info(leftSubtreeInfo.min, root, leftSubtreeInfo.maxSizeOfValidBST + 1, true);
            }
        }
        // If reaches here means both are not null
        // So we check for false comparison
        if((root.data <= leftSubtreeInfo.max.data) || (root.data >= rightSubtreeInfo.min.data)){
            return new Info(null,null, Math.max(leftSubtreeInfo.maxSizeOfValidBST, rightSubtreeInfo.maxSizeOfValidBST), false);
        }
        
        // If reaches here then both are not null and are valid BST
        return new Info(leftSubtreeInfo.min, rightSubtreeInfo.max, leftSubtreeInfo.maxSizeOfValidBST + rightSubtreeInfo.maxSizeOfValidBST + 1, true);

    }

    */
}
