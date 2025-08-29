package Dynamic_Programming;

public class _01KnapsackRecursion {

    public static int knapsack(int[] val, int[] wt, int W, int i) {
        if(W==0 || i==0) {
            return 0;
        }

        if(wt[i-1]<=W) { // can include
            int ans1 = val[i-1] + knapsack(val, wt, W-wt[i-1], i-1); // include
            int ans2 = knapsack(val, wt, W, i-1); // exclude
            return Math.max(ans1, ans2);
        } else{ // cannot include
            return knapsack(val, wt, W, i-1);
        }
    }

    public static void main(String[] args) {
        int[] val = {15,14,10,45,30};
        int[] wt = {2,5,1,3,4};

        int W = 7;
        System.out.println(knapsack(val, wt, W, val.length)); // We start from end to start
    }

    /*

    My solution:

    static int maxValue = 0;

    public static void maxProfit(int[] val, int[] wt, int W, int currIdx, int currTotalValue) {
        
        if(currIdx >= val.length || W==0){
            maxValue = Math.max(maxValue, currTotalValue);
            return;
        }
        if(wt[currIdx] <= W) {
            maxProfit(val, wt, W-wt[currIdx], currIdx+1, currTotalValue + val[currIdx]);
        }
        maxProfit(val, wt, W, currIdx+1, currTotalValue);
    }
    public static void main(String[] args) {
        int[] val = {15,14,10,45,30};
        int[] wt = {2,5,1,3,4};

        int W = 7;
        int currIdx = 0;
        int currTotalValue = 0;
        maxProfit(val, wt, W, currIdx, currTotalValue);
        System.out.println(maxValue);
    }
        */
}
