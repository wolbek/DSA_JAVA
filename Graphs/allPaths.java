package Graphs;

import java.util.ArrayList;

public class allPaths {
    static class Edge {
        int src;
        int dest;

        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    public static void dfsPaths(ArrayList<Edge>[] graph, int src, int dest, StringBuilder path) {
        if(src == dest) {
            path.append(src);
            System.out.print(path+"\n");
            path.deleteCharAt(path.length()-1);
            return;
        }

        for(Edge e: graph[src]) {
            path.append(src);
            dfsPaths(graph, e.dest, dest, path);
            path.deleteCharAt(path.length()-1);
        }

    }
    public static void main(String[] args) {
        /*
             5       4
            |  \   /  |
            v   v v   v
            2    0    1
              \  |  ^ 
               v v /
                 3
        */

        // Array size = Number of vertices
        int V = 6;

        ArrayList<Edge>[] graph = new ArrayList[V];

        for(int i=0; i<V; i++) {
            graph[i] = new ArrayList<>();
        }

        // Vertex - 0
        graph[0].add(new Edge(0, 3));

        // Vertex - 2
        graph[2].add(new Edge(2, 3));

        // Vertex - 3
        graph[3].add(new Edge(3, 1));

        // Vertex - 4
        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));

        // Vertex - 5
        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));

        int src = 5;
        int dest = 1;
        StringBuilder path = new StringBuilder("");
        dfsPaths(graph, src, dest, path);
    }
}
