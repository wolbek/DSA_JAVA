package Graphs;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class ConnectingCitiesProblem {

    static class Edge implements Comparable<Edge>{
        int dest;
        int wt;

        public Edge(int d, int wt) {
            this.dest = d;
            this.wt = wt;
        }

        @Override
        public int compareTo(Edge p2) {
            return this.wt - p2.wt;
        }

    }

    public static int getMinCost(int[][] graph) {
        boolean[] visited = new boolean[graph.length];
        PriorityQueue<Edge> pq = new PriorityQueue<>();

        pq.add(new Edge(0, 0));
        int mstCost = 0;

        while(!pq.isEmpty()) {
            Edge curr = pq.remove();
            if(!visited[curr.dest]) {
                visited[curr.dest] = true;
                mstCost += curr.wt;

                for(int j=0; j<graph[curr.dest].length; j++) {
                    if(graph[curr.dest][j] != 0 && !visited[j]) {
                        pq.add(new Edge(j, graph[curr.dest][j]));
                    }
                    
                }
            }
        }

        return mstCost;
    }
    public static void main(String[] args) {
        
        int[][] cities = { // Given in form of adjacency matrix
            {0,1,2,3,4},
            {1,0,5,0,7},
            {2,5,0,6,0},
            {3,0,6,0,0},
            {4,7,0,0,0}
        };

        System.out.println(getMinCost(cities));
    }
}
