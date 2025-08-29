package Dynamic_Programming;

public class _01KnapsackMemoization {

    public static int knapsack(int[] val, int[] wt, int W, int i, int[][] dp) {
        if(W==0 || i==0) {
            return 0;
        }

        if(dp[i][W]!=-1) {
            return dp[i][W];
        }

        if(wt[i-1]<=W) { // can include
            int ans1 = val[i-1] + knapsack(val, wt, W-wt[i-1], i-1, dp); // include
            int ans2 = knapsack(val, wt, W, i-1, dp); // exclude
            dp[i][W] = Math.max(ans1, ans2);
            return dp[i][W];
        } else{ // cannot include
            dp[i][W] = knapsack(val, wt, W, i-1, dp);
            return dp[i][W];
        }
    }

    public static void main(String[] args) {
        int[] val = {15,14,10,45,30};
        int[] wt = {2,5,1,3,4};

        int W = 7;

        int n = val.length;
        int [][] dp = new int[n+1][W+1];

        for(int i=0; i<dp.length; i++) {
            for(int j=0; j<dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }

        System.out.println(knapsack(val, wt, W, n, dp)); // We start from end to start
        
        // DP 2D array after recursion:
        for(int i=0; i<dp.length; i++) {
            for(int j=0; j<dp[0].length;j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }
}
