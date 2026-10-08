class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class MyLinkedList {

    ListNode head;

    public MyLinkedList() {
        head = null;
    }

    public int get(int index) {
        if (index < 0) {
            return -1;
        }

        ListNode temp = head;
        int count = 0;
        while (temp != null) {

            if (count == index) {
                return temp.val;
            }

            temp = temp.next;
            count++;
        }

        return -1;
    }

    public void addAtHead(int val) {
        ListNode dummy = new ListNode(val);
        dummy.next = head;
        head = dummy;
    }

    public void addAtTail(int val) {
        ListNode newNode = new ListNode(val);

        if (head == null) {
            head = newNode;
            return;
        }

        ListNode temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;
    }

    public void addAtIndex(int index, int val) {

        if (index < 0) {
            return;
        }

        if (index == 0) {
            ListNode newNode = new ListNode(val);
            newNode.next = head;
            head = newNode;
            return;
        }

        ListNode temp = head;

        for (int i = 1; i < index && temp != null; i++) {
            temp = temp.next;
        }

        if (temp == null) {
            return;
        }

        ListNode newNode = new ListNode(val);

        newNode.next = temp.next;
        temp.next = newNode;
    }

    public void deleteAtIndex(int index) {

        if (index < 0 || head == null) {
            return;
        }

        // Delete head
        if (index == 0) {
            head = head.next;
            return;
        }

        ListNode temp = head;

        for (int i = 0; i < index - 1 && temp.next != null; i++) {
            temp = temp.next;
        }

        // Index doesn't exist
        if (temp.next == null) {
            return;
        }

        temp.next = temp.next.next;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */