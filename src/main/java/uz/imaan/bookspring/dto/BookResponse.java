package uz.imaan.bookspring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import uz.imaan.bookspring.entity.Book;

@AllArgsConstructor
@Data
public class BookResponse {
    private Long id;
    private String title;
    private String author;
    private String isbn;
    private int year;
    private boolean available;

    public static BookResponse from(Book book){
        return new BookResponse(
                book.getId(),
                book.getTitle(),
                book.getAuthor(),
                book.getIsbn(),
                book.getYear(),
                book.isAvailable()
        );
    }
}
