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
    public ListNode removeNodes(ListNode head) {
        ListNode pres = head;
        ListNode prev = null;

        while (pres != null) {
            ListNode nextNode = pres.next;
            pres.next = prev;
            prev = pres;
            pres = nextNode;
        }

        head = prev;

        int max = Integer.MIN_VALUE;
        ListNode temp = new ListNode(-1);
        temp.next =  prev;
        while (temp.next != null) {
            if (temp.next.val >= max) {
                max = temp.next.val;
                temp = temp.next;
            } else {
                temp.next = temp.next.next;
                //temp = temp.next;
            }
        }

        pres = head;
        prev = null;

        while (pres != null) {
            ListNode nextNode = pres.next;
            pres.next = prev;
            prev = pres;
            pres = nextNode;
        }
        head = prev;

        return head;
    }
}