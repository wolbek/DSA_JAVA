package JCF.Set_Interface._1_HashSet;

import java.util.HashSet;

public class CountDistinctElements {
    public static void main(String[] args) {
        int[] num = {4,3,2,5,6,7,3,4,2,1};
        
        HashSet<Integer> set = new HashSet<>();

        for(Integer n: num) { // TC: O(n)
            set.add(n);
        }

        System.out.println(set.size());
    }
}
