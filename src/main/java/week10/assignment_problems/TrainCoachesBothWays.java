
public class TrainCoachesBothWays {

    static class Node {
        String name;
        Node prev;
        Node next;

        Node(String name) {
            this.name = name;
            this.prev = null;
            this.next = null;
        }
    }

    static class DoublyLinkedList {
        Node head;
        Node tail;

        void addLast(String name) {
            Node newNode = new Node(name);

            if (head == null) {
                head = tail = newNode;
                return;
            }

            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }

        void remove(String name) {
            Node current = head;

            // Find the coach
            while (current != null &&
                   !current.name.equals(name)) {
                current = current.next;
            }

            // Coach not found
            if (current == null) {
                System.out.println(
                    "Coach not found: " + name
                );
                return;
            }

            // Update the previous node or head
            if (current.prev != null) {
                current.prev.next = current.next;
            } else {
                head = current.next;
            }

            // Update the next node or tail
            if (current.next != null) {
                current.next.prev = current.prev;
            } else {
                tail = current.prev;
            }
        }

        void printForward() {
            Node current = head;

            System.out.print("Forward: ");

            while (current != null) {
                System.out.print(current.name);
                if (current.next != null) {
                    System.out.print(" <-> ");
                }
                current = current.next;
            }

            System.out.println();
        }

        void printBackward() {
            Node current = tail;

            System.out.print("Backward: ");

            while (current != null) {
                System.out.print(current.name);
                if (current.prev != null) {
                    System.out.print(" <-> ");
                }
                current = current.prev;
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {
        DoublyLinkedList train = new DoublyLinkedList();

        train.addLast("Engine");
        train.addLast("A1");
        train.addLast("B1");
        train.addLast("B2");
        train.addLast("Guard");

        train.remove("B1");

        train.printForward();
        train.printBackward();
    }
}
