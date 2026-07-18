import java.util.HashMap;

class LRUCache {

    class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.prev = null;
            this.next = null;
        }
    }

    Node head;
    Node tail;

    HashMap<Integer, Node> hmap;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;

        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;

        hmap = new HashMap<>();
    }

    public int get(int key) {
        Node keyNode = hmap.getOrDefault(key, null);

        if (keyNode == null)
            return -1;

        extract(keyNode);
        insertAtTail(keyNode);

        return keyNode.value;
    }

    public void put(int key, int value) {
        if (get(key) == -1) {
            if (hmap.size() == capacity) {
                int k = head.next.key;
                extract(head.next);
                hmap.remove(k);
            }

            Node toBeInserted = new Node(key, value);
            hmap.put(key, toBeInserted);
            insertAtTail(toBeInserted);
        } else {
            tail.prev.value = value;
        }
    }

    private void insertAtTail(Node n) {
        Node tmp = tail.prev;

        tmp.next = n;
        n.prev = tmp;

        tail.prev = n;
        n.next = tail;
    }

    private void extract(Node n) {
        Node nextNode = n.next;
        Node prevNode = n.prev;

        nextNode.prev = prevNode;
        prevNode.next = nextNode;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key, value);
 */

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */