package Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class ActivitySelection {
    public static void main(String[] args) { // O(n)
        // int[] start = {10, 12, 20};
        // int[] end = {20, 25, 30};
        int[] start = {1,3,0,5,8,5};
        int[] end = {2,4,6,7,9,9}; 
        
        // If end time not sorted:

        // Storing in 2D array to sort
        int[][] activities = new int[start.length][3];
        for(int i=0; i<start.length; i++) {
            activities[i][0] = i;
            activities[i][1] = start[i];
            activities[i][2] = end[i];
        }

        // Sorting 2D array
        Arrays.sort(activities, Comparator.comparingDouble(o -> o[2]));

        // To store max activities and activity index
        int maxAct = 0;
        ArrayList<Integer> ans = new ArrayList<>();

        // 1st activity
        maxAct = 1;
        ans.add(activities[0][0]);
        int lastEnd = activities[0][2];

        for(int i=1; i<activities.length; i++) {
            if(activities[i][1] >= lastEnd) {
                //activity select
                maxAct++;
                ans.add(activities[i][0]);
                lastEnd = activities[i][2];
            }
        }

        System.out.println("Maximum activities = " + maxAct);
        for(int i=0; i<ans.size(); i++) {
            System.out.print("A" + ans.get(i) + " ");
        }
    }
}
