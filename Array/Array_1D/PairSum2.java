package Array.Array_1D;

public class PairSum2 {
    public static boolean hasPair(int[] list, int target) {
        int bp = -1; // Breaking point
        int n = list.length;

        for(int i=0; i<list.length; i++) { // Finding breaking point
            if(list[i] > list[i+1]) {
                bp = i;
                break;
            }
        }

        int p1 = bp + 1; //smallest
        int p2 = bp; // largest

        while(p1!=p2)  {
            int sum = list[p1] + list[p2];

            if(sum == target) {
                return true;
            } else if(sum < target) {
                p1 = (p1 + 1) % n;
            } else {
                p2 = (n + p2 -1) % n;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] list = {11, 15, 6, 8, 9, 10}; // Sorted and rotated
        int target = 16;

        System.out.println(hasPair(list, target));
    }


    /*
    My approach:
    
    public static boolean hasPair(int[] list, int target) {
        int p2 = 0;

        // Finding breaking point and assign it as pointer 1
        for(int i=0; i<list.length-1; i++) {
            if(list[i] > list[i+1]) {
                p2 = i;
                break;
            }
        }

        int p1 = p2+1;

        while (p1!=p2) {
            int sum = list[p1] + list[p2];
            if (sum == target) {
                return true;
            } else if (sum < target) {
                p1++; // need bigger sum
                if(p1 == list.length) p1 = 0;
            } else {
                p2--; // need smaller sum
                if(p2 == -1) p2 = list.length-1;
            }
        }

        return false;
    }
     
    */
    
}
