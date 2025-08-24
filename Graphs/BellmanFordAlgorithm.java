package Graphs;

import java.util.ArrayList;

public class BellmanFordAlgorithm {
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

    public static void bellmanFord(ArrayList<Edge>[] graph, int src) {
        int[] dist = new int[graph.length];

        for(int i=0; i<dist.length; i++) {
            if(i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }

        int V = graph.length;

        // algo -> TC - O(V X E)
        for(int i=0; i<V-1; i++) { // TC - O(V)
            for(int j=0; j<graph.length; j++) { //edges -> TC - O(E)
                for(Edge e: graph[j]) {
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.wt;

                    // relaxation
                    if(dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]) {
                        dist[v] = dist[u] + wt;
                    }
                }
            }
        }

        // print
        for(int i=0; i<dist.length; i++) {
            System.out.print(dist[i] + " ");
        }
        System.out.println();
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
        int V = 5;

        ArrayList<Edge>[] graph = new ArrayList[V];

        for(int i=0; i<V; i++) {
            graph[i] = new ArrayList<>();
        }

        // Vertex - 0
        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        // Vertex - 1
        graph[1].add(new Edge(1, 2, -4));

        // Vertex - 2
        graph[2].add(new Edge(2, 3, 2));

        // Vertex - 3
        graph[3].add(new Edge(3, 4, 4));

        // Vertex - 4
        graph[4].add(new Edge(4, 1, -1));

        bellmanFord(graph, 0);
    }
}
