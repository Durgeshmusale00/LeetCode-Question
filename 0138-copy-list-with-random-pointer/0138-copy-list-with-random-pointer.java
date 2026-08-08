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
       if(head == null) return null;

       Node newList = new Node(head.val);
       Node head2 = newList;
       Node oldList = head.next;

       while(oldList != null){   // make a copy.
        Node tmp = new Node(oldList.val);
        newList.next = tmp;
        newList = newList.next;
        oldList = oldList.next;
       } 

     HashMap<Node,Node> map = new HashMap<>();

    // reset the newList and oldList Node.
    newList = head2;
    oldList = head;

    while(oldList != null){   
       map.put(oldList,newList);
            newList = newList.next;
            oldList = oldList.next;
    } // added the both LL Node.

    //rest the pointer.
    newList = head2;
    oldList = head;

    while(oldList != null){
        newList.random = map.get(oldList.random);
        newList = newList.next;
        oldList = oldList.next;
    }
    return head2;
    }
}