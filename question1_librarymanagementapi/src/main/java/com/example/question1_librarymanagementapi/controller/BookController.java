package com.example.question1_librarymanagementapi.controller;

import com.example.question1_librarymanagementapi.Book;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    // Sample books list (in-memory storage)
    private List<Book> books = new ArrayList<>();

    // Constructor - Initialize with 3 sample books
    public BookController() {
        books.add(new Book(1L, "Clean Code", "Robert Martin", "978-0132350884", 2008));
        books.add(new Book(2L, "Effective Java", "Joshua Bloch", "978-0134685991", 2018));
        books.add(new Book(3L, "Spring in Action", "Craig Walls", "978-1617294945", 2018));
    }

    // GET /api/books - Return all books
    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        return new ResponseEntity<>(books, HttpStatus.OK); // 200 OK
    }

    // GET /api/books/{id} - Return book by ID
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        for (Book book : books) {
            if (book.getId().equals(id)) {
                return new ResponseEntity<>(book, HttpStatus.OK); // 200 OK
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND); // 404 Not Found
    }

    // GET /api/books/search?title={title} - Search by title
    @GetMapping("/search")
    public ResponseEntity<List<Book>> searchByTitle(@RequestParam String title) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(title.toLowerCase())) {
                result.add(book);
            }
        }
        return new ResponseEntity<>(result, HttpStatus.OK); // 200 OK
    }

    // POST /api/books - Add new book
    @PostMapping
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        books.add(book);
        return new ResponseEntity<>(book, HttpStatus.CREATED); // 201 Created
    }

    // DELETE /api/books/{id} - Delete book by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        for (Book book : books) {
            if (book.getId().equals(id)) {
                books.remove(book);
                return new ResponseEntity<>(HttpStatus.NO_CONTENT); // 204 No Content
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND); // 404 Not Found
    }
}