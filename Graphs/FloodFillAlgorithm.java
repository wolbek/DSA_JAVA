package Graphs;

public class FloodFillAlgorithm {

    public static void floodFill(int[][] image, int sr, int sc, int newColor, int originalColor) {
        if(
            sr<0 || 
            sc<0 || 
            sr>=image.length || 
            sc >=image[0].length ||
            image[sr][sc] != originalColor
        ) {
            return;
        }

        image[sr][sc] = newColor;
        
        floodFill(image, sr-1, sc, newColor, originalColor); // Up
        floodFill(image, sr+1, sc, newColor, originalColor); // Down
        floodFill(image, sr, sc-1, newColor, originalColor); // Left
        floodFill(image, sr, sc+1, newColor, originalColor); // Right
    }
    public static void main(String[] args) {
        int[][] image = {
            {1,1,1},
            {1,1,0},
            {1,0,1}
        };

        int sr = 1;
        int sc = 1;
        int originalColor = image[sr][sc];
        int newColor = 2;

        floodFill(image, sr, sc, newColor, originalColor);

        for(int i=0 ;i<image.length; i++) {
            for(int j=0; j<image[0].length; j++) {
                System.out.print(image[i][j] + " ");
            }
            System.out.println();
        }
    }
}
