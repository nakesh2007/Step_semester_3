import java.util.*;

public class CounsellingList {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    static Node partition(Node head, int passMark) {
        Node smallHead = null, smallTail = null;
        Node largeHead = null, largeTail = null;

        Node temp = head;

        while (temp != null) {
            Node next = temp.next;
            temp.next = null;

            if (temp.data < passMark) {
                if (smallHead == null)
                    smallHead = smallTail = temp;
                else {
                    smallTail.next = temp;
                    smallTail = temp;
                }
            } else {
                if (largeHead == null)
                    largeHead = largeTail = temp;
                else {
                    largeTail.next = temp;
                    largeTail = temp;
                }
            }

            temp = next;
        }

        if (smallHead == null)
            return largeHead;

        smallTail.next = largeHead;

        return smallHead;
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
        Node head = null, tail = null;

        for (int i = 0; i < n; i++) {
            Node newNode = new Node(sc.nextInt());

            if (head == null)
                head = tail = newNode;
            else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        int passMark = sc.nextInt();

        head = partition(head, passMark);
        printList(head);
    }
}