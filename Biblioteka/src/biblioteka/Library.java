package biblioteka;

import java.util.ArrayList;
import java.util.List;

/**
 * Sadrzi kolekciju knjiga i elementarne metode za rad sa knjigama (dodavanje, listanje itd.).
 */
public class Library {
    
    private List<Book> bookList = new ArrayList<>();
    
    /**
     * Dodaje novu knjigu u kolekciju knjiga.
     * 
     * @param isbn
     * @param title
     * @param author 
     */
    public void addBook(String isbn, String title, String author) {
        bookList.add(new Book(isbn, title, author));
    }
    
    /**
     * Pronalazi knjigu po zadatom ISBN-u.
     * 
     * @param isbn
     * @return 
     */
    public Book findBook(String isbn) {
        if (isbn == null) {
            return null;
        }
        for (Book b : bookList) {
            if (isbn.equals(b.getIsbn())) {
                return b;
            }
        }
        return null;
    }
    
    /**
     * Brise iz liste knjigu sa prosledjenim ISBN brojem.
     * 
     * @param isbn
     * @return 
     */
    public boolean removeBook(String isbn) {
        Book book = findBook(isbn);
        if (book == null) { // ne postoji knjiga sa tim isbn-om
            return false;
        }
        this.bookList.remove(book);
        return true;
    }
    
    /**
     * Vraca sve knjige u kolekciji.
     * 
     * @return 
     */
    public List<Book> getAllBooks() {
       return this.bookList; 
    }
    
    
    
}
