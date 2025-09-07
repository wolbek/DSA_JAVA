package JCF.Map_Interface._1_HashMap;

import java.util.HashMap;

public class LargestSubarray0Sum {
    public static void main(String[] args) {
        int[] arr = {15, -2, 2, -8, 1, 7, 10, 23};

        // Key = Prefix Sum, Value = Index of first occurrence
        HashMap<Integer, Integer> map = new HashMap<>();

        int currentSum = 0;
        int maxLength = 0;

        for (int i = 0; i < arr.length; i++) {
            currentSum += arr[i];

            if (currentSum == 0) {
                // Case 1: The subarray from the start (index 0) to i sums to 0.
                maxLength = i + 1;
            } else if (map.containsKey(currentSum)) {
                // Case 2: We've seen this prefix sum before.
                // The subarray between the previous index and this one sums to 0.
                // Length = current index - previous index
                maxLength = Math.max(maxLength, i - map.get(currentSum));
            } else {
                // Case 3: First time seeing this prefix sum.
                // Store it with its index.
                map.put(currentSum, i);
            }
        }

        System.out.println("Length of the longest subarray with 0 sum is: " + maxLength);
    }


    /*
    My approach - Correct but can be optimized
    
     public static void main(String[] args){

        int[] arr = {15, -2, 2, -8, 1, 7, 10, 23};
        
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        ArrayList<Integer> currIdxList;
        int currSum = 0;
        for(int i=0; i<arr.length; i++) {
            currSum += arr[i];
            currIdxList = map.get(currSum);
            
            if (currIdxList == null) {   // first time seeing this sum
                currIdxList = new ArrayList<>();
            }
            
            currIdxList.add(i);
            
            map.put(currSum, currIdxList);
        }
        int ans=0;
        
        for(Integer num: map.keySet()) {
            currIdxList = map.get(num);
            int diff = currIdxList.get(currIdxList.size()-1)-currIdxList.get(0);
            ans = Math.max(ans, diff);
        }
        
        currIdxList = map.get(0);
        if(currIdxList!=null && (currIdxList.get(currIdxList.size()-1)+1 > ans)){
            System.out.println(currIdxList.get(currIdxList.size()-1)+1);
        } else{
            System.out.println(ans);
        }
    } 
     
     */
}
