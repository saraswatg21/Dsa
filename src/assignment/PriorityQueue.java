package assignment;
import java.util.Iterator;
import java.util.NoSuchElementException;
public class PriorityQueue{
private int[] queue;
private int size;

public PriorityQueue(int capacity) {
    queue = new int[capacity];
    size = 0;
}

//Enqueue
public void enqueue(int val) {
    if (size == queue.length) {
        throw new IllegalStateException("Queue is full");
    }
    int pos = size;
    queue[pos] = val;
    size++;
    bubbleUp(pos);
}

//Dequeue (Highest Priority)
public int dequeue() {
    if (size == 0) {
        throw new IllegalStateException("Queue is empty");
    }
    int val = queue[0];
    size--;
    if (size > 0) {
        queue[0] = queue[size];
        bubbleDown(0);
    }
    return val;
}

//Peek (Highest Priority)
public int peek() {
    if (size == 0) {
        throw new IllegalStateException("Queue is empty");
    }
    return queue[0];
}

//Contains
public boolean contains(int val) {
    for (int i = 0; i < size; i++) {
        if (queue[i] == val) {
            return true;
        }
    }
    return false;
}

//Size
public int size() {
    return size;
}

//Reverse
public void reverse() {
    for (int i = 0; i < size / 2; i++) {
        int temp = queue[i];
        queue[i] = queue[size - i - 1];
        queue[size - i - 1] = temp;
    }
}

//Center
public int center() {
    if (size % 2 == 0) {
        throw new IllegalStateException("Even number of elements, no center");
    }
    int mid = size / 2;
    return queue[mid];
}

//Iterator
public Iterator<Integer> iterator() {
    return new PQIterator();
}

//Traverse/Print
public void traverse() {
    for (int i = 0; i < size; i++) {
        System.out.print(queue[i] + " ");
    }
    System.out.println();
}

private void bubbleUp(int pos) {
    while (pos > 0) {
        int parent = (pos - 1) / 2;
        if (queue[pos] > queue[parent]) {
            int temp = queue[pos];
            queue[pos] = queue[parent];
            queue[parent] = temp;
            pos = parent;
        } else {
            break;
        }
    }
}

private void bubbleDown(int pos) {
    while (true) {
        int leftChild = 2 * pos + 1;
        int rightChild = 2 * pos + 2;
        if (leftChild >= size) {
            break;
        }
        int maxChild = leftChild;
        if (rightChild < size && queue[rightChild] > queue[leftChild]) {
            maxChild = rightChild;
        }
        if (queue[maxChild] > queue[pos]) {
            int temp = queue[pos];
            queue[pos] = queue[maxChild];
            queue[maxChild] = temp;
            pos = maxChild;
        } else {
            break;
        }
    }
}

private class PQIterator implements Iterator<Integer> {

    private int cursor;

    public PQIterator() {
        cursor = 0;
    }

    @Override
    public boolean hasNext() {
        return cursor < size;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int val = queue[cursor];
        cursor++;
        return val;
    }

}
public static void main(String[] args) {
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

