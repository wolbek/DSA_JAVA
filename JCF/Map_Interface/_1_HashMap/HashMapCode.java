package JCF.Map_Interface._1_HashMap;
import java.util.*;

public class HashMapCode {
    static class HashMap<K, V>{// generic - meaning parameterized types. In HashMap, the type of key and value is not fixed, so we use generics. K is key, V is value
        private class Node { // Using this, we'll make linked list nodes
            K key;
            V value;

            public Node(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

        private int n; // number of nodes
        private int N; // bucket length
        private LinkedList<Node>[] buckets; // N

        @SuppressWarnings("unchecked") // In some java versions, we don't need to write this
        public HashMap() {
            this.N = 4;
            this.buckets = new LinkedList[4]; // The above suppress is for this line. As, in some java version you need to specify the type of elements we'll be storing in LinkedList.
            for(int i=0; i<4; i++) {
                this.buckets[i] = new LinkedList<>();
            }
        }

        private int hashFunction(K key) {
            int hc = key.hashCode(); // hashCode takes an object and returns a hash code. Hash code can be negative, so we'll take absolute value.
            return Math.abs(hc) % N;

        }

        private int SearchInLL(K key, int bi) {
            LinkedList<Node> ll = buckets[bi];
            int di = 0;

            for(Node node: ll) {
                if(node.key == key) {
                    return di;
                }
                di++;
            }

            return -1;
        }

        @SuppressWarnings("unchecked")
        private void rehash() {
            LinkedList<Node>[] oldBucket = buckets;
            buckets = new LinkedList[N*2];
            N = 2*N;

            for(int i=0; i<buckets.length; i++) {
                buckets[i] = new LinkedList<>();
            }

            // nodes -> add in bucket
            for(int i=0; i<oldBucket.length; i++) {
                LinkedList<Node> ll = oldBucket[i];

                for(int j=0; j<ll.size(); j++) {
                    Node node = ll.remove();
                    put(node.key, node.value);
                }
            }
        }

        // TC: O(lambda) -> O(1)
        public void put(K key, V value) { // First write put operation, then other operations are just a tweak of this.
            int bi = hashFunction(key); // bucket index
            int di = SearchInLL(key, bi); // data index. If the key already exists, we get a valid index. If key does not exist, we get -1.

            if(di != -1) {
                Node node = buckets[bi].get(di);
                node.value = value;
            } else{
                buckets[bi].add(new Node(key, value));
                n++;
            }

            double lambda = (double)n/N;
            if(lambda > 2.0) {
                rehash();
            }
        }

        // TC: O(lambda) -> O(1)
        public boolean containsKey(K key) {
            int bi = hashFunction(key); // bucket index
            int di = SearchInLL(key, bi); // data index. If the key already exists, we get a valid index. If key does not exist, we get -1.

            if(di != -1) { // valid
                return true;
            } else{
                return false;
            }
        }

        // TC: O(lambda) -> O(1)
        public V remove(K key) {
            int bi = hashFunction(key);
            int di = SearchInLL(key, bi);

            if(di != -1) {
                Node node = buckets[bi].remove(di);
                n--;
                return node.value;
            } else{
                return null;
            }
        }

        // TC: O(lambda) -> O(1)
        public V get(K key) {
            int bi = hashFunction(key); // bucket index
            int di = SearchInLL(key, bi); // data index. If the key already exists, we get a valid index. If key does not exist, we get -1.

            if(di != -1) {
                Node node = buckets[bi].get(di);
                return node.value;
            } else{
                return null;
            }
        }

        public ArrayList<K> keySet() { // To return a arraylist of all the keys
            ArrayList<K> keys = new ArrayList<>();

            for(int i=0; i<buckets.length; i++) {
                LinkedList<Node> ll = buckets[i];
                for(Node node: ll) {
                    keys.add(node.key);
                }
            }

            return keys;
        }

        public boolean isEmpty() {
            return n==0;
        }
    }
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("India", 100);
        map.put("China", 150);
        map.put("US", 50);
        map.put("Nepal", 5);

        ArrayList<String> keys = map.keySet();

        for(String key: keys) {
            System.out.println(key);
        }

        System.out.println(map.get("India"));
        System.out.println(map.remove("India"));
        System.out.println(map.get("India"));
    }
}
