package Recursion;

public class BinaryStrings {
    public static void printArrangements(int n, int lastPlace, String str){
        
        if(n==0){
            System.out.println(str);
            return;
        }

        printArrangements(n-1, 0, str+'0');

        if(lastPlace == 0){
            printArrangements(n-1, 1, str+'1');
        }
    }
    public static void main(String[] args){
        int n=5;
        int lastPlace = 0; // Even when nothing is there in string we'll be storing lastPlace as 0, so that 1 can be added at start.
        printArrangements(n,lastPlace, "");
    }
}
