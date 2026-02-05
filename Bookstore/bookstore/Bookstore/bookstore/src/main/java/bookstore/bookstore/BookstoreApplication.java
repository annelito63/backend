package bookstore.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import bookstore.bookstore.model.Book;
import bookstore.bookstore.model.BookRepository;




@SpringBootApplication
public class BookstoreApplication {

	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	@Bean
	public CommandLineRunner bookDemo(BookRepository bookRepository) {
		return (args) -> {
			log.info("save a couple of books");
			bookRepository.save(new Book("Aku Ankka", "Carl B", 1956, "38192736", 12.90));
			bookRepository.save(new Book("Mustakaapu", "Floyd G", 1974, "89386272", 12.95));

			log.info("fetch all books");
			for (Book kirja: bookRepository.findAll()){
				log.info(kirja.toString());
			}
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

}
