package Binary_Trees;

import Binary_Trees.BinaryTrees.Node;

public class Diameter {
     public static int[] diameter(Node root) {
        if(root == null) {
            int[] result = {0,0};
            return result;
        }
        
        int[] leftSubtreeInfo = diameter(root.left);
        int[] rightSubtreeInfo = diameter(root.right);

        int currDiameter = leftSubtreeInfo[1] + rightSubtreeInfo[1] + 1;
        int maxDiameterOfSubtree = Math.max(leftSubtreeInfo[0], rightSubtreeInfo[0]);

        int diamToPass = (currDiameter < maxDiameterOfSubtree) ? maxDiameterOfSubtree : currDiameter; 
        // If true, it means current element is not part of the biggest diameter
        // If false, it means currDiameter is part of the the biggest diameter getting built.

        int maxHeightOfSubtree = Math.max(leftSubtreeInfo[1], rightSubtreeInfo[1]) + 1;

        int[] result = {
            diamToPass, 
            maxHeightOfSubtree
        };

        return result;
    }
    public static void main(String[] args) {

        /*
         *        1
         *      /  
         *     2
         *    / \
         *   3   5
         *  /     \
         * 4       6
         */
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(3);
        root.left.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.right = new Node(6);

        System.out.println(diameter(root)[0]);
    }
}
