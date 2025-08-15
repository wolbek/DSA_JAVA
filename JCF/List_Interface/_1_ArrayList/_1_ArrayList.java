package JCF.List_Interface;

import java.util.ArrayList;

public class _1_ArrayList {
    public static void main(String[] args) {
        //Creation
        ArrayList<Integer> list1 = new ArrayList<>();

        //Clear the list
        list1.clear();
        System.out.println("Cleared the list: "+list1);

        //Add element 
        list1.add(10); //O(1)
        list1.add(20);
        list1.add(30); 
        list1.add(40); 
        list1.add(4,50); //O(n), If 3rd element is not added, you cannot directly add 4th element

        System.out.println("ArrayList: "+list1);

        //Get element
        System.out.println("Get element at index 4: "+list1.get(4)); //O(1)

        //Remove element
        System.out.println("Remove element at index 4: "+list1.remove(4)); //O(n)
        System.out.println("Removing element 60: "+list1.remove(Integer.valueOf(60))); //remove element 4 (type of element is same as what the arraylist containss) from list and return true if removed else false
        
        //Set element at index
        list1.set(3,40); //O(n)

        // Using arraylist in functions
        // public ArrayList<String> getNames(ArrayList<String> list){
        //     return list;
        // }

        //Contains element
        System.out.println("Contains 30?: "+list1.contains(30)); //O(n). Returns true if exist, else false

        //Get size of arraylist
        System.out.println("Size of arraylist: "+list1.size());

        //Print arraylist
        System.out.println("Printing array list in 3 ways: 1) Direct, 2) for loop 3) for each");

        //1st way
        System.out.println(list1); //[30]

        //2nd way
        for(int i=0;i<list1.size();i++){
            System.out.print(list1.get(i)+", ");
        } //30
        System.out.println();

        //3rd way
        for(Integer element: list1){
            System.out.print(element+", ");
        }
        System.out.println();

        //Add all elements of list 2 to list1
        ArrayList<Integer> list2 = new ArrayList<>(); 
        list2.add(50);
        list2.add(60);

        list1.addAll(list2);
        System.out.println("Added list2 to list1: "+list1);

        //Multidimensional Arraylist
        ArrayList<ArrayList<Integer>> mainList = new ArrayList<>();
        //The lists inside are allowed to have different sizes.

        ArrayList<Integer> list3 = new ArrayList<>();
        list3.add(10);
        list3.add(20);
        mainList.add(list3);

        ArrayList<Integer> list4 = new ArrayList<>();
        list4.add(30);
        list4.add(40);
        mainList.add(list4);

        //Printing Multidimensional Arraylist

        System.out.println("Multidimensional Arraylist: ");

        //1st way
        System.out.println(mainList);//[[10,20],[30,40]]

        //2nd way
        for(int i=0;i<mainList.size();i++){
            ArrayList<Integer> currList = mainList.get(i);
            for(int j=0;j<currList.size();j++){
                System.out.print(currList.get(j)+", ");
            }
            System.out.println();
        }
        // 10 20
        // 30 40     
    }
}
