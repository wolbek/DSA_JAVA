package Binary_Trees;

import Binary_Trees.BinaryTrees.Node;

public class MinDistanceBetweenNodes {

    static class Info{
        Node nodeLCA;
        int depth;
        int minDistance;

        Info(Node nodeLCA, int depth, int minDistance){
            this.nodeLCA = nodeLCA;
            this.depth = depth;
            this.minDistance = minDistance;
        }
    }
    public static Info findMinDistance(Node root, int n1, int n2, int depth) {
        if(root == null || root.data == n1 || root.data == n2){
            return new Info(root, depth, -1);
        }

        Info leftLCAInfo = findMinDistance(root.left, n1, n2, depth+1);
        Info rightLCAInfo = findMinDistance(root.right, n1, n2, depth+1);


        if(rightLCAInfo.nodeLCA==null){
            return leftLCAInfo;
        }
        if(leftLCAInfo.nodeLCA == null){
            return rightLCAInfo;
        }

        int minDistance = (leftLCAInfo.depth - depth) + (rightLCAInfo.depth - depth);
   
        return new Info(root, depth, minDistance);
    }
     
    public static void main(String[] args){
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

        int n1 = 4;
        int n2 = 3;
        int depth = 1;

        System.out.println(findMinDistance(root, n1, n2, depth).minDistance);
    }

    
}
