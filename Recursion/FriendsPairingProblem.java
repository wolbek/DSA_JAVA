package Recursion;

public class FriendsPairingProblem {
    public static int possibleArrangements(int friendCount){
        if(friendCount==1 || friendCount==2){
            return friendCount;
        }
        int possibleArrangementsAfterSingleTaken = possibleArrangements(friendCount-1);
        int possibleArrangementsAfterPairTaken = possibleArrangements(friendCount-2);
        int pairWays = friendCount - 1; // E.g., A can take any one from B, C, D, E

        return possibleArrangementsAfterSingleTaken + pairWays * possibleArrangementsAfterPairTaken;
        // Or you can directly write: return possibleArrangements(friendCount-1) + (friendCount - 1) * possibleArrangements(friendCount-2);
    }
    public static void main(String[] args){
        int friendCount=5; // Let's say A, B, C, D, E
        System.out.println(possibleArrangements(friendCount));
    }
}
