package Binary_Trees;

import java.util.*;

import Binary_Trees.BinaryTrees.Node;

public class TopViewTree {

    static class Info {
        Node node;
        int hd;
        Info(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }
    public static void topView(Node root) {
        int min = 0, max = 0;
        HashMap<Integer, Integer> map = new HashMap<>(); // Will store position: data
        Queue<Info> q = new LinkedList<>(); // Will store: node & hd
        Info curr;

        q.offer(new Info(root, 0));
        q.offer(null);

        while(!q.isEmpty()){
            curr = q.remove(); // curr is storing poppedElementInfo
            if(curr == null){
                if(q.isEmpty()){
                    break;
                }
                else{
                    q.offer(null);
                }
            } else{
                if(!map.containsKey(curr.hd)){
                    min = Math.min(min, curr.hd);
                    max = Math.max(max, curr.hd);
                    map.put(curr.hd, curr.node.data);
                }
                if(curr.node.left!= null) {
                    q.offer(new Info(curr.node.left, curr.hd-1));
                }
                if(curr.node.right!= null) {
                    q.offer(new Info(curr.node.right, curr.hd+1));
                }
            }
        }

        for(int i = min; i <= max; i++){
            System.out.print(map.get(i) + " ");
        }
    }
    public static void main(String[] args){
        /* 
         *           1
         *          / \
         *         2   3
         *        / \ / \
         *       4  5 6  7
        */
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        topView(root);
    }
}
