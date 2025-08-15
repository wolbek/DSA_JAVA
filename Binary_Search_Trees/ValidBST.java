package Binary_Search_Trees;

import Binary_Search_Trees.BinarySearchTrees.Node;

public class ValidBST {

    public static boolean isValidBST(Node root, Node min, Node max){
      if(root == null){
        return true;
      }

      // It's basically (,min, max)
      // A left node could be min > -Infinity, so keeping null. A left node could be max < Right parent.
      // A right node could be min > Left parent. A right node could be max < Inifinity, so keeping null
      boolean isLeftSubtreeValidBST = isValidBST(root.left, min, root); // (root.left, min, parent)
      boolean isRightSubtreeValidBST = isValidBST(root.right, root, max); // (root.right, parent, max)

      if((max!=null && root.data >= max.data) || (min!=null && root.data <= min.data)){
        return false;
      }

      return isLeftSubtreeValidBST && isRightSubtreeValidBST;
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
        
        System.out.println(isValidBST(root, null, null));
    }

    /*
    
    Your first approach. Beats 100% in speed. But only 20% in memory. Solved in Leetcode

    public static int maxLeftSubtree(Node root){
        if(root == null){
            return Integer.MIN_VALUE;
        }
        
        int maxLeft = maxLeftSubtree(root.left);
        int maxRight = maxLeftSubtree(root.right);

        return (maxLeft > maxRight)? ((maxLeft> root.data)? maxLeft : root.data) : ((maxRight > root.data)? maxRight : root.data);
    }

    public static int minRightSubtree(Node root){
        if(root == null){
            return Integer.MAX_VALUE;
        }
        
        int minLeft = minRightSubtree(root.left);
        int minRight = minRightSubtree(root.right);

        return (minLeft < minRight)? ((minLeft < root.data)? minLeft : root.data) : ((minRight < root.data)? minRight : root.data);
    }

    public boolean isValidBST(Node root) {
        if(root == null) {
            return true;
        }

        if(root.data <= maxLeftSubtree(root.left) || root.data >= minRightSubtree(root.right)){
            return false;
        }

        return isValidBST(root.left) && isValidBST(root.right);
    }

    */
}
