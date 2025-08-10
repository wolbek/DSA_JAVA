package Greedy;

import java.util.Arrays;
import java.util.Comparator;

public class IndianCoins {
    public static void main(String[] args) {
        Integer[] coins = {1,2,5,10,20,50,100,500,2000};
        int amount = 590;
        int countOfUniqueCoins = 0;

        Arrays.sort(coins, Comparator.reverseOrder());

        for(int i=0; i<coins.length; i++) {
            int coinUsed = amount/coins[i];
            if( coinUsed >= 1){
                countOfUniqueCoins += coinUsed;
                amount -= coinUsed *coins[i];
            }
        }
        System.out.println(countOfUniqueCoins);
        
    }
}
