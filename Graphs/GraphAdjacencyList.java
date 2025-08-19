package Graphs;

import java.util.*;

public class GraphAdjacencyList {
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

    public static void bfs(ArrayList<Edge>[] graph) {
        Queue<Integer> adjQ = new LinkedList<>();
        boolean[] visited = new boolean[graph.length];
        
        adjQ.add(0);
        visited[0] = true;
        System.out.print(0 + " ");

        while(!adjQ.isEmpty()) {
            Integer curr = adjQ.remove();

            for(Edge e: graph[curr]){
                if(visited[e.dest] == false) {
                    adjQ.add(e.dest);
                    visited[e.dest] = true;
                    System.out.print(e.dest + " ");
                }
            }
        }
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

        // 0's neighbors
        for(int i=0; i<graph[0].size(); i++) {
            Edge e = graph[0].get(i);
            System.out.println(e.dest);
        }

        bfs(graph);
    }
}
