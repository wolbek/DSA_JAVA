package Recursion;

public class TilingProblem {
    public static int possibleArrangements(int boardCol){

        if(boardCol == 0 || boardCol == 1){
            return 1;
        }

        // Place tile horizontally (uses 2 columns) or vertically (uses 1 column)
        int horizontal = possibleArrangements(boardCol-2);
        int vertical = possibleArrangements(boardCol-1);

        return horizontal + vertical;

    }
    public static void main(String[] args){
        //int boardRow = 2; Given in the problem. And the tile dimension is 2 X 1.
        int boardCol = 4;
        System.out.println(possibleArrangements(boardCol));
    }
}
