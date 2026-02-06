package linkedlist;

/*
Problem Statement:
Design an undo/redo functionality for a text editor using a doubly linked list.
Each node represents a state of the text content.

Features:
- Add a new text state on every action
- Undo to previous state
- Redo to next state
- Display current text
- Limit history to last 10 states
*/

class TextEditor {

    // Doubly Linked List Node
    class Node {
        String text;
        Node prev;
        Node next;

        Node(String text) {
            this.text = text;
        }
    }

    private Node head;
    private Node current;
    private int size;
    private final int MAX_HISTORY = 10;

    // Add new text state
    public void addState(String newText) {
        Node newNode = new Node(newText);

        // Remove forward history after undo
        if (current != null && current.next != null) {
            current.next.prev = null;
            current.next = null;
        }

        if (head == null) {
            head = newNode;
            current = newNode;
        } else {
            current.next = newNode;
            newNode.prev = current;
            current = newNode;
        }

        size++;
        if (size > MAX_HISTORY) {
            head = head.next;
            head.prev = null;
            size--;
        }
    }

    // Undo operation
    public void undo() {
        if (current != null && current.prev != null) {
            current = current.prev;
        } else {
            System.out.println("No more undo available");
        }
    }

    // Redo operation
    public void redo() {
        if (current != null && current.next != null) {
            current = current.next;
        } else {
            System.out.println("No more redo available");
        }
    }

    // Display current text
    public void displayCurrentState() {
        if (current != null) {
            System.out.println("Current Text: " + current.text);
        } else {
            System.out.println("Editor is empty");
        }
    }
}

public class UndoRedo {
    public static void main(String[] args) {

        TextEditor editor = new TextEditor();

        editor.addState("Hello");
        editor.addState("Hello World");
        editor.addState("Hello World!");
        editor.displayCurrentState();

        editor.undo();
        editor.displayCurrentState();

        editor.undo();
        editor.displayCurrentState();

        editor.redo();
        editor.displayCurrentState();

        editor.addState("Hello World!!");
        editor.displayCurrentState();
    }
}
