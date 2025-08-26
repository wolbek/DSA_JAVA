package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CheapestFlightsProblem {
    static class Edge { 
        int dest;
        int price;

        public Edge(int d, int p) {
            this.dest = d;
            this.price = p;
        }
    }

    static class Info{
        int n;
        int price;
        int nodeTraversed;

        public Info(int n, int p, int nT) {
            this.n = n;
            this.price = p;
            this.nodeTraversed = nT;
        }
    }

    public static int dijkstra(ArrayList<Edge>[] graph, int src, int dest, int k) {
        int[] dist = new int[graph.length];
        Queue<Info> q = new LinkedList<>();

        q.add(new Info(src, 0, 0));

        for(int i=0; i<dist.length; i++) {
            if(i != src){ // We want to let the distance be 0 for src.
                dist[i] = Integer.MAX_VALUE;
            }
        }

        while(!q.isEmpty()) {
            Info curr = q.remove();
            int nodeTraversed = curr.nodeTraversed;

            if(nodeTraversed > k) {
                break;
            }

            for(Edge e: graph[curr.n]) {
                int v = e.dest;
                int price = e.price;

                if(curr.price + price < dist[v] && nodeTraversed<=k) { // relax. Should not use dist[u], use curr.price.
                    dist[v] = curr.price + price;
                    q.add(new Info(v, dist[v], nodeTraversed+1));
                }
            }
            
        }

        if(dist[dest] == Integer.MAX_VALUE) {
            return -1;
        } 

        return dist[dest];
    }

    public static void main(String[] args) {
        /*

        int n = 3;

        // From, To, Price
        int[][] flights = {
            {0, 1, 100},
            {1, 2, 100},
            {0, 2, 500}
        };

        int src = 0;
        int dest = 2;
        int k = 1;

        Ans: 200
        */

        int n = 4;

        // From, To, Price
        int[][] flights = {
            {0, 1, 100},
            {1, 2, 100},
            {2, 0, 100},
            {1, 3, 600},
            {2, 3, 200}
        };

        int src = 0;
        int dest = 3;
        int k = 1;

        // Ans: 700

        ArrayList<Edge>[] graph = new ArrayList[n];

        for(int i=0; i<n; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i<flights.length; i++) {
            graph[flights[i][0]].add(new Edge(flights[i][1], flights[i][2]));
        }

        System.out.println(dijkstra(graph, src, dest, k));
    }
}


/*
Solved using DFS-but time limit exceeded. 30/58 test cases passed

class Solution {
    static class Edge {
        int dest;
        int price;

        public Edge(int dest, int price) {
            this.dest = dest;
            this.price = price;
        }
    }

    public static int dfs(ArrayList<Edge>[] graph, boolean[] visited, int src, int dest, int k , int nodeTraversed, int priceToReach, int minPriceToReach) {
        if(src == dest) {
            return priceToReach;
        }
        visited[src] = true;

        for(Edge e: graph[src]) {
            if(nodeTraversed <= k) {
                minPriceToReach = Math.min(dfs(graph, visited, e.dest, dest, k, nodeTraversed+1, priceToReach+e.price, minPriceToReach), minPriceToReach); 

            }
        }

        return minPriceToReach;
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<Edge>[] graph = new ArrayList[n];

        for(int i=0; i<n; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i<flights.length; i++) {
            graph[flights[i][0]].add(new Edge(flights[i][1], flights[i][2]));
            System.out.println(graph[flights[i][0]].get(0).dest);
        }
        


        boolean[] visited = new boolean[n];
        int nodeTraversed = 0;
        int priceToReach = 0;
        int minPriceToReach = Integer.MAX_VALUE;
        minPriceToReach = dfs(graph, visited, src, dst, k, nodeTraversed, priceToReach, minPriceToReach);
        if(minPriceToReach ==  Integer.MAX_VALUE) {
            return -1;
        } 
        return minPriceToReach;


    }

}
 */