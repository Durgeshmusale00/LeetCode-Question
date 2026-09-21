/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
       if(head == null){
        return null;
       } 
        int length = 0;
       ListNode temp = head;
       while(temp!=null){
        temp = temp.next;
        length++;
       }
       if(length == n){
        return head.next;
       }

        int position = length - n;

        temp = head;

        for (int i = 1; i < position; i++) {
            temp = temp.next;
        }

        // Remove the node
        temp.next = temp.next.next;

       return head;
    }
}