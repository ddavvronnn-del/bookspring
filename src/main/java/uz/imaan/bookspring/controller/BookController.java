package uz.imaan.bookspring.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.imaan.bookspring.dto.BookResponse;
import uz.imaan.bookspring.entity.Book;
import uz.imaan.bookspring.repository.BookRepository;
import uz.imaan.bookspring.service.BookService;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {
    private final BookService service;

    public BookController(BookService service) {
        this.service = service;
    }

    @GetMapping
    public List<BookResponse> getAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getBookById(@PathVariable Long id){
        return service.findById(id)
                .<ResponseEntity<Object>>map(ResponseEntity :: ok)
                .orElse(ResponseEntity.status(404).body("Book not found"));
    }

    @PostMapping
    public ResponseEntity<BookResponse> createBook(@RequestBody Book book){
        BookResponse create = service.create(book);
        return ResponseEntity.status(201).body(create);
    }


    public ResponseEntity<Object> updateBook(@PathVariable Long id, @RequestBody Book book){

        return service.update(id,book).
                <ResponseEntity<Object>>map(ResponseEntity :: ok)
                .orElse(ResponseEntity.status(404).body("Book not found"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteBook(@PathVariable Long id){
        boolean deleted = service.delete(id);
        if (!deleted){
            return ResponseEntity.status(404).body("book not found");
        }
        return ResponseEntity.noContent().build();
    }





}