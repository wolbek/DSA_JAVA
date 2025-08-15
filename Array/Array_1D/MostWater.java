package Array.Array_1D;

public class MostWater {
    public static int storeWater(int[] height) {
        int start = 0;
        int end = height.length-1;
        int maxWater = 0;

        while(start < end) {
            int breadth = end-start;
            int length = Math.min(height[start], height[end]);
            int currArea = length*breadth;

            maxWater = Math.max(maxWater, currArea);

            if(height[start] >= height[end]) { // If end is smaller, we do end-- (as start++, won't increase area)
                end--;
            } else{ // If start is smaller, we do start++ (as end--, won't increase area)
                start++;
            }
            // So ultimately in maxWater, we're checking only those combinations which has a chance of better area.
        }

        return maxWater;
    }
    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(storeWater(height));
    }

    /*

    Your first approach:

    public int maxArea(int[] height) {
        int start = 0;
        int end = height.length-1;
        int maxWater = 0;

        int newArea = 0;
        int breadth = end-start;
        int length = Math.min(height[start], height[end]);
        int currArea = length*breadth;
        maxWater = currArea;
        
        while(start < end) {
            if(end-start == 1) break; // Only start to end, two rods in total, then we already have the area, no need to execute further.
            while(newArea <= currArea && start<end) { // We calculate newArea until its bigger than currArea
                if(height[start] >= height[end]) { // If end is smaller, we do end-- (as start++, won't increase area)
                    end--;
                } else{ // If start is smaller, we do start++ (as end--, won't increase area)
                    start++;
                }
                breadth = end-start;
                length = Math.min(height[start], height[end]);
                newArea = length*breadth;
            }

            maxWater = Math.max(maxWater, newArea); // We are ussing max rather than directly assigning newArea, because it may happen that we might not get a newArea which is greater than currArea.
            currArea = newArea;
            
        }

        return maxWater;
    }

    */
}


