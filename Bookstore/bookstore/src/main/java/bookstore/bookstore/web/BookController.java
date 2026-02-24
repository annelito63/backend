package bookstore.bookstore.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import bookstore.bookstore.BookstoreApplication;
import bookstore.bookstore.model.Book;
import bookstore.bookstore.model.BookRepository;
import bookstore.bookstore.model.CategoryRepository;
import jakarta.validation.Valid;

@Controller
public class BookController {

    private final BookRepository bookRepository;
    private final CategoryRepository categoryRepository;

    private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

    public BookController(BookRepository bookRepository,
            CategoryRepository categoryRepository) {
        this.bookRepository = bookRepository;
        this.categoryRepository = categoryRepository;
    }

    // Show all books
    @GetMapping("/booklist")
    public String getBooks(Model model) {
        model.addAttribute("books", bookRepository.findAll());
        return "booklist";
    }

    @RequestMapping(value = "/addbook")
    public String addBook(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("categories", categoryRepository.findAll());
        return "addbook";
    }

    @PostMapping("/saveadd")
    public String saveAdd(@Valid Book book, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            log.info("validation error tapahtui: " + book.toString());
            model.addAttribute("book", book);
            model.addAttribute("categories", categoryRepository.findAll());

            return "/addbook";
        }

        bookRepository.save(book);
        return "redirect:/booklist";
    }

    @PostMapping("/saveedit")
    public String saveEdit(@Valid Book book, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            log.info("validation error tapahtui: " + book.toString());
            model.addAttribute("book", book);
            model.addAttribute("categories", categoryRepository.findAll());
            return "/editbook";
        }

        bookRepository.save(book);
        return "redirect:/booklist";
    }

    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable("id") Long bookId, Model model) {
        bookRepository.deleteById(bookId);
        return "redirect:../booklist";
    }

    @GetMapping("/editbook/{id}")
    public String editBook(@PathVariable("id") Long bookId, Model model) {
        model.addAttribute("book", bookRepository.findById(bookId));
        model.addAttribute("categories", categoryRepository.findAll());
        return "editbook";

    }

}