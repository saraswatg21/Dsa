package assignment;

import java.util.Iterator;
import java.util.NoSuchElementException;
public class HashTable {

    private static final int DEFAULT_CAPACITY = 10;
    private int size;
    private Node[] set;

    public HashTable() {
        this(DEFAULT_CAPACITY);
    }

    public HashTable(int capacity) {
        size = 0;
        set = new Node[capacity];
    }

    public void insert(String key, String value) {
        if (size == set.length) {
            throw new IllegalStateException("table is full");
        }
        int ind = hash(key);
        Node node = set[ind];
        while (node != null) {
            if (node.key.equals(key)) {
                node.value = value;
                return;
            }
            node = node.next;
        }
        node = new Node(key, value);
        node.next = set[ind];
        set[ind] = node;
        size++;
    }

    public void delete(String key) {
        if (size == 0) {
            throw new IllegalStateException("t is empty");
        }
        int ind = hash(key);
        Node ptr = null;
        Node node = set[ind];
        while (node != null) {
            if (node.key.equals(key)) {
                if (ptr == null) {
                    set[ind] = node.next;
                } else {
                    ptr.next = node.next;
                }
                size--;
                return;
            }
            ptr = node;
            node = node.next;
        }
    }

    public boolean contains(String key) {
        int ind = hash(key);
        Node node = set[ind];
        while (node != null) {
            if (node.key.equals(key)) {
                return true;
            }
            node = node.next;
        }
        return false;
    }

    private class HashTableIterator implements Iterator<Node> {
        private int currentIndex = -1;
        private Node currentNode= null;

        public boolean hasNext() {
            if (currentNode != null && currentNode.next != null) {
                return true;
            }
            for (int i = currentIndex + 1; i < set.length; i++) {
                if (set[i] != null) {
                    return true;
                }
            }
            return false;
        }

        public Node next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            if (currentNode != null && currentNode.next != null) {
            	currentNode = currentNode.next;
            } else {
                do {
                	currentIndex++;
                	currentNode = set[currentIndex];
                } while (currentNode == null);
            }
            return currentNode;
        }
    }

    public String getValue(String key) {
        int i = hash(key);
        Node node = set[i];
        while (node != null) {
            if (node.key.equals(key)) {
                return node.value;
            }
            node = node.next;
        }
        return null;
    }



    public int size() {
        return size;
    }

    public void traverse() {
        for (int i = 0; i < set.length; i++) {
            Node node = set[i];
            while (node != null) {
                System.out.println(node.key + " : " + node.value);
                node = node.next;
            }
        }
    }

    private int hash(String k) {
        int hash = 0;
        for (int i = 0; i < k.length(); i++) {
            hash = (31 * hash + k.charAt(i)) % set.length;
        }
        return hash;
    }

    private static class Node {
        String key;
        String value;
        Node next;

        public Node(String str, String val) {
            this.key = str;
            this.value = val;
        }
    }

    public static void main(String[] args){
        HashTable t = new HashTable();
        t.insert("key1", "value1");
        t.insert("key2", "value2");
        t.insert("key3", "value3");
        try {
            Iterator<Node> it = t.HashTableIterator();
        while (it.hasNext()) {
        HashTable.Node val = it.next();
        System.out.print(val + " ");
    }
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Something went wrong");
        }
        
        t.traverse();

        t.delete("key2");

        System.out.println("Contains key1: " + t.contains("key1"));
        System.out.println("Contains key2: " + t.contains("key2"));

        System.out.println("Value for key1: " + t.getValue("key1"));
        System.out.println("Value for key2: " + t.getValue("key2"));
        
        System.out.println("s: " + t.size());
    }

    private Iterator<HashTable.Node> HashTableIterator() {
        return null;
    }
}