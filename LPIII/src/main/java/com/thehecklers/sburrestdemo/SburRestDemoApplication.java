package com.thehecklers.sburrestdemo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@SpringBootApplication
public class SburRestDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SburRestDemoApplication.class, args);
    }
}

@CrossOrigin(origins = {"http://localhost:8081", "http://127.0.0.1:5501"})
@RestController
@RequestMapping("/books")
class BookController {
    private List<Book> books = new ArrayList<>();

    public BookController() {
        books.addAll(List.of(
                new Book("Dom Casmurro"),
                new Book("1984"),
                new Book("To Kill a Mockingbird"),
                new Book("The Great Gatsby")
        ));
    }

    @GetMapping
    Iterable<Book> getBooks() {
        return books;
    }

    @GetMapping("/{id}")
    Optional<Book> getBookById(@PathVariable String id) {
        for (Book b : books) {
            if (b.getId().equals(id)) {
                return Optional.of(b);
            }
        }

        return Optional.empty();
    }

    @PostMapping
public ResponseEntity<Book> postBook(@RequestBody Book book) {
    books.add(book);
    return new ResponseEntity<>(book, HttpStatus.CREATED);
}


    @PutMapping("/{id}")
ResponseEntity<Book> putBook(@PathVariable String id, @RequestBody Book updatedBook) {
    Optional<Book> existingBook = getBookById(id);

    if (existingBook.isPresent()) {
        Book book = existingBook.get();
        book.setTitle(updatedBook.getTitle());

        return new ResponseEntity<>(book, HttpStatus.OK);
    } else {
        // Se o livro não existir, retornamos um status 404 Not Found
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}


    @DeleteMapping("/{id}")
void deleteBook(@PathVariable String id) {
    books.removeIf(b -> id.equals(b.getId())); // Verifica se o id não é nulo antes de chamar getId()
}

}

class Book {
    private final String id;
    private String title;

    public Book(String id, String title) {
    this.id = id;
    this.title = title;
}

public Book(String title) {
    this(UUID.randomUUID().toString(), title);
}


    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
