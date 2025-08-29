package Dynamic_Programming;

public class ClimbingStairsTabulation {
    public static int waysToClimb(int n, int[] ways) { // TC: O(n)
        for(int i=2; i<=n; i++) {
            ways[i] = ways[i-1] + ways[i-2];
        }
        return ways[n];
    }
    public static void main(String[] args) {
        int n=5;
        int[] ways = new int[n+1];
        ways[0] = 1;
        ways[1] = 1;
        System.out.println(waysToClimb(n, ways));
    }
}
