package Graphs;

import java.util.ArrayList;

public class ArticulationPoint {
    static class Edge {
        int src;
        int dest;

        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    // TC: O(V+E)
    public static void dfs(ArrayList<Edge>[] graph, int curr, int par, int[] dt, int[] low, int time, boolean[] visited, boolean[] AP) {
        visited[curr] = true;
        dt[curr] = low[curr] = ++time;
        int children = 0;

        for(Edge e: graph[curr]) {
            int neigh = e.dest;
            // Case 1
            if(par == neigh) {
                continue;
            } 
            // Case 2
            else if (!visited[neigh]){
                dfs(graph, neigh, curr, dt, low, time, visited, AP);
                low[curr] = Math.min(low[curr], low[neigh]);
                if(par !=-1 && dt[curr] <= low[neigh]) {
                    AP[curr] = true;
                }

                children++;
            }
            // Case 3
            else {
                low[curr] = Math.min(low[curr], dt[neigh]);
            } 
        }

        if(par == -1 && children > 1) {
            AP[curr] = true;
        }
    }

    public static void getAP(ArrayList<Edge>[] graph, int V) {
        int[] dt = new int[V];
        int[] low = new int[V];
        int time = 0;
        boolean[] visited = new boolean[V];
        boolean[] AP = new boolean[V];

        for(int i=0; i<V; i++) {
            if(!visited[i]) {
                dfs(graph, i, -1, dt, low, time, visited, AP);
            }
        }

        // Print all articulation points
        for(int i=0; i<V; i++) {
            if(AP[i]) {
                System.out.println("AP: " + i);
            }
        }
    }

    public static void main(String[] args) {
        int V = 5;
        ArrayList<Edge>[] graph = new ArrayList[V];

        for(int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<Edge>();
        }

        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0,2));
        graph[0].add(new Edge(0,3));

        graph[1].add(new Edge(1,0));
        graph[1].add(new Edge(1,2));

        graph[2].add(new Edge(2,0));
        graph[2].add(new Edge(2,1));

        graph[3].add(new Edge(3,0));

        getAP(graph, V);
    }
    
}
