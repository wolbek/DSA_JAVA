package Graphs;

public class DisjointSet {
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

    public static void main(String[] args) {
        int V = 7;

        init(V);
        // We print before and after union to see the changing leader
        System.out.println(find(3));
        union(1,3);
        System.out.println(find(3));

        System.out.println(find(4));
        union(2,4);
        System.out.println(find(4));

        System.out.println(find(6));
        union(3,6);
        System.out.println(find(6));

        System.out.println(find(4));
        union(1,4);
        System.out.println(find(4));

        System.out.println(find(5));
        union(1,5);
        System.out.println(find(5));
    }
}
