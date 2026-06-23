package uz.imaan.bookspring.repository;

import org.springframework.stereotype.Repository;
import uz.imaan.bookspring.entity.Book;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BookRepository {

    private List<Book> books = new ArrayList<>();

    private Long nextId = 1L;

    public Book save(Book book){
        book.setId(nextId);
        nextId++;
        books.add(book);
        return book;
    }

    public List<Book> findAll(){
        return books;
    }

    public Book findById(Long id){
        for (Book book : books){
            if (book.getId().equals(id)){
                return book;
            }
        }
        return null;
    }
    public Book update(Long id, Book newBook){
        Book book = findById(id);

        if (book == null){
            return null;
        }

        book.setTitle(newBook.getTitle());
        book.setAuthor(newBook.getAuthor());
        book.setIsbn(newBook.getIsbn());
        book.setYear(newBook.getYear());
        book.setAvailable(newBook.isAvailable());
        return book;
    }

    public boolean delete(Long id){
        Book book = findById(id);

        if (book == null){
            return false;
        }
        books.remove(book);

        return true;
    }
}
