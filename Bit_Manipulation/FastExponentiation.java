package Bit_Manipulation;

public class FastExponentiation {
    public static int getAnswer(int num, int power){
        int numExponent = num;
        int ans = 1;
        while(power>0){
            int currBit = power & 1;
            if(currBit == 1){
                ans = ans * numExponent;
            }
            numExponent = numExponent * numExponent;
            power = power>>1;

        }
        return ans;
    }
    public static void main(String[] args){
        int num = 3;
        int power = 5;
        System.out.println(getAnswer(num, power));
    }
}

