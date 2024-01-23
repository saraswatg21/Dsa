package assignment;

import java.util.Iterator;

public class LinkedListClass {
	public static void main(String[] args){
		LinkedList list = new LinkedList();
		list.insert(12);
		list.insert(96);
		list.insert(23);
		list.insert(67);
		list.insert(34);
		System.out.print("list after all insertions is : ");
		list.printList();
		System.out.println(" ");
		
		System.out.print("list after new insertion is : ");
		list.insert_at_Position(list.head.next, 5);
		list.printList();
		System.out.println(" ");
		
		
		System.out.print("list after deleting first node is : ");
		list.deleteNode(34);
		list.printList();
		System.out.println(" ");
		
		System.out.print("list after deleting node at 2nd position is : ");
		list.deleteNode_Position(2);
		list.printList();
		System.out.println(" ");
		
		System.out.print("list after sorting is : ");
		list.sortList();
		list.printList();
		System.out.println(" ");
		
		System.out.print("list after reversing is : ");
		list.reverse();
		list.printList();
		System.out.println(" ");
		
		System.out.print("size of the list is : "+list.getSize());
		System.out.println(" ");
		System.out.print("List after using iterator is : ");
		 Iterator<Integer> it = list.iterator();
          while (it.hasNext()) {
           System.out.print(it.next() + " ");
           }
          System.out.println();
		
	}

}
