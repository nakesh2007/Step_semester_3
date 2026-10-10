
public class RoundRobinGameTurns {

    static class Node {
        String name;
        Node next;

        Node(String name) {
            this.name = name;
            this.next = null;
        }
    }

    static class CircularLinkedList {
        Node tail;

        void addLast(String name) {
            Node newNode = new Node(name);

            if (tail == null) {
                tail = newNode;
                tail.next = tail;
                return;
            }

            newNode.next = tail.next;
            tail.next = newNode;
            tail = newNode;
        }

        void printTurns(int turns) {
            if (tail == null || turns <= 0) {
                System.out.println("No turns to display.");
                return;
            }

            Node current = tail.next;

            System.out.print("Game turns: ");

            for (int i = 0; i < turns; i++) {
                System.out.print(current.name);

                if (i < turns - 1) {
                    System.out.print(" ");
                }

                current = current.next;
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {
        CircularLinkedList players = new CircularLinkedList();

        players.addLast("Asha");
        players.addLast("Ravi");
        players.addLast("Neha");

        int turns = 7;

        players.printTurns(turns);
    }
}
