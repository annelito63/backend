package bookstore.bookstore.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
public class Book {
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty(message = "Kirjan nimi ei voi olla tyhjä")
    @Size(min = 2, max = 250, message = "Kirjan nimen tulee olla 2-250 merkkiä")
    private String title;
    
    private String author;

    @Column(name = "publication_year")
    private int publicationYear;
    private String isbn;
    private double price;

    @JsonIgnoreProperties("books")
    @ManyToOne
    @JoinColumn(name = "categoryid")
    private Category categoryid;

    public Book(String title, String author, int publicationYear, String isbn, double price, Category category) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.isbn = isbn;
        this.price = price;
        this.categoryid = category;
    }

    public Book() {
    }

    public Long getId() {
        return id;
    }

        public void setId(Long id) {
        this.id = id;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Category getCategory() {
		return categoryid;
	}

	public void setCategory(Category category) {
		this.categoryid = category;
	}

    @Override
    public String toString() {
        return "Book [id=" + id + ", title=" + title + ", author=" + author + ", publicationYear=" + publicationYear
                + ", isbn=" + isbn + ", price=" + price + ", category=" + categoryid + "]";
    }



}
