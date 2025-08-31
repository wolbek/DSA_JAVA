package Dynamic_Programming;

public class CatalanRecursion {

    public static int catalan(int n) {
        if(n==0 || n==1) {
            return 1;
        }
        int ans = 0;
        for(int i=0;i<=n-1;i++) {
            ans += catalan(i)*catalan(n-1-i);
        }

        return ans;
    }
    public static void main(String[] args) {
        int n=4;
        System.out.println(catalan(n));
    }
}
