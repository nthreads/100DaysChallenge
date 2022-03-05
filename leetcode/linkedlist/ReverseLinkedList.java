
 //Definition for singly-linked list
 //           p     c   n
 // Input:  null [1 -> 2 -> 3 -> 4 -> 5] -> null
 // Output: null [5 -> 4 -> 3 -> 2 -> 1] -> null

class Solution {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode reverseList(ListNode head) {
        return reverseIterative(head);
    }

    public ListNode reverseIterativeII(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode prev = null;

        while (head != null) {
            ListNode next = head.next;

            head.next = prev;
            prev = head;

            head = next;
        }

        return prev;
    }
    public ListNode reverseIterative(ListNode head) {
        if(head == null || head.next == null) return head;
        
        ListNode curr = head;
        ListNode prev = null;
        ListNode next = null;
        
        while(curr != null) {                        
            next = curr.next;
            curr.next = prev;

            prev = curr;
            curr = next;
        }
        
        return prev;
    }
    
    public ListNode reverseRecursive(ListNode head) {
        if(head == null || head.next == null) return head;
        
        ListNode newNode = reverseRecursive(head.next);
        head.next.next = head;
        head.next = null;
        
        return newNode;
    }
}