package Dynamic_Programming;

public class nthFibonacciNumTabulation { // TC: O(n)
    public static int fib(int n, int[] f) {
        for(int i=2; i<=n; i++) {
            f[i] = f[i-1] +f[i-2];
        }
        return f[n];
    }
    public static void main(String[] args) {
        int n=5;
        int[] f = new int[n+1];
        f[0] = 0;
        f[1] = 1;
        System.out.println(fib(n, f));
    }
}
