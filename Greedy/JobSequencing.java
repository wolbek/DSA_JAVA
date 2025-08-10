package Greedy;

import java.util.ArrayList;
import java.util.Collections;

public class JobSequencing {
    static class Job {
        int deadline;
        int profit;
        int id;

        public Job(int i, int d, int p) {
            id = i;
            deadline = d;
            profit = p;
        }
    }
    public static void main(String[] args) {
        int[][] jobsInfo = {
            {4, 20},
            {1, 10},
            {1, 40},
            {1, 30}
        };

        ArrayList<Job> jobs = new ArrayList<>();
        int maxDeadline = 0;
        for(int i=0; i<jobsInfo.length; i++) {
            maxDeadline = Math.max(maxDeadline, jobsInfo[i][0]);
            jobs.add(new Job(i+1, jobsInfo[i][0], jobsInfo[i][1]));
        }

        Collections.sort(jobs, (obj1, obj2) -> obj2.profit-obj1.profit); // descending order of profit

        int jobCount = 0;
        int maxProfit = 0;

        int[] slots = new int[maxDeadline+1]; // What size? Till max deadline. +1 because we'll start with 1. 0 will be unused

        for(int i=0; i<jobs.size(); i++) {
            Job job = jobs.get(i); // Do not need to check if profit greater, because already sorted according to profit. We just need to check if the slot of current element's deadline is filled or not. If filled put in back.
            int currSlotToFill = job.deadline;

            while(currSlotToFill >= 1 && slots[currSlotToFill] != 0) {
                currSlotToFill--;
            }
            if(currSlotToFill >= 1) {
                slots[currSlotToFill] = job.id;
                jobCount++;
                maxProfit += job.profit;
            }
        }
        
        System.out.println("Max jobs: " + jobCount);
        System.out.println("Max profit: " + maxProfit);

        // print job ids in sequence
        for(int i=0; i<slots.length; i++) {
            if(slots[i] != 0) {
                System.out.println("J"+slots[i]+" ");
            }
        }

    }
}
