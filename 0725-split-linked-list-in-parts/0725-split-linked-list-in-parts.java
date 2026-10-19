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
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] ans = new ListNode[k];

        int n = 0;
        ListNode temp = head;

        while (temp != null) {
            temp = temp.next;
            n++;
        }

        int idx = 0;
        temp = head;

        while (idx < k) {
            int tempp = n / (k - idx);
            if (n % (k - idx) != 0) {
                tempp++;
            }

            if (n == 0) {
                ans[idx++] = null;
                continue;
            }

            ListNode partHead = temp;
            ListNode tp = new ListNode(-1);

            for (int i = 0; i < tempp && temp != null; i++) {
                ListNode nextNode = temp.next;
                tp.next = temp;
                tp = tp.next;
                temp = nextNode;
                n--;
            }

            tp.next = null;
            ans[idx++] = partHead;
        }

        return ans;
    }
}