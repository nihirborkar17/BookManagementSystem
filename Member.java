package book.management;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Member {
    private  String name;
    private  int memberId;
    private  List<Book> borrowedBooks;

    public Member(String name, int memberId){
        this.name = name;
        this.memberId = memberId;
        this.borrowedBooks = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getMemberId() {
        return memberId;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }
    public void borrowBook(Book book){
        if(book.isBorrowed()){
            System.out.println("Sorry, the book is already borrowed.");
        }else{
            borrowedBooks.add(book);
            book.setBorrowed(true);
            System.out.println("Book borrowed successfully!");
        }
    }
    public void returnBook(Book book){
        if(borrowedBooks.contains(book)){
            borrowedBooks.remove(book);
            book.setBorrowed(false);
            System.out.println("Book returned successfully!");
        }else{
            System.out.println("You did not borrow this book.");
        }
    }
    @Override
    public String toString() {
        return "Member{" +
                "name='" + name + '\'' +
                ", memberId=" + memberId +
                ", borrowedBooks=" + borrowedBooks +
                '}';
    }
    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if( o == null || getClass() != o.getClass()) return false;
        Member member = (Member) o;
        return memberId == member.memberId;
    }
    @Override
    public int hashCode(){
        return Objects.hash(memberId);
    }

}
