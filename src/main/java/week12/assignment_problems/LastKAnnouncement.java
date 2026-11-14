import java.util.*;

public class LastKAnnouncement {

    static class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
        }
    }

    static String kthFromEnd(Node head, int k) {
        Node first = head;
        Node second = head;

        for (int i = 0; i < k; i++) {
            if (first == null)
                return "Invalid k";

            first = first.next;
        }

        while (first != null) {
            first = first.next;
            second = second.next;
        }

        return second.data;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Node head = null, tail = null;

        for (int i = 0; i < n; i++) {
            Node newNode = new Node(sc.next());

            if (head == null)
                head = tail = newNode;
            else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        int k = sc.nextInt();
        String result = kthFromEnd(head, k);

        if (result.equals("Invalid k"))
            System.out.println(result);
        else
            System.out.println(k + " from the end: " + result);
    }
}