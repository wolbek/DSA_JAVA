package Graphs;

import java.util.*;

public class CycleDetectionUndirected {
    static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }
    
    public static boolean detectCycleInUndirected(ArrayList<Edge>[] graph) {
        boolean[] visited = new boolean[graph.length];

        for(int i=0; i<graph.length; i++) {
            if(!visited[i] && hasCycle(graph, visited, i, -1)) {
                return true;
            }
        }

        return false;
    }

    public static boolean hasCycle(ArrayList<Edge>[] graph, boolean[] visited, int curr, int parent) {
        visited[curr] = true;

        for(Edge e: graph[curr]) {
            // Case 3: If node is not visited, we visit it and check for any cycle
            if(!visited[e.dest] && hasCycle(graph, visited, e.dest, curr)) {
                return true;
            }

            // Case 1: Checking for a visited connected node which is not parent. This indicates cycle.
            else if(visited[e.dest] && e.dest != parent){
                return true;
            }

            // Case 2: Do nothing, continue
        }

        return false;
    }


    public static void main(String[] args) {
        /*
                    (40)
            0-----------------1
            |                 |
       (10) |                 | (30)
            |                 |
            3-----------------2
                    (20)

        */

        // Array size = Number of vertices
        int V = 4;

        ArrayList<Edge>[] graph = new ArrayList[V];

        for(int i=0; i<V; i++) {
            graph[i] = new ArrayList<>();
        }

        // Vertex - 0
        graph[0].add(new Edge(0, 1, 40));
        graph[0].add(new Edge(0, 3, 10));

        // Vertex - 1
        graph[1].add(new Edge(1, 0, 40));
        graph[1].add(new Edge(1, 2, 30));

        // Vertex - 2
        graph[2].add(new Edge(2, 1, 30));
        graph[2].add(new Edge(2, 3, 20));

        // Vertex - 3
        graph[3].add(new Edge(3, 0, 10));
        graph[3].add(new Edge(3, 2, 20));

        System.out.println(detectCycleInUndirected(graph));
    }

    /*
    Your first has cycle attempt:

    public static boolean hasCycle(ArrayList<Edge>[] graph, boolean[] visited, int curr, int parent) {

        visited[curr] = true;

        // Checking for a visited connected node which is not parent. This indicates cycle.
        for(Edge e: graph[curr]) {
            if(visited[e.dest] && e.dest!=parent) {
                return true;
            }
        }
        
        for(Edge e: graph[curr]) {
            if(!visited[e.dest] && hasCycle(graph, visited, e.dest, curr)) {
                return true;
            }
        }

        return false;
    }

     */
}
