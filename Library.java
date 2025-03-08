package book.management;

import java.util.ArrayList;
import java.util.List;
public class Library {
    private List<Book> books;
    private List<Member> members;

    public Library(){
        this.books = new ArrayList<>();
        this.members = new ArrayList<>();

    }

    public void addBook(Book book){
        books.add(book);
        System.out.println("Book added successfully!");
    }

    public void removeBook(Book book){
        if (books.contains(book)){
            books.remove(book);
            System.out.println("Book removed successfully!");
        }else{
            System.out.println("Book not found.");
        }
    }
    public void addMember(Member member) {
        members.add(member);
        System.out.println("Member added successfully!");
    }
    public void removeMember(Member member){
        if (members.contains(member)){
            members.remove(member);
            System.out.println("Member remove successfully!");
        }
        else{
            System.out.println("Member not found.");
        }
    }
    public Book searchBookByTitle(String title){
        for(Book book: books){
            if(book.getTitle().equalsIgnoreCase(title)){
                return book;
            }
        }return null;
    }
    public void displayAllBooks(){
        if(books.isEmpty()){
            System.out.println("Non books available.");
        }else{
            for(Book book: books){
                System.out.println(book);
            }
        }
    }

    public void displayAllMembers(){
        if(members.isEmpty()){
            System.out.println("No members registered.");
        }else{
            for(Member member : members){
                System.out.println(member);
            }
        }
    }
    public List<Book> getBooks(){
        return books;
    }
    public List<Member> getMembers(){
        return members;
    }

}
