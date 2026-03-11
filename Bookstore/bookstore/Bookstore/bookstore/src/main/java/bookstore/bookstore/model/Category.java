package bookstore.bookstore.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;


@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long categoryid;

    
    private String name;

    @JsonIgnoreProperties("categoryid")
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "categoryid")
    private List<Book> books;

    public Category(String name) {
        super();
        this.name = name;
    }

    public Category() {
    }

    public Long getCategoryId() {
        return categoryid;
    }

    public void setCategoryId(Long id) {
        this.categoryid = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Category [id=" + categoryid + ", Name=" + name + "]";
    }

}
