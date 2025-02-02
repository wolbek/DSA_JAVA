package Array.Array_2D;

public class SearchSortedMatrix {
    public static boolean staircaseSearch(int[][] arr, int key){
        int row = 0;
        int col = arr[0].length-1;

        int currElem = arr[row][col];

        while(row <= arr.length-1 && col >= 0){
            if(currElem == key){
                System.out.println("Key found at ( " + row + ", " + col + " )");
                return true;
            }
            else if(currElem < key){
                currElem = arr[++row][col];
            } else{
                currElem = arr[row][--col];
            }
        }
        System.out.println("Key not found");
        return false;
    }
    public static void main(String[] args){
        int[][] arr = {
            {10,20,30,40},
            {15,25,35,45},
            {27,29,37,48},
            {32,33,39,50}
        };

        int key = 33;
        staircaseSearch(arr, key);
    }
}
