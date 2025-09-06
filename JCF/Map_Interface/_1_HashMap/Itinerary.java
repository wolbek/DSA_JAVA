package JCF.Map_Interface._1_HashMap;

import java.util.HashMap;
import java.util.HashSet;

public class Itinerary {
    public static void main(String[] args) {
        HashMap<String, String> tickets = new HashMap<>();
        tickets.put("Chennai", "Bengaluru");
        tickets.put("Mumbai", "Delhi");
        tickets.put("Goa", "Chennai");
        tickets.put("Delhi", "Goa");

        String start = "";
        HashSet<String> to = new HashSet<>(tickets.values());

        for(String from: tickets.keySet()) { // to find starting point
            if(!to.contains(from)) {
                start = from;
            }
        }

        System.out.print(start);
        while(tickets.containsKey(start)) {
            start = tickets.get(start);
            System.out.print(" -> " + start);
        }

        /*
        Initial solution: It's slow because "to" Collection is a list, and to do containsKey, it would take O(n)
        
        String startingPoint = "";
        Collection<String> to = tickets.values();

        for(String from: tickets.keySet()) {
            if(!to.contains(from)) { // A 'from' which is not there in 'to' is the starting point
                startingPoint = from;
                break;
            }
        }

        while(tickets.containsKey(startingPoint)) {
            System.out.print(startingPoint + " -> ");
            startingPoint = tickets.get(startingPoint);
        }
        System.out.print(startingPoint); // Printing ending point
         */

    }
}
