package Dynamic_Programming;

public class LCSMemoization {

    public static int lcs(String str1, String str2, int n, int m, int[][] dp) {
        if(n < 0 || m < 0){
            return 0;
        }

        char ch1 = str1.charAt(n);
        char ch2 = str2.charAt(m);

        if(dp[n][m] == -1) {
            if(ch1==ch2) {
                dp[n][m] = 1+lcs(str1,str2,n-1,m-1, dp);
            } else{
                int str1Shorten = lcs(str1,str2,n-1,m, dp);
                int str2Shorten = lcs(str1,str2,n,m-1, dp);

                dp[n][m] = Math.max(str1Shorten, str2Shorten);
            }
        }

        return dp[n][m];

    }
    public static void main(String[] args) {
        // String str1= "abcde";
        // String str2 = "ace";
        String str1= "abcdge";
        String str2 = "abedg";

        int n = str1.length();
        int m = str2.length();

        int[][] dp = new int[n][m];

        // Filling each cell with -1
        for(int i=0; i<n; i++){
            for(int j=0; j<m;j++){
                dp[i][j] = -1;
            }
        }
   
        System.out.println(lcs(str1, str2, n-1, m-1, dp));

        // Seeing the table
        for(int i=0; i<n; i++){
            for(int j=0; j<m;j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }
}
