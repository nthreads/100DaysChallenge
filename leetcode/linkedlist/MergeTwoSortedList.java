
/*
    21. Merge Two Sorted Lists    
    https://leetcode.com/problems/merge-two-sorted-lists/
*/
public class MergeTwoSortedList {
    
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode mergedList = new ListNode(0);
        ListNode head = mergedList;
        
        while(l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                head.next = l1;
                l1 = l1.next;
            } else {
                head.next = l2;
                l2 = l2.next;
            }
            head = head.next;
        }
        
        if (l1 != null) {
            head.next = l1;
        } else if (l2 != null) {
            head.next = l2;
        }
        
        return mergedList.next;     //to skip 0 node
    }
    
    public static void main(String[] args) {
        // 10 - 20 - 30
        // 1 - 2 - 3

        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(3)));

        ListNode l2 = new ListNode(10, new ListNode(20, new ListNode(30)));

        ListNode l3 = mergeTwoLists(l1, l2);

        printList(l3);

    }

    private static void printList(ListNode output) {
        if(output == null) return;
        System.out.print(output.val);
        if(output.next != null)
            System.out.print("=>");

        printList(output.next);
    }

}

class ListNode  {
    int val;
    ListNode next;

    ListNode(int val) { this.val = val;}

    ListNode(int val, ListNode next) { this.val = val; this.next = next;}
    
}
