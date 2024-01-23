package assignment;
import java.util.Iterator;
import java.util.NoSuchElementException;
public class Stack {
    private int[] arr;
    private int top;
    private int size;

    public Stack(int size) {
        this.arr = new int[size];
        this.top = -1;
        this.size = size;
    }

    public void push(int element) throws Exception{
        if (top == size - 1) {
            throw new IllegalStateException("stack is not empty");
        } else {
            arr[++top] = element;
        }
    }

    public int pop() throws Exception {
        if (top == -1) {
            throw new IllegalStateException("Stack is empty.");
        } else {
            return arr[top--];
        }
    }

    public int peek() throws Exception{
        if (top == -1) {
            throw new IllegalStateException("Stack is empty.");
        } else {
            return arr[top];
        }
    }

    public boolean contains(int element)throws Exception {
        boolean found = false;
        for (int i = 0; i <= top; i++) {
            if (arr[i] == element) {
                found = true;
                break;
            }
        }
        return found;
    }

    public int size() {
        return top + 1;
    }

    public int center() throws Exception{
        int mid = size() / 2;
        if (mid==0) {
    		throw new Exception("stack is empty");
    	}
        return arr[mid];
    }

    public void sort() {
        for (int i = top; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public void reverse() {
        int[] temp = new int[size];
        int j = top;
        for (int i = 0; i <= top; i++) {
            temp[j--] = arr[i];
        }
        this.arr = temp;
    }

    public Iterator<Integer> iterator() {
        return new StackIterator();
    }

    public void traverse()throws Exception {
        for (int i = 0; i <= top; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    private class StackIterator implements Iterator<Integer> {
        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex <= top;
        }

        @Override
        public Integer next() {
        	 if (!hasNext()) {
                 throw new NoSuchElementException();
             }
            return arr[currentIndex++];
        }
    }
    }


