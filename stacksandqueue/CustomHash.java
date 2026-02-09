package stacksandqueue;

/*
    Goal of this class:
    This class demonstrates the implementation of a custom hash map
    data structure using separate chaining for collision handling.
    An array of linked lists is used where each index acts as a bucket.
    The class supports basic operations such as insertion, retrieval,
    and deletion of key-value pairs while illustrating how hashing
    works internally without relying on built-in collections.
*/

public class CustomHash {

    static class Node {
        int key;
        int value;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    static int SIZE = 10;
    static Node[] table = new Node[SIZE];

    // Computes hash index for a given key
    static int hash(int key) {
        return key % SIZE;
    }

    // Inserts a key-value pair into the hash map
    static void put(int key, int value) {
        int index = hash(key);
        Node head = table[index];

        while (head != null) {
            if (head.key == key) {
                head.value = value;
                return;
            }
            head = head.next;
        }

        Node newNode = new Node(key, value);
        newNode.next = table[index];
        table[index] = newNode;
    }

    // Retrieves the value associated with a given key
    static Integer get(int key) {
        int index = hash(key);
        Node head = table[index];

        while (head != null) {
            if (head.key == key) {
                return head.value;
            }
            head = head.next;
        }

        return null;
    }

    // Removes the key-value pair associated with a given key
    static void remove(int key) {
        int index = hash(key);
        Node head = table[index];
        Node prev = null;

        while (head != null) {
            if (head.key == key) {
                if (prev == null) {
                    table[index] = head.next;
                } else {
                    prev.next = head.next;
                }
                return;
            }
            prev = head;
            head = head.next;
        }
    }

    // Entry point of the program
    public static void main(String[] args) {
        put(1, 10);
        put(2, 20);
        put(12, 120);

        System.out.println(get(1));
        System.out.println(get(12));

        remove(2);
        System.out.println(get(2));
    }
}

