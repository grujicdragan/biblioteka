package biblioteka;

import java.util.List;
import java.util.Scanner;

/**
 * Sadrzi main metodu i ispisuje korisnicki interfejs.
 * @author Grujic Dragan
 */
public class UI {
    
    public static void main(String[] args) {
        
        /*
         * Biblioteka - sadrzi knjige i metode za rad sa njima. 
         */
        Library library = new Library();
        
        Scanner sc = new Scanner(System.in);
        Scanner scBook = new Scanner(System.in);
        
        while(true) { // beskonacna petlja
            System.out.println("1 - Add book, 2 - Show all books, 3 - Remove book, 4 - Show book details, 5 - Exit");
            System.out.print("Choose option: ");
            int opcija = sc.nextInt();

            switch(opcija) {
                case 1: // dodavanje
                    System.out.print("ISBN: ");
                    String isbn = scBook.nextLine();
                    System.out.print("Title: ");
                    String title = scBook.nextLine();
                    System.out.print("Author: ");
                    String author = scBook.nextLine();
                    library.addBook(isbn, title, author);
                    System.out.println("Book has been added.");
                    break;
                case 2: // listanje
                    System.out.println("Book list:");
                    List<Book> books = library.getAllBooks();
                    for (int i=0; i<books.size(); i++) {
                        System.out.println((i+1)+". "+books.get(i));
                    }
                    break;
                case 3: // brisanje 
                    System.out.print("ISBN: ");
                    String isbnRemove = scBook.nextLine();
                    if (library.removeBook(isbnRemove)) {
                        System.out.println("Book "+isbnRemove+" has been removed.");
                    } else {
                        System.err.println("No such book.");
                    }
                    break;
                case 4: // detalji
                    System.out.print("ISBN: ");
                    String isbnFind = scBook.nextLine();
                    Book book = library.findBook(isbnFind);
                    if (book == null) {
                        System.err.println("No such book.");
                    } else {
                        System.out.println("ISBN: "+book.getIsbn());
                        System.out.println("Title: "+book.getTitle());
                        System.out.println("Author: "+book.getAuthor());
                    }
                    break;
                case 5: // izlaz
                    System.out.println("Good bye!");
                    return;
                default: // nepostojeca opcija
                    System.err.println("Unknown option.");
                    break;
            }

        }
    }
    
}
