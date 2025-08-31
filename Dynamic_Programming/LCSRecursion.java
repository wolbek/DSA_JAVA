package Dynamic_Programming;

public class LCSRecursion {

    public static int lcs(String str1, String str2, int n, int m) {
        if(n < 0 || m < 0){
            return 0;
        }

        char ch1 = str1.charAt(n);
        char ch2 = str2.charAt(m);

        if(ch1==ch2) {
            return 1+lcs(str1,str2,n-1,m-1);
        } else{
            int str1Shorten = lcs(str1,str2,n-1,m);
            int str2Shorten = lcs(str1,str2,n,m-1);

            return Math.max(str1Shorten, str2Shorten);
        }

    }
    public static void main(String[] args) {
        // String str1= "abcde";
        // String str2 = "ace";
        String str1= "abcdge";
        String str2 = "abedg";

        int n = str1.length();
        int m = str2.length();
   
        System.out.println(lcs(str1, str2, n-1, m-1));
    }
}
