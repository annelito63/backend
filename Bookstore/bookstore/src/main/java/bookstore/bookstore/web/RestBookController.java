package bookstore.bookstore.web;

import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import bookstore.bookstore.model.Book;
import bookstore.bookstore.model.BookRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class RestBookController {

    private final BookRepository bookRepository;

     public RestBookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        
    }


    @GetMapping("/books")
    public Iterable<Book> findAllBooks(){
        return bookRepository.findAll();
    }

    @GetMapping("/books/{id}")
    public Optional<Book> findOneBook(@PathVariable("id") Long bookId){
        return bookRepository.findById(bookId);
    }

    @PostMapping("/books")
    public Book saveBook(@RequestBody Book book) {
        return bookRepository.save(book);
    }

    @PutMapping("/books/{id}")
    public Book saveEditedBook(@RequestBody Book editedBook, @PathVariable Long bookId){
        editedBook.setId(bookId);
        return bookRepository.save(editedBook);
    }

    @DeleteMapping("/books/{id}")
    public Iterable<Book> deleteBook(@PathVariable Long bookId){
        bookRepository.deleteById(bookId);
        return bookRepository.findAll();
    }
    

    

}