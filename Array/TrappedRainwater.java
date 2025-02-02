package Array;
public class TrappedRainwater {
    public static int getWaterTrapped(int[] arr){
        int len = arr.length;
        int[] leftMax = new int[len];
        int[] rightMax = new int[len];
        int leftMaxVal = 0, rightMaxVal = 0, waterLevel = 0, waterTrapped = 0;

        // In leftMax we want 4,4,4,6,6,6,6
        // In rightMax we want 6,6,6,6,5,5,5
        for(int i=0;i<len;i++){
            if(leftMaxVal < arr[i]){
                leftMaxVal = arr[i];
            }
            leftMax[i] = leftMaxVal;

            if(rightMaxVal < arr[len-1-i]){
                rightMaxVal = arr[len-1-i];
            }
            rightMax[len-1-i] = rightMaxVal;
        }

        // To get waterLevel: Get min of leftMax and rightMax at i 
        // To get water trapped: Subtract block at i from waterLevel
        for(int i=0;i<len;i++){
            waterLevel =  Math.min(leftMax[i], rightMax[i]);
            waterTrapped += waterLevel - arr[i];
        }

        return waterTrapped;
        
    }
    public static void main(String[] args){
        int[] arr = {4, 2, 0, 6, 3, 2, 5};

        int waterTrapped = getWaterTrapped(arr);

        System.out.println("Water trapped: "+ waterTrapped);
    }
}
