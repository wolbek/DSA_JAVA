package Binary_Search_Trees;
import Binary_Search_Trees.BinarySearchTrees.Node;

public class ArrayToBalancedBST {
    public static Node createBalancedBST(int[] arr, int start, int end){
        if(start > end){
            return null;
        }
        int mid = (start + end)/2;
        Node root = new Node(arr[mid]);
        root.left = createBalancedBST(arr, start, mid-1);
        root.right = createBalancedBST(arr, mid+1, end);

        return root;
    }
    public static void main(String[] args){
        int[] arr = {3,5,6,8,10,11};

        Node root = createBalancedBST(arr, 0, arr.length-1);
        System.out.println(root);
    }

    /* 
    
    Your first attempt:

    public static Node createBalancedBST(int[] arr, int start, int end){
        if(start == end){
            return new Node(arr[start]);
        }
        int mid = (start + end)/2;
        Node root = new Node(arr[mid]);
        if(mid-1 >= start) root.left = createBalancedBST(arr, start, mid-1);
        if(mid+1 <= end) root.right = createBalancedBST(arr, mid+1, end);

        return root;
    }

    */
}
