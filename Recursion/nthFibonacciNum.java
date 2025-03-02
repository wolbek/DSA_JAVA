package Recursion;

public class nthFibonacciNum {
    public static int nthFiboNum(int n){
        if(n==0 || n==1){
            return n;
        }

        return nthFiboNum(n-1) + nthFiboNum(n-2);
    }
    public static void main(String[] args){
        int n=4; // For n = 4, answer will be 3
        System.out.println(nthFiboNum(n));
    }
}
