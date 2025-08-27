package Graphs;

import java.util.ArrayList;

public class BridgeInGraph {
    static class Edge {
        int src;
        int dest;

        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    public static void dfs(ArrayList<Edge>[] graph, int curr, int par, int[] dt, int[] low, boolean[] visited, int time) {
        visited[curr] = true;
        dt[curr] = low[curr] = ++time;

        for(Edge e: graph[curr]) {
            int neigh = e.dest;
            // Case 1
            if(neigh == par) {
                continue;
            } 
            // Case 2
            else if(!visited[neigh]) {
                dfs(graph, neigh, curr, dt, low, visited, time);
                low[curr] = Math.min(low[curr], low[neigh]);

                if(dt[curr] <low[neigh]) {
                    System.out.println("Bridge: "+curr+" ----- "+neigh);
                }
            } 
            // Case 3
            else{
                low[curr] = Math.min(low[curr], dt[neigh]);
            }
        }
    }

    public static void tarjanBridge(ArrayList<Edge>[] graph, int V) {
        int[] dt = new int[V];
        int[] low = new int[V];
        int time = 0;
        boolean[] visited = new boolean[V];

        for(int i=0; i<V; i++) {
            if(!visited[i]) {
                dfs(graph, i, -1, dt, low, visited, time);
            }
        }
    }

    public static void main(String[] args) {
        // int V = 6;
        int V = 4;
        ArrayList<Edge>[] graph = new ArrayList[V];

        for(int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<Edge>();
        }

        // Bridge: 0 ----- 3
        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0,2));
        graph[0].add(new Edge(0,3));

        graph[1].add(new Edge(1,0));
        graph[1].add(new Edge(1,2));

        graph[2].add(new Edge(2,0));
        graph[2].add(new Edge(2,1));

        graph[3].add(new Edge(3,0));

        /*
        Another graph:
        
        Bridge 0----3

        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0,2));
        graph[0].add(new Edge(0,3));

        graph[1].add(new Edge(1,0));
        graph[1].add(new Edge(1,2));

        graph[2].add(new Edge(2,0));
        graph[2].add(new Edge(2,1));

        graph[3].add(new Edge(3,0));
        graph[3].add(new Edge(3,4));
        graph[3].add(new Edge(3,5));

        graph[4].add(new Edge(4,3));
        graph[4].add(new Edge(4,5));

        graph[5].add(new Edge(5,3));
        graph[5].add(new Edge(5,4));
        */

        tarjanBridge(graph, V);

    }
}
