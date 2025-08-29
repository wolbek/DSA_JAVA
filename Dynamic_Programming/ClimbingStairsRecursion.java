package Dynamic_Programming;

public class ClimbingStairsRecursion {

    public static int waysToClimb(int n) { // TC - O(2^n) -> n = 10^5, it will be too much
        if(n==0) {
            return 1;
        }
        if(n<0) {
            return 0;
        }
        
        return waysToClimb(n-1) + waysToClimb(n-2);
    }
    public static void main(String[] args) {
        int n=5;
        System.out.println(waysToClimb(n));
    }
}
