package book.management;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Library Management System ---");
            System.out.println("1. Add Book");
            System.out.println("2. Add Member");
            System.out.println("3. Borrow Book");
            System.out.println("4. Return Book");
            System.out.println("5. Display All Books");
            System.out.println("6. Display All Members");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter book author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter book ISBN: ");
                    String ISBN = scanner.nextLine();
                    Book book = new Book(title, author, ISBN);
                    library.addBook(book);
                    break;

                case 2:
                    System.out.print("Enter member name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter member ID(Numeric): ");
                    int memberId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    Member member = new Member(name, memberId);
                    library.addMember(member);
                    break;

                case 3:
                    System.out.print("Enter member ID: ");
                    int borrowMemberId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter book title to borrow: ");
                    String borrowTitle = scanner.nextLine();
                    Book borrowBook = library.searchBookByTitle(borrowTitle);
                    if (borrowBook != null) {
                        Member borrowMember = null;
                        for (Member m : library.getMembers()) {
                            if (m.getMemberId() == borrowMemberId) {
                                borrowMember = m;
                                break;
                            }
                        }
                        if (borrowMember != null) {
                            borrowMember.borrowBook(borrowBook);
                        } else {
                            System.out.println("Member not found.");
                        }
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter member ID: ");
                    int returnMemberId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter book title to return: ");
                    String returnTitle = scanner.nextLine();
                    Book returnBook = library.searchBookByTitle(returnTitle);
                    if (returnBook != null) {
                        Member returnMember = null;
                        for (Member m : library.getMembers()) {
                            if (m.getMemberId() == returnMemberId) {
                                returnMember = m;
                                break;
                            }
                        }
                        if (returnMember != null) {
                            returnMember.returnBook(returnBook);
                        } else {
                            System.out.println("Member not found.");
                        }
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;

                case 5:
                    library.displayAllBooks();
                    break;

                case 6:
                    library.displayAllMembers();
                    break;

                case 7:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}