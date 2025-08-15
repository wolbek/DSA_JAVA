package Binary_Search_Trees;

import java.util.ArrayList;

import Binary_Search_Trees.BinarySearchTrees.Node;

public class MergeBSTs {

    public static void combinedInorders(ArrayList<Integer> combinedInorder, ArrayList<Integer> inorder1, ArrayList<Integer> inorder2) {
        int i=0, j=0;
        int inorder1Element, inorder2Element;

        while(i<inorder1.size() && j< inorder2.size()){
            inorder1Element = inorder1.get(i);
            inorder2Element = inorder2.get(j);
            if(inorder1Element <= inorder2Element){
                combinedInorder.add(inorder1Element);
                i++;
            } else{
                combinedInorder.add(inorder2Element);
                j++;
            }
        }

        while(i < inorder1.size()){
            combinedInorder.add(inorder1.get(i));
            i++;
        }

        while(j < inorder2.size()){
            combinedInorder.add(inorder2.get(j));
            j++;
        }
    }
    public static Node mergeBSTs(Node root1, Node root2){
        // Get inorders
        ArrayList<Integer> inorder1 = new ArrayList<>();
        ArrayList<Integer> inorder2 = new ArrayList<>();
        BSTToBalancedBST.getInorder(root1, inorder1);
        BSTToBalancedBST.getInorder(root2, inorder2);

        // Combine Inorders
        ArrayList<Integer> combinedInorder = new ArrayList<>();
        combinedInorders(combinedInorder, inorder1, inorder2);

        // Create Balanced BST from ArrayList
        Node resultRoot = BSTToBalancedBST.createBalancedBST(combinedInorder, 0, combinedInorder.size()-1);     
        return resultRoot;   
    }
    public static void main(String[] args){
        /*
         *      2
         *     / \
         *    1   4
         */
        Node root1 = new Node(2);
        root1.left = new Node(1);
        root1.right = new Node(4);

        /*
         *      9
         *     /  \
         *    3    12
         */

        Node root2 = new Node(9);
        root2.left = new Node(3);
        root2.right = new Node(12);

        Node resultRoot = mergeBSTs(root1, root2);
        BSTToBalancedBST.preorder(resultRoot);
    }

    /*
    
    1st approach of combining. But you can make it simpler as we did above.

    public static void combinedInorders(ArrayList<Integer> combinedInorder, ArrayList<Integer> inorder1, ArrayList<Integer> inorder2) {
        int currInorder1Index = 0;
        int currInorder2Index = 0; 
        int currInorder1Element;
        int currInorder2Element;
        for(int i=0;i<=inorder1.size() + inorder2.size()-1;i++){
            if(currInorder1Index > inorder1.size()-1){
                currInorder2Element = inorder2.get(currInorder2Index);
                combinedInorder.add(currInorder2Element);
                currInorder2Index++;
                continue;
            }
            else if(currInorder2Index > inorder2.size()-1){
                currInorder1Element = inorder1.get(currInorder1Index);
                combinedInorder.add(currInorder1Element);
                currInorder1Index++;
                continue;
            } else{
                currInorder1Element = inorder1.get(currInorder1Index);
                currInorder2Element = inorder2.get(currInorder2Index);
                if(currInorder1Element < currInorder2Element){
                    combinedInorder.add(currInorder1Element);
                    currInorder1Index++;
                } else{
                    combinedInorder.add(currInorder2Element);
                    currInorder2Index++;
                }
            }
        }
    }

    */
}
