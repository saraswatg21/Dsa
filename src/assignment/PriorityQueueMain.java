package assignment;

import java.util.Iterator;

public class PriorityQueueMain {
	public static void main() {
	 PriorityQueue pq = new PriorityQueue(10);
	    pq.enqueue(5);
	    pq.enqueue(4);
	    pq.enqueue(8);
	    pq.enqueue(9);
	    pq.enqueue(1);
	    pq.enqueue(6);
	    System.out.println("Size: " + pq.size());
	    pq.traverse();
	    System.out.println("Dequeue: " + pq.dequeue());
	    pq.traverse();
	    System.out.println("Peek: " + pq.peek());
	    System.out.println("Contains 9: " + pq.contains(9));
	    System.out.println("Contains 7: " + pq.contains(7));
	    pq.reverse();
	    pq.traverse();
	    System.out.println("Center: " + pq.center());
	    Iterator<Integer> it = pq.iterator();
	    while (it.hasNext()) {
	        int val = it.next();
	        System.out.print(val + " ");
	    }
	    System.out.println();
	}
}
