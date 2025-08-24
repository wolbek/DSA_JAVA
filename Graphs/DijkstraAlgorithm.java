package Graphs;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class DijkstraAlgorithm {
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

    static class Pair implements Comparable<Pair> {
        int n;
        int path;

        public Pair(int n, int path) {
            this.n = n;
            this.path = path;
        }

        @Override
        public int compareTo(Pair p2) {
            return this.path - p2.path;
        }
    }

    public static void dijkstra(ArrayList<Edge>[] graph, int src) {
        boolean[] visited = new boolean[graph.length];
        int[] dist = new int[graph.length]; // dist[i] -> src to i distance

        for(int i=0; i<graph.length; i++) {
            if(i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src, 0));

        // BFS
        while(!pq.isEmpty()) {
            Pair curr = pq.remove();
            if(!visited[curr.n]) {
                visited[curr.n] = true;
                //neighbors
                for(Edge e: graph[curr.n]) {
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.wt;

                    if(dist[u] + wt < dist[v]) { // update distance of src to v
                        dist[v] = dist[u] +wt;
                        pq.add(new Pair(v, dist[v]));
                    }
                }
            }
        }

        // Print all source to vertices shortest dist
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

        int src = 0;
        dijkstra(graph, src);
        
    }
}
