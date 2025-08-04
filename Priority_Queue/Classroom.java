package Priority_Queue;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Classroom {
    static class Student implements Comparable<Student> { // overriding
        String name;
        int rank;

        public Student(String name, int rank) {
            this.name = name;
            this.rank = rank;
        }

        @Override
        public int compareTo(Student s2) {
            return this.rank - s2.rank;
        }
    }

    public static void main(String[] args) {
        // PriorityQueue<Student> pq = new PriorityQueue<>();
        PriorityQueue<Student> pq = new PriorityQueue<>(Comparator.reverseOrder());

        pq.add(new Student("Izuku", 2)); // O(log n)
        pq.add(new Student("Mark", 4));
        pq.add(new Student("Aakash", 1));
        pq.add(new Student("Senku", 3));

        while(!pq.isEmpty()) {
            System.out.println(pq.peek().name + " -> " + pq.peek().rank); // O(1)
            pq.remove(); // O(log n)
        }
    }
}
