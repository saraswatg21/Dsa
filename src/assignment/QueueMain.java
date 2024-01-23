package assignment;
import java.util.Iterator;
import java.util.Scanner;
public class QueueMain {
     public static void main(String[] args) {
    	 Scanner sc = new Scanner(System.in);
 		Queue q = new Queue();
    	 try {
		int	data;
		//1. Enqueue
		System.out.println("Enter the element value = ");

		data = sc.nextInt();
		q.queue(data);
		data = sc.nextInt();
		q.queue(data);
		data = sc.nextInt();
		q.queue(data);
		data = sc.nextInt();
		q.queue(data);
		
		//2. Dequeue
		System.out.println("Front Element deleted: " +q.dequeue());
		
		//3.peek
		System.out.println("Peek Element: " + q.peek());
		
		
		//4. Contains
		System.out.println("Which element you want to check? = ");
		data = sc.nextInt();
		q.contains(data); 
		
		//5. Center
		System.out.println("Center Element: " + q.findCenter());
		
		//6. Sort
		System.out.print("Queue Sorted: "); 
		q.sort();
		q.traverse();
		
		//7. Reverse
		System.out.println("Queue Reversed: ");
		q.reverse(q);
		q.traverse();
		
		//8. Size
		System.out.println("Size of Queue: " + q.getSize()); 
		
		//9.Iterator
		Iterator<Integer> iter= q.iter();
		System.out.println("Iterator: ");
		while(iter.hasNext()) {
			System.out.println(iter.next()+" ");
		}
		
		 //10. Print
		System.out.println("Queue: ");
		q.traverse();
     }
    	 catch(Exception e){
    		 System.out.println("Something went wrong");
    	 }
    	 }
}
