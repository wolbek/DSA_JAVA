package Array;

public class SpiralMatrix {
    public static void printSpiral(int[][] arr){
        int topRow = 0, bottomRow = arr.length-1;
        int leftCol = 0, rightCol = arr[0].length-1;

        while(topRow <= bottomRow && leftCol<=rightCol){
            // top
            for(int j=leftCol;j<=rightCol;j++){
                System.out.print(arr[topRow][j]+" ");
            }
            ++topRow;

            // right
            for(int i=topRow;i<=bottomRow;i++){
                System.out.print(arr[i][rightCol]+" ");
            }
            --rightCol;

            // bottom
            if(topRow <= bottomRow){
                // Condition so that if top has printed the element, bottom doesn't print it again.
                for(int j=rightCol;j>=leftCol;j--){
                    System.out.print(arr[bottomRow][j]+" ");
                }
                --bottomRow;
            }

            // left
            if(leftCol <= rightCol){
                // Condition so that if right has printed the element, left doesn't print it again.
                for(int i=bottomRow;i>=topRow;i--){
                    System.out.print(arr[i][leftCol]+" ");
                }
                ++leftCol;
            }
            
        }
    }
    public static void main(String[] args){
        // Array can be n*m
        // int[][] arr = {
        //     {1,2,3,4},
        //     {5,6,7,8},
        //     {9,10,11,12},
        //     {13,14,15,16}
        // };
        int[][] arr = {
            {1,2,3,4},
            {5,6,7,8},
            {9,10,11,12}
        };


        printSpiral(arr);
    }
}
