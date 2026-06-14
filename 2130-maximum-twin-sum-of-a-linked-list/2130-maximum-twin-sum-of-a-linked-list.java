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
    public int pairSum(ListNode head) {
        ListNode temp = head;
        int n = 0;
        while(temp != null ) {
            n++;
            temp = temp.next;
        }
        int a = n / 2;
        int[] arr = new int[a];
        temp = head;
        for(int i = 0; i < a; i++) {
            arr[i] = temp.val;
            temp = temp.next;
        }
        int max = 0;
        for (int i = a - 1; i > -1; i--) {
            max = Math.max(max, arr[i] + temp.val);
            temp = temp.next;
        }
        return max;
    }
}