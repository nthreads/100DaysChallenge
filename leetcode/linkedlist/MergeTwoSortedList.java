

public class MergeTwoSortedList {
    
    class ListNode  {
        int val;
        ListNode next;

        ListNode(int val) { this.val = val;}

        ListNode(int val, ListNode next) { this.val = val; this.next = next;}
        
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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
        
    }


}
