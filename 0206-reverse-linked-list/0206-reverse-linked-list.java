import java.util.ArrayList;
import java.util.Collections;
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
    public ListNode reverseList(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        ListNode node = head;

        // Store values in ArrayList
        while (node != null) {
            list.add(node.val);
            node = node.next;
        }

        // Reverse the ArrayList
        Collections.reverse(list);

        // Create a new linked list from reversed values
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        for (int val : list) {
            current.next = new ListNode(val);
            current = current.next;
        }

        return dummy.next;
    }
}