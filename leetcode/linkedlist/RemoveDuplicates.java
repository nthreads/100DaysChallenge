import java.util.List;

public class RemoveDuplicates {

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(2))));
        traverse(head);
        traverse(deleteDuplicates(head));
    }

    private static void traverse(ListNode head) {
        while (head != null) {
            System.out.print(head.val +  " -> ");
            head = head.next;
        }
        System.out.println("Null");
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode curr = head;

        while(curr.next != null) {
            ListNode next = curr.next;
            if(curr.val == next.val) {
                curr.next = next.next;
            } else {
                curr = next;
            }
        }

        return dummy.next;
    }
}
