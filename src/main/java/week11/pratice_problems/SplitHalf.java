public class SplitHalf {
    static class Node {
        int data;
        Node next;
        Node(int data) { this.data = data; }
    }

    static Node splitListInHalf(Node head) {
        if (head == null || head.next == null) return null;

        Node slow = head;
        Node fast = head;
        Node previous = null;

        while (fast != null && fast.next != null) {
            previous = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        previous.next = null;
        return slow;
    }

    static void display(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        Node secondHalf = splitListInHalf(head);
        System.out.print("First half: ");
        display(head);
        System.out.print("Second half: ");
        display(secondHalf);
    }
}
