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
        boolean[] visited = new boolean[graph.length];
        // Loop through all vertices to handle disconnected components
        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                // Start a BFS traversal from this new component
                bfsUtil(graph, i, visited); 
            }
        }
    }

    public static void bfsUtil(ArrayList<Edge>[] graph, int startNode, boolean[] visited) {
        Queue<Integer> adjQ = new LinkedList<>();
        
        adjQ.add(startNode);
        visited[startNode] = true;
        System.out.print(startNode + " ");

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

    public static void dfs(ArrayList<Edge>[] graph) {
        boolean[] visited = new boolean[graph.length];
        // Loop through all vertices to handle disconnected components
        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                // Start a DFS traversal from this new component
                dfsUtil(graph, i, visited); 
            }
        }
    }

    public static void dfsUtil(ArrayList<Edge>[] graph, int curr, boolean[] visited) {
        // Visit
        System.out.print(curr + " ");
        visited[curr] = true;

        for(Edge e: graph[curr]) {
            if(visited[e.dest] == false) {
                dfsUtil(graph, e.dest, visited);
            }
        }
    }

    public static boolean hasPath(ArrayList<Edge>[] graph, boolean[] visited, int curr, int dest) {
        if(curr == dest) {
            return true;
        }

        visited[curr] = true;

        for(Edge e: graph[curr]) {
            if(!visited[e.dest] && hasPath(graph, visited, e.dest, dest)) {
                return true;
            } 
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

        // 0's neighbors
        System.out.println("0's neighbors: ");
        for(int i=0; i<graph[0].size(); i++) {
            Edge e = graph[0].get(i);
            System.out.print(e.dest + " ");
        }

        System.out.println("\n\nBFS: ");
        bfs(graph);
        
        System.out.println("\n\nDFS: ");
        dfs(graph);


        System.out.println("\n\nHas Path?: ");
        int src = 0;
        int dest = 1;
        System.out.println(hasPath(graph, new boolean[V], src, dest));
    }

    /*

    Your hasPath first attempt:
    In this case, if a path is found earlier in the loop, but a later neighbor doesn't have a path, the result gets overwritten, leading to wrong results.

    public static boolean hasPath(ArrayList<Edge>[] graph, boolean[] visited, int curr, int dest) {
        if(curr == dest) {
            return true;
        }

        boolean foundPath = false;
        // Visit
        visited[curr] = true;

        for(Edge e: graph[curr]) {
            if(!visited[e.dest]) {
                foundPath = hasPath(graph, visited, e.dest, dest);
            } 
        }

        return foundPath;
    } 

    */
}
