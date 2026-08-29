class LibraryBook {
    String title;
    String isbn;

    LibraryBook(String title, String isbn) {
        this.title = title;

        if (isbn.equals("")) {
            this.isbn = "PENDING";
        } else {
            this.isbn = isbn;
        }
    }

    LibraryBook(String title) {
        this(title, "PENDING");
    }

    void display() {
        System.out.println(title + " | " + isbn + " | Catalogued: true");
    }

    public static void main(String[] args) {
        LibraryBook b1 = new LibraryBook("Clean Code", "978-0132350884");
        LibraryBook b2 = new LibraryBook("Untitled Draft");
        LibraryBook b3 = new LibraryBook("1984", "9780451524935");
        LibraryBook b4 = new LibraryBook("Notes");

        b1.display();
        b2.display();
        b3.display();
        b4.display();
    }
}