package Recursion;

public class Factorial {
    public static int fact(int n){
        if (n < 0){
            return -1;
        }

        if(n==1 || n==0){
            return 1;
        }
        
        return n * fact(n-1);
    }  
    public static void main(String[] args){
        int n=5;
        int ans = fact(n);
        if(ans == -1){
            System.out.println("Factorial not possible for " + n);
        } else{
            System.out.println("Factorial of " + n + ": " + ans);
        }
    }
}
