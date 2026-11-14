import java.util.*;

public class BrowserTabStrip {

    static class Node {
        String data;
        Node prev, next;

        Node(String data) {
            this.data = data;
        }
    }

    static Node head, current;

    static void open(String name) {
        Node newNode = new Node(name);

        if (current == null) {
            head = current = newNode;
        } else {
            newNode.next = current.next;
            newNode.prev = current;

            if (current.next != null)
                current.next.prev = newNode;

            current.next = newNode;
            current = newNode;
        }
    }

    static void close() {
        if (current == null)
            return;

        Node temp = current;

        if (temp.prev != null)
            temp.prev.next = temp.next;
        else
            head = temp.next;

        if (temp.next != null) {
            temp.next.prev = temp.prev;
            current = temp.next;
        } else {
            current = temp.prev;
        }
    }

    static boolean back() {
        if (current == null || current.prev == null)
            return false;

        current = current.prev;
        return true;
    }

    static boolean forward() {
        if (current == null || current.next == null)
            return false;

        current = current.next;
        return true;
    }

    static void print() {
        Node temp = head;

        if (temp == null) {
            System.out.println("Empty");
            return;
        }

        while (temp != null) {
            if (temp == current)
                System.out.print("[" + temp.data + "]");
            else
                System.out.print(temp.data);

            if (temp.next != null)
                System.out.print(" <-> ");

            temp = temp.next;
        }

        System.out.println();
    }

    static void printBackward() {
        Node temp = head;

        if (temp == null) {
            System.out.println("Empty");
            return;
        }

        while (temp.next != null)
            temp = temp.next;

        while (temp != null) {
            System.out.print(temp.data);

            if (temp.prev != null)
                System.out.print(" <-> ");

            temp = temp.prev;
        }

        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            String command = sc.nextLine();

            if (command.startsWith("OPEN ")) {
                String name = command.substring(5);
                open(name);
                System.out.print(command + ": ");
                print();
            }
            else if (command.equals("CLOSE")) {
                String name = current == null ? "" : current.data;
                close();
                System.out.print("CLOSE " + name + ": ");
                print();
            }
            else if (command.equals("BACK")) {
                if (back()) {
                    System.out.print("BACK: ");
                    print();
                } else {
                    System.out.println("BACK: already at first tab");
                }
            }
            else if (command.equals("FORWARD")) {
                if (forward()) {
                    System.out.print("FORWARD: ");
                    print();
                } else {
                    System.out.println("FORWARD: already at last tab");
                }
            }
            else if (command.equals("PRINT BACKWARD")) {
                System.out.print("Backward: ");
                printBackward();
            }
        }
    }
}