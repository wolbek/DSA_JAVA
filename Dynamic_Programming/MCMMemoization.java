package Dynamic_Programming;

import java.util.Arrays;

public class MCMMemoization {
    public static int mcm(int[] arr, int i, int j, int[][] dp) {
        if(i==j) {
            return 0; // single matrix case
        }

        if(dp[i][j] != -1) {
            return dp[i][j];
        }

        int minCost = Integer.MAX_VALUE;
        for(int k=i; k<=j-1; k++) {
            int cost1 = mcm(arr, i, k, dp); // Ai...Ak => Result size = arr[i-1] X arr[k]
            int cost2 = mcm(arr, k+1, j, dp); // Ai+1...Aj => Result size = arr[k] X arr[j]
            int cost3 = arr[i-1] * arr[k] * arr[j];
            int finalCost = cost1 + cost2 + cost3;
            minCost = Math.min(minCost, finalCost);
        }

        return dp[i][j] = minCost;
    } 
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,3}; // n = 5
        int n = arr.length;

        int[][] dp = new int[n][n];
        for(int i=0; i<n; i++){
            Arrays.fill(dp[i], -1);
        }
        System.out.println(mcm(arr,1,n-1, dp));

        // Printing dp array
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }
}
