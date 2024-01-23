package assignment;
import java.util.Scanner;
import java.util.Iterator;

public class Queue  {
    private int[] Q;

    private static final int Default = 10;

     static int end = 0;

    public Queue(){
        this(Default);
    }

    public Queue(int len) {
        this.Q= new int[len];
    }

    public boolean notEmpty() {
        return end == Q.length; 
    }

    public static boolean Empty() {
        return end == 0;
    }

    public boolean queue(int item) {
        if (notEmpty()) {
            return false;
        }
        Q[end++] = item;
        return true;
    }

    public int dequeue() throws Exception {
        if (Empty()) {
            throw new Exception("Queue is vacant");
        }

        int removed = Q[0];

        // shift the elements to left
        for (int i = 1; i < end; i++) {
            Q[i-1] = Q[i];
        }
        end--;
        return removed;
    }

    public int peek() throws Exception{
        if (Empty()) {
            throw new Exception("There's nothing in the Queue");
        }
        return Q[0];
    }

    public Queue reverse(Queue que) throws Exception
{
    if (Queue.Empty() )
       return que;
    else {
       int data = que.peek();
       que.dequeue();
       que = reverse(que);
       que.queue(data);
       return que;
    }
}
public int Size(){
    return end;
}
public void contains(int a) throws Exception{
    boolean isPresent = false;
    for(int i=0; i<this.Size(); i++) {
        int element = this.dequeue();
        if(element == a) {
            isPresent = true;
            break;
        }
        this.queue(element);
    }
    
    if(isPresent) {
        System.out.println("Queue contains " + a);
    } else {
        System.out.println("Queue does not contain " + a);
    }
}

public  int findCenter() throws Exception {
    int startptr = 0;
    int endptr = 0;
    int center = 0;
    int index = 0;
    
    while(!this.Empty()) {
        int element = this.dequeue();
        if(index == endptr ) {
        	endptr  += 2;
            startptr++;
        } else {
        	endptr ++;
        }
        index++;
        
        if(endptr  > this.Size()) {
            center = element;
            break;
        }
    }
    
    return center;
}
 public void sort(){
    for (int i = 0; i <Size(); i++)
    {
    	for (int j = i + 1; j <Size(); j++)
    	{
    		int tmp = 0;
    		if (Q[i] > Q[j])
    		{  
    			tmp = Q[i];  
    			Q[i] = Q[j];  
    			Q[j] = tmp;
    		    }   
    		}
    }
 }
 public Iterator<Integer> iter(){
	 return new QueIterator();
 }
 
 private class QueIterator implements Iterator<Integer>{
	 private int c=0;
	 
@Override
public boolean hasNext() {
	return c<=end-1;
}

@Override
public Integer next() {
	return Q[c++];
}

 }
 public void traverse() {
        for (int i = 0; i < end; i++) {
            System.out.print(Q[i] + " <- ");
        }
        System.out.println("END");
    }

}
