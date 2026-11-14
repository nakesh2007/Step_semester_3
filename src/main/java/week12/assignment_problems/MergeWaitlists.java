import java.util.*;

public class MergeWaitlists {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    static Node merge(Node first, Node second) {
        Node dummy = new Node(0);
        Node tail = dummy;

        while (first != null && second != null) {
            if (first.data <= second.data) {
                tail.next = first;
                first = first.next;
            } else {
                tail.next = second;
                second = second.next;
            }

            tail = tail.next;
        }

        if (first != null)
            tail.next = first;
        else
            tail.next = second;

        return dummy.next;
    }

    static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Node first = null, tail1 = null;

        for (int i = 0; i < n; i++) {
            Node newNode = new Node(sc.nextInt());

            if (first == null)
                first = tail1 = newNode;
            else {
                tail1.next = newNode;
                tail1 = newNode;
            }
        }

        int m = sc.nextInt();
        Node second = null, tail2 = null;

        for (int i = 0; i < m; i++) {
            Node newNode = new Node(sc.nextInt());

            if (second == null)
                second = tail2 = newNode;
            else {
                tail2.next = newNode;
                tail2 = newNode;
            }
        }

        Node result = merge(first, second);
        printList(result);
    }
}