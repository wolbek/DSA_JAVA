package Graphs;

import java.util.ArrayList;
import java.util.Collections;

public class KruskalsAlgorithm {
    static class Edge implements Comparable<Edge> {
        int src;
        int dest;
        int wt;
        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }

        @Override
        public int compareTo(Edge e2) {
            return this.wt - e2.wt;
        }
    }

    static int[] parent;
    static int[] rank;

    public static void init(int V) {
        parent = new int[V];
        rank = new int[V];

        for(int i=0; i<V; i++) {
            parent[i] = i;
        }
    }

    public static int find(int n) {
        if(n == parent[n]) {
            return n;
        }

        return parent[n] = find(parent[n]);
    }

    public static void union(int a, int b) {
        int parA = find(a);
        int parB = find(b);

        if(rank[parA] == rank[parB]) {
            parent[parB] = parA;
            rank[parA]++;
        } else if(rank[parA] < rank[parB]) {
            parent[parA] = parB;
        } else{
            parent[parB] = parA;
        }
    }

    public static void kruskalsMST(ArrayList<Edge> edges, int V) {
        init(V);
        Collections.sort(edges); // edges sorted in ascending order of weight - TC: O(E log E)
        int mstCost = 0;
        int count = 0;

        int i=0;
        while(count<V-1) { // O(V)
            Edge e = edges.get(i); // (src, dest, wt)

            int parA = find(e.src);
            int parB = find(e.dest);

            if(parA != parB) {
                union(e.src, e.dest);
                mstCost += e.wt;
                count++;
            }
            i++;
        }

        System.out.println(mstCost);
    }
    public static void main(String[] args) {
        int V=4;
        ArrayList<Edge> edges = new ArrayList<>();
        // edges
        edges.add(new Edge(0,1,40));
        edges.add(new Edge(0,3,10));
        edges.add(new Edge(1,2,30));
        edges.add(new Edge(2,3,20));

        kruskalsMST(edges, V);
    }
}
