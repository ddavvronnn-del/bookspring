package uz.imaan.bookspring.controller;

import org.springframework.web.bind.annotation.*;
import uz.imaan.bookspring.entity.Book;
import uz.imaan.bookspring.repository.BookRepository;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {
    private final BookRepository repository;

    public BookController(BookRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public Book createBook(Book book){
        return repository.save(book);
    }

    public List<Book> getAllBooks(){
        return repository.findAll();
    }
    @GetMapping("/id")
    public Object getBookById(Long id){
        Book book = repository.findById(id);

        if (book == null){
            return "Book not found";
        }
        return book;
    }

    public Object updateBook(Long id, Book book){

        Book updateBook = repository.update(id,book);

        if (updateBook == null){
            return "Book not found";
        }
        return updateBook;
    }

    @DeleteMapping("/{id}")
    public String deleteBook(Long id){
        boolean deleted = repository.delete(id);

        if (!deleted){
            return "Book not found";
        }
        return "Book ochirildi";
    }
}