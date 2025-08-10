package Greedy;

import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapsack {
    public static void main(String[] args) {
        int[] val = {60, 100, 120};
        int[] weight = {10, 20, 30};
        int W = 50;

        // Creating 2D array to sort according to val/weight
        double[][] arr = new double[val.length][2];

        // At index 0 we'll store val/ weight
        // At index 1 we'll store weight

        for(int i=0; i<arr.length; i++) {
            arr[i][0] = (double)(val[i]/weight[i]);
            arr[i][1] = weight[i];
        }

        // Sort
        Arrays.sort(arr, Comparator.comparingDouble(o -> o[0])); // ascending sort, so we'll traverse from last to first below.

        double weightRemains = W;
        double totalVal = 0;

        for(int i=arr.length-1; i>=0; i--){
            
            if(arr[i][1] > weightRemains) {
                totalVal += weightRemains * arr[i][0];
                weightRemains = 0;
                break;
            }
            totalVal += arr[i][1] * arr[i][0];
            weightRemains -= arr[i][1];
        }

        System.out.println(totalVal);
    }
}
