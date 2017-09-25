package BFS;

/**
 * Bag, represents unordered collection. Imagine bag of marbles. Represented as single linkedlist.
 */
public class Bag<E> {
    Node<E> head; // beginning

    /**
     * Initializes empty
     */
    public Bag(){
        head = null;
    }

    /**
     * Returns true if empty.
     */
    public boolean isEmpty(){
        return head == null;
    }

    /**
     * Add new item into the head of current bag.
     */
    public void add(E item) {
        Node<E> oldHead = head;
        head = new Node<>();
        head.item = item;
        head.next = oldHead;
    }
}
