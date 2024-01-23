package assignment;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList {
	static Node head;
	class Node {
		   int data ;
		   Node next;
		   Node(int data) {
		    this.data=data;
		    this.next=next;
		   }
		    }
		    public void insert(int data){
		        Node newNode= new Node(data);
		        if(head==null){
		            head = newNode;
		            return;
		        }
		        newNode.next=head;
		        head=newNode;
		    }
		    public void insert_at_Position(Node prev_node , int newdata) {
		    	if(prev_node==null) {
		    		System.out.println("the given node is null please return");
		    		return;
		    	}
		    	Node new_node= new Node(newdata);
		    	new_node.next=prev_node.next;
		    	prev_node.next=new_node;
		    	
		    }
		    void deleteNode(int key)
		    {
		        Node temp = head;
		        if (temp == null) {
		            return;
		        }
		        if (temp.data == key) {
		            head = head.next; 
		            return;
		        }
		 
		        while (temp.next != null) {
		        	if(temp.next.data==key) {
		            temp.next = temp.next.next;
		            return;
		        	}
		        	temp=temp.next;
		        }
		        
		    }
		    void deleteNode_Position(int position)
		    {
		    	 if (position < 0) {
		             throw new IndexOutOfBoundsException("Invalid position");
		         }
		       
		        if (head == null)
		            return;
		        
		        Node temp = head;
		        if (position == 0)
		        {
		            head = temp.next;
		            return;
		        }
		        for (int i=0; temp!=null && i<position-1; i++) {
		            temp = temp.next;
		    }
		   
		        if (temp == null || temp.next == null)
		            return;
		 
		        Node next = temp.next.next;
		 
		        temp.next = next;  
		    }
		    public int center() {
		        if (head == null) {
		            throw new NoSuchElementException("List is empty");
		        }
		        Node first = head;
		        Node last = head;
		        while (last != null && last.next != null) {
		            first = first.next;
		            last = last.next.next;
		        }
		        return first.data;
		    }
		    public void sortList()
		    {
		    	 if (head == null || head.next== null) {
			            return;
			        }
		   
		        Node current = head;
		            while (current != null) {
		            	Node initial = current;
		                Node last = current.next;
		                while (last != null) {
		                	int data;
		                    if (initial.data > last.data) {
		                        initial= last;
		                    }
		 
		                    last = last.next;
		                }
		                int temp = current.data;
		                current.data=initial.data;
		                initial.data=temp;
		                current=current.next;
		            }
		    }
		   static void reverse() {

		        Node prev = null;
		        Node current = head;
		        Node next = null;
		        while (current != null) {
		            next = current.next;
		            current.next = prev;
		            prev = current;
		            current = next;
		        }
		        head = prev;
//		        Node temp=node;
//		        System.out.println(After 
//		        while(temp!=null)
//		        {
//		        	System.out.println(temp.data);
//		        	temp=temp.next;
//		        }
		        
		    }
		    public int getSize()
		    {
		        Node temp = head;
		        int count = 0;
		        while (temp != null)
		        {
		            count++;
		            temp = temp.next;
		        }
		        return count;
		    }


		     public Iterator<Integer> iterator() {
		         return new LinkedListIterator();
		     }

		     private class LinkedListIterator implements Iterator<Integer> {
		         Node current = head;

		         public boolean hasNext() {
		             return current != null;
		         }

		         public Integer next() {
		             if (!hasNext()) {
		                 throw new NoSuchElementException();
		             }
		             int data = current.data;
		             current = current.next;
		             return data;
		         }

		         public void remove() {
		             throw new UnsupportedOperationException();
		         }
		     }
		    public void printList()
		    {
		        Node tnode = head;
		        while (tnode != null)
		        {
		            System.out.print(tnode.data + " ");
		            tnode = tnode.next;
		        }
		    }
}
