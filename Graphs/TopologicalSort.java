package Graphs;

import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSort {
    static class Edge {
        int src;
        int dest;

        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    public static void dfsTopSort(ArrayList<Edge>[] graph) {
        boolean[] visited = new boolean[graph.length];
        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<graph.length; i++) {
            if(!visited[i]) {
                dfsTopSortUtil(graph, visited, stack, i);
            }
        }

        while(!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }

    public static void dfsTopSortUtil(ArrayList<Edge>[] graph, boolean[] visited,Stack<Integer> stack, int curr) {
        visited[curr] = true;

        for(Edge e: graph[curr]) {
            if(!visited[e.dest]) {
                dfsTopSortUtil(graph, visited, stack, e.dest);
            }
        }

        stack.push(curr);
    }


    public static void main(String[] args) {
        /*
             5       4
            |  \   /  |
            v   v v   v
            2    0    1
              \     ^ 
               v   /
                 3
        */

        // Array size = Number of vertices
        int V = 6;

        ArrayList<Edge>[] graph = new ArrayList[V];

        for(int i=0; i<V; i++) {
            graph[i] = new ArrayList<>();
        }

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

        dfsTopSort(graph);
    }

}
