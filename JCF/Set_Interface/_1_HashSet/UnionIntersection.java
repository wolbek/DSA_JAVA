package JCF.Set_Interface._1_HashSet;

import java.util.*;

public class UnionIntersection {
    public static void main(String[] args) {
        int[] arr1 = {7,3,9};
        int[] arr2 = {6,3,9,2,9,4};

        HashSet<Integer> union = new HashSet<>();
        HashSet<Integer> intersection = new HashSet<>();


        for(Integer num: arr1) {
            union.add(num);
        }

        for(Integer num: arr2) {
            if(union.contains(num) == true){
                intersection.add(num);
            }
            union.add(num);
        }

        System.out.println(union);
        System.out.println(intersection);
    }
}
