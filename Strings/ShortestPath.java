package Strings;

public class ShortestPath {
    public static double getShortestPath(String path){
        int x = 0, y = 0;

        for(int i =0; i<path.length();i++){
            char direction = path.charAt(i);
            if(direction == 'N'){
                ++y;
            }
            if(direction == 'E'){
                ++x;
            }
            if(direction == 'S'){
                --y;
            }
            if(direction == 'W'){
                --x;
            }
        }
        
        double distance = Math.sqrt(x*x+y*y);
        return distance;
    }
    public static void main(String[] args){
        String path = "WNEENESENNN";
        System.out.println(getShortestPath(path));

        
    }
}