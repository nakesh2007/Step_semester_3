import java.util.*;

public class EditorUndoHistory {

    String[] stack;
    int top;
    int capacity;

    EditorUndoHistory(int n) {
        capacity = n;
        stack = new String[n];
        top = -1;
    }

    void type(String word) {

        if (top == capacity - 1) {
            System.out.println("rejected: history full");
            return;
        }

        stack[++top] = word;
        display();
    }

    void undo() {

        if (top == -1) {
            System.out.println("rejected: nothing to undo");
            return;
        }

        stack[top] = null;
        top--;

        display();
    }

    void display() {

        if (top == -1) {
            System.out.println("(empty)");
            return;
        }

        for (int i = 0; i <= top; i++) {
            System.out.print(stack[i]);

            if (i < top)
                System.out.print(" ");
        }

        System.out.println();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int commands = sc.nextInt();

        EditorUndoHistory editor = new EditorUndoHistory(n);

        for (int i = 0; i < commands; i++) {

            String operation = sc.next();

            if (operation.equalsIgnoreCase("TYPE")) {
                String word = sc.next();
                editor.type(word);
            }
            else if (operation.equalsIgnoreCase("UNDO")) {
                editor.undo();
            }
        }
    }
}