package Array;
public class KadanesAlgo {
    public static int getMaxSubarraySum(int[] arr){
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;
        int maxVal = Integer.MIN_VALUE; // Using this to handle case where all values inside array are in negative.

        for(int i=0;i<arr.length;i++){
            currSum+=arr[i];
            if(currSum < 0){
                currSum = 0;
            }
            if(maxSum < currSum) {
                maxSum = currSum;
            }
            if(maxVal < arr[i]){
                maxVal = arr[i];
            }
        }

        if(maxVal < 0){
            return maxVal;
        } else{
            return maxSum;
        }
    }
    public static void main(String[] args){
        int[] arr = {1, -2, 6, -1, 3};
        // int[] arr = {-5, -1, -3, -4, -2};

        int maxSubarraySum = getMaxSubarraySum(arr);

        System.out.println("Max Subarray Sum: " + maxSubarraySum);
    }
}
