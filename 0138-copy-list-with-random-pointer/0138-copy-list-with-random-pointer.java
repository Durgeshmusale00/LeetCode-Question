/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;

        Node oldTemp = head;
        HashMap<Node, Node> map = new HashMap<>();
        while (oldTemp != null) {
            map.put(oldTemp, new Node(oldTemp.val));
            oldTemp = oldTemp.next;
        }

        oldTemp = head;

        while(oldTemp != null){
            Node newTemp = map.get(oldTemp);

            newTemp.random = map.get(oldTemp.random);
            newTemp.next = map.get(oldTemp.next);
            oldTemp = oldTemp.next;
        }
        return map.get(head);
    }
}