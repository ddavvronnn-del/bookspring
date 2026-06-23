package uz.imaan.bookspring.repository;

import org.springframework.stereotype.Repository;
import uz.imaan.bookspring.entity.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class BookRepository {

    private final List<Book> books = new ArrayList<>();

    private Long nextId = 1L;

    public BookRepository(){
        books.add(new Book(nextId++,"Spring book","craig walls ","345-04",2022,true));
        books.add(new Book(nextId++,"Java core","james","345-01",2021,true));
        books.add(new Book(nextId++,"Phyton ","ilon","345-05",2019,false));
    }

    public Book save(Book book){
        book.setId(nextId);
        nextId = nextId + 1;
        books.add(book);
        return book;
    }

    public List<Book> findAll(){
        return books;
    }

    public Optional<Book> findById(Long id){
        for (Book book : books){
            if (book.getId().equals(id)){
                return Optional.of(book);
            }
        }
        return Optional.empty();
    }

    public Optional<Book> update(Long id, Book newBook) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getId().equals(id)) {
                newBook.setId(id);
                books.set(i, newBook);
                return Optional.of(newBook);
            }
        }
        return Optional.empty();
    }

    public boolean delete(Long id){
        return books.removeIf(book -> book.getId().equals(id));
    }

}
