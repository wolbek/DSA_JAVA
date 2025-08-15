package Greedy;

import java.util.Arrays;
import java.util.Collections;

public class Chocola {
    public static void main(String[] args) {
        int n = 4, m = 6;
        Integer[] costHorizontal = {4, 1, 2}; // n-1
        Integer[] costVertical = {2, 1, 3, 1, 4}; // m-1

        Arrays.sort(costHorizontal, Collections.reverseOrder());
        Arrays.sort(costVertical, Collections.reverseOrder());

        int currH = 0;
        int currV = 0;
        int HP = 1; // For the first time when vertical cut is applied, it should be multiplied with 1 horizontal piece. And after a horizontal cut, the horizontal piece should increase to 2.
        int VP = 1;

        int cost = 0;

        while (currH < costHorizontal.length && currV < costVertical.length) {
            if(costHorizontal[currH] > costVertical[currV]) { // Horizontal cut
                cost += costHorizontal[currH] * VP;
                currH++;
                HP++;
            } else{ // Vertical cut. For costHorizontal[currH] == costVertical[currV] and costHorizontal[currH] < costVertical[currV]
                cost += costVertical[currV] * HP;
                currV++;
                VP++;
            }
        }

        while(currH < costHorizontal.length) {
            cost += costHorizontal[currH] * VP;
            currH++;
            HP++;
        }

        while(currV < costVertical.length) {
            cost += costVertical[currV] * HP;
            currV++;
            VP++;
        }

        System.out.println("Minimum cost: " + cost);
    }
}
