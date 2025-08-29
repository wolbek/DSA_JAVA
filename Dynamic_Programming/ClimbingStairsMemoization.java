package Dynamic_Programming;

import java.util.Arrays;

public class ClimbingStairsMemoization {
    public static int waysToClimb(int n, int[] ways) { // TC: O(n)
        if(n==0) {
            return 1;
        }
        if(n<0) {
            return 0;
        }
 
        if(ways[n] != -1) {
            return ways[n];
        }

        ways[n] = waysToClimb(n-1, ways) + waysToClimb(n-2, ways);
        return ways[n];
    }
    public static void main(String[] args) {
        int n=5;
        int[] ways = new int[n+1];
        Arrays.fill(ways, -1);
        System.out.println(waysToClimb(n, ways));
    }
}
