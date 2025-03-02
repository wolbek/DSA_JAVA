package Recursion;

public class SortedArray {
    public static boolean isArraySorted(int[] arr, int n){
        if(n == arr.length-1){
            return true;
        }

        if(arr[n] > arr[n+1]){
            return false;
        }
        
        return isArraySorted(arr, n+1);
    }
    public static void main(String[] args){
        int[] arr = {1,2,3,4,5}; 
        System.out.println(isArraySorted(arr, 0));
    }
}
