package bookstore.bookstore;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

import org.springframework.beans.factory.annotation.Autowired;

import bookstore.bookstore.web.BookController;
import bookstore.bookstore.web.RestBookController;

@SpringBootTest
class BookstoreApplicationTests {
	@Autowired
	private BookController bookController;
	@Autowired
	private RestBookController restBookController;

	@Test
	void contextLoads() {
	}

	@Test
	public void bookControllerLoad() throws Exception {
		assertThat(bookController).isNotNull();
	}

	@Test
	public void restBookControllerLoad() throws Exception {
		assertThat(restBookController).isNotNull();
	}

}
