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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
      ListNode pres = dummy;

        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
              pres.next = list1;
              list1 = list1.next;
            }else{
            pres.next = list2;
            list2 = list2.next;
            }
            pres = pres.next;
        }

        while(list1 != null){
             pres.next = list1;
            list1 = list1.next;
             pres = pres.next;
        }

        while(list2 != null){
            pres.next = list2;
            list2 = list2.next;
             pres = pres.next;
        }
        return dummy.next;
    }
}