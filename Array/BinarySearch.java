package Array;
public class BinarySearch {
    public static int binarySearch(int[] arr, int key){
        int start =0;
        int end = arr.length-1;

        while(start<=end){
            int mid = (start + end) /2;

            if(arr[mid] == key){
                return mid;
            }
            else if (key < arr[mid]){
                end = mid - 1;
            }
            else if(arr[mid] < key) {
                start = mid + 1;
            }
        }

        return -1;
    }
    public static void main(String[] args){
        // Prerequisite - Array should be sorted
        int[] arr = {1,2,3,4,5,6,7,8,9};
        int key = 8;
        int keyIndex = binarySearch(arr, key);
        if(keyIndex == -1){
            System.out.println("Key not present in array");
        } else{
            System.out.println("Key is present at " + keyIndex +" index in array");
        }
    }
}