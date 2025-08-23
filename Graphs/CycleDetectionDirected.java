package Graphs;

import java.util.ArrayList;

public class CycleDetectionDirected {
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
    
    public static boolean detectCycleInDirected(ArrayList<Edge>[] graph) {
        boolean[] visited = new boolean[graph.length];
        boolean[] stack =new boolean[graph.length];

        for(int i=0; i<graph.length; i++) {
            if(!visited[i] && hasCycle(graph, visited, stack, i)) {
                return true;
            }
        }

        return false;
    }

    public static boolean hasCycle(ArrayList<Edge>[] graph, boolean[] visited, boolean[] stack, int curr) {
        visited[curr] = true;
        stack[curr] = true;
        
        for(Edge e: graph[curr]) {
            // Case 1: Cycle condition: The neighbor node is already there in stack
            if(stack[e.dest]) {
                return true;
            }
            // Case 2: If not visited, we visit it and check for cycle
            if(!visited[e.dest] && hasCycle(graph, visited, stack, e.dest)) {
                return true;
            }

            // Case 3: Do nothing, continue
        }

        stack[curr] = false; // Remove curr from stack if cycle not found
        return false;
    }


    public static void main(String[] args) {
        /*
                    (40)
            0---------------->1
            A                 |
       (10) |                 | (30)
            |                 V
            3<----------------2
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

        // Vertex - 1
        graph[1].add(new Edge(1, 2, 30));

        // Vertex - 2
        graph[2].add(new Edge(2, 3, 20));

        // Vertex - 3
        graph[3].add(new Edge(3, 0, 10));

        System.out.println(detectCycleInDirected(graph));
    }
}
