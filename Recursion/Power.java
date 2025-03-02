package Recursion;

public class Power {
    // Naive approach:

    // public static int pow(int x, int n){
    //     if(n == 0){
    //         return 1;
    //     }
    //     return x * pow(x, n-1);
    // }

    // Efficient approach:
    public static long pow(int x, int n){
        if(n==0){
            return 1;
        }
        long halfPower = pow(x, n/2);

        if(n%2==0){
            return halfPower * halfPower;
        } else{
            return x * halfPower * halfPower;
        }
    }
    public static void main(String[] args){
        int x = 3;
        int n = 4;
        System.out.println(pow(x, n));
    }
}
