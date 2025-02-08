package Bit_Manipulation;

public class OddOrEven {
    public static void isOddOrEven(int n){
        int bitMask = 1;
        if((n & bitMask) == 1){
            System.out.println("Odd number");
        } else{
            System.out.println("Even number");
        }
    }
    public static void main(String[] args){
        isOddOrEven(3);
        isOddOrEven(20);
    }
}
