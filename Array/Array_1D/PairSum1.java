package Array.Array_1D;

public class PairSum1 {
    public static boolean hasPair(int[] list, int target) {
    int p1 = 0;
    int p2 = list.length - 1;

    while (p1 < p2) {
        int sum = list[p1] + list[p2];
        if (sum == target) {
            return true;
        } else if (sum < target) {
            p1++; // need bigger sum
        } else {
            p2--; // need smaller sum
        }
    }

    return false;
}

    public static void main(String[] args) {
        int[] list = {1,2,3,4,5,6};
        int target = 5;

        System.out.println(hasPair(list, target));
    }

    /*
    My logic: 

    public static boolean hasPair(int[] list, int target) {
        int p1 = 0;
        int p2 = list.length-1;

        while(p1<p2) {
            int remainingAmount = target-list[p1];
            while(list[p2] > remainingAmount) {
                p2--;
            }
            if(list[p2] == remainingAmount){
                return true;
            }
            else{
                p1++;
            }
        }

        return false;
    }
    */
}
