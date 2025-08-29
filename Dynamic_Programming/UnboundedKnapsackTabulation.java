package Dynamic_Programming;

public class UnboundedKnapsackTabulation {

    public static int knapsack(int[] val, int[] wt, int W, int n, int[][] dp) {

        for(int i=0; i<dp.length; i++) { // 0th col
            dp[i][0] = 0;
        }
        for(int j=0; j<dp[0].length; j++) { // 0th row
            dp[0][j] = 0;
        }

        for(int i=1; i<n+1; i++) {
            for(int j=1; j<W+1; j++) {
                int v = val[i-1]; // ith item val
                int w = wt[i-1]; // ith item wt
                if(w<=j) { // can include
                    int incProfit = v + dp[i][j-w]; // Just i-1 from 01 Knapsack is changed to i
                    int excProfit = dp[i-1][j];
                    dp[i][j] = Math.max(incProfit, excProfit);
                } else{ // cannot include
                    int excProfit = dp[i-1][j];
                    dp[i][j] = excProfit;
                }
            }
        }

        return dp[n][W];
    }

    public static void main(String[] args) {
        int[] val = {15,14,10,45,30};
        int[] wt = {2,5,1,3,4};

        int W = 7;

        int n = val.length;
        int[][] dp = new int[n+1][W+1];

        System.out.println(knapsack(val, wt, W, n, dp));
        
        // DP 2D array after iteration:
        for(int i=0; i<dp.length; i++) {
            for(int j=0; j<dp[0].length;j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }
}
