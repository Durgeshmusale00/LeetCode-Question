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
    public ListNode mergeKLists(ListNode[] lists) {
        ArrayList<Integer> list = new ArrayList<>();

        // Collect values from all linked lists
        for (ListNode curr : lists) {
            while (curr != null) {
                list.add(curr.val);
                curr = curr.next;
            }
        }

        if (list.isEmpty()) {
            return null;
        }

        Collections.sort(list);

        ListNode dummy = new ListNode(list.get(0));
        ListNode temp = dummy;

        for (int i = 1; i < list.size(); i++) {
            ListNode newNode = new ListNode(list.get(i));
            temp.next = newNode;
            temp = temp.next;
        }

        return dummy;
    }
}