package uz.imaan.bookspring.service;

import org.springframework.stereotype.Service;
import uz.imaan.bookspring.dto.BookResponse;
import uz.imaan.bookspring.entity.Book;
import uz.imaan.bookspring.repository.BookRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private final BookRepository repo;

    public BookService(BookRepository repo) {
        this.repo = repo;
    }

    public List<BookResponse> findAll(){
        List<Book> books = repo.findAll();
        List<BookResponse> result = new ArrayList<>();
        for (Book book : books){
            result.add(BookResponse.from(book));
        }
        return result;
    }

    public Optional<BookResponse> findById(Long id) {
        return repo.findById(id).map(BookResponse :: from);
    }

    public Optional<BookResponse> update(Long id, Book book){
        return repo.update(id,book).map(BookResponse :: from);
    }

    public BookResponse create(Book book){
        Book saved = repo.save(book);
        return BookResponse.from(saved);
    }

    public boolean delete(Long id){
        return repo.delete(id);
    }







}
