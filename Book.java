package book.management;

public class Book {
    private final String title;
    private final String author;
    private final String ISBN;
    private boolean isBorrowed;

    public Book(String title, String author, String ISBN){
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.isBorrowed = false;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor(){
        return author;
    }

    public String getISBN(){
        return ISBN;
    }
    public void setBorrowed(boolean sb){
        this.isBorrowed = sb;
    }
    public boolean isBorrowed(){
        return isBorrowed;
    }

    public String toString(){
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", ISBN='" + ISBN + '\'' +
                ", isBorrowed=" + isBorrowed +
                '}';
    }

}
