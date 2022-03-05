public class LinkedListTraversals {

    private static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    public static void traverse(Node head) {
        while (head != null) {
            System.out.print(head.data + " -> ");
            head = head.next;
        }
        System.out.println("Null");
    }


    public static void main(String[] args) {
        Node ll = new Node(1, new Node(2, new Node(3)));
        traverse(ll);
        Node rll = reverse(ll);
        traverse(rll);
    }

    private static Node reverse(Node head) {
        Node prev = null;

        while(head != null) {
            Node next = head.next;

            head.next = prev;
            prev = head;

            head = next;
        }


        return prev;
    }
}
