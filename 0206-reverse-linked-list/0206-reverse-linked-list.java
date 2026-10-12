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

       if(head == null) return head;

        ListNode prev = null;
        ListNode pres = head;
        ListNode next1 = pres.next;

        while(pres != null){
           next1 = pres.next;
            pres.next = prev;
            prev = pres;
            pres = next1;
        }

        return prev;
    }
    // public TreeNode helper(ListNode root){
    //     //base case 
    //     if(root == null) return null;
        


    //     helper(root, )
    // }
}