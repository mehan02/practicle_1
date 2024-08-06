// Class to represent a Book
class Book {
    private String title;
    private String author;
    private String ISBN;
    private boolean isAvailable;

    // Constructor
    public Book(String title, String author, String ISBN, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.isAvailable = isAvailable;
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getISBN() {
        return ISBN;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    // Setters
    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }
}

// Class to represent the Library
public class Library {
    private Book[] books;
    private int bookCount;

    // Constructor
    public Library(int size) {
        books = new Book[size];
        bookCount = 0;
    }

    // Method to add a book
    public void addBook(Book book) {
        if (bookCount < books.length) {
            books[bookCount] = book;
            bookCount++;
        }
    }

    // Method to search a book by title
    public Book searchBookByTitle(String title) {
        for (int i = 0; i < bookCount; i++) {
            if (books[i].getTitle().equalsIgnoreCase(title)) {
                return books[i];
            }
        }
        return null;
    }

    // Method to update book availability status
    public void updateBookStatus(String title, boolean isAvailable) {
        Book book = searchBookByTitle(title);
        if (book != null) {
            book.setAvailable(isAvailable);
        }
    }
}

// Example Usage
public class Main {
    public static void main(String[] args) {
        Library library = new Library(10);
        library.addBook(new Book("Java Programming", "Author A", "123456", true));
        library.addBook(new Book("Python Programming", "Author B", "789012", true));

        // Searching for a book by title
        Book book = library.searchBookByTitle("Java Programming");
        if (book != null) {
            System.out.println("Book found: " + book.getTitle() + " by " + book.getAuthor());
        } else {
            System.out.println("Book not found");
        }

        // Updating book availability status
        library.updateBookStatus("Java Programming", false);
        System.out.println("Availability of 'Java Programming': " + library.searchBookByTitle("Java Programming").isAvailable());
    }
}
