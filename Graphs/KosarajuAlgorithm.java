package Graphs;

import java.util.ArrayList;
import java.util.Stack;

public class KosarajuAlgorithm {
    static class Edge {
        int src;
        int dest;

        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    public static void topSort(ArrayList<Edge>[] graph, int curr, boolean[] visited, Stack<Integer> s) {
        visited[curr] = true;

        for(Edge e: graph[curr]) {
            if(!visited[e.dest]) {
                topSort(graph, e.dest, visited, s);
            }
        }

        s.push(curr);
    }

    public static void dfs(ArrayList<Edge>[] graph, int curr, boolean[] visited) {
        visited[curr] = true;
        System.out.print(curr+" ");

        for(Edge e: graph[curr]) {
            if(!visited[e.dest]) {
                dfs(graph, e.dest, visited);
            }
        }
    }

    public static void kosaraju(ArrayList<Edge>[] graph, int V) { // TC: O(V+E)
        // Step 1
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[V];

        for(int i=0; i<V; i++) {
            if(!visited[i]) {
                topSort(graph, i, visited, stack);
            }
        }

        // Step 2
        ArrayList<Edge>[] transpose = new ArrayList[V];

        for(int i=0; i<V; i++) {
            visited[i] = false;
            transpose[i] = new ArrayList<Edge>();
        }

        for(int i=0; i<V; i++) {
            for(Edge e: graph[i]) {
                transpose[e.dest].add(new Edge(e.dest, e.src));
            }
        }

        // Step 3
        while(!stack.isEmpty()) {
            int curr = stack.pop();
            if(!visited[curr]) {
                System.out.print("SCC -> ");
                dfs(transpose, curr, visited); // Print scc
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {

        int V=5;
        ArrayList<Edge>[] graph = new ArrayList[V];

        for(int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<Edge>();
        }

        graph[0].add(new Edge(0,2));
        graph[0].add(new Edge(0,3));

        graph[1].add(new Edge(1,0));
        graph[2].add(new Edge(2,1));
        graph[3].add(new Edge(3,4));

        kosaraju(graph, V);

    }
}
