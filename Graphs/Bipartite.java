package Graphs;

import java.util.ArrayList;

public class Bipartite {
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

    public static boolean isBipartite(ArrayList<Edge>[] graph) {
        int[] color = new int[graph.length];
       
        for(int i=0; i<graph.length; i++) {
            if(color[i]==0 && !isBipartiteUtil(graph, color, i, 1)){
                return false;
            }
        }

        return true;
    }

    public static boolean isBipartiteUtil(ArrayList<Edge>[] graph, int[] color, int curr, int currColor) {
        color[curr] = currColor;

        for(Edge e: graph[curr]) {
            if(color[e.dest] == 0 && !isBipartiteUtil(graph, color, e.dest, -currColor)) {
                return false;
            }
            if(color[e.dest] == currColor) {
                return false;
            }
        }

        return true; // Meaning all the times color[e.dest] == -currColor
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

        System.out.println(isBipartite(graph));
    }
}
